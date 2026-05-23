package model;

public class Keyboard extends KomponenPC {
    private String jenisSwitch;

    public Keyboard(String id, String merk, String seri, double harga, String jenisSwitch) {
        super(id, merk, seri, harga);
        this.jenisSwitch = jenisSwitch;
    }

    public String getJenisSwitch() { return jenisSwitch; }

    @Override
    public void displaySpesifikasi() {
        System.out.printf("%s %s | Switch: %s | Rp%,.0f\n", getMerk(), getNamaSeri(), jenisSwitch, getHarga());
    }
}