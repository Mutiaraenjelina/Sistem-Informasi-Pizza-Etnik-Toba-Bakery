/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistem_Informasi_Pizza_Etnik_Toba_Bakery;

/**
 *
 * @author MUTIARA ENJELINA
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DataProduk extends Produk implements Aksi{
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Produk> dataproduk = new ArrayList<>();
    Produk newproduk = new Produk();
    

    /*public DataProduk(int kode, Kategori kategori, String nama, double harga, Status status) {
        super(kode, kategori, nama, harga, status);
    }*/
    
    public void loopKategori() {
    System.out.println("Pilih Kategori Produk : ");

    for (Kategori kategori : Kategori.values()) {
        System.out.println((kategori.ordinal() + 1) + ". " + capitalizeFirstLetter(kategori.name()));
    }

    int opsiKategori = 0;
    boolean inputValid;

    do {
        inputValid = true; // Menganggap input valid secara default

        try {
            System.out.print("Pilih: ");
            opsiKategori = input.nextInt();

            if (opsiKategori < 1 || opsiKategori > Kategori.values().length) {
                System.out.println("Pilihan kategori tidak valid. Silahkan coba lagi.");
                inputValid = false; // Set inputValid ke false agar loop melanjutkan
            } else {
                setkategori(Kategori.values()[opsiKategori - 1]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka. Silahkan coba lagi.");
            input.nextLine(); // Konsumsi input yang tidak valid
            inputValid = false; // Set inputValid ke false agar loop melanjutkan
        }
    } while (!inputValid);
}

    
    public void loopStatus() {
    System.out.println("Pilih Status Produk : ");

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
    
  public void displayforuser() {
        if (!dataproduk.isEmpty()) {
            System.out.println("Pilih Kategori Produk atau ALL untuk melihat semua produk:");

            // Menampilkan opsi kategori
            int optionNumber = 1;
            ArrayList<Kategori> categories = new ArrayList<>();

            for (Kategori category : Kategori.values()) {
                System.out.println(optionNumber + ". " + capitalizeFirstLetter(category.name()));
                categories.add(category);
                optionNumber++;
            }
            System.out.println(optionNumber + ". ALL");

            // Mendapatkan input kategori dari pengguna
            System.out.print("Pilih: ");
            int selectedOption = input.nextInt();

            if (selectedOption >= 1 && selectedOption <= categories.size()) {
                Kategori selectedCategory = categories.get(selectedOption - 1);
                displayProductsForCategory(selectedCategory);
            } else if (selectedOption == optionNumber) {
                displayAllProducts();
            } else {
                System.out.println("Pilihan tidak valid.");
            }

        } else {
            System.out.println("===========================");
            System.out.println("Produk masih kosong");
            System.out.println("===========================");
        }
    }

    private void displayProductsForCategory(Kategori category) {
    while (true) {
        System.out.println("===========================");
        System.out.println("Produk dalam kategori " + capitalizeFirstLetter(category.name()));
        System.out.println("===========================");

        boolean foundProducts = false;

        for (Produk p : dataproduk) {
            if (p.getstatus() == Status.AKTIF && p.getkategori() == category) {
                System.out.println("Nama: " + p.getnama() +
                        ", Harga: " + p.getharga());
                foundProducts = true;
            }
        }

        if (!foundProducts) {
            System.out.println("Tidak ada produk dalam kategori ini.");
        }

        System.out.println("===========================");
        System.out.println("Pilih opsi:");
        System.out.println("1. Kembali ke Pilih Kategori Produk");
        System.out.println("2. Kembali ke Menu Utama");
        System.out.print("Pilih: ");

        int option = input.nextInt();

        switch (option) {
            case 1:
                return;  // Kembali ke memilih kategori produk
            case 2:
                displayAllProducts();  // Kembali ke menu utama
                return;
            default:
                System.out.println("Pilihan tidak sesuai. Silakan coba lagi.");
        }
    }
}


    private void displayAllProducts() {
        System.out.println("===========================");
        System.out.println("Semua Produk");
        System.out.println("===========================");

        for (Produk p : dataproduk) {
            if (p.getstatus() == Status.AKTIF) {
                System.out.println("Nama: " + p.getnama() +
                        ", Harga: " + p.getharga() +
                        ", Kategori: " + capitalizeFirstLetter(p.getkategori().name()));
            }
        }

        System.out.println("-===========================");
    }


    
    @Override
    public void display() {
         int i =1;
        if(!dataproduk.isEmpty()) {
            System.out.println("Produk yang tersedia : ");
            Iterator iter = dataproduk.iterator();
            System.out.println("===========================");
            for(Produk p : dataproduk) {
                System.out.println(i + ". "+ p + "\n");
                i++;
            }
            System.out.println("===========================");
        }else {
           System.out.println("===========================");
           System.out.println("Produk masih kosong");
           System.out.println("===========================");
       }
    }
    
    @Override
    public void add() {
        int success = 1;
        loopKategori();
        System.out.print("Masukkan nama Produk : ");
        nama = input.next();
        System.out.print("Masukkan harga Produk : ");
        harga = input.nextDouble();
        loopStatus();
        setkode(dataproduk.size() + 1);
        setnama(nama);
        setharga(harga);

        dataproduk.add(new Produk(kode,kategori,nama, harga,status));
        System.out.println("===========================");
        System.out.println("Berhasil Menambah Produk");
        System.out.println("===========================");
        display();
    }

    // Implementasi

@Override
public void update() {
    if (!dataproduk.isEmpty()) {
        display(); // Display existing products for user reference

        try {
            System.out.print("Masukkan kode produk yang ingin diubah: ");
            int kodeToUpdate = input.nextInt();

            boolean productFound = false;
            Produk selectedProduct = null;

            for (Produk p : dataproduk) {
                if (p.getkode() == kodeToUpdate) {
                    productFound = true;
                    selectedProduct = p;
                    break;
                }
            }

            if (productFound) {
                boolean continueUpdating = true;

                while (continueUpdating) {
                    System.out.println("Pilih Opsi untuk Mengubah:");
                    System.out.println("1. Ubah semua atribut dari kode " + kodeToUpdate);
                    System.out.println("2. Pilih atribut yang ingin diubah");
                    System.out.println("3. Keluar");

                    int updateOption = input.nextInt();

                    switch (updateOption) {
                        case 1:
                            loopKategori();
                            System.out.print("Masukkan Nama Baru Produk: ");
                            String newNama = input.next();
                            System.out.print("Masukkan Harga Baru Produk: ");
                            double newHarga = input.nextDouble();
                            selectedProduct.setnama(newNama);
                            selectedProduct.setharga(newHarga);
                            selectedProduct.setkategori(kategori);
                            display();
                            System.out.println("Produk Berhasil Diubah");
                            continueUpdating = false;
                            break;

                        case 2:
                            boolean continueUpdatingAttributes = true;

                            while (continueUpdatingAttributes) {
                                System.out.println("Pilih atribut yang ingin diubah:");
                                System.out.println("1. Nama");
                                System.out.println("2. Harga");
                                System.out.println("3. Kategori");
                                System.out.println("4. Keluar");

                                int option = input.nextInt();

                                switch (option) {
                                    case 1:
                                        System.out.print("Masukkan Nama Baru Produk: ");
                                        String newNamaOption = input.next();
                                        selectedProduct.setnama(newNamaOption);
                                        break;

                                    case 2:
                                        System.out.print("Masukkan Harga Baru Produk: ");
                                        double newHargaOption = input.nextDouble();
                                        selectedProduct.setharga(newHargaOption);
                                        break;

                                    case 3:
                                        loopKategori();
                                        selectedProduct.setkategori(kategori);
                                        break;

                                    case 4:
                                        continueUpdatingAttributes = false;
                                        break;

                                    default:
                                        System.out.println("Opsi Tidak Sesuai. Tidak ada Atribut yang diubah.");
                                }

                                display();
                                System.out.println("Berhasil Mengubah Atribut");
                            }
                            break;

                        case 3:
                            continueUpdating = false;
                            break;

                        default:
                            System.out.println("Opsi Tidak Sesuai. Silahkan Coba lagi");
                    }
                }

                System.out.println("Proses Pengubahan Selesai.");
            } else {
                System.out.println("Produk dengan kode" + kodeToUpdate + " tidak ditemukan.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Masukan tidak sesuai. Silahkan Masukkan kode yang sesuai");
            input.nextLine(); // Consume invalid input
        }
    } else {
        System.out.println("Tidak ada produk yang tersedia untuk diubah.");
    }
}






@Override
public void updatestatus() {
    if (!dataproduk.isEmpty()) {
        display(); // Display existing products for user reference

        try {
            System.out.print("Masukkan kode produk yang ingin di ubah statusnya: ");
            int kodeToUpdate = input.nextInt();

            boolean productFound = false;
            for (Produk p : dataproduk) {
                if (p.getkode() == kodeToUpdate) {
                    loopStatus();
                    p.setstatus(status);

                    productFound = true;
                    break;
                }
            }

            if (productFound) {
                System.out.println("Status Produk Berhasil diubah");
            } else {
                System.out.println("Produk dengan kode " + kodeToUpdate + " tidak ditemuakan.");
            }

            display(); // Display updated products
        } catch (InputMismatchException e) {
            System.out.println("Masukan tidak sesuai. Silahkan masukkan kode yang sesuai.");
            input.nextLine(); // Consume invalid input
        }
    } else {
        System.out.println("Tidak ada produk yang tersedia untuk diubah statusnya");
    }
}
}

