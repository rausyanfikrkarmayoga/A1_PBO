package com.posttest4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Perental> daftarPerental = new ArrayList<Perental>();
    private static ArrayList<Rental> daftarRental = new ArrayList<Rental>();
    private static Perental user;
    private static Rental konsol;
    private static int userId = 1;
    private static int konsolId = 8;
        
    public static void main(String[] args) {

        user = new Perental(userId, "Rausyan", 19, "Air Hitam", 4, 20000, 2);
        daftarPerental.add(user);
        
        Rental data1 = new Rental(1, "Ps 2", "Ruang 1", 3000, "Tersedia"); daftarRental.add(data1);
        Rental data2 = new Rental(2, "Ps 3", "Ruang 2", 5000, "  Disewa"); daftarRental.add(data2);
        Rental data3 = new RentalPs(3, "Ps 3", "Ruang 3", 5000, "Tersedia", false); daftarRental.add(data3);
        Rental data4 = new RentalPs(4, "Ps 4", "Ruang 4", 8000, "Tersedia", true); daftarRental.add(data4);
        Rental data5 = new RentalPs(5, "Ps 4", "Ruang 5", 8000, "Tersedia", true); daftarRental.add(data5);

        Rental data6 = new RentalXbox(6, "Xbox One", "Ruang 6", 6000, "Tersedia", true); daftarRental.add(data6);
        Rental data7 = new RentalXbox(7, "Xbox One", "Ruang 7", 6000, "Tersedia", true); daftarRental.add(data7);
        Rental data8 = new RentalXbox(8, "Xbox 360", "Ruang 8", 4000, "Tersedia", false); daftarRental.add(data8);

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
    
    private static void menu_rental(int menu) {
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
    private static void data_konsol() {
        clear_screen();
        System.out.println("           === Informasi Daftar Konsol ===         ");
        System.out.println("===================================================");
        System.out.println(" ID  KONSOL\tRUANGAN   HARGA/JAM   STATUS  EXTRA");
        for(Rental data : daftarRental) {
            data.read_rental();
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
            System.out.print("Masukkan jenis konsol  : ");
            String jenis = input.nextLine();
            System.out.print("Masukkan nomor ruangan : ");
            String nomorRuang = input.nextLine();
            System.out.print("Masukkan harga/jam     : Rp.");
            int harga = input.nextInt(); input.nextLine();
            System.out.print("Tambahan konsol vr/cam : ");
            String extra = input.nextLine();
            String ruang = "Ruang " + nomorRuang;
            String status = "Tersedia";

            if(extra.equals("vr")) {
                konsol = new RentalPs(++konsolId, jenis, ruang, harga, status, true);
            } else if(extra.equals("cam")) {
                konsol = new RentalXbox(++konsolId, jenis, ruang, harga, status, true);
            } else {
                konsol = new Rental(++konsolId, jenis, ruang, harga, status);
            }

            daftarRental.add(konsol);
            System.out.println("\nData berhasil ditambahkan.");
            continue_input();

        } else if(nomor == 2) {
            System.out.print("Masukkan id konsol     : ");
            int id = input.nextInt(); input.nextLine();
            Boolean ubah = false; boolean found = false;
            
            for(Rental data : daftarRental) {
                if(id == data.getId()) {
                    found = true;
                    if(data.getStatus().equals("Tersedia")) {
                        ubah = true;
                        System.out.print("Masukkan jenis konsol baru : ");
                        String jenis = input.nextLine();
                        System.out.print("Masukkan nomor ruang baru  : ");
                        String nomorRuang = input.nextLine();
                        System.out.print("Masukkan harga/jam baru    : Rp.");
                        int harga = input.nextInt(); input.nextLine();
                        String ruang = "Ruang " + nomorRuang;
                        String status = "Tersedia";
                        
                        boolean rentalSub = data.isSubclass();
                        if(rentalSub) {
                            String extra = input.nextLine();
                            rentalSub = extra.equals("y") ? true : false;
                            data.isExtra(rentalSub);
                        }
                        data.rental_update(jenis, ruang, harga, status);
                        break;
                    }
                }
            }
            
            if(ubah == false && found == true) {
                System.out.println("\nGagal mengubah, jenis konsol sedang disewa.");
            } else {
                if(ubah == false && found == false) {
                    System.out.println("\nData tidak ditemukan.");
                } else if(ubah == true && found == true) {
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

            if(hapus == true && found == false) {
                System.out.println("\nGagal menghapus, jenis konsol sedang disewa.");
            } else {
                if(hapus == false && found == false) {
                    System.out.println("\nData tidak ditemukan.");
                } else if(hapus == true && found == true) {
                    System.out.println("\nData berhasil dihapus.");
                }
            }
            continue_input();
            
        } else {
            System.out.println("\nPilihan tidak tersedia.");
            continue_input();
        }
    }

    private static void data_perental() {
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
    private static void create_data() {
        boolean buat = false;
        int konsolId = 0, tagihan = 0;
        clear_screen();
        System.out.println("           === Informasi Daftar Konsol ===         ");
        System.out.println("===================================================");
        System.out.println(" ID  KONSOL\tRUANGAN   HARGA/JAM   STATUS  EXTRA");
        for(Rental data : daftarRental) {
            data.read_rental();
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

        for(Rental data : daftarRental) {
            if(data.getJenis().equals(jenis) && data.getStatus().equals("Tersedia")) {
                tagihan = lamaSewa * data.getHarga();
                konsolId = data.getId();
                data.setStatus("  Disewa");
                user = new Perental(++userId, nama, umur, alamat, lamaSewa, tagihan, konsolId);
                daftarPerental.add(user);
                buat = true;
                break;
            }
        }

        if(!buat) {
            System.out.println("\nJenis Konsol yang anda pilih tidak tersedia.");
        } else {
            System.out.println("\nBerhasil menambahkan data perental.");
        }
    }

    private static void read_data() {
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
    
    private static void update_data() {
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
                    data.read_rental();
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
            System.out.println("\nJenis konsol yang anda pilih tidak tersedia.");
        } else { 
            if(!ubah) {
                System.out.println("\nId perental tidak ditemukan.");
            } else {
                System.out.println("\nData perental berhasil diubah.");
            }
        }
    }

    private static void delete_data() {
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
    private static void continue_input() {
        System.out.print("Tekan enter untuk kembali ke menu.");
        input.nextLine();
    }

    public final static void clear_screen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
