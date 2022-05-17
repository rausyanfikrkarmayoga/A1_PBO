package com.posttest6;

class RentalXbox extends Rental {
    
    private boolean cam;

    RentalXbox(String jenis, String ruang, int harga, String status, boolean cam) {
        super(jenis, ruang, harga, status);
        this.cam = cam;
    }

    public boolean getCam() {
        return cam;
    }

    public void setCam(boolean cam) {
        this.cam = cam;
    }

    
    @Override
    public String read_rental() {
        if(getCam()) {
            return
                " " + getId() + "   " + getJenis() + " \t" + getRuang() + "   Rp." + getHarga() + "   " + getStatus() + "  +Cam\n"
            ;
        } else {
            return
                " " + getId() + "   " + getJenis() + " \t" + getRuang() + "   Rp." + getHarga() + "   " + getStatus() + "  no Cam\n"
            ;
        }
    }

    @Override
    public void status_rental() {
        System.out.print("\nData konsol " + getJenis() + " dengan " + getRuang() + " berhasil ditambahkan");
        if(getCam()) {
            System.out.print(",\ndengan Cam");
        }
        System.out.print("!\n");
    }

    @Override
    public void status_perental() {
        System.out.print("\nPenyewaan konsol " + getJenis() + " di " + getRuang() + " berhasil disewakan");
        if(getCam()) {
            System.out.print(",\ndengan Cam");
        }
        System.out.print("!\n");
    }
    
}
