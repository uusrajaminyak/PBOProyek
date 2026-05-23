package model;

public class RAM extends KomponenPC {
    private static final long serialVersionUID = 1L;
    private String tipeMemori;
    private int kapasitasGB;

    public RAM(String id, String merk, String seri, double harga, String tipeMemori, int kapasitasGB) {
        super(id, merk, seri, harga);
        this.tipeMemori = tipeMemori;
        this.kapasitasGB = kapasitasGB;
    }

    public String getTipeMemori() { return tipeMemori; }
    public int getKapasitasGB() { return kapasitasGB; }

    @Override
    public void displaySpesifikasi() {
        System.out.printf("%s %s | %s %dGB | Rp%,.0f\n", 
            getMerk(), getNamaSeri(), tipeMemori, kapasitasGB, getHarga());
    }
}