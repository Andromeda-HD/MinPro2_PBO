/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo GK
 */
public abstract class ItemPerpustakaan {
    private final String judul;

    public ItemPerpustakaan(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public abstract void tampilkanInfo();
}

