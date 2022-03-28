package com.posttest1;

public class Rental {
    private int id;
    private String nama;
    private int jenisPs;
    private int lamaSewa;

    public Rental(int id, String nama, int jenisPs, int lamaSewa) {
        this.id = id;
        this.nama = nama;
        this.jenisPs = jenisPs;
        this.lamaSewa = lamaSewa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJenisPs() {
        return jenisPs;
    }

    public void setJenisPs(int jenisPs) {
        this.jenisPs = jenisPs;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }
}
