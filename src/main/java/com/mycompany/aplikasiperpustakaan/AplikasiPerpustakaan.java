


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aplikasiperpustakaan;

/**
 *
 * @author Lenovo GK
 */
import model.Buku;
import model.Perpustakaan;

import java.util.Scanner;

public class AplikasiPerpustakaan {
    private static Perpustakaan perpustakaan;

    public static void main(String[] args) {
        perpustakaan = new Perpustakaan("Perpustakaan Umum");
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            tampilkanHeader();
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    tambahBuku(scanner);
                    break;
                case 2:
                    perpustakaan.lihatDaftar();
                    break;
                case 3:
                    hapusBuku(scanner);
                    break;
                case 4:
                    updateBuku(scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 5);
    }

    // Menambahkan buku baru
    private static void tambahBuku(Scanner scanner) {
        System.out.print("\nMasukkan Judul Buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Pengarang: ");
        String pengarang = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine();  // Konsumsi newline

        Buku bukuBaru = new Buku(judul, pengarang, tahunTerbit);
        perpustakaan.tambah(bukuBaru);
    }

    // Menghapus buku berdasarkan judul
    private static void hapusBuku(Scanner scanner) {
        System.out.print("\nMasukkan Judul Buku yang akan dihapus: ");
        String judul = scanner.nextLine();
        perpustakaan.hapus(judul);
    }

    // Mengupdate data buku berdasarkan judul
    private static void updateBuku(Scanner scanner) {
        System.out.print("\nMasukkan Judul Buku yang akan diupdate: ");
        String judul = scanner.nextLine();
        perpustakaan.update(judul);
    }

    // Menampilkan header aplikasi
    private static void tampilkanHeader() {
        System.out.println("=======================================");
        System.out.println("        Aplikasi Perpustakaan");
        System.out.println("=======================================");
    }

    // Menampilkan menu aplikasi
    private static void tampilkanMenu() {
        System.out.println("1. Tambah Buku");
        System.out.println("2. Lihat Daftar Buku");
        System.out.println("3. Hapus Buku");
        System.out.println("4. Update Buku");
        System.out.println("5. Keluar");
    }
}
