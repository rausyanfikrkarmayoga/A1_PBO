package com.posttest3;

public class Rental {
    
    private int id, umur, jenisPs, lamaSewa, tagihan, usrIdPs;
    private String nama, alamat;

    public Rental(int id, String nama, int umur, String alamat, int jenisPs, int lamaSewa, int tagihan, int usrIdPs) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.jenisPs = jenisPs;
        this.lamaSewa = lamaSewa;
        this.tagihan = tagihan;
        this.usrIdPs = usrIdPs;
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
    
    public int getTagihan() {
        return tagihan;
    }

    public void setTagihan(int tagihan) {
        this.tagihan = tagihan;
    }

    public int getUsrIdPs() {
        return usrIdPs;
    }

    public void setUsrIdPs(int usrIdPs) {
        this.usrIdPs = usrIdPs;
    }
    

    // Overloading Method
    public void informasi_perental(int id, String nama, int umur, String alamat, int jenisPs, int lamaSewa, int tagihan) {
        System.out.println("===============================");
        System.out.println("Id Perental : " + id);
        System.out.println("Nama        : " + nama);
        System.out.println("Umur        : " + umur);
        System.out.println("Alamat      : " + alamat);
        System.out.println("Jenis       : Ps " + jenisPs);
        System.out.println("Lama Sewa   : " + lamaSewa + " jam");
        System.out.println("Tagihan     : Rp." + tagihan);
    }
    
    public void informasi_perental() {
        System.out.println("===============================");
        System.out.println("Id Perental : " + getId());
        System.out.println("Nama        : " + getNama());
        System.out.println("Umur        : " + getUmur());
        System.out.println("Alamat      : " + getAlamat());
        System.out.println("Jenis       : Ps " + getJenisPs());
        System.out.println("Lama Sewa   : " + getLamaSewa() + " jam");
        System.out.println("Tagihan     : Rp." + getTagihan());
        System.out.println("===============================");
    }

    
    // Ubah Data Perental
    public void ubahData_perental(String nama, int umur, String alamat, int jenisPs, int lamaSewa, int tagihan) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.jenisPs = jenisPs;
        this.lamaSewa = lamaSewa;
        this.tagihan = tagihan;
    }
}
