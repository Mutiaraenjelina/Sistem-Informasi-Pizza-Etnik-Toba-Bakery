/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistem_Informasi_Pizza_Etnik_Toba_Bakery;

/**
 *
 * @author MUTIARA ENJELINA
 */
public abstract class User {
protected String  nama, username, password, email, notelp;

public User(){}

public User(String nama, String username, String password, String email, String noTelp) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.email = email;
        this.notelp = noTelp;
    }

 // SET
protected void setnama ( String nama ) {
    this.nama = nama;
}
 
protected void setusername ( String username ) {
    this.username = username;
}

protected void setpassword ( String password ) {
    this.password = password;
}

protected void setemail ( String email ) {
    this.email = email;
}
protected void setnotelp ( String notelp ) {
    this.notelp = notelp;
}

// GET
protected String getnama () {
    return this.nama;
}
 
protected String getusername () {
    return this.username;
}

protected String getpassword () {
    return this.password;
}

protected String getemail(){
    return this.email;
}
protected String getnotelp () {
    return this.notelp;
}
public String toString(){
    return "====================================\n"+
            "Nama          : "+getnama()+"\n"+
            "Email         : "+getemail()+"\n"+
            "Nomor Telepon : "+getnotelp()+"\n"+
             "====================================\n";
}
}
