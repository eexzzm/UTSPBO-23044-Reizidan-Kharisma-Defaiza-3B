package user;
import java.util.Scanner;


public class Customer {
int pIntKamar, stokKamar = 20, arrPesananCounter = -1;
public String pNama, pTanggal, pKamar;
String tempStr;
int tempInt;
String[] arrPesanan = new String[100];
String[] arrKamar = new String[20];

Scanner scanner = new Scanner(System.in);

    void daftarNama(){
            System.out.println("Masukan nama anda.");
            System.out.print("Input = ");
            pNama = scanner.nextLine();
    }

    void buatPesanan (){
        
            do {
                System.out.println("Masukan jumlah kamar yang ingin anda pesan.");
                System.out.print("Input = ");
                pKamar = scanner.nextLine();
                pIntKamar = Integer.parseInt(pKamar);
                    if (pIntKamar > stokKamar){
                            System.out.println("Maaf, saat ini kami tidak memiliki cukup kamar yang tersedia untuk memenuhi pesanan Anda.");
                        }
            } while (pIntKamar > stokKamar);
            stokKamar -= pIntKamar;
            
            for (int i = 0; i < pIntKamar; i++){
            boolean status = false;
                do{
                    cekKamar();
                    System.out.print("Input = ");
                    tempInt = scanner.nextInt();
                    scanner.nextLine();
                    tempInt--;
                    
                    if (arrKamar[tempInt].equals("BOOKED")){
                        System.out.println("Maaf, nomor kamar yang Anda inginkan tidak tersedia saat ini.");
                        System.out.println("Kami sarankan Anda memilih kamar lain yang masih tersedia.\n");
                    } else {
                        for (int j = 0; j < arrKamar.length; j++) {
                            if (j == tempInt){
                                tempStr = Integer.toString(tempInt);
                                arrKamar[j] = "BOOKED"; 
                                status = true;
                            }
                        }
                    }
                } while (status == false);
            }
                
            System.out.println("Masukan tanggal check-in dan check out.");
            System.out.println("Format pengisian = (20 agustus 2024 - 22 agustus 2024)");
            System.out.print("Input = ");
            pTanggal = scanner.nextLine();
                
            ++arrPesananCounter;
            arrPesanan[arrPesananCounter] = "Nama\t= "+pNama+"\nJumlah Kamar\t="+pKamar+"\nTanggal\t= "+pTanggal+"\n";
        }
    
    void resetKamar(){
        for (int i = 0; i < arrKamar.length; i++) {
            tempInt = i;    
            tempStr = Integer.toString(++tempInt);  
            arrKamar[i] = tempStr;
            }
        }
    
    
    void cekKamar(){
        System.out.println("\tDaftar Nomo Kamar Hotel\n");
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5;j++){
                System.out.print(arrKamar[counter++]);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }
    
    void detilPesanan(){
            System.out.println("\tDETIL PESANAN\n");
        for (int i = 0; i <= arrPesananCounter; i++) {
            if (arrPesanan[i].contains(pNama)){
                System.out.print(arrPesanan[i]);
                System.out.println("");
            }
        }
    }
}