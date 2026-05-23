package model;

public class Monitor extends KomponenPC {
    private String resolusi;
    private int refreshRate;

    public Monitor(String id, String merk, String seri, double harga, String resolusi, int refreshRate) {
        super(id, merk, seri, harga);
        this.resolusi = resolusi;
        this.refreshRate = refreshRate;
    }

    public String getResolusi() { return resolusi; }
    public int getRefreshRate() { return refreshRate; }

    @Override
    public void displaySpesifikasi() {
        System.out.printf("%s %s | %s %dHz | Rp%,.0f\n", getMerk(), getNamaSeri(), resolusi, refreshRate, getHarga());
    }
}