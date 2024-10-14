/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo GK
 */
public class Buku {
    private final String judul; // Menggunakan final agar judul tidak bisa diubah setelah dibuat
    private String pengarang;
    private int tahunTerbit;

    // Constructor
    public Buku(String judul, String pengarang, int tahunTerbit) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    // Getter untuk judul
    public String getJudul() {
        return judul;
    }

    // Getter untuk pengarang
    public String getPengarang() {
        return pengarang;
    }

    // Setter untuk pengarang
    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    // Getter untuk tahun terbit
    public int getTahunTerbit() {
        return tahunTerbit;
    }

    // Setter untuk tahun terbit
    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
}
