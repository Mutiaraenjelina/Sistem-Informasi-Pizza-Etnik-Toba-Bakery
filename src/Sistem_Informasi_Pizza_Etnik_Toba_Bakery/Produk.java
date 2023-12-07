/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistem_Informasi_Pizza_Etnik_Toba_Bakery;

/**
 *
 * @author MUTIARA ENJELINA
 */
public  class Produk {
    int kode;
    Kategori kategori;
    String nama;
    double harga;
    Status status;
    
        Produk(){
            
        }
    
   Produk (int kode, Kategori kategori,String nama, double harga,Status status){
        this.kode=kode;
        this.kategori = kategori;
        this.nama= nama;
        this.harga=harga;
        this.status=status;
    }
    
    //SET
    public void setkode (int kode){
        this.kode = kode;
    }
    public void setkategori (Kategori kategori){
        this.kategori = kategori;
    }
     public void setnama (String nama){
        this.nama = nama;
    }
     public void setharga (double harga){
        this.harga = harga;
    }
    public void setstatus (Status status){
        this.status = status;
    }
     
     // GET
    public int getkode (){
        return this.kode;
    }
    public Kategori getkategori (){
        return this.kategori;
    }
     public String getnama (){
        return this.nama;
    }
     public double getharga (){
        return this.harga;
    }
     public Status getstatus (){
        return this.status;
    }
     
    public String capitalizeFirstLetter(String text) {
    return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
     
     public String toString(){
         return "\n========================================="+
                 "\nKode Produk : "+getkode()+
                 "\nKategori Produk : "+capitalizeFirstLetter(kategori.name())+
                 "\nNama Produk : "+getnama()+
                 "\nHarga Produk : "+getharga()+
                 "\nStatus Produk : "+capitalizeFirstLetter(status.name())+
                 "\n=========================================";
     }
     public  void updatestatus(){
         
     }
}
