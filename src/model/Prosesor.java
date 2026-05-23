package model;

public class Prosesor extends KomponenPC {
    private static final long serialVersionUID = 1L;
    private String socket;
    private int tdp;

    public Prosesor(String id, String merk, String seri, double harga, String socket, int tdp) {
        super(id, merk, seri, harga);
        this.socket = socket;
        this.tdp = tdp;
    }

    public String getSocket() { return socket; }
    public int getTdp() { return tdp; }

    @Override
    public void displaySpesifikasi() {
        System.out.printf("%s %s | Socket: %s | TDP: %dW | Rp%,.0f\n", 
            getMerk(), getNamaSeri(), socket, tdp, getHarga());
    }
}