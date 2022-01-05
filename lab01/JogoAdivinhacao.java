import java.util.Scanner;

public class JogoAdivinhacao {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numCorreto = input.nextInt();
        int numTentativa = input.nextInt();

        while (numTentativa != numCorreto){
            if (numTentativa > numCorreto){
                System.out.println("MAIOR");
            } else {
                System.out.println("MENOR");
            }
            numTentativa = input.nextInt();
        }

        System.out.println("ACERTOU");
    }    
}
