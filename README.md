# Employee Management System
Aplikasi sistem manajemen karyawan sederhana. Dibuat untuk kepentingan portfolio dan resume kandidat. Teknologi yang digunakan pada aplikasi ini adalah Java Spring Boot, Thymeleaf, Hibernate, Spring Security, & PostgreSQL.

# Fitur pada Aplikasi Web
## Registrasi
Calon pengguna harus mendaftarkan dirinya terlebih dahulu supaya mendapatkan akun akses dan bisa login ke halaman klien.

## Login
Login berfungsi untuk melakukan otentifikasi kepada pengguna yang akan mengakses halaman klien.

## Update
Fitur update berfungsi untuk membantu klien melakukan pembaharuan mengenai data dirinya.

## Delete
Fitur delete digunakan untuk menghapus salah satu akun pengguna dari database.

## Sorting
Fitur sorting berguna untuk membantu klien mengurutkan data pada tabel data berdasarkan kategori kolom tabel.

# Teknologi
## Java Spring Boot
Framework Java Spring Boot dipilih karena ragam fitur dan kemudahan yang ditawarkan kepada programmer dengan mengeleminasi banyak pengkodean boiler plate.

## Thymeleaf
UI (User Interface) Template Engine ini dipilih karena memiliki fitur untuk memeriksa langsung hasil perubahan kode program yang dilakukan tanpa harus melakukan restart server terlebih dahulu.

## Hibernate JPA
Hibernate JPA digunakan untuk memudahkan akses ke database.

## Spring Security
Spring Security digunakan untuk memastikan keamanan otentifikasi pengguna.

## PostgreSQL
PostgreSQL dipilih semata-mata karena kandidat sudah terbiasa dengan teknologi database jenis ini.

# How-to-Use (Cara Penggunaan)
- copy seluruh file yang ada dalam repository ini dengan menggunakan 'git clone' (jika anda tidak mempunyai git di komputer anda, install terlebih dahulu)
- impor file database 'karyawan_ems.csv' ke sistem database di komputer anda terlebih dahulu (file database 'karyawan_ems.csv' dibuat dengan menggunakan PostgreSQL)
- buka direktori 'employee-management-system' melalui aplikasi Spring Tool Suite
- pastikan setting database pada file 'application.properties' sudah sesuai dengan sistem database di komputer anda
- run aplikasi

# Akses
Untuk akses pertama anda bisa menggunakan username 'admin@administrator.com' & password 'passadmin'. Setelahnyaanda dapat mencoba user lain dengan login menggunakan username [nama depan]@email.com & password pass[nama depan]