package lab2;

/**
 * Classe para mostrar funcionalidades extras do bônus, com alguns exemplos.
 * 
 * @author Amilton Cristian
 */
public class CoisaBonus {

    /**
     * Invoca os métodos para exibir os exemplos em ordem.
     * 
     * @param args não é utilizado.
     */
    public static void main(String[] args) {
        disciplinaEscolhaNumNotas();
        disciplinaComMediaPonderada();
        financas();
        descanso();
    }

    /**
     * Exemplo para invocar um construtor, onde é possível alterar o quantidade de notas a serem armazenadas.
     */
    private static void disciplinaEscolhaNumNotas() {
        Disciplina prog2 = new Disciplina("PROGRAMACAO 2", 6);
        prog2.cadastraNota(1, 5.0);
        prog2.cadastraNota(2, 6.0);
        prog2.cadastraNota(3, 7.0);
        prog2.cadastraNota(4, 10.0);
        prog2.cadastraNota(5, 8.0);
        prog2.cadastraNota(6, 4.5);
        System.out.println("\nExemplo média aritmetica:");
        System.out.println(prog2.toString());
    }

    /**
     * Exemplo para invocar um construtor, onde escolhe quantas notas terá e quais os pesos de cada nota.
     * O principal diferencial é a utilização da média ponderada.
     */
    private static void disciplinaComMediaPonderada() {
        int[] pesosParaNotas = {3, 4, 2, 1};
        Disciplina prog2 = new Disciplina("PROGRAMACAO 2", 4, pesosParaNotas);
        prog2.cadastraNota(1, 5.0);
        prog2.cadastraNota(2, 6.0);
        prog2.cadastraNota(3, 7.0);
        prog2.cadastraNota(4, 10.0);
        System.out.println("----\nExemplo média ponderada:");
        System.out.println(prog2.toString());
    }

    /**
     * Mostra um exemplo onde é possível descrever o motivo da despesa.
     * Todos os motivos são armazenados, porém só é exibida os cinco últimos motivos.
     */
    private static void financas() {
        int dinheiroGuardado = 10000;
        int historicoDeGanhos = 4;
        RegistroFinancas minhaFinanca = new RegistroFinancas(dinheiroGuardado, historicoDeGanhos);
        minhaFinanca.adicionaGanhos(12000, 1);
        minhaFinanca.adicionaGanhos(72100, 2);
        minhaFinanca.pagaDespesa(20000);
        minhaFinanca.pagaDespesa(1000, "Comprar um amburguer igual a do How I meet your mother");
        minhaFinanca.pagaDespesa(500, "Comprar pão");
        minhaFinanca.pagaDespesa(50000, "Ingresso Fórmula 1 Interlagos");
        System.out.println("\n\nExemplo finanças 1:");
        System.out.println(minhaFinanca.toString());
        System.out.println(" - Motivos das despezas:");
        System.out.println(minhaFinanca.listarDetalhes());

        RegistroFinancas minhaFinanca2 = new RegistroFinancas(dinheiroGuardado, historicoDeGanhos);
        minhaFinanca2.adicionaGanhos(12000, 1);
        minhaFinanca2.adicionaGanhos(72100, 2);
        minhaFinanca2.adicionaGanhos(7210, 3);
        minhaFinanca2.pagaDespesa(20000);
        minhaFinanca2.pagaDespesa(1000, "Comprar um amburguer igual a do How I meet your mother");
        minhaFinanca2.pagaDespesa(500, "Comprar pão");
        minhaFinanca2.pagaDespesa(50000, "Ingresso Fórmula 1 Interlagos");
        minhaFinanca2.pagaDespesa(750, "Comprar capinha de celular");
        minhaFinanca2.pagaDespesa(1500, "Pagar uma dança privada");
        minhaFinanca2.pagaDespesa(500, "Comprar uma cerveja");
        minhaFinanca2.pagaDespesa(2000, "Comprar uma pizza");
        System.out.println("----\nExemplo finanças 2:");
        System.out.println(minhaFinanca2.toString());
        System.out.println(" - Motivos das despezas:");
        System.out.println(minhaFinanca2.listarDetalhes());
    }

    /**
     * Se o usuário quiser, ele pode adicionar um emoticon para representar sua última sensação em geral.
     * O emotico pode ser trocado a qualquer momento se o usuario quiser.
     * Caso o estado do usuário mude, o emoticon é removido.
     */
    public static void descanso() {
        Descanso descanso = new Descanso();
        System.out.println("\n\nExemplo de descanso com emoji:");
        System.out.println(descanso.getStatusGeral());
 
        descanso.defineHorasDescanso(22);
        descanso.defineNumeroSemanas(1);
        descanso.definirEmoji("( ఠ ͟ʖ ఠ)");
        System.out.println(descanso.getStatusGeral());

        descanso.defineHorasDescanso(30);
        descanso.defineNumeroSemanas(1);
        descanso.definirEmoji("(づ｡◕‿‿◕｡)づ");
        System.out.println(descanso.getStatusGeral());

        descanso.defineHorasDescanso(27);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());
        
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(2);
        System.out.println(descanso.getStatusGeral());
 
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());
    }
}
