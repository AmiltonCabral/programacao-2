import java.util.Scanner;

public class DesmascararWally {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String possivelNome = "";
        Boolean continua = true;
        
        while (true){
            /* Se alguém estiver lendo, eu tentei fazer sem while true, comparando string com o "==" e tava dando errado
            obviamente, então não detectei o erro a princípio, e fui modificando o código até chegar no while True,
            continuava dando errado, ai pesquisei e lembrei de usar o equals para comparar string, corrigido isso o código
            voltou a funcionar, e já tava no while true, então como funciona bem, não precisei mudar.*/

            String entrada = sc.nextLine();
            String lisNomes[] = entrada.split(" ");
            Boolean achouNome = false;

            for (String nome: lisNomes){
                if (nome.equals("wally")){
                    continua = false;
                    break;
                }
                if (nome.length() == 5){
                    possivelNome = nome;
                    achouNome = true;
                }
            }

            if (continua == false){break; }

            if (!achouNome){
                System.out.println("?");
            } else {
                System.out.println(possivelNome);
            }
        }
    }
}