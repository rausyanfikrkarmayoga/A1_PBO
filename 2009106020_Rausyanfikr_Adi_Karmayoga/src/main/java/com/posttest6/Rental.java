package com.posttest6;

abstract class Rental implements Konsol {

    static int jumlahKonsol;
    private int id, harga;
    private String jenis, ruang, status;

    public Rental (String jenis, String ruang, int harga, String status) {
        this.id = ++jumlahKonsol;
        this.jenis = jenis;
        this.ruang = ruang;
        this.harga = harga;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public void rental_update(String jenis, String ruang, int harga, String status) {
        setJenis(jenis);
        setRuang(ruang);
        setHarga(harga);
        setStatus(status);
    }

    public void rental_update(boolean extra) {
        if(this instanceof RentalXbox) {
            ((RentalXbox)this).setCam(extra);
        } else if(this instanceof RentalPs) {
            ((RentalPs)this).setVr(extra);
        }
    }
    
    static void rental_update(int maxPs) {
        if(maxPs > RentalPs.jenisPs) {
            RentalPs.jenisPs = maxPs;
        }
    }

}
