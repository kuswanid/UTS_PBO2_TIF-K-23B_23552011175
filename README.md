# UTS Pemrograman Berorientasi Obyek 2

- Mata Kuliah: Pemrograman Berorientasi Obyek 2
- Dosen Pengampu: [Muhammad Ikhwan Fathulloh](https://github.com/Muhammad-Ikhwan-Fathulloh)

## Profil

- Nama: **Tatang**
- NIM: **23552011175**
- Studi Kasus: Aplikasi CLI PropertEase untuk Manajemen Properti dan Transaksi Sewa Properti

## Judul Studi Kasus

PropertEase: Aplikasi CLI Manajemen Properti Berbasis Java

## Penjelasan Studi Kasus

Proyek ini membangun sebuah aplikasi Command-Line Interface (CLI) menggunakan Java untuk mengelola data properti,
pelanggan, dan transaksi sewa. Semua data disimpan di database PostgreSQL melalui JDBC. Aplikasi menyediakan fitur:

- **Autentikasi User** (login & registrasi dengan peran berbeda)
- **CRUD** untuk entitas Customer, Property, dan Transaction
- **Navigasi antar‐layar** menggunakan Screen interface dan Navigator berbasis stack history
- **Business logic** terpisah di layer Service, dan akses database di layer Repository

## Penjelasan 4 Pilar OOP dalam Studi Kasus

1. **Inheritance**

Setiap layar (screen) seperti **LoginScreen**, **MainScreen**, **CustomersScreen** mengimplementasikan interface
**Screen**, memanfaatkan konsep *inheritance/interface* untuk menyeragamkan kontrak UI.

3. **Encapsulation**

Model domain (**Customer**, **Property**, **Transaction**, **User**) menyimpan atribut sebagai **private** fields dan
hanya menyediakan *getter*, sehingga data tidak bisa diubah langsung dari luar kelas.

4. **Polymorphism**

**Navigator** menyimpan objek-objek **Screen** dalam sebuah **Stack<Screen>** dan memanggil method **render()** dan **onInput()** tanpa mempedulikan tipe konkret kelasnya, semua implementasi **Screen** diperlakukan secara uniform.

5. **Abstraction**

Detail koneksi dan query SQL disembunyikan di balik kelas-kelas Repository (misalnya **CustomerRepository.findAll()**,
**TransactionRepository.save()**), sedangkan Service layer (misalnya **PropertyService**, **TransactionService**)
mengekspos API
sederhana seperti **create()**, **update()**, **delete()** tanpa mengungkapkan kompleksitas JDBC.

## Demo Proyek

Google Drive: https://drive.google.com/drive/folders/1diEYXkc0esiv6_3xo3pk6IvMdaDbXmku


