import java.util.Scanner;

public class SorVeTe{
    
    public static int calcularSorvete(int posicaoInicial, int velocidade, int tempo){
        int posicaoFinal = posicaoInicial + velocidade * tempo;
        return posicaoFinal;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int posicaoInicialObj1, posicaoInicialObj2, posicaoFinal1, posicaoFinal2, velocidadeObj1, velocidadeObj2, tempoDecorrido, diferenca;
        
        posicaoInicialObj1 = input.nextInt();
        velocidadeObj1 = input.nextInt();
        posicaoInicialObj2 = input.nextInt();
        velocidadeObj2 = input.nextInt();
        tempoDecorrido = input.nextInt();

        posicaoFinal1 = calcularSorvete(posicaoInicialObj1, velocidadeObj1, tempoDecorrido);
        posicaoFinal2 = calcularSorvete(posicaoInicialObj2, velocidadeObj2, tempoDecorrido);

        if (posicaoFinal1 > posicaoFinal2){
            diferenca = posicaoFinal1 - posicaoFinal2;
        } else {
            diferenca = posicaoFinal2 - posicaoFinal1;
        }
        
        System.out.println(diferenca);
    }
}