/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistem_Informasi_Pizza_Etnik_Toba_Bakery;

/**
 *
 * @author MUTIARA ENJELINA
 */

public class Prestasi extends Post {
    public String toString(){
         return "\n========================================="+
                 "\nKode : "+getkode()+
                 "\nJudul : "+getjudul()+
                 "\nDeskripsi : "+getdeskripsi();
     }
   public String toStringforuser(){
         return "\n========================================="+
                 "\nJudul : "+getjudul()+
                 "\nDeskripsi : "+getdeskripsi();
     }
}
