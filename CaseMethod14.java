import java.util.Scanner;

public class CaseMethod14 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int maxData = maxData();
        int indeks = 0;

        String[][] dataMahasiswa = new String[maxData][2];
        String[] jenisPrestasi = new String[maxData];
        String[] tingkatPrestasi = new String[maxData];
        int[] tahunPrestasi = new int[maxData];
        
        boolean pemilihanMenu = true;

        while (pemilihanMenu) {
            System.out.println("\n=== MENU SIAKAD PRESTASI MAHASISWA ===");
            System.out.println("1. Tambah Data dan Prestasi Mahasiswa");
            System.out.println("2. Tampilkan Data dan Prestasi Mahasiswa");
            System.out.println("3. Analisis data prestasi");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine();
            
            if (pilihan == 1) {
                if (indeks < maxData) {
                    
                    // --- PEMANGGILAN FUNGSI INPUT ---
                    tambahDataMahasiswa(dataMahasiswa, indeks, sc);
                    jenisPrestasi[indeks] = inputJenisPrestasi();
                    tingkatPrestasi[indeks] = inputTingkatPrestasi();
                    tahunPrestasi[indeks] = inputTahun();
                    // increment indeks
                    indeks++;
                    
                    System.out.println("Data berhasil disimpan.");
                } else {
                    System.out.println("Penyimpanan Penuh!");
                }
            } else if (pilihan == 2) {
                System.out.println("\n===== DAFTAR SEMUA PRESTASI =====");

                if (indeks == 0) {
                    System.out.println("Belum ada data prestasi.");
                } else {
                    for (int i = 0; i < indeks; i++) { 
                        System.out.println("-------------------------------");                  
                        System.out.println(" | Nama   : " + dataMahasiswa[i][0]);
                        System.out.println(" | NIM    : " + dataMahasiswa[i][1]);
                        System.out.println(" | Jenis  : " + jenisPrestasi[i]);
                        System.out.println(" | Tingkat: " + tingkatPrestasi[i]);
                        System.out.println(" | Tahun  : " + tahunPrestasi[i]);
                    }
                }
            } else if (pilihan == 3) {
                System.out.print("Masukkan jenis prestasi yang dicari: ");
                String cariJenis = sc.nextLine();
                boolean ditemukan = false;

                System.out.println("\n===== HASIL ANALISIS =====");

                for (int i = 0; i < indeks; i++) {
                    if (jenisPrestasi[i].equalsIgnoreCase(cariJenis)) {
                        ditemukan = true;
                        System.out.println("-------------------------------");
                        System.out.println("Nama   : " + dataMahasiswa[i][0]);
                        System.out.println("NIM    : " + dataMahasiswa[i][1]);
                        System.out.println("Tingkat: " + tingkatPrestasi[i]);
                        System.out.println("Tahun  : " + tahunPrestasi[i]);
                    }
                }         if (!ditemukan) {
                       System.out.println("Tidak ada prestasi dengan jenis tersebut!");
                }
                
            } else if (pilihan == 4) {
                System.out.println("Program selesai. Terima kasih!");
                pemilihanMenu = false;
            }
        }
    }
    
    // Penggunaan Fungsi
    public static void tambahDataMahasiswa(String[][] arrayMhs, int index, Scanner sc) {
        System.out.print("Masukkan Nama Mahasiswa: ");
        arrayMhs[index][0] = sc.nextLine(); 

        System.out.print("Masukkan NIM Mahasiswa: ");
        arrayMhs[index][1] = sc.nextLine(); 
    }

    public static String inputJenisPrestasi() {
        System.out.print("Masukkan Jenis Prestasi: ");
        String jenisPrestasi = sc.nextLine();
        return jenisPrestasi;
    }

    public static String inputTingkatPrestasi() {
        while (true) {
            System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
            String tingkat = sc.nextLine();
            if (tingkat.equalsIgnoreCase("Lokal") ||
                tingkat.equalsIgnoreCase("Nasional") ||
                tingkat.equalsIgnoreCase("Internasional")) {
                return tingkat;
            } else {
                System.out.println("Tingkat tidak valid! Masukkan Lokal, Nasional, atau Internasional.");
            }
        }
    }
    
    public static int maxData() {
        System.out.print("Masukkan jumlah prestasi yang akan di input: ");
        int maxData = sc.nextInt();
        return maxData;
    }

    public static int inputTahun() {
        while (true) {
            System.out.print("Masukkan Tahun Prestasi (2010-2025): ");
            int thn = sc.nextInt();
            if (thn < 2010 || thn > 2025) {
                System.out.println ("Tahun tidak valid! Masukkan antara 2010-2025.");
            } else {
                return thn;
            }
        }
    }
}
