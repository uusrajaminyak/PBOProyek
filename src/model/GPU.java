package model;

public class GPU extends KomponenPC {
    private int vramGB;
    private int tdp;

    public GPU(String id, String merk, String seri, double harga, int vramGB, int tdp) {
        super(id, merk, seri, harga);
        this.vramGB = vramGB;
        this.tdp = tdp;
    }

    public int getVramGB() { return vramGB; }
    public int getTdp() { return tdp; }

    @Override
    public void displaySpesifikasi() {
        System.out.printf("%s %s | VRAM: %dGB | TDP: %dW | Rp%,.0f\n", getMerk(), getNamaSeri(), vramGB, tdp, getHarga());
    }
}