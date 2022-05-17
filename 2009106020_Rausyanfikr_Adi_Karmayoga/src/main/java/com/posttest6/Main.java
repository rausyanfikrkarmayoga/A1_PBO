package com.posttest6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static private final Scanner input = new Scanner(System.in);
    static private ArrayList<Perental> daftarPerental = new ArrayList<Perental>();
    static private ArrayList<Rental> daftarRental = new ArrayList<Rental>();
    static private Perental user;
    static private Rental konsol;
        
    public static void main(String[] args) {

        user = new Perental("Rausyan", 19, "Air Hitam", 4, 20000, 2);
        daftarPerental.add(user);
        
        Rental data1 = new RentalPs("Ps 2", "Ruang 1", 3000, "Tersedia", false); daftarRental.add(data1);
        Rental data2 = new RentalPs("Ps 3", "Ruang 2", 5000, "  Disewa", false); daftarRental.add(data2);
        Rental data3 = new RentalPs("Ps 3", "Ruang 3", 5000, "Tersedia", false); daftarRental.add(data3);
        Rental data4 = new RentalPs("Ps 4", "Ruang 4", 8000, "Tersedia", true); daftarRental.add(data4);
        Rental data5 = new RentalPs("Ps 4", "Ruang 5", 8000, "Tersedia", true); daftarRental.add(data5);

        Rental data6 = new RentalXbox("Xbox One", "Ruang 6", 6000, "Tersedia", true); daftarRental.add(data6);
        Rental data7 = new RentalXbox("Xbox One", "Ruang 7", 6000, "Tersedia", true); daftarRental.add(data7);
        Rental data8 = new RentalXbox("Xbox 360", "Ruang 8", 4000, "Tersedia", false); daftarRental.add(data8);

        int menu;
        do {
            clear_screen();
            System.out.println("   ===RENTAL KONSOL GAME===");
            System.out.println("===========================");
            System.out.println("1. Informasi Daftar Konsol");
            System.out.println("2. Informasi Data Perental");
            System.out.println("3. Tambah Data Perental");
            System.out.println("4. Tampilkan Daftar Perental");
            System.out.println("5. Ubah Data Perental");
            System.out.println("6. Hapus Data Perental");
            System.out.println("0. Keluar");
            System.out.print("Masukkan nomor menu : ");
            menu = input.nextInt(); input.nextLine();

            if(menu > 0) {
                menu_rental(menu);
            }
        } while(menu != 0);

        
        System.out.println("\nProgram selesai.");
        System.exit(0);
    }
    
    static private void menu_rental(int menu) {
        switch(menu) {
            case 1:
                data_konsol();
                break;
            case 2:
                data_perental();
                break;
            case 3:
                create_data();
                continue_input();
                break;
            case 4:
                read_data();
                continue_input();
                break;
            case 5:
                update_data();
                continue_input();
                break;
            case 6:
                delete_data();
                continue_input();
                break;
            default:
                System.out.println("\nMenu tidak tersedia lebih dari 6.");
                continue_input();
        }
    }
    

    // CRUD Konsol Rental
    static private void data_konsol() {
        clear_screen();
        System.out.println("           === Informasi Daftar Konsol ===         ");
        System.out.println("===================================================");
        System.out.println(" ID  KONSOL\tRUANGAN   HARGA/JAM   STATUS  EXTRA");
        for(Rental data : daftarRental) {
            System.out.print(data.read_rental());
        }

        System.out.println("====================================================");
        System.out.println("1. Tambah Data Konsol");
        System.out.println("2. Ubah Data Konsol");
        System.out.println("3. Hapus Data Konsol");
        System.out.println("0. Kembali");
        System.out.print("Masukkan nomor pilihan : ");
        int nomor = input.nextInt(); input.nextLine();
        
        if(nomor == 0) {} 
        else if(nomor == 1) {
            System.out.println("\n[1] Ps");
            System.out.println("[2] Xbox");
            System.out.print("Masukkan pilihan konsol : ");
            int noKonsol = input.nextInt(); input.nextLine();
            String jenisKonsol = null;
            switch(noKonsol) {
                case 1 :
                    System.out.print("Masukkan jenis konsol   : Ps ");
                    int jenis = input.nextInt(); input.nextLine();
                    Rental.rental_update(jenis);
                    jenisKonsol = "Ps " + jenis;
                    break;
                case 2 : 
                    System.out.print("Masukkan jenis konsol   : Xbox ");
                    jenisKonsol = "Xbox " + input.nextLine();
                    break;
            }
            System.out.print("Masukkan nomor ruangan  : Ruang ");
            String nomorRuang = input.nextLine();
            System.out.print("Masukkan harga per jam  : Rp.");
            int harga = input.nextInt(); input.nextLine();
            System.out.print("Tambahan konsol (y/n)   : ");
            Boolean extra = input.next().charAt(0) == 'y';
            input.nextLine();

            if(noKonsol == 1) {
                konsol = new RentalPs(jenisKonsol, "Ruang " + nomorRuang, harga, "Tersedia", extra);
            } else if(noKonsol == 2) {
                konsol = new RentalXbox(jenisKonsol, "Ruang " + nomorRuang, harga, "Tersedia", extra);
            }

            daftarRental.add(konsol);
            konsol.status_rental();
            continue_input();


        } else if(nomor == 2) {
            System.out.print("Masukkan id konsol     : ");
            int id = input.nextInt(); input.nextLine();
            Boolean ubah = false; boolean found = false;
            
            for(Rental data : daftarRental) {
                if(id == data.getId()) {
                    found = true;
                    if(data.getStatus().equals("Tersedia")) {
                        ubah = true; String jenisKonsol = null;
                        
                        if(data instanceof RentalPs) {
                            System.out.print("Masukkan jenis konsol baru : Ps ");
                            int jenis = input.nextInt(); input.nextLine();
                            if(jenis > RentalPs.jenisPs) {
                                found = false;
                                break;
                            }
                            jenisKonsol = "Ps " + jenis;
                        } else if(data instanceof RentalXbox) {
                            System.out.print("Masukkan jenis konsol baru : Xbox ");
                            jenisKonsol = "Xbox " + input.nextLine();
                        }

                        System.out.print("Masukkan nomor ruang baru  : ");
                        String nomorRuang = input.nextLine();
                        System.out.print("Masukkan harga/jam baru    : Rp.");
                        int harga = input.nextInt(); input.nextLine();
                        System.out.print("Tambahan konsol baru (y/n) : ");
                        Boolean extra = input.next().charAt(0) == 'y';
                        input.nextLine();
                        
                        data.rental_update(jenisKonsol, "Ruang " + nomorRuang, harga, "Tersedia");
                        data.rental_update(extra);
                        break;
                    }
                }
            }
            
            if(!ubah && found) {
                System.out.println("\nGagal mengubah, jenis konsol sedang disewa.");
            } else if(ubah && !found) {
                // Static method
                RentalPs.maksJenisPs();
            } else {
                if(!ubah && !found) {
                    System.out.println("\nData tidak ditemukan.");
                } else if(ubah && found) {
                    System.out.println("\nData berhasil diubah.");
                }
            }
            continue_input();


        } else if(nomor == 3) {
            System.out.print("Masukkan id konsol     : ");
            int id = input.nextInt(); input.nextLine();
            boolean hapus = false; Boolean found = false;

            for(Rental data : daftarRental) {
                if(id == data.getId()) {
                    found = true;
                    if(data.getStatus().equals("Tersedia")) {
                        daftarRental.remove(data);
                        hapus = true;
                        break;
                    }
                }
            }

            if(!hapus && found) {
                System.out.println("\nGagal menghapus, jenis konsol sedang disewa.");
            } else {
                if(!hapus && !found) {
                    System.out.println("\nData tidak ditemukan.");
                } else if(hapus && found) {
                    System.out.println("\nData berhasil dihapus.");
                }
            }
            continue_input();
            

        }else {
            System.out.println("\nPilihan tidak tersedia.");
            continue_input();
        }
    }

    static private void data_perental() {
        read_data();
        System.out.println(" == Informasi Data Perental == ");
        System.out.println("===============================");
        System.out.println("1. Tampilkan semua data");
        System.out.println("2. Tampilkan berdasarkan id");
        System.out.println("0. Kembali");
        System.out.print("Masukkan menu pilihan : ");
        int nomor = input.nextInt(); input.nextLine();

        if(nomor == 0) {}
        else if(nomor == 1) {
            for(Perental perental : daftarPerental) {
                for(Rental data : daftarRental) {
                    if(perental.getIdKonsol() == data.getId()) {
                        System.out.println("===============================");
                        System.out.println("Id Perental : " + perental.getId());
                        System.out.println("Nama        : " + perental.getNama());
                        System.out.println("Umur        : " + perental.getUmur());
                        System.out.println("Alamat      : " + perental.getAlamat());
                        System.out.println("Jenis       : " + data.getJenis());
                        System.out.println("Lama Sewa   : " + perental.getLamaSewa() + " jam");
                        System.out.println("Tagihan     : Rp." + perental.getTagihan());
                    }
                }
            }
            System.out.println("===============================\n");
            continue_input();

        } else if(nomor == 2) {
            System.out.print("Masukkan id perental  : ");
            int idPerental = input.nextInt(); input.nextLine();
            boolean tampil = false;

            for(Perental perental : daftarPerental) {
                if(idPerental == perental.getId()) {
                    for(Rental data : daftarRental) {
                        if(perental.getIdKonsol() == data.getId()) {
                            System.out.println("===============================");
                            System.out.println("Id Perental : " + perental.getId());
                            System.out.println("Nama        : " + perental.getNama());
                            System.out.println("Umur        : " + perental.getUmur());
                            System.out.println("Alamat      : " + perental.getAlamat());
                            System.out.println("Jenis       : " + data.getJenis());
                            System.out.println("Lama Sewa   : " + perental.getLamaSewa() + " jam");
                            System.out.println("Tagihan     : Rp." + perental.getTagihan());
                            tampil = true;
                            break;
                        }
                    }
                }
            }

            if(!tampil) {
                System.out.println("\nData perental tidak ditemukan.");
            } else {
                System.out.println("===============================");
                System.out.println("\nData perental ditemukan.");
            }
            continue_input();
        } else {
            System.out.println("\nPilihan tidak tersedia.");
            continue_input();
        }
    }
     

    // CRUD Perental
    static private void create_data() {
        clear_screen();
        System.out.println("           === Informasi Daftar Konsol ===         ");
        System.out.println("===================================================");
        System.out.println(" ID  KONSOL\tRUANGAN   HARGA/JAM   STATUS  EXTRA");
        for(Rental data : daftarRental) {
            System.out.print(data.read_rental());
        }

        System.out.println("\n  === Buat data Rental ===");
        System.out.println("============================");
        System.out.print("Masukkan nama perental   : ");
        String nama = input.nextLine();
        System.out.print("Masukkan umur perental   : ");
        int umur = input.nextInt(); input.nextLine();
        System.out.print("Masukkan alamat perental : ");
        String alamat = input.nextLine();
        System.out.print("Masukkan jenis konsol    : ");
        String jenis = input.nextLine();
        System.out.print("Masukkan lama sewa       : ");
        int lamaSewa = input.nextInt(); input.nextLine();
        int tagihan = 0;

        for(Rental data : daftarRental) {
            if(data.getJenis().equals(jenis) && data.getStatus().equals("Tersedia")) {
                int konsolId = data.getId();
                tagihan = lamaSewa * data.getHarga();
                data.setStatus("  Disewa");
                user = new Perental(nama, umur, alamat, lamaSewa, tagihan, konsolId);
                daftarPerental.add(user);
                data.status_perental();
                break;
            }
        }

        if(tagihan == 0) {
            System.out.println("\nJenis konsol yang anda pilih tidak tersedia,\natau sedang full disewakan.");
        }
    }

    static private void read_data() {
        System.out.println("\n           === Daftar Perental ===          ");
        System.out.println("============================================");
        System.out.println("ID  NAMA\tLAMA SEWA  RUANGAN  KONSOL");
        for(Perental user : daftarPerental) {
            for(Rental data : daftarRental) {
                if(user.getIdKonsol() == data.getId()) {
                    System.out.println(
                        user.getId() + "   " + user.getNama() + "\t" + user.getLamaSewa()+ " Jam\t   " + data.getRuang() + "  " + data.getJenis()
                    );
                }
            }
        }
        System.out.println();
    }
    
    static private void update_data() {
        read_data();
        System.out.print("Masukan id perental : ");
        int idPerental = input.nextInt(); input.nextLine();

        boolean ubah = false; int tagihan = 0;
        for (Perental perental : daftarPerental) {
            if(perental.getId() == idPerental) {
                ubah = true;
                clear_screen();
                System.out.println("           === Informasi Daftar Konsol ===         ");
                System.out.println("===================================================");
                System.out.println(" ID  KONSOL\tRUANGAN   HARGA/JAM   STATUS  EXTRA");
                for(Rental data : daftarRental) {
                    System.out.print(data.read_rental());
                }
                
                System.out.println("\n  === Mengubah Data Perental ===  ");
                System.out.println("================================");
                System.out.println("Id perental yg di perbarui    : " + idPerental);
                System.out.print("Masukkan nama baru perental   : ");
                String nama = input.nextLine();
                System.out.print("Masukkan umur baru perental   : ");
                int umur = input.nextInt(); input.nextLine();
                System.out.print("Masukkan alamat baru perental : ");
                String alamat = input.nextLine();
                System.out.print("Masukkan jenis konsol baru    : ");
                String jenis = input.nextLine();
                System.out.print("Masukkan lama sewa baru       : ");
                int lamaSewa = input.nextInt(); input.nextLine();
                int konsolId = perental.getIdKonsol();

                for(Rental data : daftarRental) {
                    if(data.getJenis().equals(jenis) && data.getStatus().equals("Tersedia")) {
                        tagihan = lamaSewa * data.getHarga();
                        data.setStatus("  Disewa");
                        perental.setNama(nama);
                        perental.setUmur(umur);
                        perental.setAlamat(alamat);
                        perental.setLamaSewa(lamaSewa);
                        perental.setTagihan(tagihan);
                        perental.setIdKonsol(data.getId());
                        break;
                    }
                } 
                for(Rental data : daftarRental) {
                    if(tagihan != 0 && data.getId() == konsolId) {
                        data.setStatus("Tersedia");
                        break;
                    }
                }
                break;
            }
        }

        if(tagihan == 0 && ubah) {
            System.out.println("\nJenis konsol yang anda pilih tidak tersedia,\natau sedang full disewakan.");
        } else { 
            if(!ubah) {
                System.out.println("\nId perental tidak ditemukan.");
            } else {
                System.out.println("\nData perental berhasil diubah.");
            }
        }
    }

    static private void delete_data() {
        read_data();
        System.out.println("  === Menghapus Data Rental ===  ");
        System.out.println("=================================");
        System.out.print("Masukkan id perental : ");
        int idPerental = input.nextInt(); input.nextLine();
        boolean hapus = false;
        
        for (Perental perental : daftarPerental) {
            if(perental.getId() == idPerental) {
                for(Rental data : daftarRental) {
                    if(data.getId() == perental.getIdKonsol()) {
                        data.setStatus("Tersedia");
                        break;
                    }
                }
                daftarPerental.remove(perental);
                hapus = true;
                break;
            }
        }

        if(!hapus) {
            System.out.println("\nId perental tidak ditemukan.");
        } else {
            System.out.println("\nData perental berhasil dihapus.");
        }
    }
    

    // ## \\
    static private final void continue_input() {
        System.out.print("Tekan enter untuk kembali ke menu.");
        input.nextLine();
    }

    static public final void clear_screen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
