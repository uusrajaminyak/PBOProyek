package model;

public class PSU extends KomponenPC {
    private int wattase;
    private String sertifikasi; 

    public PSU(String id, String merk, String seri, double harga, int wattase, String sertifikasi) {
        super(id, merk, seri, harga);
        this.wattase = wattase;
        this.sertifikasi = sertifikasi;
    }

    public int getWattase() { return wattase; }
    public String getSertifikasi() { return sertifikasi; }

    @Override
    public void displaySpesifikasi() {
        System.out.printf("%s %s | %dW %s | Rp%,.0f\n", getMerk(), getNamaSeri(), wattase, sertifikasi, getHarga());
    }
}