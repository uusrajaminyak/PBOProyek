package util;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static void simpanRakitan(List<KomponenPC> keranjang, String namaFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile))) {
            bw.write("Tipe,ID,Merk,Seri,Harga,Atribut1,Atribut2");
            bw.newLine();

            for (KomponenPC k : keranjang) {
                String baris = "";
                if (k instanceof Prosesor) {
                    Prosesor p = (Prosesor) k;
                    baris = String.format("Prosesor,%s,%s,%s,%.0f,%s,%d", p.getIdKomponen(), p.getMerk(), p.getNamaSeri(), p.getHarga(), p.getSocket(), p.getTdp());
                } else if (k instanceof Motherboard) {
                    Motherboard m = (Motherboard) k;
                    baris = String.format("Motherboard,%s,%s,%s,%.0f,%s,-", m.getIdKomponen(), m.getMerk(), m.getNamaSeri(), m.getHarga(), m.getSocketDukungan());
                } else if (k instanceof RAM) {
                    RAM r = (RAM) k;
                    baris = String.format("RAM,%s,%s,%s,%.0f,%s,%d", r.getIdKomponen(), r.getMerk(), r.getNamaSeri(), r.getHarga(), r.getTipeMemori(), r.getKapasitasGB());
                } else if (k instanceof GPU) {
                    GPU g = (GPU) k;
                    baris = String.format("GPU,%s,%s,%s,%.0f,%d,%d", g.getIdKomponen(), g.getMerk(), g.getNamaSeri(), g.getHarga(), g.getVramGB(), g.getTdp());
                } else if (k instanceof PSU) {
                    PSU p = (PSU) k;
                    baris = String.format("PSU,%s,%s,%s,%.0f,%d,%s", p.getIdKomponen(), p.getMerk(), p.getNamaSeri(), p.getHarga(), p.getWattase(), p.getSertifikasi());
                } else if (k instanceof Storage) {
                    Storage s = (Storage) k;
                    baris = String.format("Storage,%s,%s,%s,%.0f,%s,%d", s.getIdKomponen(), s.getMerk(), s.getNamaSeri(), s.getHarga(), s.getTipe(), s.getKapasitasGB());
                } else if (k instanceof CPUCooler) {
                    CPUCooler c = (CPUCooler) k;
                    baris = String.format("CPUCooler,%s,%s,%s,%.0f,%s,-", c.getIdKomponen(), c.getMerk(), c.getNamaSeri(), c.getHarga(), c.getTipe());
                } else if (k instanceof Casing) {
                    Casing c = (Casing) k;
                    baris = String.format("Casing,%s,%s,%s,%.0f,%s,-", c.getIdKomponen(), c.getMerk(), c.getNamaSeri(), c.getHarga(), c.getUkuran());
                } else if (k instanceof Keyboard) {
                    Keyboard kbd = (Keyboard) k;
                    baris = String.format("Keyboard,%s,%s,%s,%.0f,%s,-", kbd.getIdKomponen(), kbd.getMerk(), kbd.getNamaSeri(), kbd.getHarga(), kbd.getJenisSwitch());
                } else if (k instanceof Mouse) {
                    Mouse ms = (Mouse) k;
                    baris = String.format("Mouse,%s,%s,%s,%.0f,%d,-", ms.getIdKomponen(), ms.getMerk(), ms.getNamaSeri(), ms.getHarga(), ms.getDpi());
                } else if (k instanceof Monitor) {
                    Monitor mon = (Monitor) k;
                    baris = String.format("Monitor,%s,%s,%s,%.0f,%s,%d", mon.getIdKomponen(), mon.getMerk(), mon.getNamaSeri(), mon.getHarga(), mon.getResolusi(), mon.getRefreshRate());
                }
                bw.write(baris);
                bw.newLine();
            }
            System.out.println("Rakitan berhasil diekspor ke file CSV: " + namaFile);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }

    public static List<KomponenPC> muatRakitan(String namaFile) {
        List<KomponenPC> keranjang = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String baris = br.readLine(); 
            if (baris != null && baris.startsWith("Tipe")) {
                while ((baris = br.readLine()) != null) {
                    String[] d = baris.split(",");
                    if (d.length >= 5) {
                        String t = d[0], id = d[1], merk = d[2], seri = d[3];
                        double hg = Double.parseDouble(d[4]);

                        switch (t) {
                            case "Prosesor": keranjang.add(new Prosesor(id, merk, seri, hg, d[5], Integer.parseInt(d[6]))); break;
                            case "Motherboard": keranjang.add(new Motherboard(id, merk, seri, hg, d[5])); break;
                            case "RAM": keranjang.add(new RAM(id, merk, seri, hg, d[5], Integer.parseInt(d[6]))); break;
                            case "GPU": keranjang.add(new GPU(id, merk, seri, hg, Integer.parseInt(d[5]), Integer.parseInt(d[6]))); break;
                            case "PSU": keranjang.add(new PSU(id, merk, seri, hg, Integer.parseInt(d[5]), d[6])); break;
                            case "Storage": keranjang.add(new Storage(id, merk, seri, hg, d[5], Integer.parseInt(d[6]))); break;
                            case "CPUCooler": keranjang.add(new CPUCooler(id, merk, seri, hg, d[5])); break;
                            case "Casing": keranjang.add(new Casing(id, merk, seri, hg, d[5])); break;
                            case "Keyboard": keranjang.add(new Keyboard(id, merk, seri, hg, d[5])); break;
                            case "Mouse": keranjang.add(new Mouse(id, merk, seri, hg, Integer.parseInt(d[5]))); break;
                            case "Monitor": keranjang.add(new Monitor(id, merk, seri, hg, d[5], Integer.parseInt(d[6]))); break;
                        }
                    }
                }
                System.out.println("[+] Data rakitan dimuat dari " + namaFile);
            }
        } catch (Exception e) {
            System.out.println("[!] Gagal membaca file.");
        }
        return keranjang;
    }
}