package service;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class PCBuilderService {

    public double hitungTotalHarga(List<KomponenPC> keranjang) {
        double total = 0;
        for (KomponenPC k : keranjang) total += k.getHarga();
        return total;
    }

    public void cekKompatibilitas(List<KomponenPC> keranjang) {
        Prosesor cpu = null; Motherboard mobo = null;
        for (KomponenPC k : keranjang) {
            if (k instanceof Prosesor) cpu = (Prosesor) k;
            else if (k instanceof Motherboard) mobo = (Motherboard) k;
        }

        System.out.println("[HASIL KOMPATIBILITAS]");
        if (cpu != null && mobo != null) {
            if (cpu.getSocket().equalsIgnoreCase(mobo.getSocketDukungan())) {
                System.out.println("[+] Socket CPU (" + cpu.getSocket() + ") dan Motherboard COCOK.");
            } else {
                System.out.println("[!] SOCKET TIDAK COCOK!");
                System.out.println("CPU butuh: " + cpu.getSocket() + " | MOBO mendukung: " + mobo.getSocketDukungan());
            }
        } else {
            System.out.println("[*] Masukkan minimal 1 CPU dan 1 Motherboard.");
        }
    }

    public List<KomponenPC> getTemplateGamingEntry() {
        List<KomponenPC> t = new ArrayList<>();
        t.add(new Prosesor("P-GE", "Intel", "Core i3-12100F", 1400000, "LGA1700", 58));
        t.add(new Motherboard("M-GE", "ASRock", "H610M-HDV", 1200000, "LGA1700"));
        t.add(new RAM("R-GE", "Kingston", "Fury Beast 16GB", 800000, "DDR4", 16));
        t.add(new GPU("G-GE", "NVIDIA", "GTX 1650", 2500000, 4, 75));
        t.add(new PSU("PS-GE", "DeepCool", "PF450", 500000, 450, "80+ White"));
        t.add(new CPUCooler("CL-GE", "DeepCool", "AK400", 450000, "Air Cooler")); // Tambahan Cooler Entry
        return t;
    }

    public List<KomponenPC> getTemplateAI_Enthusiast() {
        List<KomponenPC> t = new ArrayList<>();
        t.add(new Prosesor("P-AI", "AMD", "Ryzen 9 7950X", 9500000, "AM5", 170));
        t.add(new Motherboard("M-AI", "ASUS", "ROG X670E Hero", 11000000, "AM5"));
        t.add(new RAM("R-AI", "Corsair", "Dominator 64GB", 3500000, "DDR5", 64));
        t.add(new GPU("G-AI", "NVIDIA", "RTX 4090", 35000000, 24, 450));
        t.add(new PSU("PS-AI", "Corsair", "HX1200", 4000000, 1200, "80+ Platinum"));
        t.add(new CPUCooler("CL-AI", "ASUS", "ROG Ryujin III 360", 5500000, "AIO Liquid")); // Tambahan Cooler High-End
        return t;
    }

    public List<KomponenPC> getTemplateContentCreation() {
        List<KomponenPC> t = new ArrayList<>();
        t.add(new Prosesor("P-CC", "Intel", "Core i7-13700K", 6800000, "LGA1700", 125));
        t.add(new Motherboard("M-CC", "MSI", "Z790 Tomahawk", 4500000, "LGA1700"));
        t.add(new RAM("R-CC", "Team", "T-Force 32GB", 1800000, "DDR5", 32));
        t.add(new GPU("G-CC", "NVIDIA", "RTX 4070 Ti", 14000000, 12, 285));
        t.add(new Storage("S-CC", "Samsung", "990 Pro 2TB", 3000000, "NVMe Gen4", 2000));
        t.add(new CPUCooler("CL-CC", "Corsair", "iCUE H150i Elite", 3200000, "AIO Liquid")); // Tambahan Cooler AIO
        return t;
    }

    public List<KomponenPC> getTemplateMiniITX() {
        List<KomponenPC> t = new ArrayList<>();
        t.add(new Motherboard("M-ITX", "Gigabyte", "B550I AORUS PRO AX", 3500000, "AM4"));
        t.add(new Casing("C-ITX", "Cooler Master", "NR200P", 1300000, "Mini-ITX"));
        t.add(new PSU("PS-ITX", "Corsair", "SF750", 2500000, 750, "80+ Platinum SFX"));
        t.add(new CPUCooler("CL-ITX", "Arctic", "Liquid Freezer II 240", 1600000, "AIO Liquid")); // Tambahan AIO ukuran pas
        return t;
    }

    public List<KomponenPC> getTemplateATXFullTower() {
        List<KomponenPC> t = new ArrayList<>();
        t.add(new Motherboard("M-ATX", "ASUS", "TUF Gaming Z690-PLUS", 4200000, "LGA1700"));
        t.add(new Casing("C-ATX", "Corsair", "7000D Airflow", 4500000, "Full Tower"));
        t.add(new CPUCooler("CL-ATX", "NZXT", "Kraken Z73 360mm", 4800000, "AIO Liquid"));
        return t;
    }
}