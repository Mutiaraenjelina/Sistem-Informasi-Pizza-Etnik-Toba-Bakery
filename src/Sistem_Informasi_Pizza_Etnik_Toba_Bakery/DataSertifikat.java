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
import java.util.Date;
import java.util.Scanner;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class DataSertifikat extends Sertifikat implements Aksi {
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Sertifikat> datasertifikat = new ArrayList<>();
    
    @Override
    public  void display(){
        int i =1;
        if(!datasertifikat.isEmpty()) {
            System.out.println("Sertifikat Toko : ");
            Iterator iter = datasertifikat.iterator();
            System.out.println("===========================");
            for(Sertifikat s : datasertifikat) {
                System.out.println(i + ". "+ s + "\n");
                i++;
            }
            System.out.println("===========================");
        }else {
           System.out.println("===========================");
           System.out.println("Sertifikat masih kosong");
           System.out.println("===========================");
       }
    }
    @Override
    public void displayforuser(){
        int i = 1;

    if (!datasertifikat.isEmpty()) {
        System.out.println("Sertifikat Toko: ");
        System.out.println("===========================");

        for (Sertifikat s : datasertifikat) {
                System.out.println(i + ". " + s.toStringforuser()+ "\n");
                i++;    
            }
        System.out.println("===========================");
    } else {
        System.out.println("===========================");
        System.out.println("Sertifikat masih kosong");
        System.out.println("===========================");
    }
    }
    
    
    @Override
public void add() {
    System.out.println("Tambah Sertifikat Baru:");

    System.out.print("Masukkan Judul Sertifikat: ");
    String judul = input.next();

    System.out.print("Masukkan Deskripsi Sertifikat: ");
    String deskripsi = input.next();

    System.out.print("Masukkan Tanggal Terbit Sertifikat (Format: dd-MM-yyyy): ");
    String tanggalTerbitStr = input.next();
    Date tanggalTerbit = parseDate(tanggalTerbitStr);

    System.out.print("Masukkan Tanggal Kadaluarsa Sertifikat (Format: dd-MM-yyyy): ");
    String tanggalKadaluarsaStr = input.next();
    Date tanggalKadaluarsa = parseDate(tanggalKadaluarsaStr);

    // Membuat objek Sertifikat baru
    Sertifikat newSertifikat = new Sertifikat();
    newSertifikat.setkode(datasertifikat.size() + 1);
    newSertifikat.setjudul(judul);
    newSertifikat.setdeskripsi(deskripsi);
    newSertifikat.settanggal_terbit(tanggalTerbit);
    newSertifikat.settanggal_kadaluarsa(tanggalKadaluarsa);

    // Menambahkan sertifikat baru ke dalam list
    datasertifikat.add(newSertifikat);

    System.out.println("Sertifikat berhasil ditambahkan!");
    displayforuser(); // Menampilkan sertifikat setelah penambahan
}

// Metode untuk mengonversi string ke objek Date
private Date parseDate(String dateStr) {
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.parse(dateStr);
    } catch (ParseException e) {
        System.out.println("Format tanggal tidak valid. Gunakan format dd-MM-yyyy.");
        return null;
    }
}
     @Override
public void update() {
    display(); // Menampilkan sertifikat sebelum update

    try {
        System.out.print("Masukkan kode sertifikat yang ingin diupdate: ");
        int kodeToUpdate = input.nextInt();

        boolean sertifikatFound = false;
        for (Sertifikat s : datasertifikat) {
            if (s.getkode() == kodeToUpdate) {
                System.out.println("Pilih tindakan yang ingin dilakukan:");
                System.out.println("1. Update semua atribut");
                System.out.println("2. Update salah-satu atribut");

                int opsiUpdate = input.nextInt();
                input.nextLine(); // Membersihkan newline setelah nextInt()

                switch (opsiUpdate) {
                    case 1:
                        updateAllAttributes(s);
                        break;
                    case 2:
                        updateSingleAttribute(s);
                        break;
                    default:
                        System.out.println("Opsi tidak valid.");
                        break;
                }

                sertifikatFound = true;
                break;
            }
        }

        if (!sertifikatFound) {
            System.out.println("Sertifikat dengan kode " + kodeToUpdate + " tidak ditemukan.");
        }

        display(); // Menampilkan sertifikat setelah update
    } catch (InputMismatchException e) {
        System.out.println("Input tidak sesuai. Masukkan kode yang sesuai.");
        input.nextLine(); // Mengonsumsi input yang tidak valid
    }
}

// Metode untuk mengupdate semua atribut sertifikat
private void updateAllAttributes(Sertifikat s) {
    System.out.print("Masukkan judul baru: ");
    String newJudul = input.next();
    s.setjudul(newJudul);

    System.out.print("Masukkan deskripsi baru: ");
    String newDeskripsi = input.next();
    s.setdeskripsi(newDeskripsi);

    System.out.print("Masukkan tanggal terbit baru (Format: dd-MM-yyyy): ");
    String newTanggalTerbitStr = input.next();
    Date newTanggalTerbit = parseDate(newTanggalTerbitStr);
    s.settanggal_terbit(newTanggalTerbit);

    System.out.print("Masukkan tanggal kadaluarsa baru (Format: dd-MM-yyyy): ");
    String newTanggalKadaluarsaStr = input.next();
    Date newTanggalKadaluarsa = parseDate(newTanggalKadaluarsaStr);
    s.settanggal_kadaluarsa(newTanggalKadaluarsa);

    System.out.println("Sertifikat berhasil diupdate");
}

// Metode untuk mengupdate satu atribut sertifikat
private void updateSingleAttribute(Sertifikat s) {
    boolean updateMoreAttributes = true;

    while (updateMoreAttributes) {
        System.out.println("Pilih atribut yang ingin diupdate:");
        System.out.println("1. Judul");
        System.out.println("2. Deskripsi");
        System.out.println("3. Tanggal Terbit");
        System.out.println("4. Tanggal Kadaluarsa");
        System.out.println("5. Selesai");

        int opsiUpdate = input.nextInt();
        input.nextLine(); // Membersihkan newline setelah nextInt()

        switch (opsiUpdate) {
            case 1:
                System.out.print("Masukkan judul baru: ");
                String newJudul = input.next();
                s.setjudul(newJudul);
                break;
            case 2:
                System.out.print("Masukkan deskripsi baru: ");
                String newDeskripsi = input.next();
                s.setdeskripsi(newDeskripsi);
                break;
            case 3:
                System.out.print("Masukkan tanggal terbit baru (Format: dd-MM-yyyy): ");
                String newTanggalTerbitStr = input.next();
                Date newTanggalTerbit = parseDate(newTanggalTerbitStr);
                s.settanggal_terbit(newTanggalTerbit);
                break;
            case 4:
                System.out.print("Masukkan tanggal kadaluarsa baru (Format: dd-MM-yyyy): ");
                String newTanggalKadaluarsaStr = input.next();
                Date newTanggalKadaluarsa = parseDate(newTanggalKadaluarsaStr);
                s.settanggal_kadaluarsa(newTanggalKadaluarsa);
                break;
            case 5:
                updateMoreAttributes = false;
                break;
            default:
                System.out.println("Opsi tidak valid.");
                break;
        }

        System.out.println("Sertifikat berhasil diupdate");
    }
}


public void delete() {
    display(); // Menampilkan sertifikat sebelum delete

    try {
        System.out.print("Masukkan kode sertifikat yang ingin dihapus: ");
        int kodeToDelete = input.nextInt();

        Iterator<Sertifikat> iterator = datasertifikat.iterator();
        boolean sertifikatFound = false;
        while (iterator.hasNext()) {
            Sertifikat s = iterator.next();
            if (s.getkode() == kodeToDelete) {
                iterator.remove();
                sertifikatFound = true;
                break;
            }
        }

        if (sertifikatFound) {
            System.out.println("Sertifikat berhasil dihapus");
        } else {
            System.out.println("Sertifikat dengan kode " + kodeToDelete + " tidak ditemukan.");
        }

        display(); // Menampilkan sertifikat setelah delete
    } catch (InputMismatchException e) {
        System.out.println("Input tidak sesuai. Masukkan kode yang sesuai.");
        input.nextLine(); // Mengonsumsi input yang tidak valid
    }
}
}
