/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Sistem_Informasi_Pizza_Etnik_Toba_Bakery;

/**
 *
 * @author MUTIARA ENJELINA
 */
import java.util.Scanner;
public class Admin extends User{
    private int jumlahKesalahanPassword;
    private static final int BATAS_KESALAHAN_PASSWORD = 3;
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    
    public Admin(String nama, String username, String password, String email, String noTelp) {
        super(nama, username, password, email, noTelp);
    }
    public void login() {
        String username,password;
        int hasFail = 0;
        do {
            if(hasFail > 0) {
                System.out.println("===========================");
                System.out.println("Username atau password tidak cocok !");
                 // Beri pilihan untuk keluar dari role atau mencoba login lagi
                System.out.print("Apakah Anda ingin melakukan login lagi? (y/n): ");
                String response = input.next().toLowerCase();

                if (response.equals("n")) {
                    System.out.println("Keluar dari role...");
                    break; //perbaikan
                    
                } else if (!response.equals("y")) {
                    System.out.println("Input tidak valid. Mencoba login lagi.");
                }
                
            }
            System.out.println("===========================");
            System.out.println("Silahkan login");
            System.out.print("Masukkan username : ");
            username = input.next();
            System.out.print("Masukkan password : ");
            password = input.next();
            
            hasFail++;
        }while(!username.equals(this.username) || !password.equals(this.password));
        
        System.out.println("===========================");
        System.out.println("Selamat Datang Admin " + this.nama + "\n");
    }
    
    public void display_profil(){
        System.out.println("Profil Admin:");
        System.out.println(toString());
    }
    public void update_profil() {
        Scanner input = new Scanner(System.in);

        int opsiUtama;
        do {
            System.out.println("Pilihan Update Profil:");
            System.out.println("1. Edit semua atribut");
            System.out.println("2. Edit salah-satu atribut");
            System.out.println("3. Keluar");

            System.out.print("Masukkan pilihan: ");
            opsiUtama = input.nextInt();
            input.nextLine();  // Membersihkan buffer

            switch (opsiUtama) {
                case 1:
                    updateSemuaAtribut();
                    break;
                case 2:
                    updateSatuAtribut();
                    break;
                case 3:
                    System.out.println("Keluar dari Update Profil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (opsiUtama != 3);
    }

    private void updateSatuAtribut() {
        Scanner input = new Scanner(System.in);

        int opsiAtribut;
        do {
            System.out.println("Pilihan Update Atribut:");
            System.out.println("1. Update Nama");
            System.out.println("2. Update Email");
            System.out.println("3. Update Nomor Telepon");
            System.out.println("4. Kembali");

            System.out.print("Masukkan pilihan: ");
            opsiAtribut = input.nextInt();
            input.nextLine();  // Membersihkan buffer

            switch (opsiAtribut) {
                case 1:
                    System.out.print("Masukkan nama baru: ");
                    String newNama = input.nextLine();
                    setnama(newNama);
                    System.out.println("Nama berhasil diperbarui!");
                    break;
                case 2:
                    System.out.print("Masukkan email baru: ");
                    String newEmail = input.nextLine();
                    setemail(newEmail);
                    System.out.println("Email berhasil diperbarui!");
                    break;
                case 3:
                    System.out.print("Masukkan nomor telepon baru: ");
                    String newNoTelp = input.nextLine();
                    setnotelp(newNoTelp);
                    System.out.println("Nomor telepon berhasil diperbarui!");
                    break;
                case 0:
                    System.out.println("Kembali ke Menu Utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (opsiAtribut != 4);
    }

    private void updateSemuaAtribut() {
        System.out.print("Masukkan nama baru: ");
        String newNama = input.nextLine();
        setnama(newNama);

        System.out.print("Masukkan email baru: ");
        String newEmail = input.nextLine();
        setemail(newEmail);

        System.out.print("Masukkan nomor telepon baru: ");
        String newNoTelp = input.nextLine();
        setnotelp(newNoTelp);

        System.out.println("Semua atribut berhasil diperbarui!");
    }
    
     public void update_password() {
        Scanner input = new Scanner(System.in);

        jumlahKesalahanPassword = 0;

        do {
            System.out.println("Update Password");
            System.out.print("Masukkan password lama: ");
            String oldPassword = input.next();

            if (oldPassword.equals(this.getpassword())) {
                System.out.print("Masukkan password baru: ");
                String newPassword = input.next();
                setpassword(newPassword);
                System.out.println("Password berhasil diperbarui!");
                break;  // Keluar dari loop jika password berhasil diupdate
            } else {
                System.out.println("Password lama tidak cocok.");
                jumlahKesalahanPassword++;

                if (jumlahKesalahanPassword >= BATAS_KESALAHAN_PASSWORD) {
                    System.out.println("Anda telah melebihi batas kesalahan password. Kembali ke menu utama.");
                    break;  // Keluar dari loop jika batas kesalahan tercapai
                } else {
                    System.out.println("Silakan coba lagi. Sisa kesalahan: " + (BATAS_KESALAHAN_PASSWORD - jumlahKesalahanPassword));
                }
            }
        } while (true);  // Loop terus sampai password berhasil diupdate atau batas kesalahan tercapai
    }
}

