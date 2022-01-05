import java.util.Scanner;

public class ConsultandoGastosMensais {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String meses[] = input.nextLine().split(" ");
        String gastos[] = input.nextLine().split(" ");
        String mesBusca = input.next();
        int i = 0;

        for (String mesConsulta : meses){
            if (mesConsulta.equals(mesBusca)){
                break;
            }
            i++;
        }

        System.out.println(gastos[i]);
    }    
}
