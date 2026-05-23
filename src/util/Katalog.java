package util;

import model.KomponenPC;
import java.util.ArrayList;
import java.util.List;

public class Katalog<T extends KomponenPC> {
    private List<T> daftarKomponen;
    private static final String BORDER_TEBAL = "==============================================================";
    private static final String BORDER_TIPIS = "--------------------------------------------------------------";

    public Katalog() {
        this.daftarKomponen = new ArrayList<>();
    }

    public void tambahKomponen(T komponen) {
        daftarKomponen.add(komponen);
    }

    public void tampilkanKatalog(String judul) {
        System.out.println("\n" + BORDER_TEBAL);
        System.out.printf("|| KATALOG: %-48s ||\n", judul.toUpperCase());
        System.out.println(BORDER_TEBAL);

        if (daftarKomponen.isEmpty()) {
            System.out.println("[!] Katalog kosong.");
            System.out.println(BORDER_TIPIS);
            return;
        }

        for (int i = 0; i < daftarKomponen.size(); i++) {
            System.out.printf(" %2d. ", (i + 1));
            daftarKomponen.get(i).displaySpesifikasi(); 
        }
        System.out.println(BORDER_TIPIS);
    }

    public T pilihKomponen(int index) {
        if (index > 0 && index <= daftarKomponen.size()) {
            return daftarKomponen.get(index - 1); 
        }
        return null;
    }
}