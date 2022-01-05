import java.util.Scanner;

public class DobroTriplo {
    /**
    * Laboratório de Programação 2 - Lab 1
    * 
    * Amilton Cristian Pereira Cabral - 120210322
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int dobro = num * 2;
        int triplo = num * 3;

        System.out.printf("dobro: %d, triplo: %d%n", dobro, triplo);
    }
}
