package com.posttest4;

class Rental {

    private int id, harga;
    private String jenis, ruang, status;

    public Rental (int id, String jenis, String ruang, int harga, String status) {
        this.id = id;
        this.jenis = jenis;
        this.ruang = ruang;
        this.harga = harga;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    // Update & Read data Rental
    public void rental_update(String jenis, String ruang, int harga, String status) {
        setJenis(jenis);
        setRuang(ruang);
        setHarga(harga);
        setStatus(status);
    }
    
    public void read_rental() {
        System.out.printf(
            " %d   %s\t%s   Rp.%d   %s\n", getId(), getJenis(), getRuang(), getHarga(), getStatus()
        );
    }


    // Check if class is RentalPs || RentalXbox
    public boolean isSubclass() {
        boolean isRentalSub;
        if(this instanceof RentalPs) {
            isRentalSub = true;
            System.out.print("Tambahan konsol vr (y/n)   : ");
        }
        else if(this instanceof RentalXbox) {
            isRentalSub = true;
            System.out.print("Tambahan konsol cam (y/n)  : ");
        } else {
            isRentalSub = false;
        }

        return isRentalSub;
    }

    // Update new Extra condition
    public void isExtra(boolean extra) {
        if(this instanceof RentalPs) {
            ((RentalPs)this).rental_update(extra);
        } else if(this instanceof RentalXbox){
            ((RentalXbox)this).rental_update(extra);
        }
    }
}
