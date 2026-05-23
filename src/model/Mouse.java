package model;

public class Mouse extends KomponenPC {
    private int dpi;

    public Mouse(String id, String merk, String seri, double harga, int dpi) {
        super(id, merk, seri, harga);
        this.dpi = dpi;
    }

    public int getDpi() { return dpi; }

    @Override
    public void displaySpesifikasi() {
        System.out.printf("%s %s | %d DPI | Rp%,.0f\n", getMerk(), getNamaSeri(), dpi, getHarga());
    }
}