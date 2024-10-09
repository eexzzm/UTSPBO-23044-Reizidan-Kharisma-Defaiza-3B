package user;
import java.util.Scanner;
import Data.Array;


public class Customer implements Fitur {
int pIntKamar, stokKamar = 20, arrPesananCounter = -1, tempInt, counter;
public String pNama, pTanggal, pKamar;
boolean status = false;
String tempStr, noKamar;

Array array;

    public Customer(Array arr) {
        this.array = arr;
    }

Scanner scanner = new Scanner(System.in);

    public void daftarNama(){
            System.out.println("\tReservasi");
            System.out.println("Masukan nama pemesan.");
            System.out.print("Input = ");
            pNama = scanner.nextLine();
    }

@Override
    public void buatPesanan() {
    // Menentukan jumlah kamar
    do {
        System.out.println("Masukan jumlah kamar yang ingin anda pesan.");
        System.out.print("Input = ");
        pKamar = scanner.nextLine();
        pIntKamar = Integer.parseInt(pKamar);
        if (pIntKamar > stokKamar) {
            System.out.println("Maaf, saat ini kami tidak memiliki cukup kamar yang tersedia untuk memenuhi pesanan Anda.");
        }
    } while (pIntKamar > stokKamar);
    
    stokKamar -= pIntKamar;
    noKamar = "";
    counter = 0;

    // Menentukan nomor kamar
    while (counter < pIntKamar) {  // Loop sampai jumlah kamar yang dipesan terpenuhi
        cekKamar();
        System.out.println("Masukan Nomor Kamar yang ingin anda pesan");
        System.out.print("Input = ");
        tempInt = scanner.nextInt();
        scanner.nextLine();
        tempInt--;  // Sesuaikan nomor kamar dengan indeks array (mulai dari 0)

        if (array.arrKamar[tempInt].equals("BOOKED")) {
            System.out.println("Maaf, nomor kamar yang Anda inginkan tidak tersedia saat ini.");
            System.out.println("Kami sarankan Anda memilih kamar lain yang masih tersedia.\n");
        } else {
            array.arrKamar[tempInt] = "BOOKED";
            array.arrOwnerKamar[tempInt] = pNama;
            tempInt++; 
            
            if (counter < pIntKamar - 1) {
                noKamar += tempInt + ", "; 
            } else {
                noKamar += tempInt;
            }
            counter++; 
        }
    }

    // Menentukan tanggal reservasi
    System.out.println("Masukan tanggal check-in dan check out.");
    System.out.println("Format pengisian = (20 agustus 2024 - 22 agustus 2024)");
    System.out.print("Input = ");
    pTanggal = scanner.nextLine();

    // Simpan detail pesanan
    ++arrPesananCounter;
    array.arrPesanan[arrPesananCounter] = "Nama\t\t\t= " + pNama + "\nJumlah Kamar\t\t= " + pKamar + "\nNomor Kamar\t\t= " + noKamar + "\nTanggal Reservasi\t= " + pTanggal + "\n";
    
}

    
    public void resetKamar(){
        for (int i = 0; i < array.arrKamar.length; i++) {
            tempInt = i;    
            tempStr = Integer.toString(++tempInt);  
            array.arrKamar[i] = tempStr;
            array.arrOwnerKamar[i] = "";
            array.arrPesanan[i] = "";
            }
        }
    
    
@Override
    public void cekKamar(){
        System.out.println("\tDaftar Nomor Kamar Hotel\n");
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5;j++){
                System.out.print(array.arrKamar[counter++]);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }
@Override
    public void detilPesanan(){
            System.out.println("\tDetil Reservasi\n");
        for (int i = 0; i <= arrPesananCounter; i++) {
            if (array.arrPesanan[i].contains(pNama)){
                System.out.print(array.arrPesanan[i]);
                System.out.println("");
                status = true;
                }
        }
        if (status == false){
            System.out.println("Maaf reservasi atas nama "+pNama+" tidak ditemukan");
        }
        status = false;
    }
}