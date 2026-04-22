# JOBSHEET 9

# PRAKTIKUM 

## - Praktikum 1 : Mahasiswa Mengumpulkan Tugas

## - Praktikum 1 : Verifikasi Hasil Percobaan

![Verifikasi1](./Verifikasi1.png)

![Verifikasi2](./Verifikasi2.png)

_Pertanyaan:_

1.  Lakukan perbaikan pada kode program, sehingga keluaran yang dihasilkan sama dengan verifikasi hasil percobaan! Bagian mana yang perlu diperbaiki?
2.  Berapa banyak data tugas mahasiswa yang dapat ditampung di dalam Stack? Tunjukkan potongan kode programnya!
3.  Mengapa perlu pengecekan kondisi !isFull() pada method push? Kalau kondisi if-else tersebut dihapus, apa dampaknya? 
4.  Modifikasi kode program pada class MahasiswaDemo3 dan Stack TugasMahasiswa3 sehingga pengguna juga dapat melihat mahasiswa yang pertama kali mengumpulkan tugas melalui operasi lihat tugas terbawah!
5.  Tambahkan method untuk dapat menghitung berapa banyak tugas yang sudah dikumpulkan saat ini, serta tambahkan operasi menunya!
6.  Commit dan push kode program ke Github

_Jawaban:_

1.  Agar keluaran sesuai dengan gambar verifikasi, perulangan pada method print() yang ada pada class StackTugasMahasiswa3 harus diubah dari for (int i = 0; i <=top; i++) menjadi for (int i = top; i>= 0; i--)
2.  - Program ini memiliki kapasitas penyimpanan statis sebanyak 5 data tugas. Angka ini ditentukan secara manual (hardcoded) saat objek stack dibuat di kelas main. Jika data ke-6 dimasukkan tanpa ada tugas yang dinilai(dihapus) terlebih dahulu, maka akan terjadi kondisi Stack Full.
    - Implementasi Kode : 
      Kapasitas tersebut diatur melalui dua bagian penting : 
        - Inisialisasi : new StackTugasMahasiswa3(5) : pada kelas MahasiswaDemo3.
        - Alokasi memori : stack = new Mahasiswa3[size]; pada konstruktor kelas StackTugasMahasiswa3.