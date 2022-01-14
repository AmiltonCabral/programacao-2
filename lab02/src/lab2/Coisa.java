package lab2;
 
public class Coisa {

    public static void main(String[] args) {
        descanso();
        System.out.println("-----");
        registroOnline();
        System.out.println("-----");
        disciplina();
        System.out.println("-----");
        financas();
    }
 
    public static void descanso() {
        Descanso descanso = new Descanso();
        System.out.println(descanso.getStatusGeral());
 
        descanso.defineHorasDescanso(30);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());
 
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(2);
        System.out.println(descanso.getStatusGeral());
 
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());
    }
 
    private static void registroOnline() {
        RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
        tempoLP2.adicionaTempoOnline(10);
        System.out.println(tempoLP2.atingiuMetaTempoOnline());
 
        tempoLP2.adicionaTempoOnline(10);
        tempoLP2.adicionaTempoOnline(10);
        System.out.println(tempoLP2.atingiuMetaTempoOnline());
 
        tempoLP2.adicionaTempoOnline(2);
        System.out.println(tempoLP2.atingiuMetaTempoOnline());
        System.out.println(tempoLP2.toString());
 
        RegistroTempoOnline tempoP2 = new RegistroTempoOnline("P2");
        System.out.println(tempoP2.toString());
    }
 
    private static void disciplina() {
        Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
        prog2.cadastraHoras(4);
        prog2.cadastraNota(1, 5.0);
        prog2.cadastraNota(2, 6.0);
        prog2.cadastraNota(3, 7.0);
        System.out.println(prog2.aprovado());
 
        prog2.cadastraNota(4, 10.0);
        System.out.println(prog2.aprovado());
        System.out.println(prog2.toString());
    }
 
    private static void financas() {
        int dinheiroGuardado = 10000;
        int historicoDeGanhos = 4;
        RegistroFinancas minhaFinanca = new RegistroFinancas(dinheiroGuardado, historicoDeGanhos);
 
        minhaFinanca.adicionaGanhos(12000, 1);
        minhaFinanca.adicionaGanhos(72100, 2);
        minhaFinanca.pagaDespesa(20000);
        System.out.println(minhaFinanca.exibeGanhos());
        System.out.println(minhaFinanca.toString());
 
        minhaFinanca.adicionaGanhos(7210, 2);
        minhaFinanca.pagaDespesa(5000);
        System.out.println(minhaFinanca.exibeGanhos());
        System.out.println(minhaFinanca.toString());
    }
 
}
