import java.util.Scanner;

public class MaiorMenorDuasPalavras {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String palavra1 = input.next();
        String palavra2 = input.next();

        if (palavra1.length() <= palavra2.length()){
            System.out.println(palavra1);
        } else {
            System.out.println(palavra2);
        }

        if (palavra1.length() >= palavra2.length()){
            System.out.println(palavra1);
        } else {
            System.out.println(palavra2);
        }
    }
}
