/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo GK
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perpustakaan implements CRUD<Buku> {
    private final String namaPerpustakaan;
    private static List<Buku> daftarBuku = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public Perpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;
        if (daftarBuku.isEmpty()) {
            inisialisasiBuku();  // Inisialisasi data statis
        }
    }

    public String getNamaPerpustakaan() {
        return namaPerpustakaan;
    }

    // Method untuk menambah buku
    @Override
    public void tambah(Buku buku) {
        daftarBuku.add(buku);
        System.out.println("Buku '" + buku.getJudul() + "' berhasil ditambahkan!");
    }

    // Method untuk melihat daftar buku dengan format tabel
    @Override
    public void lihatDaftar() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Tidak ada buku di perpustakaan.");
        } else {
            System.out.println("\nDaftar Buku di " + namaPerpustakaan + ":");
            System.out.println("============================================================");
            System.out.printf("%-5s %-30s %-25s %-15s\n", "No", "Judul", "Pengarang", "Tahun Terbit");
            System.out.println("============================================================");

            int no = 1;
            for (Buku buku : daftarBuku) {
                System.out.printf("%-5d %-30s %-25s %-15d\n", no++, buku.getJudul(), buku.getPengarang(), buku.getTahunTerbit());
            }
            System.out.println("============================================================");
        }
    }

    // Method untuk menghapus buku
    @Override
    public void hapus(String judul) {
        Buku bukuDihapus = null;
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                bukuDihapus = buku;
                break;
            }
        }
        if (bukuDihapus != null) {
            daftarBuku.remove(bukuDihapus);
            System.out.println("Buku '" + judul + "' berhasil dihapus.");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    // Method untuk memperbarui informasi buku
    @Override
    public void update(String judul) {
        Buku bukuDiperbarui = null;
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                bukuDiperbarui = buku;
                break;
            }
        }

        if (bukuDiperbarui != null) {
            System.out.println("Mengubah data untuk buku: " + bukuDiperbarui.getJudul());
            System.out.print("Masukkan Pengarang Baru: ");
            String pengarangBaru = scanner.nextLine();
            System.out.print("Masukkan Tahun Terbit Baru: ");
            int tahunTerbitBaru = scanner.nextInt();
            scanner.nextLine();  // Konsumsi newline

            // Memperbarui data buku
            bukuDiperbarui.setPengarang(pengarangBaru);
            bukuDiperbarui.setTahunTerbit(tahunTerbitBaru);

            System.out.println("Data buku berhasil diperbarui.");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    // Data awal buku secara statis
    private void inisialisasiBuku() {
        daftarBuku.add(new Buku("Laskar Pelangi", "Andrea Hirata", 2005));
        daftarBuku.add(new Buku("Bumi Manusia", "Pramoedya Ananta Toer", 1980));
        daftarBuku.add(new Buku("Dilan: Dia Adalah Dilanku Tahun 1990", "Pidi Baiq", 2014));
        daftarBuku.add(new Buku("Negeri 5 Menara", "Ahmad Fuadi", 2009));
        daftarBuku.add(new Buku("Supernova: Ksatria, Putri, dan Bintang Jatuh", "Dee Lestari", 2001));
        daftarBuku.add(new Buku("Cantik Itu Luka", "Eka Kurniawan", 2002));
        daftarBuku.add(new Buku("Gadis Kretek", "Ratih Kumala", 2012));
        daftarBuku.add(new Buku("Orang-Orang Biasa", "Andrea Hirata", 2009));
        daftarBuku.add(new Buku("Sang Pemimpi", "Andrea Hirata", 2006));
        daftarBuku.add(new Buku("Bulan", "Tere Liye", 2013));
        daftarBuku.add(new Buku("Hujan", "Tere Liye", 2012));
        daftarBuku.add(new Buku("Rindu", "Tere Liye", 2015));
        daftarBuku.add(new Buku("Pulang", "Tere Liye", 2017));
        daftarBuku.add(new Buku("Laut Bercerita", "Leila S. Chudori", 2017));
        daftarBuku.add(new Buku("Oleh-Oleh dari Surga", "Asma Nadia", 2011));
        daftarBuku.add(new Buku("Panda: Kisah Sang Pemberani", "Mariana", 2018));
        daftarBuku.add(new Buku("Matahari", "Tere Liye", 2019));
        daftarBuku.add(new Buku("The Rainbow Troops", "Andrea Hirata", 2009));
        daftarBuku.add(new Buku("Cinta di Ujung Sajadah", "Rizki M. S", 2020));
        daftarBuku.add(new Buku("Cinta dan Keajaiban", "Lailah S. Syafina", 2021));
    }
}

