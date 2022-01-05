package lp2.lab01;

public class IdadePreferencialInteligente {
    public static void main(String[] args) {  // Definindo uma função
        
        int anoAtual = 2021;
        int anoNascimento = 2001;
        int idade = anoAtual - anoNascimento;
        boolean ehGestante = false;
        int numCriancasColo = 2;
        
        if (idade >= 60) {
            System.out.println("Voce tem " + idade + " anos. Voce pode usar o atendimento especial.");
        } else if (ehGestante) {
            System.out.println("Preferencial Genstante.");
        } else if (numCriancasColo > 0) {
            System.out.printf("Preferencial pois está com %d crianças de colo.%n", numCriancasColo);
        } else {
        System.out.println("Voce tem " + idade + " anos. Voce ainda nao pode usar o atendimento especial.");
        }
    }
}