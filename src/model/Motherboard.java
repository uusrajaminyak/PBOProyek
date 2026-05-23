package model;

public class Motherboard extends KomponenPC {
    private static final long serialVersionUID = 1L;
    private String socketDukungan;

    public Motherboard(String id, String merk, String seri, double harga, String socketDukungan) {
        super(id, merk, seri, harga);
        this.socketDukungan = socketDukungan;
    }

    public String getSocketDukungan() { return socketDukungan; }

    @Override
    public void displaySpesifikasi() {
        System.out.printf("%s %s | Socket Dukungan: %s | Rp%,.0f\n", 
            getMerk(), getNamaSeri(), socketDukungan, getHarga());
    }
}