/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistem_Informasi_Pizza_Etnik_Toba_Bakery;



/**
 *
 * @author MUTIARA ENJELINA
 */
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
public class Post {
     int kode;
    String judul;
    String deskripsi;
    Date tanggal_terbit ;
    
    
    
    // Dete in Indonesia
    public String getTanggalIndonesia(Date tanggal) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("id", "ID"));
        return sdf.format(this.tanggal_terbit);
    }
    
    // set
    public void setkode(int kode){
        this.kode=kode;
    }
    public void setjudul(String judul){
        this.judul=judul;
    }
    public void setdeskripsi(String deskripsi){
        this.deskripsi=deskripsi;
    }
    public void settanggal_terbit(Date tanggal_terbit){
        this.tanggal_terbit=tanggal_terbit;
    }
    
    
    // get
    public int getkode(){
       return this.kode;
    }
    public String getjudul(){
       return this.judul;
    }
    public String getdeskripsi(){
       return this.deskripsi;
    }
    public Date gettanggal_terbit(){
        return this.tanggal_terbit;
    }
    
}
