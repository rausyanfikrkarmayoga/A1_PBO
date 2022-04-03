package com.posttest2;

public class Rental {
    
    private int id, umur, jenisPs, lamaSewa, tagihan;
    private String nama, alamat;

    public Rental(int id, String nama, int umur, String alamat, int jenisPs, int lamaSewa, int tagihan) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.jenisPs = jenisPs;
        this.lamaSewa = lamaSewa;
        this.tagihan = tagihan;
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
    

    public void daftar_ps() {
        System.out.println("\n == Daftar Ps == ");
        System.out.println("=================");
        System.out.println(" JENIS  HARGA/JAM");
        System.out.println("  Ps 1   Rp.2000");
        System.out.println("  Ps 2   Rp.3000");
        System.out.println("  Ps 3   Rp.5000");
        System.out.println("  Ps 4   Rp.8000");
    }
    //  Overriding Method
    public void daftar_ps(int jenisPs, int harga) {
        System.out.println("\n == Daftar Ps == ");
        System.out.println("=================");
        System.out.println(" JENIS  HARGA/JAM");
        System.out.println("  Ps 1   Rp.2000");
        System.out.println("  Ps 2   Rp.3000");
        System.out.println("  Ps 3   Rp.5000");
        System.out.println("  Ps 4   Rp.8000");
        
        this.jenisPs = jenisPs; this.lamaSewa = harga;
        System.out.printf("  Ps %d   Rp.%d\n", jenisPs, harga);
    }

    public void info_rental() {
        System.out.println("Nama        : " + nama);
        System.out.println("Umur        : " + umur);
        System.out.println("Alamat      : " + alamat);
        System.out.println("Jenis       : Ps " + jenisPs);
        System.out.println("Lama Sewa   : " + lamaSewa + " jam");
        System.out.println("Tagihan     : Rp." + tagihan);
    }
    
}
