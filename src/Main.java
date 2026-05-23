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

        Katalog<Prosesor> katCpu = new Katalog<>();
        Katalog<Motherboard> katMobo = new Katalog<>();
        Katalog<RAM> katRam = new Katalog<>();
        Katalog<GPU> katGpu = new Katalog<>();
        Katalog<PSU> katPsu = new Katalog<>();
        Katalog<Storage> katStorage = new Katalog<>();
        Katalog<CPUCooler> katCooler = new Katalog<>();
        Katalog<Casing> katCasing = new Katalog<>();

        katCpu.tambahKomponen(new Prosesor("C01", "Intel", "Core i3-12100F", 1400000, "LGA1700", 58));
        katCpu.tambahKomponen(new Prosesor("C02", "Intel", "Core i5-12400F", 2500000, "LGA1700", 65));
        katCpu.tambahKomponen(new Prosesor("C03", "Intel", "Core i5-13400F", 3500000, "LGA1700", 65));
        katCpu.tambahKomponen(new Prosesor("C04", "Intel", "Core i7-13700K", 6800000, "LGA1700", 125));
        katCpu.tambahKomponen(new Prosesor("C05", "Intel", "Core i9-14900K", 10500000, "LGA1700", 125));
        katCpu.tambahKomponen(new Prosesor("C06", "AMD", "Ryzen 5 5600X", 2500000, "AM4", 65));
        katCpu.tambahKomponen(new Prosesor("C07", "AMD", "Ryzen 7 5800X3D", 5000000, "AM4", 105));
        katCpu.tambahKomponen(new Prosesor("C08", "AMD", "Ryzen 5 7600X", 4000000, "AM5", 105));
        katCpu.tambahKomponen(new Prosesor("C09", "AMD", "Ryzen 7 7800X3D", 7000000, "AM5", 120));
        katCpu.tambahKomponen(new Prosesor("C10", "AMD", "Ryzen 9 7950X", 9500000, "AM5", 170));

        katMobo.tambahKomponen(new Motherboard("M01", "ASRock", "H610M-HDV", 1200000, "LGA1700"));
        katMobo.tambahKomponen(new Motherboard("M02", "ASUS", "Prime H610M-E", 1400000, "LGA1700"));
        katMobo.tambahKomponen(new Motherboard("M03", "MSI", "MAG B660M Mortar", 2800000, "LGA1700"));
        katMobo.tambahKomponen(new Motherboard("M04", "Gigabyte", "B760M AORUS ELITE", 3000000, "LGA1700"));
        katMobo.tambahKomponen(new Motherboard("M05", "MSI", "PRO Z790-P WIFI", 4000000, "LGA1700"));
        katMobo.tambahKomponen(new Motherboard("M06", "Gigabyte", "B550I AORUS PRO AX (ITX)", 3500000, "AM4"));
        katMobo.tambahKomponen(new Motherboard("M07", "ASUS", "TUF GAMING B550-PLUS", 2500000, "AM4"));
        katMobo.tambahKomponen(new Motherboard("M08", "MSI", "MAG B650 TOMAHAWK", 3800000, "AM5"));
        katMobo.tambahKomponen(new Motherboard("M09", "ASRock", "X670E Taichi", 8500000, "AM5"));
        katMobo.tambahKomponen(new Motherboard("M10", "ASUS", "ROG X670E Hero", 11000000, "AM5"));

        katRam.tambahKomponen(new RAM("R01", "Kingston", "Fury Beast 8GB", 400000, "DDR4", 8));
        katRam.tambahKomponen(new RAM("R02", "Adata", "XPG Spectrix 8GB", 450000, "DDR4", 8));
        katRam.tambahKomponen(new RAM("R03", "Team", "T-Force Delta 16GB", 850000, "DDR4", 16));
        katRam.tambahKomponen(new RAM("R04", "PNY", "XLR8 16GB", 800000, "DDR4", 16));
        katRam.tambahKomponen(new RAM("R05", "KLEVV", "CRAS X 16GB", 900000, "DDR4", 16));
        katRam.tambahKomponen(new RAM("R06", "Kingston", "Fury Beast 32GB", 1600000, "DDR5", 32));
        katRam.tambahKomponen(new RAM("R07", "Corsair", "Vengeance 32GB", 1800000, "DDR5", 32));
        katRam.tambahKomponen(new RAM("R08", "Team", "Delta RGB 32GB", 1900000, "DDR5", 32));
        katRam.tambahKomponen(new RAM("R09", "G.Skill", "Trident Z5 64GB", 3800000, "DDR5", 64));
        katRam.tambahKomponen(new RAM("R10", "Corsair", "Dominator 64GB", 4200000, "DDR5", 64));

        katGpu.tambahKomponen(new GPU("G01", "NVIDIA", "GTX 1650", 2500000, 4, 75));
        katGpu.tambahKomponen(new GPU("G02", "NVIDIA", "RTX 3050", 3500000, 8, 130));
        katGpu.tambahKomponen(new GPU("G03", "NVIDIA", "RTX 3060", 4800000, 12, 170));
        katGpu.tambahKomponen(new GPU("G04", "NVIDIA", "RTX 4060", 5500000, 8, 115));
        katGpu.tambahKomponen(new GPU("G05", "NVIDIA", "RTX 4070 Ti", 14000000, 12, 285));
        katGpu.tambahKomponen(new GPU("G06", "NVIDIA", "RTX 4090", 35000000, 24, 450));
        katGpu.tambahKomponen(new GPU("G07", "AMD", "Radeon RX 6600", 3500000, 8, 132));
        katGpu.tambahKomponen(new GPU("G08", "AMD", "Radeon RX 7600", 5000000, 8, 165));
        katGpu.tambahKomponen(new GPU("G09", "AMD", "Radeon RX 7800 XT", 9000000, 16, 263));
        katGpu.tambahKomponen(new GPU("G10", "AMD", "Radeon RX 7900 XTX", 18000000, 24, 355));

        katPsu.tambahKomponen(new PSU("P01", "DeepCool", "PF450", 500000, 450, "80+ White"));
        katPsu.tambahKomponen(new PSU("P02", "FSP", "HV PRO 550", 650000, 550, "80+ Bronze"));
        katPsu.tambahKomponen(new PSU("P03", "Cooler Master", "MWE 650", 950000, 650, "80+ Bronze"));
        katPsu.tambahKomponen(new PSU("P04", "Corsair", "RM650", 1500000, 650, "80+ Gold"));
        katPsu.tambahKomponen(new PSU("P05", "Corsair", "SF750 (SFX)", 2500000, 750, "80+ Platinum"));
        katPsu.tambahKomponen(new PSU("P06", "MSI", "MAG A750GL", 1600000, 750, "80+ Gold"));
        katPsu.tambahKomponen(new PSU("P07", "Thermaltake", "Toughpower 850W", 1900000, 850, "80+ Gold"));
        katPsu.tambahKomponen(new PSU("P08", "be quiet!", "Pure Power 1000W", 2800000, 1000, "80+ Gold"));
        katPsu.tambahKomponen(new PSU("P09", "Seasonic", "Prime TX-1000", 4500000, 1000, "80+ Titanium"));
        katPsu.tambahKomponen(new PSU("P10", "ASUS", "ROG Thor 1200W", 6000000, 1200, "80+ Platinum"));

        katStorage.tambahKomponen(new Storage("S01", "WD", "Blue 1TB HDD", 700000, "HDD", 1000));
        katStorage.tambahKomponen(new Storage("S02", "Seagate", "Barracuda 2TB HDD", 950000, "HDD", 2000));
        katStorage.tambahKomponen(new Storage("S03", "Adata", "SU650 512GB", 450000, "SATA SSD", 512));
        katStorage.tambahKomponen(new Storage("S04", "Samsung", "870 EVO 1TB", 1500000, "SATA SSD", 1000));
        katStorage.tambahKomponen(new Storage("S05", "Kingston", "NV2 500GB", 600000, "NVMe Gen4", 500));
        katStorage.tambahKomponen(new Storage("S06", "Crucial", "P3 1TB", 1000000, "NVMe Gen3", 1000));
        katStorage.tambahKomponen(new Storage("S07", "Team", "MP44L 1TB", 1100000, "NVMe Gen4", 1000));
        katStorage.tambahKomponen(new Storage("S08", "Samsung", "980 Pro 1TB", 1800000, "NVMe Gen4", 1000));
        katStorage.tambahKomponen(new Storage("S09", "WD", "Black SN850X 2TB", 3200000, "NVMe Gen4", 2000));
        katStorage.tambahKomponen(new Storage("S10", "Corsair", "MP700 2TB", 5000000, "NVMe Gen5", 2000));

        katCooler.tambahKomponen(new CPUCooler("CL01", "DeepCool", "AK400", 450000, "Air Cooler"));
        katCooler.tambahKomponen(new CPUCooler("CL02", "Cooler Master", "Hyper 212", 600000, "Air Cooler"));
        katCooler.tambahKomponen(new CPUCooler("CL03", "Arctic", "Freezer 34 eSports", 750000, "Air Cooler"));
        katCooler.tambahKomponen(new CPUCooler("CL04", "Noctua", "NH-U12S", 1200000, "Air Cooler"));
        katCooler.tambahKomponen(new CPUCooler("CL05", "Be Quiet!", "Dark Rock Pro 4", 1500000, "Air Cooler"));
        katCooler.tambahKomponen(new CPUCooler("CL06", "Noctua", "NH-D15", 1800000, "Air Cooler"));
        katCooler.tambahKomponen(new CPUCooler("CL07", "Arctic", "Liquid Freezer II 240", 1600000, "AIO Liquid"));
        katCooler.tambahKomponen(new CPUCooler("CL08", "NZXT", "Kraken 240", 2200000, "AIO Liquid"));
        katCooler.tambahKomponen(new CPUCooler("CL09", "Corsair", "iCUE H150i Elite", 3200000, "AIO Liquid"));
        katCooler.tambahKomponen(new CPUCooler("CL10", "ASUS", "ROG Ryujin III 360", 5500000, "AIO Liquid"));

        katCasing.tambahKomponen(new Casing("CS01", "Cube Gaming", "Finesse", 450000, "Micro-ATX"));
        katCasing.tambahKomponen(new Casing("CS02", "Paradox Gaming", "Trickster", 550000, "Micro-ATX"));
        katCasing.tambahKomponen(new Casing("CS03", "Cooler Master", "NR200P", 1300000, "Mini-ITX"));
        katCasing.tambahKomponen(new Casing("CS04", "Corsair", "4000D Airflow", 1500000, "ATX Mid-Tower"));
        katCasing.tambahKomponen(new Casing("CS05", "NZXT", "H5 Flow", 1400000, "ATX Mid-Tower"));
        katCasing.tambahKomponen(new Casing("CS06", "Fractal Design", "Pop Air", 1600000, "ATX Mid-Tower"));
        katCasing.tambahKomponen(new Casing("CS07", "Phanteks", "Eclipse G360A", 1700000, "ATX Mid-Tower"));
        katCasing.tambahKomponen(new Casing("CS08", "Be Quiet!", "Pure Base 500DX", 1800000, "ATX Mid-Tower"));
        katCasing.tambahKomponen(new Casing("CS09", "Hyte", "Y60", 3000000, "ATX Mid-Tower"));
        katCasing.tambahKomponen(new Casing("CS10", "Lian Li", "O11 Dynamic XL", 3500000, "Full Tower"));

        List<KomponenPC> keranjang = new ArrayList<>();
        boolean berjalan = true;

        while (berjalan) {
            bersihkanLayar();
            System.out.println(BORDER_TEBAL);
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
            bersihkanLayar();

            if (pilihan == -1) continue;

            switch (pilihan) {
                case 1:
                    boolean belanja = true;
                    while (belanja) {
                        bersihkanLayar();
                        System.out.println(BORDER_TIPIS);
                        System.out.println("||                     KATEGORI KOMPONEN                      ||");
                        System.out.println(BORDER_TIPIS);
                        System.out.println("|| [1]. Prosesor       [4]. GPU           [7]. Casing         ||");
                        System.out.println("|| [2]. Motherboard    [5]. PSU           [8]. Cooler         ||");
                        System.out.println("|| [3]. RAM            [6]. Storage       [0]. Kembali        ||");
                        System.out.println(BORDER_TIPIS);
                        System.out.print("[+] Pilih komponen: ");
                        
                        int pilBelanja = bacaInputAngka(scanner);
                        bersihkanLayar();

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
                            case 8: katAktif = katCooler; break;
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
                                    System.out.println("[+] " + k.getNamaSeri() + " berhasil ditambahkan.");
                                }
                            }
                            tahanLayar(scanner);
                        }
                    }
                    break;
                case 2:
                    System.out.println(BORDER_TEBAL);
                    System.out.println("||                  DETAIL KERANJANG RAKITAN                  ||");
                    System.out.println(BORDER_TEBAL);
                    if (keranjang.isEmpty()) System.out.println("[*] Keranjang kosong.");
                    else {
                        for (KomponenPC k : keranjang) k.displaySpesifikasi();
                        System.out.println(BORDER_TIPIS);
                        System.out.printf("[+] ESTIMASI BIAYA: Rp%,.0f\n", service.hitungTotalHarga(keranjang));
                    }
                    tahanLayar(scanner);
                    break;
                case 3: 
                    System.out.println(BORDER_TIPIS);
                    service.cekKompatibilitas(keranjang); 
                    System.out.println(BORDER_TIPIS);
                    tahanLayar(scanner);
                    break;
                case 4:
                    System.out.println(BORDER_TIPIS);
                    System.out.println("||                    PILIH KATEGORI PRESET                   ||");
                    System.out.println(BORDER_TIPIS);
                    System.out.println("[1]. Berdasarkan Kebutuhan & Fungsi");
                    System.out.println("[2]. Berdasarkan Ukuran/Form Factor");
                    System.out.println("[0]. Kembali");
                    System.out.println(BORDER_TIPIS);
                    System.out.print("[+] Pilih kategori: ");
                    int pilKategori = bacaInputAngka(scanner);
                    bersihkanLayar();

                    if (pilKategori == 1) {
                        System.out.println(BORDER_TIPIS);
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
                        tahanLayar(scanner);
                    } 
                    else if (pilKategori == 2) {
                        System.out.println(BORDER_TIPIS);
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
                        tahanLayar(scanner);
                    } else if (pilKategori == 0) {
                        break;
                    } else {
                        System.out.println("[!] Pilihan kategori tidak valid.");
                        tahanLayar(scanner);
                    }
                    break;
                case 5:
                    System.out.println(BORDER_TIPIS);
                    System.out.print("[1]. Ekspor Data ke CSV\n");
                    System.out.print("[2]. Impor Data dari CSV\n");
                    System.out.print("[0]. Kembali\n");
                    System.out.println(BORDER_TIPIS);
                    System.out.print("[+] Pilih opsi: ");
                    int pilF = bacaInputAngka(scanner);
                    if (pilF == 1) FileHandler.simpanRakitan(keranjang, namaFilePersistensi);
                    else if (pilF == 2) keranjang = FileHandler.muatRakitan(namaFilePersistensi);
                    tahanLayar(scanner);
                    break;
                case 0: 
                    berjalan = false; 
                    System.out.println("[+] Bye Bye."); 
                    break;
                default: 
                    System.out.println("[!] Pilihan tidak valid.");
                    tahanLayar(scanner);
            }
        }
        scanner.close();
    }

    private static int bacaInputAngka(Scanner scanner) {
        try {
            int input = scanner.nextInt();
            scanner.nextLine(); 
            return input;
        } catch (InputMismatchException e) {
            System.out.println("[!] Harap masukkan angka bulat.");
            scanner.nextLine(); 
            return -1;
        }
    }

    private static void bersihkanLayar() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {}
    }

    private static void tahanLayar(Scanner scanner) {
        System.out.print("\n[+] Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        bersihkanLayar();
    }
}