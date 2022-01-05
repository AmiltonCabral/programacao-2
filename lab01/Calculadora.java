import java.util.Scanner;

public class Calculadora {
    /**
    * Laboratório de Programação 2 - Lab 1
    * 
    * Amilton Cristian Pereira Cabral - 120210322
    */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String acao = sc.next();

        double num1 = 0;
        double num2 = 0;
        double resultado = 0;
        boolean erro = false;

        if (acao.equals("+") || acao.equals("-") || acao.equals("*") || acao.equals("/")) {
            num1 = sc.nextDouble();
            num2 = sc.nextDouble();
        } else {
            System.out.println("ENTRADA INVALIDA");
            erro = true;
        }

        if (acao.equals("+")){
            resultado = num1 + num2;
        } else if (acao.equals("-")){
            resultado = num1 - num2;
        } else if (acao.equals("*")){
            resultado = num1 * num2;
        } else if (acao.equals("/")){
            if (num2 == 0){
                System.out.println("ERRO");
                erro = true;
            } else {
                resultado = num1 / num2;
            }
        }

        if (!erro) {
        System.out.println("RESULTADO: " + resultado);
        }
    }
}