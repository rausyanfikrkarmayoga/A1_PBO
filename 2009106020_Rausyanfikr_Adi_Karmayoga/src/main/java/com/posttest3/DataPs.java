package com.posttest3;

public class DataPs {

    private int idPs, jenisPs, harga;
    private String ruang, status;

    public DataPs (int idPs, int jenisPs, String ruang, int harga, String status) {
        this.idPs = idPs;
        this.jenisPs = jenisPs;
        this.ruang = ruang;
        this.harga = harga;
        this.status = status;
    }

    public int getIdPs() {
        return idPs;
    }

    public void setIdPs(int idPs) {
        this.idPs = idPs;
    }

    public int getJenisPs() {
        return jenisPs;
    }

    public void setJenisPs(int jenisPs) {
        this.jenisPs = jenisPs;
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


    // Update & Read data
    public void read_psData() {
        System.out.printf(" %d    Ps %d   %s   Rp.%d   %s\n", getIdPs(), getJenisPs(), getRuang(), getHarga(), getStatus());
    }

    public void update_psData(int id, int jenis, String ruang, int harga, String status) {
        this.idPs = id;
        this.jenisPs = jenis;
        this.ruang = ruang;
        this.harga = harga;
        this.status = status;
    }
}
