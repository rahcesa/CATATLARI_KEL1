# Aplikasi CatatLari 🏃‍♂️

## 👤 Informasi Pembuat

| NPM | Nama |
|-----|------|
| 24082010059 | Adelia Noviyanti |
| 24082010060 | Sherly Dea Aulia |
| 24082010062 | Rahcesa Sabell Gusti |
| 24082010063 | Naila Sasikirana |

---

## 📱 Deskripsi Aplikasi

**CatatLari** adalah aplikasi Android yang digunakan untuk mencatat aktivitas lari pengguna secara sederhana.  
Aplikasi ini memungkinkan pengguna untuk menyimpan data seperti tanggal lari, jarak tempuh, dan durasi lari.

Data disimpan secara lokal menggunakan **Room Database**, sehingga tetap tersedia meskipun aplikasi ditutup.

Aplikasi ini dibangun menggunakan arsitektur **MVVM (Model-View-ViewModel)** agar struktur kode lebih rapi dan mudah dikembangkan.

---

## Fitur Aplikasi

### 🔐 1. Login & Register
Pengguna dapat membuat akun dan masuk ke dalam aplikasi.

### ➕ 2. Tambah Catatan Lari (Create)
Pengguna dapat menambahkan data lari:
- Tanggal
- Jarak (meter)
- Durasi (menit)

### 📋 3. Lihat Riwayat Lari (Read)
Semua data lari ditampilkan dalam bentuk list menggunakan RecyclerView.

### ✏️ 4. Update Data (Update)
Pengguna dapat mengedit data lari yang sudah dibuat.

### 🗑️ 5. Hapus Data (Delete)
Pengguna dapat menghapus data lari dari daftar.

### 💾 6. Penyimpanan Lokal
Data disimpan menggunakan **Room Database**, sehingga tidak hilang saat aplikasi ditutup.

---

## 🛠️ Tech Stack

- **Bahasa Pemrograman:** Kotlin
- **Arsitektur:** MVVM (Model-View-ViewModel)
- **Database:** Room Database
- **UI:** XML Layout
- **Komponen Android:**
    - ViewModel
    - LiveData
    - RecyclerView
    - Navigation Component
    - ViewBinding

---

## 🧱 Struktur Utama

- **Model:** `Run.kt`
- **DAO:** `RunDao.kt`
- **Database:** `RunDatabase.kt`
- **Repository:** `RunRepository.kt`
- **ViewModel:** `RunViewModel.kt`
- **View:** Fragment & Adapter

---

## ▶️ Cara Menjalankan Aplikasi

1. Buka project di Android Studio
2. Tunggu proses Gradle Sync selesai
3. Jalankan aplikasi di emulator atau device
4. Login / Register
5. Tambahkan catatan lari

---

## 📌 Catatan

Aplikasi ini dibuat sebagai tugas mata kuliah Pemrograman Mobile dengan menerapkan konsep MVVM dan Room Database.