import model.*;
import service.PCBuilderService;
import util.FileHandler;
import util.Katalog;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String BORDER_TEBAL = "================================================================";
    private static final String BORDER_TIPIS = "----------------------------------------------------------------";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PCBuilderService service = new PCBuilderService();
        String namaFilePersistensi = "rakitan_tersimpan.csv";

        // Inisialisasi Katalog
        Katalog<Prosesor> katCpu = new Katalog<>();
        Katalog<Motherboard> katMobo = new Katalog<>();
        Katalog<RAM> katRam = new Katalog<>();
        Katalog<GPU> katGpu = new Katalog<>();
        Katalog<PSU> katPsu = new Katalog<>();
        Katalog<Storage> katStorage = new Katalog<>();
        Katalog<CPUCooler> katCooler = new Katalog<>();
        Katalog<Casing> katCasing = new Katalog<>();

        // ===== POPULASI KATALOG (BIAR RAME!) =====
        katCpu.tambahKomponen(new Prosesor("C01", "Intel", "Core i3-12100F", 1400000, "LGA1700", 58));
        katCpu.tambahKomponen(new Prosesor("C02", "Intel", "Core i5-13400F", 3500000, "LGA1700", 65));
        katCpu.tambahKomponen(new Prosesor("C03", "Intel", "Core i9-14900K", 10500000, "LGA1700", 125));
        katCpu.tambahKomponen(new Prosesor("C04", "AMD", "Ryzen 5 5600X", 2500000, "AM4", 65));
        katCpu.tambahKomponen(new Prosesor("C05", "AMD", "Ryzen 9 7950X", 9500000, "AM5", 170));

        katMobo.tambahKomponen(new Motherboard("M01", "ASRock", "H610M-HDV", 1200000, "LGA1700"));
        katMobo.tambahKomponen(new Motherboard("M02", "MSI", "MAG B660M Mortar", 2800000, "LGA1700"));
        katMobo.tambahKomponen(new Motherboard("M03", "Gigabyte", "B550I AORUS PRO AX (ITX)", 3500000, "AM4"));
        katMobo.tambahKomponen(new Motherboard("M04", "ASUS", "ROG X670E Hero", 11000000, "AM5"));

        katRam.tambahKomponen(new RAM("R01", "Kingston", "Fury Beast 8GB", 400000, "DDR4", 8));
        katRam.tambahKomponen(new RAM("R02", "Team", "T-Force Delta 16GB", 850000, "DDR4", 16));
        katRam.tambahKomponen(new RAM("R03", "Corsair", "Vengeance 32GB", 1800000, "DDR5", 32));
        katRam.tambahKomponen(new RAM("R04", "G.Skill", "Trident Z5 64GB", 3800000, "DDR5", 64));

        katGpu.tambahKomponen(new GPU("G01", "NVIDIA", "GTX 1650", 2500000, 4, 75));
        katGpu.tambahKomponen(new GPU("G02", "NVIDIA", "RTX 3060", 4800000, 12, 170));
        katGpu.tambahKomponen(new GPU("G03", "NVIDIA", "RTX 4070 Ti", 14000000, 12, 285));
        katGpu.tambahKomponen(new GPU("G04", "NVIDIA", "RTX 4090", 35000000, 24, 450));
        katGpu.tambahKomponen(new GPU("G05", "AMD", "Radeon RX 6600", 3500000, 8, 132));

        katPsu.tambahKomponen(new PSU("P01", "DeepCool", "PF450", 500000, 450, "80+ White"));
        katPsu.tambahKomponen(new PSU("P02", "Corsair", "RM650", 1500000, 650, "80+ Gold"));
        katPsu.tambahKomponen(new PSU("P03", "Corsair", "SF750 (SFX)", 2500000, 750, "80+ Platinum"));
        katPsu.tambahKomponen(new PSU("P04", "Seasonic", "Prime TX-1000", 4500000, 1000, "80+ Titanium"));

        katCasing.tambahKomponen(new Casing("CS1", "Cube Gaming", "Finesse", 450000, "Micro-ATX"));
        katCasing.tambahKomponen(new Casing("CS2", "Cooler Master", "NR200P", 1300000, "Mini-ITX"));
        katCasing.tambahKomponen(new Casing("CS3", "Corsair", "4000D Airflow", 1500000, "ATX Mid-Tower"));
        katCasing.tambahKomponen(new Casing("CS4", "Lian Li", "O11 Dynamic XL", 3500000, "Full Tower"));

        List<KomponenPC> keranjang = new ArrayList<>();
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n" + BORDER_TEBAL);
            System.out.println("||                         MENU UTAMA                         ||");
            System.out.println(BORDER_TEBAL);
            System.out.println("|| [1]. Pilih Komponen                                        ||");
            System.out.println("|| [2]. Lihat Detail Keranjang                                ||");
            System.out.println("|| [3]. Cek Kompatibilitas                                    ||");
            System.out.println("|| [4]. Gunakan Preset                                        ||");
            System.out.println("|| [5]. Simpan/Load Preset                                    ||");
            System.out.println("|| [0]. Keluar                                                ||");
            System.out.println(BORDER_TEBAL);
            System.out.print("[+] Masukkan pilihan: ");

            int pilihan = bacaInputAngka(scanner);
            if (pilihan == -1) continue;

            switch (pilihan) {
                case 1:
                    boolean belanja = true;
                    while (belanja) {
                        System.out.println("\n" + BORDER_TIPIS);
                        System.out.println("||                     KATEGORI KOMPONEN                      ||");
                        System.out.println(BORDER_TIPIS);
                        System.out.println("|| [1]. Prosesor       [4]. GPU           [7]. Casing         ||");
                        System.out.println("|| [2]. Motherboard    [5]. PSU           [0]. Kembali        ||");
                        System.out.println("|| [3]. RAM            [6]. Storage                           ||");
                        System.out.println(BORDER_TIPIS);
                        System.out.print("[+] Pilih komponen: ");
                        
                        int pilBelanja = bacaInputAngka(scanner);
                        if (pilBelanja == 0) { belanja = false; break; }

                        Katalog<? extends KomponenPC> katAktif = null;
                        switch (pilBelanja) {
                            case 1: katAktif = katCpu; break;
                            case 2: katAktif = katMobo; break;
                            case 3: katAktif = katRam; break;
                            case 4: katAktif = katGpu; break;
                            case 5: katAktif = katPsu; break;
                            case 6: katAktif = katStorage; break;
                            case 7: katAktif = katCasing; break;
                            default: System.out.println("[!] Kategori tidak tersedia.");
                        }

                        if (katAktif != null) {
                            katAktif.tampilkanKatalog("DAFTAR KOMPONEN TERSEDIA");
                            System.out.print("[+] Pilih nomor komponen atau 0 untuk kembali: ");
                            int pilBarang = bacaInputAngka(scanner);
                            if (pilBarang > 0) {
                                KomponenPC k = katAktif.pilihKomponen(pilBarang);
                                if (k != null) {
                                    keranjang.add(k);
                                    System.out.println("[+]" + k.getNamaSeri() + " berhasil ditambahkan.");
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n" + BORDER_TEBAL);
                    System.out.println("||                 DETAIL KERANJANG RAKITAN                 ||");
                    System.out.println(BORDER_TEBAL);
                    if (keranjang.isEmpty()) System.out.println("[*] Keranjang kosong.");
                    else {
                        for (KomponenPC k : keranjang) k.displaySpesifikasi();
                        System.out.println(BORDER_TIPIS);
                        System.out.printf("[+] ESTIMASI BIAYA: Rp%,.0f\n", service.hitungTotalHarga(keranjang));
                    }
                    break;
                case 3: 
                    System.out.println("\n" + BORDER_TIPIS);
                    service.cekKompatibilitas(keranjang); 
                    System.out.println(BORDER_TIPIS);
                    break;
                case 4:
                    System.out.println("\n" + BORDER_TIPIS);
                    System.out.println("||                    PILIH KATEGORI PRESET                   ||");
                    System.out.println(BORDER_TIPIS);
                    System.out.println("[1]. Berdasarkan Kebutuhan & Fungsi");
                    System.out.println("[2]. Berdasarkan Ukuran/Form Factor");
                    System.out.println("[0]. Kembali");
                    System.out.println(BORDER_TIPIS);
                    System.out.print("[+] Pilih kategori: ");
                    int pilKategori = bacaInputAngka(scanner);

                    System.out.println(BORDER_TIPIS);
                    if (pilKategori == 1) {
                        System.out.println("[1]. Entry-Level Gaming");
                        System.out.println("[2]. Content Creation");
                        System.out.println("[3]. AI/Machine Learning Enthusiast");
                        System.out.println("[0]. Kembali");
                        System.out.println(BORDER_TIPIS);
                        System.out.print("[+] Pilih preset: ");
                        int p1 = bacaInputAngka(scanner);
                        if (p1 == 1) keranjang = service.getTemplateGamingEntry();
                        else if (p1 == 2) keranjang = service.getTemplateContentCreation();
                        else if (p1 == 3) keranjang = service.getTemplateAI_Enthusiast();
                        else if (p1 == 0) break;
                        System.out.println("[+] Preset Fungsi berhasil dimuat!");
                    } 
                    else if (pilKategori == 2) {
                        System.out.println("[1]. Mini-ITX");
                        System.out.println("[2]. ATX Full Tower");
                        System.out.println("[0]. Kembali");
                        System.out.println(BORDER_TIPIS);
                        System.out.print("[+] Pilih preset: ");
                        int p2 = bacaInputAngka(scanner);
                        if (p2 == 1) keranjang = service.getTemplateMiniITX();
                        else if (p2 == 2) keranjang = service.getTemplateATXFullTower();
                        else if (p2 == 0) break;
                        System.out.println(BORDER_TIPIS);
                        System.out.println("[+] Preset Ukuran berhasil dimuat!");
                    } else if (pilKategori == 0) break;
                    else {
                        System.out.println("[!] Pilihan kategori tidak valid.");
                    }
                    break;
                case 5:
                    System.out.println("\n" + BORDER_TIPIS);
                    System.out.print("[+] 1. Ekspor Data ke CSV | 2. Impor Data dari CSV : ");
                    int pilF = bacaInputAngka(scanner);
                    if (pilF == 1) FileHandler.simpanRakitan(keranjang, namaFilePersistensi);
                    else if (pilF == 2) keranjang = FileHandler.muatRakitan(namaFilePersistensi);
                    break;
                case 0: 
                    berjalan = false; 
                    System.out.println("\n[+] Terminasi program berhasil."); 
                    break;
                default: 
                    System.out.println("[!] Pilihan tidak valid.");
            }
        }
        scanner.close();
    }

    private static int bacaInputAngka(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("[!] Harap masukkan angka bulat.");
            scanner.nextLine(); 
            return -1;
        }
    }
}