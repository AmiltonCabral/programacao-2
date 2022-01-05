import java.util.Scanner;

public class MaiorMenor {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        for(int cont=0; cont<5; cont++){
            int entrada = input.nextInt();
            if(entrada > maior){
                maior = entrada;
            }
            if(entrada < menor){
                menor = entrada;
            }
        }

        System.out.println(maior - menor);
    }    
}
