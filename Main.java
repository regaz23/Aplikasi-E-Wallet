package Dompet;

import Authentication.*;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("Dompet Digital");
            System.out.println("1.Registrasi");
            System.out.println("2.Login");
            pilih = scan.nextInt();
            switch (pilih){
                case 1:
                    authentication.regis();
                    break;
                case 2:
                    authentication.login();
                    break;
                default:
            }
        }while ()
    }


}
