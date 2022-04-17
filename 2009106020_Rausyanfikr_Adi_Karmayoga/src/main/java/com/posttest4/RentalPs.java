package com.posttest4;

class RentalPs extends Rental {
    private boolean vr;
    
    RentalPs(int id, String jenis, String ruang, int harga, String status, boolean vr) {
        super(id, jenis, ruang, harga, status);
        this.vr = vr;
    }

    public boolean getVr() {
        return vr;
    }

    public void setVr(boolean vr) {
        this.vr = vr;
    }

    // Overload
    public void rental_update(boolean isVr) {
        setVr(isVr);
    }

    @Override
    public void read_rental() {
        if(getVr()) {
            System.out.printf(
                " %d   %s \t%s   Rp.%d   %s  +Vr\n", getId(), getJenis(), getRuang(), getHarga(), getStatus()
            );
        } else {
            System.out.printf(
                " %d   %s \t%s   Rp.%d   %s  no Vr\n", getId(), getJenis(), getRuang(), getHarga(), getStatus()
            );
        }
    }
}
