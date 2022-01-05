import java.util.Scanner;

public class AcheNaTabela { 

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Quantas linhas terá a tabela:");
        int numLinhas = input.nextInt();
        input.nextLine();
        String[][] tabela = new String[numLinhas][];
        
        System.out.println("Digite a tabela:");
        for (int y=0; y<numLinhas; y++){
            tabela[y] = input.nextLine().split(" ");
        }

        System.out.println("Digite as coordenadas para buscar na tabela:");
        int linhaSaida = input.nextInt();
        int colunaSaida = input.nextInt();
        System.out.println("Resultado: " + tabela[linhaSaida][colunaSaida]);
    }
}