package model;

public class Storage extends KomponenPC {
    private String tipe; 
    private int kapasitasGB;

    public Storage(String id, String merk, String seri, double harga, String tipe, int kapasitasGB) {
        super(id, merk, seri, harga);
        this.tipe = tipe;
        this.kapasitasGB = kapasitasGB;
    }

    public String getTipe() { return tipe; }
    public int getKapasitasGB() { return kapasitasGB; }

    @Override
    public void displaySpesifikasi() {
        System.out.printf("%s %s | %s %dGB | Rp%,.0f\n", getMerk(), getNamaSeri(), tipe, kapasitasGB, getHarga());
    }
}