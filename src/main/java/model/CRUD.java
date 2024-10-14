/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo GK
 */
public interface CRUD<T> {
    void tambah(T item);
    void lihatDaftar();
    void hapus(String judul);
    void update(String judul);
}
