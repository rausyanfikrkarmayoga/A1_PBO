package com.posttest4;

class RentalXbox extends Rental {
    private boolean cam;

    RentalXbox(int id, String jenis, String ruang, int harga, String status, boolean cam) {
        super(id, jenis, ruang, harga, status);
        this.cam = cam;
    }

    public boolean getCam() {
        return cam;
    }

    public void setCam(boolean cam) {
        this.cam = cam;
    }

    // Overload
    public void rental_update(boolean isCam) {
        setCam(isCam);
    }

    @Override
    public void read_rental() {
        if(getCam()) {
            System.out.printf(
                " %d   %s \t%s   Rp.%d   %s  +Cam\n", getId(), getJenis(), getRuang(), getHarga(), getStatus()
            );
        } else {
            System.out.printf(
                " %d   %s \t%s   Rp.%d   %s  no Cam\n", getId(), getJenis(), getRuang(), getHarga(), getStatus()
            );
        }
    }
    
}
