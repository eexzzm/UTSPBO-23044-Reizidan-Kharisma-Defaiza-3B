package user;
import java.util.Scanner;


public class Customer implements Fitur {
int pIntKamar, stokKamar = 20, arrPesananCounter = -1, tempInt;
public String pNama, pTanggal, pKamar;
String tempStr, noKamar;
String[] arrPesanan = new String[100];
String[] arrKamar = new String[20];

Scanner scanner = new Scanner(System.in);

    void daftarNama(){
            System.out.println("Masukan nama anda.");
            System.out.print("Input = ");
            pNama = scanner.nextLine();
    }

@Override
    public void buatPesanan (){
            //menentukan jumlah kamar
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
            
            //menentukan nomor kamar
            for (int i = 1; i <= pIntKamar; i++){
                boolean status = false; //tanda keberhasilan booking kamar
                do{
                    cekKamar();
                    System.out.print("Masukan Nomor Kamar yang ingin anda pesan = ");
                    System.out.print("Input = ");
                    tempInt = scanner.nextInt();
                    scanner.nextLine();
                    tempInt--;
                    
                    if (arrKamar[tempInt].equals("BOOKED")){
                        System.out.println("Maaf, nomor kamar yang Anda inginkan tidak tersedia saat ini.");
                        System.out.println("Kami sarankan Anda memilih kamar lain yang masih tersedia.\n");
                    } else {
                        if (i != pIntKamar){
                            arrKamar[tempInt] = "BOOKED";
                            tempInt++;
                            noKamar += Integer.toString(tempInt)+", ";
                        } else {
                            arrKamar[tempInt] = "BOOKED";
                            tempInt++;
                            noKamar += Integer.toString(tempInt);
                        }
                    }
                } while (status == false);
            }
             
            //menentukan tanggal reservasi
            System.out.println("Masukan tanggal check-in dan check out.");
            System.out.println("Format pengisian = (20 agustus 2024 - 22 agustus 2024)");
            System.out.print("Input = ");
            pTanggal = scanner.nextLine();
                
            ++arrPesananCounter;
            arrPesanan[arrPesananCounter] = "Nama\t\t= "+pNama+"\nJumlah Kamar\t="+pKamar+"Nomor Kamar\t= "+noKamar+"\nTanggal Reservasi\t\t= "+pTanggal+"\n";
        }
    
    void resetKamar(){
        for (int i = 0; i < arrKamar.length; i++) {
            tempInt = i;    
            tempStr = Integer.toString(++tempInt);  
            arrKamar[i] = tempStr;
            }
        }
    
    
@Override
    public void cekKamar(){
        System.out.println("\tDaftar Nomor Kamar Hotel\n");
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5;j++){
                System.out.print(arrKamar[counter++]);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }
@Override
    public void detilPesanan(){
            System.out.println("\tDetil Pesanan\n");
        for (int i = 0; i <= arrPesananCounter; i++) {
            if (arrPesanan[i].contains(pNama)){
                System.out.print(arrPesanan[i]);
                System.out.println("");
            }
        }
    }
}