# Aplikasi Perpustakaan

Aplikasi Perpustakaan adalah sebuah sistem manajemen perpustakaan yang dirancang untuk mempermudah pengelolaan dan pemantauan koleksi buku. Dengan aplikasi ini, pengguna dapat melakukan berbagai operasi dasar yang terkait dengan pengelolaan buku, termasuk penambahan, pembaruan, penghapusan, dan pemantauan daftar buku yang tersedia. Aplikasi ini dibangun dengan menggunakan bahasa pemrograman Java dan menerapkan prinsip-prinsip Pemrograman Berorientasi Objek (OOP), yang menjadikan kode lebih terstruktur, modular, dan mudah untuk dikembangkan lebih lanjut.

## Tujuan
Tujuan utama dari pengembangan aplikasi ini adalah untuk:

Menyederhanakan Pengelolaan Buku: Memudahkan pengguna dalam mengelola koleksi buku dengan menyediakan antarmuka yang intuitif dan mudah digunakan.

Meningkatkan Aksesibilitas: Menyediakan akses yang cepat dan efisien untuk menambah, memperbarui, dan menghapus informasi buku.

Mengurangi Risiko Kesalahan: Dengan menggunakan sistem berbasis komputer, aplikasi ini mengurangi kemungkinan kesalahan manusia dalam pengelolaan data buku.
## Daftar Isi
- [Deskripsi Proyek](#deskripsi-proyek)
- [Fitur](#fitur)
- [Struktur Proyek](#struktur-proyek)
- [Penjelasan Kode](#penjelasan-kode)
  - [Model](#model)
    - [Buku](#buku)
    - [ItemPerpustakaan](#itemperpustakaan)
    - [CRUD](#crud)
    - [Kelas Perpustakaan](#kelas-perpustakaan)
  - [Kelas AplikasiPerpustakaan](#kelas-aplikasiperpustakaan)
- [Cara Menjalankan Aplikasi](#cara-menjalankan-aplikasi)
- [Pentingnya Penggunaan OOP](#pentingnya-penggunaan-oop)
- [Kontribusi](#kontribusi)

## Deskripsi Proyek

Aplikasi Perpustakaan ini memungkinkan pengguna untuk:
- Menambahkan buku baru.
- Melihat daftar buku yang tersedia.
- Menghapus buku dari daftar.
- Memperbarui informasi buku yang ada.

Program ini menggunakan prinsip-prinsip Pemrograman Berorientasi Objek (OOP), termasuk **Inheritance**, **Encapsulation**, **Abstraction**, dan **Polymorphism**.

## Fitur
- Menyimpan data buku secara statis pada awal aplikasi.
- Menampilkan daftar buku dalam format tabel yang mudah dibaca.
- Memungkinkan pengguna untuk memperbarui informasi buku.
- Menghapus buku berdasarkan judul.

## Struktur Proyek

```
AplikasiPerpustakaan/
│
├── src/
│   ├── com.mycompany.aplikasiperpustakaan/
│   │   └── AplikasiPerpustakaan.java
│   └── model/
│       ├── Buku.java
│       ├── CRUD.java
│       ├── ItemPerpustakaan.java
│       └── Perpustakaan.java
└── README.md
```

## Penjelasan Kode

### Model

#### 1. `Buku.java`

Kelas ini merepresentasikan objek buku dengan atribut judul, pengarang, dan tahun terbit. Menggunakan **encapsulation** dengan getter dan setter untuk mengakses dan memodifikasi data.

```java
package model;

public class Buku extends ItemPerpustakaan {
    private String pengarang;
    private int tahunTerbit;

    // Constructor
    public Buku(String judul, String pengarang, int tahunTerbit) {
        super(judul); // Memanggil constructor ItemPerpustakaan
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    // Getter dan Setter
    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("| %-25s | %-20s | %-10d |\n", getJudul(), pengarang, tahunTerbit);
    }
}
```

#### 2. `ItemPerpustakaan.java`

Kelas abstrak ini mendefinisikan atribut dasar dan metode yang harus dimiliki oleh semua item perpustakaan, termasuk buku. 

```java
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
```

#### 3. `CRUD.java`

Interface ini mendefinisikan metode yang diperlukan untuk operasi CRUD. Semua kelas yang ingin melakukan operasi ini harus mengimplementasikan interface ini.

```java
package model;

public interface CRUD<T> {
    void tambah(T item);
    void lihatDaftar();
    void hapus(String judul);
    void update(String judul);
}
```

### Kelas Perpustakaan

Kelas ini mengimplementasikan interface `CRUD` dan menyimpan daftar buku. Kelas ini memiliki metode untuk menambah, melihat, menghapus, dan memperbarui buku.

```java
package model;

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

    // Method untuk menambah buku
    @Override
    public void tambah(Buku buku) {
        daftarBuku.add(buku);
        System.out.println("Buku '" + buku.getJudul() + "' berhasil ditambahkan!");
    }

    // Method untuk melihat daftar buku dengan format tabel
    @Override
    public void lihatDaftar() {
        System.out.println("Daftar Buku:");
        System.out.println("| Judul Buku               | Pengarang           | Tahun Terbit |");
        System.out.println("----------------------------------------------------");
        for (Buku buku : daftarBuku) {
            buku.tampilkanInfo();
        }
    }

    // Method untuk menghapus buku
    @Override
    public void hapus(String judul) {
        // Menghapus buku berdasarkan judul
    }

    // Method untuk memperbarui informasi buku
    @Override
    public void update(String judul) {
        // Memperbarui informasi buku
    }

    // Data awal buku secara statis
    private void inisialisasiBuku() {
        daftarBuku.add(new Buku("Laskar Pelangi", "Andrea Hirata", 2009));
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
```

### Kelas AplikasiPerpustakaan

Kelas ini adalah titik masuk aplikasi, menampilkan menu dan mengatur interaksi pengguna.

```java
package com.mycompany.aplikasiperpustakaan;

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
                    System.out.println("Pilihan tidak valid, sil

akan coba lagi.");
            }
        } while (pilihan != 5);
    }

    // Menambahkan buku baru
    private static void tambahBuku(Scanner scanner) {
        // Menambah buku
    }

    // Menghapus buku berdasarkan judul
    private static void hapusBuku(Scanner scanner) {
        // Menghapus buku
    }

    // Mengupdate data buku berdasarkan judul
    private static void updateBuku(Scanner scanner) {
        // Memperbarui data buku
    }

    // Menampilkan header aplikasi
    private static void tampilkanHeader() {
        System.out.println("=====================================");
        System.out.println("     APLIKASI PERPUSTAKAAN");
        System.out.println("=====================================");
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
```

## Cara Menjalankan Aplikasi

Untuk menjalankan aplikasi ini, ikuti langkah-langkah berikut:

1. **Kompilasi Kode**:
   Pastikan Anda memiliki Java Development Kit (JDK) terinstal di komputer Anda. Buka terminal atau command prompt, dan navigasikan ke folder `src`. Jalankan perintah berikut untuk mengkompilasi semua file Java:
   ```bash
   javac com/mycompany/aplikasiperpustakaan/AplikasiPerpustakaan.java model/*.java
   ```

2. **Jalankan Aplikasi**:
   Setelah kompilasi berhasil, jalankan aplikasi dengan perintah:
   ```bash
   java com.mycompany.aplikasiperpustakaan.AplikasiPerpustakaan
   ```

3. **Ikuti Instruksi**:
   Ikuti instruksi yang muncul di layar untuk menambahkan, melihat, menghapus, atau memperbarui buku.

## Pentingnya Penggunaan OOP

Penggunaan **Pemrograman Berorientasi Objek (OOP)** dalam aplikasi ini memiliki banyak keuntungan:
- **Reusability**: Kode dapat digunakan kembali melalui inheritance dan interfaces.
- **Encapsulation**: Data disembunyikan dan hanya dapat diakses melalui metode yang ditentukan.
- **Abstraction**: Pengguna tidak perlu mengetahui detail implementasi untuk menggunakan kelas.
- **Modularitas**: Kode terorganisir dalam paket yang berbeda, membuatnya lebih mudah dikelola.

## Kontribusi

Kontribusi dalam bentuk saran dan perbaikan sangat diterima. Jika Anda memiliki ide atau perbaikan untuk aplikasi ini, silakan buka isu atau kirim pull request.
