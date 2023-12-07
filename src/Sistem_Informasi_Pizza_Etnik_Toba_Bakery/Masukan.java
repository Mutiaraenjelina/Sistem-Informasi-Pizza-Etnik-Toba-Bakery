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
public class Masukan extends User {
    int kode;
    String masukan;
    Date waktu;
    Status status;
    //set
    public void setkode(int kode){
        this.kode =kode;
    }
    public void setmasukan (String masukan){
        this.masukan=masukan;
    }
    public void setwaktu(Date waktu){
        this.waktu = waktu;
    }
    public void setstatus (Status status){
        this.status = status;
    }
    
    // get
    public int getkode(){
        return this.kode;
    }
    public String getmasukan(){
        return this.masukan;
    }
    public Date getwaktu(){
        return this.waktu;
    }
    public Status getstatus (){
        return this.status;
    }
    // Dete in Indonesia
    public String getTanggalIndonesia() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
        return sdf.format(this.waktu);
    }
     // capitalize
    public String capitalizeFirstLetter(String text) {
    return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
    public String toString(){
         return "\n========================================="+
                 "\nKode : "+getkode()+
                 "\nNama : "+getnama()+
                 "\nWaktu Unggah : "+getTanggalIndonesia()+
                 "\nMasukan : "+getmasukan()+
                 "\nStatus : "+capitalizeFirstLetter(status.name())+
                 "\n=========================================";
     }
    public String toStringforuser(){
         return "\n========================================="+
                 "\nNama : "+getnama()+
                 "\nWaktu Unggah : "+getTanggalIndonesia()+
                 "\nMasukan : "+getmasukan()+
                 "\n=========================================";
     }
} 

