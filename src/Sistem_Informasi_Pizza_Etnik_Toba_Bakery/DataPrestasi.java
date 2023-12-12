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
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
public class DataPrestasi extends Prestasi implements Aksi{
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Prestasi> dataprestasi = new ArrayList<>();
    
    // Fungsi untuk menampilkan tanggal dalam bahasa Indonesia
    private void displayTanggalIndonesia(Date date) {
        // Convert Date to LocalDateTime
        Instant instant = date.toInstant();
        LocalDateTime waktu = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // Format the LocalDateTime using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id", "ID"));
        String waktuFormatted = waktu.format(formatter);

        System.out.println("Tanggal Terbit : " + waktuFormatted);
    }
    
    @Override
    public void display() {
        int i = 1;
        if (!dataprestasi.isEmpty()) {
            System.out.println("Prestasi Toko : ");
            for (Prestasi p : dataprestasi) {
                System.out.println(i + ". " + p);
                displayTanggalIndonesia(p.gettanggal_terbit());
                System.out.println("=========================================");
                i++;
            }
        } else {
            System.out.println("===========================");
            System.out.println("Prestasi masih kosong");
            System.out.println("===========================");
        }
    }

    @Override
    public void displayforuser() {
        int i = 1;

        if (!dataprestasi.isEmpty()) {
            System.out.println("Prestasi Toko: ");

            for (Prestasi p : dataprestasi) {
                System.out.println(i + ". " + p.toStringforuser());
                displayTanggalIndonesia(p.gettanggal_terbit());
                System.out.println("=========================================");
                i++;
            }
        } else {
            System.out.println("===========================");
            System.out.println("Prestasi masih kosong");
            System.out.println("===========================");
        }
    }
    
    
    @Override
public void add() {
    System.out.println("Tambah Prestasi Baru:");

    System.out.print("Masukkan Judul Prestasi: ");
    String judul = input.next();

    System.out.print("Masukkan Deskripsi Prestasi: ");
    String deskripsi = input.next();

    System.out.print("Masukkan Tanggal Terbit Prestasi (Format: dd-MM-yyyy): ");
    String tanggalTerbitStr = input.next();
    Date tanggalTerbit = parseDate(tanggalTerbitStr);


    // Membuat objek Prestasi baru
    Prestasi newPrestasi = new Prestasi();
    newPrestasi.setkode(dataprestasi.size() + 1);
    newPrestasi.setjudul(judul);
    newPrestasi.setdeskripsi(deskripsi);
    newPrestasi.settanggal_terbit(tanggalTerbit);

    // Menambahkan Prestasi baru ke dalam list
    dataprestasi.add(newPrestasi);

    System.out.println("Prestasi berhasil ditambahkan!");
    displayforuser(); // Menampilkan Prestasi setelah penambahan
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
    display(); // Menampilkan Prestasi sebelum update

    try {
        System.out.print("Masukkan kode Prestasi yang ingin diupdate: ");
        int kodeToUpdate = input.nextInt();

        boolean prestasiFound = false;
        for (Prestasi p : dataprestasi) {
            if (p.getkode() == kodeToUpdate) {
                System.out.println("Pilih tindakan yang ingin dilakukan:");
                System.out.println("1. Edit semua atribut");
                System.out.println("2. Edit salah-satu atribut");
                System.out.println("3. Keluar");

                int opsiUpdate = input.nextInt();
                input.nextLine(); // Membersihkan newline setelah nextInt()

                switch (opsiUpdate) {
                    case 1:
                        updateAllAttributes(p);
                        break;
                    case 2:
                        updateSingleAttribute(p);
                        break;
                    case 3:
                            break;
                    default:
                        System.out.println("Opsi tidak valid.");
                        break;
                }

                prestasiFound = true;
                break;
            }
        }

        if (!prestasiFound) {
            System.out.println("Prestasi dengan kode " + kodeToUpdate + " tidak ditemukan.");
        }

        display(); // Menampilkan Prestasi setelah update
    } catch (InputMismatchException e) {
        System.out.println("Input tidak sesuai. Masukkan kode yang sesuai.");
        input.nextLine(); // Mengonsumsi input yang tidak valid
    }
}

// Metode untuk mengupdate semua atribut Prestasi
private void updateAllAttributes(Prestasi p) {
    System.out.print("Masukkan judul baru: ");
    String newJudul = input.next();
    p.setjudul(newJudul);

    System.out.print("Masukkan deskripsi baru: ");
    String newDeskripsi = input.next();
    p.setdeskripsi(newDeskripsi);

    System.out.print("Masukkan tanggal terbit baru (Format: dd-MM-yyyy): ");
    String newTanggalTerbitStr = input.next();
    Date newTanggalTerbit = parseDate(newTanggalTerbitStr);
    p.settanggal_terbit(newTanggalTerbit);

    System.out.println("Prestasi berhasil diupdate");
}

// Metode untuk mengupdate satu atribut Prestasi
private void updateSingleAttribute(Prestasi p) {
    boolean updateMoreAttributes = true;

    while (updateMoreAttributes) {
        System.out.println("Pilih atribut yang ingin diupdate:");
        System.out.println("1. Judul");
        System.out.println("2. Deskripsi");
        System.out.println("3. Tanggal Terbit");
        System.out.println("4. Selesai");

        int opsiUpdate = input.nextInt();
        input.nextLine(); // Membersihkan newline setelah nextInt()

        switch (opsiUpdate) {
            case 1:
                System.out.print("Masukkan judul baru: ");
                String newJudul = input.next();
                p.setjudul(newJudul);
                break;
            case 2:
                System.out.print("Masukkan deskripsi baru: ");
                String newDeskripsi = input.next();
                p.setdeskripsi(newDeskripsi);
                break;
            case 3:
                System.out.print("Masukkan tanggal terbit baru (Format: dd-MM-yyyy): ");
                String newTanggalTerbitStr = input.next();
                Date newTanggalTerbit = parseDate(newTanggalTerbitStr);
                p.settanggal_terbit(newTanggalTerbit);
                break;
            case 4:
                updateMoreAttributes = false;
                break;
            default:
                System.out.println("Opsi tidak valid.");
                break;
        }

        System.out.println("Prestasi berhasil diupdate");
    }
}


public void delete() {
    display(); // Menampilkan Prestasi sebelum delete

    try {
        System.out.print("Masukkan kode Prestasi yang ingin dihapus: ");
        int kodeToDelete = input.nextInt();

        Iterator<Prestasi> iterator = dataprestasi.iterator();
        boolean prestasiFound = false;
        while (iterator.hasNext()) {
            Prestasi p = iterator.next();
            if (p.getkode() == kodeToDelete) {
                iterator.remove();
                prestasiFound = true;
                break;
            }
        }

        if (prestasiFound) {
            System.out.println("Prestasi berhasil dihapus");
        } else {
            System.out.println("Prestasi dengan kode " + kodeToDelete + " tidak ditemukan.");
        }

        display(); // Menampilkan Prestasi setelah delete
    } catch (InputMismatchException e) {
        System.out.println("Input tidak sesuai. Masukkan kode yang sesuai.");
        input.nextLine(); // Mengonsumsi input yang tidak valid
    }
}
}
