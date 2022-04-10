package com.posttest3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Rental> daftarPerental = new ArrayList<Rental>();
    private static ArrayList<DataPs> listDataPs = new ArrayList<DataPs>();
    private static Rental perental;
    private static DataPs dataPs;
    private static int perentalId = 1;
    private static int psId = 8;
        
    public static void main(String[] args) {

        perental = new Rental(perentalId, "Rausyan", 19, "Air Hitam", 3, 4, 20000, 3);
        daftarPerental.add(perental);
        
        // Data Ps Rental
        DataPs dataPs1 = new DataPs(1, 2, "Ruang 1", 3000, "Tersedia"); listDataPs.add(dataPs1);
        DataPs dataPs2 = new DataPs(2, 2, "Ruang 2", 3000, "Tersedia"); listDataPs.add(dataPs2);
        DataPs dataPs3 = new DataPs(3, 3, "Ruang 3", 5000, "  Disewa"); listDataPs.add(dataPs3);
        DataPs dataPs4 = new DataPs(4, 3, "Ruang 4", 5000, "Tersedia"); listDataPs.add(dataPs4);

        DataPs dataPs5 = new DataPs(5, 3, "Ruang 5", 5000, "Tersedia"); listDataPs.add(dataPs5);
        DataPs dataPs6 = new DataPs(6, 4, "Ruang 6", 8000, "Tersedia"); listDataPs.add(dataPs6);
        DataPs dataPs7 = new DataPs(7, 4, "Ruang 7", 8000, "Tersedia"); listDataPs.add(dataPs7);
        DataPs dataPs8 = new DataPs(8, 1, "Ruang 8", 2000, "Tersedia"); listDataPs.add(dataPs8);

        int menu;
        do {
            clear_screen();
            System.out.println("   ===PIXEL RENTAL PS===");
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
                data_ps();
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
    
    private static void data_ps() {
        System.out.println("\n       === Informasi Daftar Ps ===     ");
        System.out.println("=========================================");
        System.out.println(" IDPS JENIS  RUANGAN  HARGA/JAM    STATUS");

        for(DataPs data : listDataPs) {
            data.read_psData();
        }

        System.out.println("=========================================");
        System.out.println("1. Tambah Data Ps");
        System.out.println("2. Ubah Data Ps");
        System.out.println("3. Hapus Data Ps");
        System.out.println("0. Kembali");
        System.out.print("Masukkan nomor pilihan : ");
        int nomor = input.nextInt(); input.nextLine();
        
        if(nomor == 0) {} 
        else if(nomor == 1) {
            System.out.print("Masukkan jenis Ps      : ");
            int jenis = input.nextInt(); input.nextLine();
            System.out.print("Masukkan nomor ruangan : ");
            String nomorRuangan = input.nextLine();
            System.out.print("Masukkan harga/jam     : Rp.");
            int harga = input.nextInt(); input.nextLine();

            String ruang = "Ruang " + nomorRuangan;
            String status = "Tersedia";

            psId++;
            dataPs = new DataPs(psId, jenis, ruang, harga, status);
            listDataPs.add(dataPs);

            System.out.println("\nData berhasil ditambahkan.");
            continue_input();

        } else if(nomor == 2) {
            System.out.print("Masukkan id Ps : ");
            int id = input.nextInt(); input.nextLine();
            char ubah = 'f'; boolean found = false;
            
            for(DataPs data : listDataPs) {
                if(id == data.getIdPs()) {
                    found = true;
                    if(data.getStatus().equals("Tersedia")) {
                        System.out.print("Masukkan jenis Ps baru    : ");
                        int jenis = input.nextInt(); input.nextLine();
                        System.out.print("Masukkan nomor ruang baru : ");
                        String nomorRuangan = input.nextLine();
                        System.out.print("Masukkan harga/jam baru   : Rp.");
                        int harga = input.nextInt(); input.nextLine();
    
                        String ruang = "Ruang " + nomorRuangan;
                        String status = "Tersedia";
    
                        data.update_psData(id, jenis, ruang, harga, status);
                        ubah = 't';
                        break;
                    }
                }
            }
            
            if(ubah == 'f' && found == true) {
                System.out.println("\nGagal mengubah, Ps sedang disewa.");
            } else {
                if(ubah == 'f' && found == false) {
                    System.out.println("\nData tidak ditemukan.");
                } else if(ubah == 't' && found == true) {
                    System.out.println("\nData berhasil diubah.");
                }
            }
            continue_input();

        } else if(nomor == 3) {
            System.out.print("Masukkan id Ps : ");
            int id = input.nextInt(); input.nextLine();
            char hapus = 'f'; boolean found = false;

            for(DataPs data : listDataPs) {
                if(id == data.getIdPs()) {
                    found = true;
                    if(data.getStatus().equals("Tersedia")) {
                        listDataPs.remove(data);
                        hapus = 't';
                        break;
                    }
                }
            }

            if(hapus == 'f' && found == true) {
                System.out.println("\nGagal menghapus, Ps sedang disewa.");
            } else {
                if(hapus == 'f' && found == false) {
                    System.out.println("\nData tidak ditemukan.");
                } else if(hapus == 't' && found == true) {
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
        System.out.print("Masukkan nomor pilihan : ");
        int nomor = input.nextInt(); input.nextLine();

        if(nomor == 0) {}
        else if(nomor == 1) {
            for(Rental perental : daftarPerental) {
                perental.informasi_perental(perental.getId(), perental.getNama(), perental.getUmur(), perental.getAlamat(), perental.getJenisPs(), perental.getLamaSewa(), perental.getTagihan());
            }
            System.out.println("===============================\n");
            continue_input();

        } else if(nomor == 2) {
            System.out.print("Masukkan id perental : ");
            int idPerental = input.nextInt(); input.nextLine();
            boolean tampil = false;

            for(Rental perental : daftarPerental) {
                if(perental.getId() == idPerental) {
                    perental.informasi_perental();
                    tampil = true;
                    break;
                }
            }

            if(!tampil) {
                System.out.println("\nData perental tidak ditemukan.");
            } else {
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
        int userIdPs = 0;
        int tagihan = 0;

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

        for(DataPs dataPs : listDataPs) {
            if(jenisPs == dataPs.getJenisPs() && dataPs.getStatus().equals("Tersedia")) {
                userIdPs = dataPs.getIdPs();
                tagihan = lamaSewa * dataPs.getHarga();
                dataPs.setStatus("  Disewa");
                buat = true;
                break;
            }
        }
        
        if(!buat) {
            System.out.println("\nJenis Ps yang anda pilih tidak tersedia.");
        } else {
            perentalId++;
            perental = new Rental(perentalId, nama, umur, alamat, jenisPs, lamaSewa, tagihan, userIdPs);
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
                ubah = true;
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
                int userIdPs = perental.getUsrIdPs();

                for(DataPs dataPs : listDataPs) {
                    if(jenisPs == dataPs.getJenisPs() && dataPs.getStatus().equals("Tersedia")) {
                        tagihan = lamaSewa * dataPs.getHarga();
                        dataPs.setStatus("  Disewa");
                        perental.ubahData_perental(nama, umur, alamat, jenisPs, lamaSewa, tagihan);
                        break;
                    }
                } 
                for(DataPs dataPs : listDataPs) {
                    if(tagihan != 0 && dataPs.getIdPs() == userIdPs) {
                        dataPs.setStatus("Tersedia");
                        break;
                    }
                }
                break;
            }
        }

        if(tagihan == 0 && ubah) {
            System.out.println("\nJenis Ps yang anda pilih tidak tersedia.");
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
        
        for (Rental perental : daftarPerental) {
            if(perental.getId() == idPerental) {
                for(DataPs dataPs : listDataPs) {
                    if(dataPs.getIdPs() == perental.getUsrIdPs()) {
                        dataPs.setStatus("Tersedia");
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
