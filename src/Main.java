import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username;
        String alphabetOnlyPattern = "[a-zA-Z]"; // pattern untuk hanya alfabet
        String alphanumericPattern = "^[a-zA-Z0-9]*$"; // pattern untuk alfanumerik

        System.out.println("Selamat datang di Program Pengecekan Validitas Nama Pengguna!");

        while (true) {
            System.out.print("Masukkan nama pengguna (username): ");
            username = scanner.nextLine();

            if (Pattern.matches(alphabetOnlyPattern, username.substring(0, 1))) { // validasi apakah karakter awal username merupakan alfabet
                if (username.length() >= 5 && username.length() <= 12) { // validasi apakah username terdiri dari 5 hingga 12 karakter
                    if (!username.contains(" ")) { // validasi apakah username mengandung spasi
                        if (Pattern.matches(alphanumericPattern, username))
                            break; // validasi apakah username hanya mengandung alfanumerik
                        else
                            System.out.println("Username hanya boleh terdiri dari huruf dan angka."); // pesan error jika username mengadung selain alfanumerik
                    } else {
                        System.out.println("Username tidak boleh mengandung spasi."); // pesan error jika username mengandung spasi
                    }
                } else {
                    System.out.println("Username harus terdiri dari 5 hingga 12 karakter."); // pesan error jika panjang username < 5 karakter dan > 12 karakter
                }
            } else {
                System.out.println("Username harus dimulai dengan huruf."); // pesan error jika username diawali dengan angka
            }
        }

        System.out.println("Username anda valid, selamat datang, " + username + "!"); // tampilkan username jika semua kondisi terpenuhi
        scanner.close(); // tutup objek scanner
    }
}