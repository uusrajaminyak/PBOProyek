package model;

public class Casing extends KomponenPC {
    private String ukuran; 

    public Casing(String id, String merk, String seri, double harga, String ukuran) {
        super(id, merk, seri, harga);
        this.ukuran = ukuran;
    }

    public String getUkuran() { return ukuran; }

    @Override
    public void displaySpesifikasi() {
        System.out.printf("%s %s | Ukuran: %s | Rp%,.0f\n", getMerk(), getNamaSeri(), ukuran, getHarga());
    }
}