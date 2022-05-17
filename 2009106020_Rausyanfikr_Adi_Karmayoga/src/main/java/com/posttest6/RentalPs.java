package com.posttest6;

class RentalPs extends Rental {
    
    static int jenisPs = 5;
    private boolean vr;
    
    RentalPs(String jenis, String ruang, int harga, String status, boolean vr) {
        super(jenis, ruang, harga, status);
        this.vr = vr;
    }

    public boolean getVr() {
        return vr;
    }

    public void setVr(boolean vr) {
        this.vr = vr;
    }


    static void maksJenisPs() {
        System.out.println("\nMaksimal jenis Ps adalah : " + RentalPs.jenisPs);
    }

    @Override
    public String read_rental() {
        if(getVr() == true) {
            return
                " " + getId() + "   " + getJenis() + " \t" + getRuang() + "   Rp." + getHarga() + "   " + getStatus() + "  +Vr\n"
            ;
        } else {
            return 
                " " + getId() + "   " + getJenis() + " \t" + getRuang() + "   Rp." + getHarga() + "   " + getStatus() + "  no Vr\n"
            ;
        }
    }

    @Override
    public void status_rental() {
        System.out.print("\nData jenis " + getJenis() + " dengan " + getRuang() + " berhasil ditambahkan");
        if(getVr()) {
            System.out.print(",\ndengan VR");
        }
        System.out.print("!\n");
    }

    @Override
    public void status_perental() {
        System.out.print("\nPenyewaan jenis " + getJenis() + " di " + getRuang() + " berhasil disewakan");
        if(getVr()) {
            System.out.print(",\ndengan VR");
        }
        System.out.print("!\n");
    }
    
}
