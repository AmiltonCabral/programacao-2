import java.util.Scanner;

public class EstritamenteCresDecr {
    /**
    * Laboratório de Programação 2 - Lab 1
    * 
    * Amilton Cristian Pereira Cabral - 120210322
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, num3, num4;
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();
        num4 = sc.nextInt();

        if (num1 < num2 && num2 < num3 && num3 < num4) {
            System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
        } else if (num1 > num2 && num2 > num3 && num3 > num4) {
            System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
        } else {
            System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
        }
    }
}
