package com.posttest4;

public class Perental {
    
    private int id, umur, lamaSewa, tagihan, idKonsol;
    private String nama, alamat;

    Perental(int id, String nama, int umur, String alamat, int lamaSewa, int tagihan, int idKonsol) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.lamaSewa = lamaSewa;
        this.tagihan = tagihan;
        this.idKonsol = idKonsol;
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

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }
    
    public int getTagihan() {
        return tagihan;
    }

    public void setTagihan(int tagihan) {
        this.tagihan = tagihan;
    }

    public int getIdKonsol() {
        return idKonsol;
    }

    public void setIdKonsol(int idKonsol) {
        this.idKonsol = idKonsol;
    }
}
