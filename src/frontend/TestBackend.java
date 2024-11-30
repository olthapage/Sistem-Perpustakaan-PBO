/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

/**
 *
 * @author oltha
 */

import backend.Kategori;
public class TestBackend
{
    public static void main(String[] args) {
        Kategori kat1 = new Kategori("Novel", "Koleksi buku novel");
        Kategori kat2 = new Kategori ("referensi", "Buku referensi ilmiah");
        Kategori kat3 = new Kategori("Komik", "Komik anak-anak");
        
        kat1.save();
        kat2.save();
        kat3.save();
        
        kat2.setKeterangan("Koleksi buku referensi buku ilmiah");
        kat2.save();
        
        kat3.delete();
        
        System.out.println("== Data Kategori ==");
        for (Kategori k : new Kategori().getAll()) {
            System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
        }
        
        System.out.println("\n== Hasil Pencarian Kategori ==");
        for (Kategori k : new Kategori().search("ilmiah")) {
            System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
        }
    }
}
