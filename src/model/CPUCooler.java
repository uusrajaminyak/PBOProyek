package model;

public class CPUCooler extends KomponenPC {
    private String tipe;

    public CPUCooler(String id, String merk, String seri, double harga, String tipe) {
        super(id, merk, seri, harga);
        this.tipe = tipe;
    }

    public String getTipe() { return tipe; }

    @Override
    public void displaySpesifikasi() {
        System.out.printf("%s %s | Tipe: %s | Rp%,.0f\n", getMerk(), getNamaSeri(), tipe, getHarga());
    }
}