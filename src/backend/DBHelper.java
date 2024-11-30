/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author oltha
 */
import java.sql.*;

public class DBHelper {
    private static Connection koneksi;

    // Method untuk membuka koneksi ke database
    public static void bukaKoneksi() {
    if (koneksi == null) {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=dbperpus;encrypt=true;trustServerCertificate=true;";
            String user = "sa";
            String password = "admin123";
            koneksi = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
    }
    }

    // Method untuk menjalankan query INSERT dan mendapatkan ID yang dihasilkan
    public static int insertQueryGetId(String query) {
        bukaKoneksi();
        int result = -1;
        try {
            Statement stmt = koneksi.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method untuk menjalankan query INSERT, UPDATE, DELETE
    public static boolean executeQuery(String query) {
        bukaKoneksi();
        boolean result = false;
        try {
            Statement stmt = koneksi.createStatement();
            stmt.executeUpdate(query);
            result = true;
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method untuk menjalankan query SELECT dan mengembalikan ResultSet
    public static ResultSet selectQuery(String query) {
        bukaKoneksi();
        ResultSet rs = null;
        try {
            Statement stmt = koneksi.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}