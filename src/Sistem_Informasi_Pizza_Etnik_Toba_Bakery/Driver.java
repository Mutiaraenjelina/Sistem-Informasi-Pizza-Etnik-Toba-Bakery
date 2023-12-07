/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistem_Informasi_Pizza_Etnik_Toba_Bakery;

/**
 *
 * @author MUTIARA ENJELINA
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        Admin admin = new Admin("Helena J Pakpahan", "helena_j_pakpahan", "Bakery123", "admin@example.com", "081234567890");
        DataProduk dataproduk = new DataProduk();
        DataMasukan datamasukan = new DataMasukan();
        DataSertifikat datasertifikat = new DataSertifikat();
        DataPrestasi dataprestasi = new DataPrestasi();
        int opsi = 0;

        System.out.println("PIZZA ETNIK TOBA BAKERY");
        System.out.println("===========================");

        outerLoop:
        do {
            System.out.println("Silahkan pilih role anda : ");
            System.out.println("1.Admin\n2.Pengunjung\n3.Keluar");
            System.out.print("Pilih : ");

            try {
                opsi = input.nextInt();
                // Membersihkan layar setelah pemilihan menu
                System.out.println("\u000C");

                switch (opsi) {
                    case 1 -> {
                        admin.login();
                        innerLoop:
                        do {
                            System.out.println("Silahkan pilih menu : ");
                            System.out.println("1. Mengelola Produk\n2. Mengelola Prestasi\n3. Mengelola Promosi\n4. Mengelola Sertifikat\n5. Mengelola Masukan\n6. Profil\n7. Mengganti Password\n8. Keluar");
                            System.out.print("Pilih : ");

                            try {
                                opsi = input.nextInt();
                                // Membersihkan layar setelah pemilihan menu
                                System.out.println("\u000C");

                                switch (opsi) {
                                    case 1 -> {
                                        do {
                                            System.out.println("====== Kelola Produk ======");
                                            System.out.println("Silahkan Pilih Aksi : ");
                                            System.out.println("1. Tambah Produk\n2. Edit Produk\n3. Edit Status\n4. Keluar");
                                            opsi = input.nextInt();
                                            // Membersihkan layar setelah pemilihan menu
                                            System.out.println("\u000C");

                                            switch (opsi) {
                                                case 1 -> dataproduk.add();
                                                case 2 -> dataproduk.update();
                                                case 3 -> dataproduk.updatestatus();
                                            }
                                        } while (opsi != 4);
                                    }
                                    case 2 ->{
                                           do {
                                            System.out.println("====== Kelola Prestasi ======");
                                            System.out.println("Silahkan Pilih Aksi : ");
                                            System.out.println("1. Tambah Prestasi\n2. Edit Prestasi\n3. Hapus Prestasi\n4. Keluar");
                                            opsi = input.nextInt();
                                            // Membersihkan layar setelah pemilihan menu
                                            System.out.println("\u000C");

                                            switch (opsi) {
                                                case 1 -> dataprestasi.add();
                                                case 2 -> dataprestasi.update();
                                                case 3 -> dataprestasi.delete();
                                            }
                                        } while (opsi != 4);
                                    }
                                    case 4->{
                                        do {
                                            System.out.println("====== Kelola Sertifikat ======");
                                            System.out.println("Silahkan Pilih Aksi : ");
                                            System.out.println("1. Tambah Sertifikat\n2. Edit Sertifikat\n3. Hapus Sertifikat\n4. Keluar");
                                            opsi = input.nextInt();
                                            // Membersihkan layar setelah pemilihan menu
                                            System.out.println("\u000C");

                                            switch (opsi) {
                                                case 1 -> datasertifikat.add();
                                                case 2 -> datasertifikat.update();
                                                case 3 -> datasertifikat.delete();
                                            }
                                        } while (opsi != 4);
                                    }
                                    case 5 ->{
                                            datamasukan.display();
                                            datamasukan.update();
                                    }
                                    case 6->{
                                        do{
                                            System.out.println("====== Profil  ======");
                                            System.out.println("Silahkan Pilih Aksi : ");
                                            System.out.println("1. Lihat Profil\n2. Edit Profil\n3. Keluar");
                                            opsi = input.nextInt();
                                            // Membersihkan layar setelah pemilihan menu
                                            System.out.println("\u000C");
                                            switch (opsi) {
                                                case 1 -> admin.display_profil();
                                                case 2 -> admin.update_profil();
                                            }
                                        }while(opsi != 3);
                                    }
                                    case 7 -> admin.update_password();
                                }
                            } catch (InputMismatchException e) {
                                 // Membersihkan layar setelah pemilihan menu
                                System.out.println("\u000C");
                                System.out.println("Input harus menggunakan format angka");
                                input.nextLine(); // consume the invalid input
                                continue innerLoop;
                            }
                        } while (opsi != 8);
                    }
                    case 2 ->{
                        innerLoop:
                        do {
                            System.out.println("Silahkan pilih menu : ");
                            System.out.println("1. Melihat Informasi Produk\n2. Melihat Informasi Prestasi\n3. Melihat Informasi Promosi\n4. Melihat Informasi Sertifikat\n5. Melihat Informasi Masukan\n6. Memberi Masukan \n7. Keluar");
                            System.out.print("Pilih : ");

                            try {
                                opsi = input.nextInt();
                                // Membersihkan layar setelah pemilihan menu
                                System.out.println("\u000C");

                                switch (opsi) {
                                    case 1 -> {
                                      
                                            System.out.println("======  Informasi Produk ======");
                                            dataproduk.displayforuser();
                                    }
                                    case 2 ->dataprestasi.displayforuser();
                                    case 4 ->datasertifikat.displayforuser();
                                    case 5->{
                                            System.out.println("======  Informasi Masukan ======");
                                            datamasukan.displayforuser();
                                    }
                                    case 6->datamasukan.add();
                                }
                            } catch (InputMismatchException e) {
                                 // Membersihkan layar setelah pemilihan menu
                                System.out.println("\u000C");
                                System.out.println("Input harus menggunakan format angka");
                                input.nextLine(); // consume the invalid input
                                continue innerLoop;
                            }
                        } while (opsi != 7);
                    }
                }
            } catch (InputMismatchException e) {
                 // Membersihkan layar setelah pemilihan menu
                  System.out.println("\u000C");
                System.out.println("Input harus menggunakan format angka");
                input.nextLine(); // consume the invalid input
                continue outerLoop;
            }
        } while (opsi != 3);
    }
}
