/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistem_Informasi_Pizza_Etnik_Toba_Bakery;

/**
 *
 * @author MUTIARA ENJELINA
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public abstract class DatabaseConnection {
    
    // Menyiapkan paramter JDBC untuk koneksi ke datbase
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/rumah_sakit";
    static final String USER = "root";
    static final String PASS = "";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    
    public static void testDatabase() {
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Membuka koneksi ke database
            System.out.println("Menghubungkan ke database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Jika berhasil terhubung ke database
            System.out.println("Berhasil terhubung ke database!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC tidak ditemukan.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Gagal terhubung ke database.");
            e.printStackTrace();
        } finally {
            // Menutup koneksi ke database
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }   
    
}
