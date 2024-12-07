# Sample Android Project with Retrofit and Lifecycle

Proyek ini merupakan contoh aplikasi Android yang mengimplementasikan **Retrofit**, **Lifecycle**, dan **View Binding** untuk menangani komunikasi API, pengelolaan data, dan interaksi antarmuka secara efisien. Aplikasi ini dirancang dengan fitur **CRUD** (Create, Read, Update, Delete) serta detail data yang ditampilkan dengan cara yang terstruktur.

---

## **Fitur Utama**
1. **Implementasi Library**:
   - **Retrofit**: Digunakan untuk menangani komunikasi dengan REST API.
   - **Lifecycle**: Memanfaatkan ViewModel dan LiveData untuk mengelola data secara reaktif dan terintegrasi dengan siklus hidup Android.
   - **View Binding**: Untuk mempermudah interaksi dengan elemen UI tanpa menggunakan `findViewById`.

2. **Fitur CRUD**:
   - **Create**: Tambahkan data baru ke server melalui API.
   - **Read**: Tampilkan daftar data dari API secara dinamis menggunakan RecyclerView.
   - **Update**: Ubah data yang ada melalui API dengan formulir yang mudah digunakan.
   - **Delete**: Hapus data secara langsung dari server dengan konfirmasi yang aman.

3. **Detail Data**:
   - Tampilkan detail lengkap dari item yang dipilih, termasuk informasi tambahan yang diambil dari API.

---

## **Struktur Proyek**
- **Model**: Kelas data untuk merepresentasikan struktur JSON dari API.
- **Repository**: Mengelola interaksi dengan API menggunakan Retrofit.
- **ViewModel**: Menghubungkan antara data di Repository dan UI menggunakan LiveData.
- **UI (Fragments)**: 
  - **List Fragment**: Menampilkan daftar data menggunakan RecyclerView.
  - **Add/Edit Fragment**: Formulir untuk menambah atau mengedit data.
  - **Detail Fragment**: Menampilkan detail data item yang dipilih, termasuk tombol hapus.

---

## **Persyaratan**
- **Android Studio**: Versi 2024.4.4 atau lebih baru.
- **Min SDK**: 21 (Lollipop)
- **Retrofit**: Versi 2.9.0
- **Lifecycle Components**: Versi terbaru sesuai dependency Gradle.
