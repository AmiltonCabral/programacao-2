import java.util.Scanner;

class Palavra {
    String nome;
    String primeiraLetra;
    String ultimaLetra;
}

public class PalavrasPoeticas {
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Palavra palavra1 = new Palavra();
        Palavra palavra2 = new Palavra();

        palavra1.nome = input.next();
        palavra2.nome = input.next();
        palavra1.primeiraLetra = palavra1.nome.substring(0, 1);
        palavra2.primeiraLetra = palavra2.nome.substring(0, 1);
        palavra1.ultimaLetra = palavra1.nome.substring(palavra1.nome.length() -1, palavra1.nome.length());
        palavra2.ultimaLetra = palavra2.nome.substring(palavra2.nome.length() -1, palavra2.nome.length());

        if(palavra1.primeiraLetra.equals(palavra2.primeiraLetra) && 
        palavra1.ultimaLetra.equals(palavra2.ultimaLetra)){
            System.out.println("S");
        } else {
            System.out.println("N");
        }
    }    
}
