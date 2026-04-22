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
3.  Pengecekan !isFull() pada method push berfungsi sebagai validasi kapasitas. Karena menggunakan array yang ukurannya statis (sudah ditentukan di awal), kita harus memastikan masih ada ruang kosong sebelum menambah data baru. Kondisi if-else tersebut adalah bentuk pencegahan dini (error handling) agar program tetap berjalan stabil dan bisa memberikan informasi yang jelas kepada pengguna saat penyimpanan sudah penuh.
4.  Code pada class StackTugasMahasiswa3 :
    ```java
        package Jobsheet9;
        public class StackTugasMahasiswa3 {
            Mahasiswa3[] stack;
            int top;
            int size;  
            
            public StackTugasMahasiswa3(int size) {
                this.size = size;
                stack = new Mahasiswa3[size];
                top = -1;
            }

            public boolean isFull() {
                if (top == size - 1) {
                    return true;
                } else {
                    return false;
                }
            }

            public boolean isEmpty(){
                if (top == -1) {
                    return true;        
                } else {
                    return false;
                }
            }

            public void push(Mahasiswa3 mhs) {
                if (!isFull()) {
                    top++;
                    stack[top] = mhs;
                } else {
                    System.out.println("Stack penuh! Tidak bisa menambahkan tugas lagi.");
                }
            }

            public Mahasiswa3 pop(){
                if (!isEmpty()) {
                    Mahasiswa3 m = stack[top];
                    top--;    
                    return m;
                } else {
                    System.out.println("Stack kosong! Tidak ada tugas untuk dinilai.");
                    return null;
                }
            }

            public Mahasiswa3 peek() {
                if (!isEmpty()) {
                    return stack[top];
                } else {
                    System.out.println("Stack kosong! Tidak ada tugas yang dikumpulkan");
                    return null;
                }
            }

            public void print() {
                for (int i = top; i >= 0; i--) {
                    System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
                }
                System.out.println("");
            }

            public Mahasiswa3 peekBottom() {
                if (!isEmpty()) {
                    return stack[0];
                } else {
                    System.out.println("Stack kosong! Belum ada tugas yang dikumpulkan.");
                    return null;
                }
            }
            
        }
    ```

    Code pada class MahasiswaDemo3 :
    ```java 
        package Jobsheet9;
        import java.util.Scanner;

        public class MahasiswaDemo3 {
            public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);

                int pilih;

                StackTugasMahasiswa3 stack = new StackTugasMahasiswa3(5);

                do {
                    System.out.println("\nMenu:");
                    System.out.println("1. Mengumpulkan Tugas");
                    System.out.println("2. Menilai Tugas");
                    System.out.println("3. Melihat Tugas Teratas");
                    System.out.println("4. Melihat Daftar Tugas");
                    System.out.println("5. Melihat Tugas Terbawah (Pertama)");
                    System.out.print("Pilih: ");
                    pilih = scan.nextInt();
                    scan.nextLine();
                    switch (pilih) {
                        case 1:
                            System.out.print("Nama: ");
                            String nama = scan.nextLine();
                            System.out.print("NIM: ");
                            String nim = scan.nextLine();
                            System.out.print("Kelas: ");
                            String kelas = scan.nextLine();
                            Mahasiswa3 mhs = new Mahasiswa3(nama, nim, kelas);
                            stack.push(mhs);
                            System.out.printf("Tugas %s berhasil dikumpulkan\n", mhs.nama);
                            break;
                        case 2:
                            Mahasiswa3 dinilai = stack.pop();
                            if (dinilai != null) {
                                System.out.println("Menilai tugas dari " + dinilai.nama);
                                System.out.print("Masukkan nilai (0-100): ");
                                int nilai = scan.nextInt();
                                dinilai.tugasDinilai(nilai);
                                System.out.printf("Nilai Tugas %s adalah %d\n", dinilai.nama, nilai);
                            }
                                break;
                        case 3:
                            Mahasiswa3 lihat = stack.peek();
                            if (lihat != null) {
                                System.out.println("Tugas terakhir dikumpulkan oleh " + lihat.nama);  
                            }
                            break;
                        case 4:
                            System.out.println("Daftar semua tugas");
                            System.out.println("Nama\tNIM\tKelas");
                            stack.print();
                            break;
                        case 5:
                            Mahasiswa3 bawah = stack.peekBottom();
                            if (bawah != null) {
                                System.out.println("Tugas pertama dikumpulkan oleh: " + bawah.nama);
                                System.out.println("NIM: " + bawah.nim + " | kelas: " + bawah.kelas);
                            }
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                    }  
                } while (pilih >= 1 && pilih <= 5);
            }
        }
    ```
5.  Code pada class StackTugasMahasiswa3 :
    ```java
        package Jobsheet9;
        public class StackTugasMahasiswa3 {
            Mahasiswa3[] stack;
            int top;
            int size;  
            
            public StackTugasMahasiswa3(int size) {
                this.size = size;
                stack = new Mahasiswa3[size];
                top = -1;
            }

            public boolean isFull() {
                if (top == size - 1) {
                    return true;
                } else {
                    return false;
                }
            }

            public boolean isEmpty(){
                if (top == -1) {
                    return true;        
                } else {
                    return false;
                }
            }

            public void push(Mahasiswa3 mhs) {
                if (!isFull()) {
                    top++;
                    stack[top] = mhs;
                } else {
                    System.out.println("Stack penuh! Tidak bisa menambahkan tugas lagi.");
                }
            }

            public Mahasiswa3 pop(){
                if (!isEmpty()) {
                    Mahasiswa3 m = stack[top];
                    top--;    
                    return m;
                } else {
                    System.out.println("Stack kosong! Tidak ada tugas untuk dinilai.");
                    return null;
                }
            }

            public Mahasiswa3 peek() {
                if (!isEmpty()) {
                    return stack[top];
                } else {
                    System.out.println("Stack kosong! Tidak ada tugas yang dikumpulkan");
                    return null;
                }
            }

            public void print() {
                for (int i = top; i >= 0; i--) {
                    System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
                }
                System.out.println("");
            }

            public Mahasiswa3 peekBottom() {
                if (!isEmpty()) {
                    return stack[0];
                } else {
                    System.out.println("Stack kosong! Belum ada tugas yang dikumpulkan.");
                    return null;
                }
            }

            public int getJumlahTugas() {
                return top + 1;
            }
            
        }
    ```

    Code pada class MahasiswaDemo3 : 
    ```java
            case 6:
                        int jumlah = stack.getJumlahTugas();
                        System.out.println("Jumlah tugas yang ada di tumpukan saat ini: " + jumlah);
                        break;
                    default:
                        if (pilih < 1 || pilih > 6) {
                            System.out.println("Pilihan tidak valid.");
                        }
                }  
            } while (pilih >= 1 && pilih <= 6);
            }
        }
    ```
6.  Commit dan push kode program ke Github