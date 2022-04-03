package com.posttest2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Rental> daftarPerental = new ArrayList<Rental>();
    private static Rental perental;
    private static int globalId = 1;
        
    public static void main(String[] args) {

        // Data yang dibuat sendiri
        perental = new Rental(1, "Rausyan", 19, "Air Hitam", 3, 4, 20000);
        daftarPerental.add(perental);

        int menu;
        do {
            System.out.println("\n\n   ===PIXEL RENTAL PS===");
            System.out.println("===========================");
            System.out.println("1. Informasi Daftar Ps");
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
                daftar_ps();
                continue_input();
                break;
            case 2:
                data_perental();
                continue_input();
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
    

    // 2 Method Tambahan Dari Class
    private static void daftar_ps() {
        System.out.println("1. Tampilkan Daftar Ps");
        System.out.println("2. Tambahkan Daftar Ps (sementara)");
        System.out.print("Masukkan nomor pilihan : ");
        int nomor = input.nextInt(); input.nextLine();

        if(nomor == 1) {
            perental.daftar_ps();
        } else if(nomor == 2) {
            System.out.print("Masukkan jenis Ps  : ");
            int jenis = input.nextInt(); input.nextLine();
            System.out.print("Masukkan harga/jam : ");
            int harga = input.nextInt(); input.nextLine();

            Rental perental0 = new Rental(0, "", 0, "", 0, 0, 0);
            perental0.daftar_ps(jenis, harga);
        } else {
            System.out.println("\nPilihan tidak tersedia.");
        }
    }

    private static void data_perental() {
        read_data();
        System.out.println(" == Informasi Data Perental == ");
        System.out.println("===============================");

        System.out.print("Masukkan id perental : ");
        int idPerental = input.nextInt(); input.nextLine();
        boolean tampil = false;

        for(Rental perental : daftarPerental) {
            if(perental.getId() == idPerental) {
                perental.info_rental();
                tampil = true;
            }
        }

        if(tampil == false) {
            System.out.println("\nData perental tidak ditemukan.");
        } else {
            System.out.println("\nData perental ditemukan.");
        }
    }
     

    // CRUD Perental
    private static void create_data() {
        boolean buat = false;
        globalId++;

        System.out.println("\n  === Buat data Rental ===");
        System.out.println("============================");
        System.out.print("Masukkan nama perental   : ");
        String nama = input.nextLine();
        System.out.print("Masukkan umur perental   : ");
        int umur = input.nextInt(); input.nextLine();
        System.out.print("Masukkan alamat perental : ");
        String alamat = input.nextLine();
        System.out.print("Masukkan jenis Ps        : Ps ");
        int jenisPs = input.nextInt();
        System.out.print("Masukkan lama sewa       : ");
        int lamaSewa = input.nextInt(); input.nextLine();

        int tagihan = 0;
        switch(jenisPs) {
            case 1:
                tagihan = lamaSewa * 2000;
                buat = true;
                break;
            case 2:
                tagihan = lamaSewa * 3000;
                buat = true;
                break;
            case 3:
                tagihan = lamaSewa * 5000;
                buat = true;
                break;
            case 4:
                tagihan = lamaSewa * 8000;
                buat = true;
                break;
        }
        
        if(buat == false) {
            System.out.println("\nJenis Ps yang anda pilih tidak tersedia.");
            globalId--;
        } else {
            perental = new Rental(globalId, nama, umur, alamat, jenisPs, lamaSewa, tagihan);
            daftarPerental.add(perental);
            
            System.out.println("\nBerhasil menambahkan data perental.");
        }
    }

    private static void read_data() {
        System.out.println("\n     === Daftar Perental ===  ");
        System.out.println("================================");
        System.out.println("ID  NAMA \tJENIS  LAMA SEWA");

        for (Rental perental : daftarPerental) {
            System.out.println(
                    perental.getId() + "   " + perental.getNama() + " \tPs " + perental.getJenisPs() + "\t  " + perental.getLamaSewa()+ " Jam"
            );
        }
        System.out.println();
    }
    
    private static void update_data() {
        read_data();
        System.out.println("  === Mengubah Data Rental ===  ");
        System.out.println("================================");

        System.out.print("Masukkan id perental : ");
        int idPerental = input.nextInt(); input.nextLine();
        boolean ubah = false;
        int tagihan = 0;
        
        for (Rental perental : daftarPerental) {
            if(perental.getId() == idPerental) {
                System.out.print("Masukkan nama baru   : ");
                String nama = input.nextLine();
                System.out.print("Masukkan umur baru   : ");
                int umur = input.nextInt(); input.nextLine();
                System.out.print("Masukkan alamat baru : ");
                String alamat = input.nextLine();
                System.out.print("Masukkan jenis baru  : Ps ");
                int jenisPs = input.nextInt();
                System.out.print("Masukkan jam baru    : ");
                int lamaSewa = input.nextInt(); input.nextLine();

                switch(jenisPs) {
                    case 1:
                        tagihan = lamaSewa * 2000;
                        break;
                    case 2:
                        tagihan = lamaSewa * 3000;
                        break;
                    case 3:
                        tagihan = lamaSewa * 5000;
                        break;
                    case 4:
                        tagihan = lamaSewa * 8000;
                        break;
                    default:
                        tagihan = 0;
                        break;
                }
                
                if(tagihan != 0) {
                    perental.setNama(nama);
                    perental.setUmur(umur);
                    perental.setAlamat(alamat);
                    perental.setJenisPs(jenisPs);
                    perental.setLamaSewa(lamaSewa);
                    perental.setTagihan(tagihan);
                }
                ubah = true;
                break;
            }
        }


        if(tagihan == 0 && ubah == true) {
            System.out.println("\nJenis Ps yang anda pilih tidak tersedia.");
        } else { 
            if(ubah == false) {
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
        
        for (Rental perental : daftarPerental) {
            if(perental.getId() == idPerental) {
                daftarPerental.remove(perental);
                hapus = true;
                break;
            }
        }

        if(hapus == false) {
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

}
