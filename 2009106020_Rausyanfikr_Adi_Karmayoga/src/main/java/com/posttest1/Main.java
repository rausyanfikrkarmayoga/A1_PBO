package com.posttest1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    private static Scanner input = new Scanner(System.in);
    private static int id;
    private static ArrayList<Rental> vecRental = new ArrayList<Rental>();
    private static Rental data;
        
    public static void main(String[] args) {
        int menu;
        do {
            System.out.println("\n\n   ===PIXEL RENTAL PS===");
            System.out.println("===========================");
            System.out.println("Daftar Harga : ");
            System.out.println("-- Ps 1 Rp.2000/jam");
            System.out.println("-- Ps 2 Rp.3000/jam");
            System.out.println("-- Ps 3 Rp.5000/jam");
            System.out.println("-- Ps 4 Rp.8000/jam");
            // ## \\
            System.out.println("Pilih Menu  : ");
            System.out.println("1. Tambah Data Rental");
            System.out.println("2. Tampilkan Data Rental");
            System.out.println("3. Ubah Data Rental");
            System.out.println("4. Hapus Data Rental");
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
    
    
    public static void menu_rental(int menu) {
        switch(menu) {
            case 1:
                create_data();
                break;
            case 2:
                read_data();
                continue_input();
                break;
            case 3:
                update_data();
                break;
            case 4:
                delete_data();
                break;
            default:
                System.out.println("\nMenu tidak tersedia lebih dari 4.");
                continue_input();
        }
    }
    
    public static void create_data() {
        id++;

        System.out.println("\n  === Buat data Rental ===");
        System.out.println("============================");
        System.out.print("Masukkan nama perental : ");
        String nama = input.nextLine();
        System.out.print("Masukkan jenis Ps      : Ps ");
        int jenisPs = input.nextInt();
        System.out.print("Masukkan lama sewa     : ");
        int lamaSewa = input.nextInt();
        
        data = new Rental(id, nama, jenisPs, lamaSewa);
        vecRental.add(data);
        
        System.out.println("\nBerhasil menambahkan data rental.");
        input.nextLine();
        continue_input();
    }

    private static void read_data() {
        System.out.println("\n      === Daftar Rental ===     ");
        System.out.println("================================");
        System.out.println("No  Nama \tJenis  Lama Sewa");

        for (Rental data : vecRental) {
            System.out.println(data.getId() + "   " + data.getNama() + " \tPs " + data.getJenisPs() + "\t  " + data.getLamaSewa()+ " Jam"
            );
        }
        System.out.println();
    }
    
    private static void update_data() {
        read_data();
        System.out.println("  === Mengubah Data Rental ===  ");
        System.out.println("================================");

        System.out.print("Masukkan no perental : ");
        int nomor = input.nextInt(); input.nextLine();
        boolean ubah = false;
        
        for (Rental data : vecRental) {
            if(data.getId() == nomor) {
                System.out.print("Masukkan nama baru   : ");
                String nama = input.nextLine();
                System.out.print("Masukkan jenis baru  : Ps ");
                int jenisPs = input.nextInt();
                System.out.print("Masukkan jam baru    : ");
                int lamaSewa = input.nextInt(); input.nextLine();
                
                data.setNama(nama);
                data.setJenisPs(jenisPs);
                data.setLamaSewa(lamaSewa);

                ubah = true;
                break;
            }
        }

        if(ubah == false) {
            System.out.println("\nNomor perental tidak ditemukan.");
            continue_input();
        } else {
            System.out.println("\nData perental berhasil diubah.");
            continue_input();
        }
    }

    private static void delete_data() {
        read_data();
        System.out.println("  === Menghapus Data Rental ===  ");
        System.out.println("=================================");

        System.out.print("Masukkan no perental : ");
        int nomor = input.nextInt(); input.nextLine();
        boolean hapus = false;
        
        for (Rental data : vecRental) {
            if(data.getId() == nomor) {
                vecRental.remove(data);
                hapus = true;
                break;
            }
        }

        if(hapus == false) {
            System.out.println("\nNomor perental tidak ditemukan.");
            continue_input();
        } else {
            System.out.println("\nData perental berhasil dihapus.");
            continue_input();
        }
    }


    public static void continue_input() {
        System.out.print("Tekan enter untuk kembali ke menu.");
        input.nextLine();
    }
}
