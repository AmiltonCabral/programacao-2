import java.util.Scanner;

public class PassMedia {
    /**
    * Laboratório de Programação 2 - Lab 1
    * 
    * Amilton Cristian Pereira Cabral - 120210322
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextFloat();
        double num2 = sc.nextFloat();
        double media = (num1 + num2) / 2;
        double mediaMin = 7.0;

        if (media >= mediaMin) {
            System.out.println("pass: True!");
        } else {
            System.out.println("pass: False!");
        }
    }
}
