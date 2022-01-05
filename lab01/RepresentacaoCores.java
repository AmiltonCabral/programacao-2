import java.util.Scanner;

public class RepresentacaoCores {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String newColor = "BRANCO";

        for (int i=0; i<3; i++){
            int corUnit = input.nextInt();
            if (corUnit < 128){
                newColor = "PRETO";
            }
        }
        System.out.println(newColor);
    }
}