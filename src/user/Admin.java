
package user;
import Data.Array;

public class Admin extends Customer {
    
    public Admin(Array arr) {
        super(arr);
    }
    
    @Override
    public void detilPesanan() {
        System.out.println("\tDetil Pesanan\n");
        for (int i = 0; i < array.arrPesanan.length; i++) {
            if (array.arrPesanan[i] != null) {
                System.out.println(array.arrPesanan[i]);
            }
        }
    }

    public void hapusPesanan() {
        System.out.println("\tHapus Reservasi");
        System.out.println("Masukan Nama Customer.");
        System.out.print("Input : ");
        pNama = scanner.nextLine();
        super.detilPesanan();

        boolean ketemu = false;

        if (status) {
            System.out.println("Apakah anda yakin ingin menghapus Reservasi atas nama " + pNama + "?");
            System.out.println("(y/n)");
            System.out.print("Input : ");
            tempStr = scanner.nextLine();
            
            if (tempStr.equalsIgnoreCase("y")) {
                for (int i = 0; i <= arrPesananCounter; i++) {

                    if (array.arrPesanan[i].contains("Nama\t\t= " + pNama)) {
                        ketemu = true;
                       
                        for (int j = i; j < arrPesananCounter; j++) {
                            array.arrPesanan[j] = array.arrPesanan[j + 1];
                        }
                        array.arrPesanan[arrPesananCounter] = "";
                        arrPesananCounter--;
                        i--;
                    }
                }

                // Jika pesanan ditemukan dan dihapus
                if (ketemu) {
                    // Menghapus label booking pada kamar
                    for (int i = 0; i < array.arrOwnerKamar.length; i++) {
                        if (array.arrOwnerKamar[i].equals(pNama)) {
                            tempStr = Integer.toString(i + 1);
                            array.arrKamar[i] = tempStr;
                            array.arrOwnerKamar[i] = ""; 
                        }
                    }
                    System.out.println("Reservasi atas nama " + pNama + " berhasil dihapus.");
                } else {
                    System.out.println("Pesanan atas nama " + pNama + " tidak ditemukan.");
                }
            } else {
                System.out.println("Penghapusan dibatalkan.");
            }
        } else {
            System.out.println("Tidak ada reservasi.");
        }
        status = false; // Reset status setelah selesai
    }
}
