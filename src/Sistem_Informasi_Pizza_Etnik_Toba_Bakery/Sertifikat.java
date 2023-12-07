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
public class Sertifikat extends Post {
   Date tanggal_kadaluarsa;
   
   public void settanggal_kadaluarsa(Date tanggal_kadaluarsa){
        this.tanggal_kadaluarsa=tanggal_kadaluarsa;
    }
   
   public Date gettanggal_kadaluarsa(){
        return this.tanggal_kadaluarsa;
    }
   
   public String toString(){
         return "\n========================================="+
                 "\nKode : "+getkode()+
                 "\nJudul : "+getjudul()+
                 "\nDeskripsi : "+getdeskripsi()+
                 "\nTanggal Terbit : "+gettanggal_terbit()+
                 "\nTanggal Kadaluarsa : "+gettanggal_kadaluarsa()+
                 "\n=========================================";
     }
   public String toStringforuser(){
         return "\n========================================="+
                 "\nJudul : "+getjudul()+
                 "\nDeskripsi : "+getdeskripsi()+
                 "\nTanggal Terbit : "+gettanggal_terbit()+
                 "\nTanggal Kadaluarsa : "+gettanggal_kadaluarsa()+
                 "\n=========================================";
     }
   
    
}
