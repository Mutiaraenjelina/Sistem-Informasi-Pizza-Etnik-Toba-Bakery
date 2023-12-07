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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Date;
public class DataMasukan extends Masukan implements Aksi{
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Masukan> datamasukan = new ArrayList<>();
    Masukan newmasukan = new Masukan();
    
    @Override
    public  void display(){
         int i =1;
        if(!datamasukan.isEmpty()) {
            System.out.println("Masukan Pengunjung : ");
            Iterator iter = datamasukan.iterator();
            System.out.println("===========================");
            for(Masukan m : datamasukan) {
                System.out.println(i + ". "+ m + "\n");
                i++;
            }
            System.out.println("===========================");
        }else {
           System.out.println("===========================");
           System.out.println("Masukan masih kosong");
           System.out.println("===========================");
       }
    }
    
@Override
public void displayforuser() {
    int i = 1;
    boolean masukanAktifDitemukan = false;

    if (!datamasukan.isEmpty()) {
        System.out.println("Masukan Pengunjung : ");
        System.out.println("===========================");

        for (Masukan m : datamasukan) {
            if (m.getstatus() == Status.AKTIF) {
                System.out.println(i + ". " + m.toStringforuser()+ "\n");
                i++;    
                masukanAktifDitemukan = true;
            }
        }

        System.out.println("===========================");
    } else {
        System.out.println("===========================");
        System.out.println("Masukan masih kosong");
        System.out.println("===========================");
    }

    if (!masukanAktifDitemukan) {
        System.out.println("Tidak ada masukan dengan status aktif.");
    }
}

    
@Override
public void add() {
    System.out.println("Tambah Masukan Baru:");

    System.out.print("Masukkan Nama Pengunjung: ");
    String nama = input.next();

    System.out.print("Masukkan Masukan: ");
    String masukan = input.next();

    // Anda mungkin ingin menggunakan timestamp untuk waktu masukan
    Date waktu = new Date();

    // Membuat objek Masukan baru
    Masukan newMasukan = new Masukan();
    newMasukan.setkode(datamasukan.size() + 1); // Kode dapat di-generate sesuai dengan jumlah masukan yang sudah ada
    newMasukan.setnama(nama);
    newMasukan.setmasukan(masukan);
    newMasukan.setwaktu(waktu);
    newMasukan.setstatus(Status.AKTIF); // Status diatur secara otomatis sebagai AKTIF

    // Menambahkan masukan baru ke dalam list
    datamasukan.add(newMasukan);

    System.out.println("Masukan berhasil ditambahkan!");
    displayforuser(); // Menampilkan masukan setelah penambahan
}


    // capitalize
    public String capitalizeFirstLetter(String text) {
    return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
    
    //loop status
    public void loopStatus() {
    System.out.println("Pilih Status Masukan : ");

    for (Status status : Status.values()) {
        System.out.println((status.ordinal() + 1) + ". " + capitalizeFirstLetter(status.name()));
    }

    int opsiStatus = 0;
    boolean inputValid;

    do {
        inputValid = true; // Menganggap input valid secara default

        try {
            System.out.print("Pilih: ");
            opsiStatus = input.nextInt();

            if (opsiStatus < 1 || opsiStatus > Status.values().length) {
                System.out.println("Pilihan status tidak valid. Silahkan coba lagi.");
                inputValid = false; // Set inputValid ke false agar loop melanjutkan
            } else {
                setstatus(Status.values()[opsiStatus - 1]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka. Silahkan coba lagi.");
            input.nextLine(); // Konsumsi input yang tidak valid
            inputValid = false; // Set inputValid ke false agar loop melanjutkan
        }
    } while (!inputValid);
}
    @Override
public void update() {
    if (!datamasukan.isEmpty()) {
        display(); // Menampilkan masukan

        try {
            System.out.print("Masukkan kode masukan yang ingin dinonaktifkan: ");
            int kodeToUpdate = input.nextInt();

            boolean masukanDitemukan = false;
            for (Masukan m : datamasukan) {
                if (m.getkode() == kodeToUpdate) {
                    m.setstatus(Status.NONAKTIF); // Mengubah status menjadi NONAKTIF
                    masukanDitemukan = true;
                    break;
                }
            }

            if (masukanDitemukan) {
                System.out.println("Masukan Berhasil di Blokir");
            } else {
                System.out.println("Masukan dengan kode " + kodeToUpdate + " tidak ditemukan.");
            }

            display(); // Menampilkan status yang diperbarui
        } catch (InputMismatchException e) {
            System.out.println("Masukan tidak sesuai. Silakan masukkan kode yang sesuai.");
            input.nextLine(); // Mengonsumsi input yang tidak valid
        }
    } else {
        System.out.println("Tidak ada masukan yang tersedia");
    }
}

}
