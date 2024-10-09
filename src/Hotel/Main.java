package Hotel;
import java.util.Scanner;
import user.*;

public class Main {
    public int pilihan;
    boolean administrator = false;
    boolean customer = false;

    // Constructor yang menerima input pilihan
    Main(int input) {
        this.pilihan = input;

        if (pilihan == 1) {
            administrator = true;
        }
        else if (pilihan == 2){
            customer = true;
        }
    }
    
    private void menu(){
        System.out.println("\tMENU");
        System.out.println("1. Reservasi.");
        System.out.println("2. Periksa Ketersediaan Kamar Hotel.");
        System.out.println("3. Periksa Detil Reservasi.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Customer customer = new Customer();
        
        int pilihan = 0;
        
        customer.resetKamar();
        admin.resetKamar(); // mengisi value default array
        
        while (pilihan != 1 && pilihan != 2) {
            System.out.println("Masuk sebagai:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("0. Keluar");
            System.out.print("Input: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            // Jika input tidak valid (bukan 1 atau 2), beri pesan error
            if (pilihan != 1 && pilihan != 2) {
                System.out.println("Pilihan tidak valid. Silakan masukkan 1 untuk Admin atau 2 untuk Customer.");
            }
            
        Main main = new Main(pilihan);

        if (main.administrator) {
            while(pilihan != 0){
                
            main.menu();
            System.out.println("4. Hapus Reservasi");
            System.out.println("0. Kembali");
            System.out.print("Input: ");
            
            // Perbaiki dengan membaca input dan assign ke variabel pilihan
            pilihan = scanner.nextInt();

            // Validasi input, dengan logika OR (||)
            if (pilihan > 4 || pilihan < 0) {
                System.out.println("Input tidak valid, mohon pilih menu yang tersedia");
            } else {
                switch (pilihan) {
                    case 1:
                        admin.daftarNama();
                        admin.buatPesanan();
                        break;
                    case 2:
                        admin.cekKamar();
                        break;
                    case 3:
                        admin.detilPesanan();
                        break;
                    case 4:
                        admin.hapusPesanan();
                        break;
                    case 0:
                        System.out.println("Kembali ke menu utama");
                        break;
                }
            }
        }
            
            
        } else if (main.customer == true) {
            
            while(pilihan != 0){
            
            System.out.println("Anda masuk sebagai Customer");
            main.menu();
            System.out.println("0. Kembali");
            System.out.print("Input: ");
            
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            if (pilihan > 3 || pilihan < 0) {
                System.out.println("Pilihan tidak valid.");
            } else {
                switch (pilihan) {
                    case 1:
                        customer.daftarNama();
                        customer.buatPesanan();
                        break;
                    case 2:
                        customer.cekKamar();
                        break;
                    case 3:
                        customer.daftarNama();
                        customer.detilPesanan();
                        break;
                    case 0:
                        System.out.println("Kembali ke menu utama");
                        break;
                }
            }
            
            }
        }
    }

    }
}
