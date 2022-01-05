import java.util.Scanner;

public class MaiorPalavra {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true){
            String[] frase = input.nextLine().split(" ");
            int numMaiorPalavra = Integer.MIN_VALUE;
            int indiceMaiorPalavra = 0;
            
            if (frase.length < 2){break;}

            for (int i=0; i<frase.length; i++){
                if (frase[i].length() > numMaiorPalavra){
                    numMaiorPalavra = frase[i].length();
                    indiceMaiorPalavra = i;
                }
            }

            System.out.println(frase[indiceMaiorPalavra]);
        }
    }
}
