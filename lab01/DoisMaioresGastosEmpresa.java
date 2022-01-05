import java.util.Scanner;

public class DoisMaioresGastosEmpresa {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String gastos[] = input.nextLine().split(" ");
        int maior1 = 0;
        int maior2 = 0;

        for (String gasto : gastos){
            if (Integer.parseInt(gasto) > maior1 && maior1 < maior2){
                maior1 = Integer.parseInt(gasto);
            } else if (Integer.parseInt(gasto) > maior2){
                maior2 = Integer.parseInt(gasto);
            }
        }

        System.out.println(maior1 + maior2);
    }    
}