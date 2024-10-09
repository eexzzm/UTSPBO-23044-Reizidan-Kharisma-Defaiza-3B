/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author SNSV
 */
public class Admin extends Customer {

    @Override
    public void detilPesanan() {
        System.out.println("\tDetil Pesanan\n");
        for (int i = 0; i <= arrPesananCounter; i++) {
            System.out.print(arrPesanan[i]);
            System.out.println("");
        }
    }

    public void hapusPesanan() {
        System.out.println("\tHapus Reservasi");
        System.out.println("Masukan Nama Customer.");
        System.out.print("Input : ");
        pNama = scanner.nextLine();
        super.detilPesanan();

        // Gunakan variabel lokal untuk melacak apakah pesanan ditemukan
        boolean found = false;

        if (status) {
            System.out.println("Apakah anda yakin ingin menghapus Reservasi atas nama " + pNama + "?");
            System.out.println("(y/n)");
            System.out.print("Input : ");
            tempStr = scanner.nextLine();

            // Perbandingan String menggunakan .equalsIgnoreCase()
            if (tempStr.equalsIgnoreCase("y")) {
                for (int i = 0; i <= arrPesananCounter; i++) {
                    // Ubah perbandingan dengan .equals untuk kecocokan tepat
                    if (arrPesanan[i].contains("Nama\t\t= " + pNama)) {
                        found = true;
                        // Hapus pesanan dengan menggeser elemen-elemen di belakangnya
                        for (int j = i; j < arrPesananCounter; j++) {
                            arrPesanan[j] = arrPesanan[j + 1]; // Geser elemen
                        }
                        arrPesanan[arrPesananCounter] = ""; // Kosongkan elemen terakhir
                        arrPesananCounter--; // Kurangi counter
                        i--; // Ulangi loop dari elemen yang dihapus
                    }
                }

                // Jika pesanan ditemukan dan dihapus
                if (found) {
                    // Menghapus label booking pada kamar
                    for (int i = 0; i < arrOwnerKamar.length; i++) {
                        if (arrOwnerKamar[i].equals(pNama)) {
                            tempStr = Integer.toString(i + 1);
                            arrKamar[i] = tempStr; // Set kamar kembali ke nomor aslinya
                            arrOwnerKamar[i] = ""; // Kosongkan pemilik kamar
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
            System.out.println("Tidak ada reservasi yang aktif.");
        }
        status = false; // Reset status setelah selesai
    }
}
