package model;

import java.io.Serializable;

public abstract class KomponenPC implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idKomponen;
    private String merk;
    private String namaSeri;
    private double harga;

    public KomponenPC(String idKomponen, String merk, String namaSeri, double harga) {
        this.idKomponen = idKomponen;
        this.merk = merk;
        this.namaSeri = namaSeri;
        this.harga = harga;
    }

    public String getIdKomponen() { 
        return idKomponen; 
    }

    public String getMerk() { 
        return merk; 
    }

    public String getNamaSeri() { 
        return namaSeri; 
    }

    public double getHarga() { 
        return harga; 
    }

    public abstract void displaySpesifikasi();
}
