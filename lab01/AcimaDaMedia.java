import java.util.Scanner;

public class AcimaDaMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        String[] lisValores = entrada.split(" ");
        int somaValores = 0;
        String saida = "";

        for (String num: lisValores){
            somaValores += Integer.parseInt(num);
        }

        int mediaValores = somaValores / lisValores.length;

        for (String num: lisValores){
            if (Integer.parseInt(num) > mediaValores){
                if (saida != ""){
                    saida += " ";
                }
                saida += num;
            }
        }

        System.out.print(saida);
    }
}