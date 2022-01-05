import java.util.Scanner;

public class EstatisticasNotasAlunos {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String entrada = input.nextLine();
        int quantidadeAlunos = 0;
        int somaNotas = 0;
        int alunosIgualAcima = 0;
        int alunosAbaixo = 0;
        int maiorNota = 0;
        int menorNota = 1000;

        while (!entrada.equals("-")){
            quantidadeAlunos++;
            String listaAlunos[] = entrada.split(" ");
            int nota = Integer.parseInt(listaAlunos[1]);
            somaNotas += nota;

            if (nota > maiorNota){
                maiorNota = nota;
            }
            if (nota < menorNota){
                menorNota = nota;
            }
            if (nota >= 700){
                alunosIgualAcima++;
            } else {
                alunosAbaixo++;
            }

            entrada = input.nextLine();
        }
        
        int media = somaNotas / quantidadeAlunos;

        System.out.println("maior: " + maiorNota);
        System.out.println("menor: " + menorNota);
        System.out.println("media: " + media);
        System.out.println("acima: " + alunosIgualAcima);
        System.out.println("abaixo: " + alunosAbaixo);
    }
}
