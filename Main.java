package Dompet;
import java.util.Scanner;

public class Main {
    private static User[] user = new User[100];
    private static Scanner masuk = new Scanner(System.in);
    private static int jumppengguna = 0;
    static int cek;

    public static void main(String[] args) {
        int pil;
        do {
            System.out.println("=============DOMPET DIGITAL==================");
            System.out.println("1.LOGIN");
            System.out.println("2.REGISTER");
            System.out.println("pilihan : ");
            pil = masuk.nextInt();

            switch (pil){
                case 1:
                    login();
                    break;
                case 2:
                    regis();
                    break;
            }
        }while (pil !=0);
    }

    static void regis(){
        System.out.println("masukan nama : ");
        String nama = masuk.next();
        System.out.println("masukan no telp : ");
        String notelp = masuk.next();
        System.out.println("masukan alamat : ");
        String alamat = masuk.next();
        System.out.println("masukan no ktp : ");
        String noktp = masuk.next();
        System.out.println("masukan Email : ");
        String email = masuk.next();
        System.out.println("masukan Password : ");
        String pass = masuk.next();
        user[jumppengguna] = new User(email,pass,nama,notelp,alamat,noktp);
        jumppengguna = jumppengguna+1;
    }

    static void view(){
        if (jumppengguna == 0){
            System.out.println("Belum ada peserta terdaftar");
        }else {
            for (int i = 0; i < jumppengguna; i++){
                System.out.println("==================================================");
                System.out.println(" Nama : " + user[i].getNama() + "\n Alamat : " +
                        user[i].getAlamat() + "\n No.ktp : " + user[i].getNoktp()
                        + "\n No.Telp : " + user[i].getNotelp());
                System.out.println("==================================================");
            }
        }
    }

    static void login(){
        System.out.println("Email : ");
        String email = masuk.next();
        System.out.println("Password : ");
        String pass = masuk.next();
        cek = ceklog(email,pass);
        System.out.println("Selamat datang " + user[cek].getNama());
        int pillog;

        do {
            System.out.println("1. lihat saldo");
            System.out.println("2. transfer");
            System.out.println("3. isi saldo");
            System.out.println("4. lihat data diri");
            System.out.println("0. logout");
            System.out.println("pilih : ");
            pillog = masuk.nextInt();

            switch (pillog){
                case 1:
                    saldo();
                    break;
                case 2:
                    trans();
                    break;
                case 3:
                    topup();
                    break;
                case 4:
                    view();
                    break;
            }
        }while (pillog !=0);
    }

    static int ceklog(String email, String pass){
        int loop = 0;
        for (int i = 0; i <= jumppengguna; i++){
            if (user[i].getEmail().equals(email) && user[i].getPass().equals(pass)){
                break;
            }else {
                loop++;
            }
        }
        return loop;
    }

    static void saldo(){

    }

    static void trans(){

    }

    static void topup(){

    }
}
