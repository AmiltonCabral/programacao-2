package lab2;

import java.util.Scanner;

/**
 * Implementação de comandos no terminal para utilizar o sistema com mais praticidade.
 * O programa só para se o usuário digitar "sair".
 * É possível digitar "help" para listar os comandos possíveis e alguns exemplos de como usar.
 * 
 * @author Amilton Cristian
 */
public class CoisaCLI {
    static Descanso descansoObj = new Descanso();
    static RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
    static Disciplina prog2 = new Disciplina("PROGRAMACAO-2");
    static RegistroFinancas minhaFinanca = new RegistroFinancas(10000, 4);

    /**
     * Um loop, que finaliza após o usuário digitar "sair".
     * É possível digitar comandos, e de acordo com cada comando, o processo é encaminhado para um metódo mais específico.
     * 
     * @param args sem uso.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite 'help' para listar os comandos e 'sair' para sair.");
        String[] entradaDoComando = new String[4];
        while (true) {
            entradaDoComando[0] = input.next();
            entradaDoComando[1] = "-1";
            entradaDoComando[2] = "-1";
            entradaDoComando[3] = "-1";

            if (entradaDoComando[0].equalsIgnoreCase("help")) {
                menu();

            } else if (entradaDoComando[0].equalsIgnoreCase("rotina")) {
                entradaDoComando[1] = input.next();
                if (entradaDoComando[1].equalsIgnoreCase("descanso") | entradaDoComando[1].equalsIgnoreCase("semanas")) {
                    entradaDoComando[2] = input.next();
                }
                rotinaDescanso(entradaDoComando[1], Integer.parseInt(entradaDoComando[2]));

            } else if (entradaDoComando[0].equalsIgnoreCase("tempoonline")) {
                entradaDoComando[1] = input.next();
                if (entradaDoComando[1].equalsIgnoreCase("adicionar")) {
                    entradaDoComando[2] = input.next();
                }
                registroOnline(entradaDoComando[1], Integer.parseInt(entradaDoComando[2]));

            } else if (entradaDoComando[0].equalsIgnoreCase("disciplina")) {
                entradaDoComando[1] = input.next();
                if (entradaDoComando[1].equalsIgnoreCase("adicionarhoras")) {
                    entradaDoComando[2] = input.next();
                } else if (entradaDoComando[1].equalsIgnoreCase("adicionarnota")) {
                    entradaDoComando[2] = input.next();
                    entradaDoComando[3] = input.next();
                }
                disciplina(entradaDoComando[1], Integer.parseInt(entradaDoComando[2]), Double.valueOf(entradaDoComando[3]).doubleValue());
    
            } else if (entradaDoComando[0].equalsIgnoreCase("financas")) {
                entradaDoComando[1] = input.next();
                if (entradaDoComando[1].equalsIgnoreCase("pagar")) {
                    entradaDoComando[2] = input.next();
                } else if (entradaDoComando[1].equalsIgnoreCase("adicionar")) {
                    entradaDoComando[2] = input.next();
                    entradaDoComando[3] = input.next();
                }
                financas(entradaDoComando[1], Integer.parseInt(entradaDoComando[2]), Integer.parseInt(entradaDoComando[3]));

            } else if (entradaDoComando[0].equalsIgnoreCase("sair")) {
                break;

            } else {
                System.out.println("Comando inválido, digite 'help' para ver a lista de comandos.");
            }

            input.nextLine();
        }
        input.close();

    }
    
    /**
     * Recebe comandos específicos para a rotina de descanso.
     * 
     * @param comando o comando específico.
     * @param valor valores necessários para alterar alguns valores no sistema, de acordo com o comando.
     */
    private static void rotinaDescanso(String comando, int valor) {
        if (comando.equalsIgnoreCase("descanso")) {
            descansoObj.defineHorasDescanso(valor);
        } else if (comando.equalsIgnoreCase("semanas")) {
            descansoObj.defineNumeroSemanas(valor);
        } else if (comando.equalsIgnoreCase("status")) {
            System.out.println(descansoObj.getStatusGeral());
        } else {
            System.out.println("Comando inválido, digite 'help' para ver a lista de comandos.");
        }
    }

    /**
     * Recebe comandos específicos para o registro online.
     * 
     * @param comando o comando específico.
     * @param horasOnline dependendo do comando, pode ser utilizado para adicionar horas online no sistema.
     */
    private static void registroOnline(String comando, int horasOnline) {
        if (comando.equalsIgnoreCase("adicionar")) {
            tempoLP2.adicionaTempoOnline(horasOnline);
        } else if (comando.equalsIgnoreCase("verificar")) {
            System.out.println(tempoLP2.atingiuMetaTempoOnline());
        } else if (comando.equalsIgnoreCase("status")) {
            System.out.println(tempoLP2.toString());
        } else {
            System.out.println("Comando inválido, digite 'help' para ver a lista de comandos.");
        }
    }

    /**
     * Recebe comandos específicos para o registro online.
     * 
     * @param comando o comando específico.
     * @param valor dependendo do comando, pode alterar a hora ou a nota.
     * @param notaDisciplina dependendo do comando, pode ser utilizado como a nota da disciplina.
     */
    private static void disciplina(String comando, int valor, double notaDisciplina) {
        if (comando.equalsIgnoreCase("adicionarhoras")) {
            prog2.cadastraHoras(valor);
        } else if (comando.equalsIgnoreCase("adicionarnota")) {
            prog2.cadastraNota(valor, notaDisciplina);
        } else if (comando.equalsIgnoreCase("verificar")) {
            System.out.println(prog2.aprovado());
        } else if (comando.equalsIgnoreCase("status")) {
            System.out.println(prog2.toString());
        } else {
            System.out.println("Comando inválido, digite 'help' para ver a lista de comandos.");
        }
    }

    /**
     * Recebe comandos específicos para gerenciar as finanças.
     * 
     * @param comando o comando específico.
     * @param valor dependendo do comando, pode ser utilizado como ganhos ou despesas pagas.
     * @param identificacao dependendo do comando, pode ser utilizado para identificar a posição do valor ganho.
     */
    private static void financas(String comando, int valor, int identificacao) {
        if (comando.equalsIgnoreCase("adicionar")) {
            minhaFinanca.adicionaGanhos(valor, identificacao);
        } else if (comando.equalsIgnoreCase("pagar")) {
            minhaFinanca.pagaDespesa(valor);
        } else if (comando.equalsIgnoreCase("ganhos")) {
            System.out.println(minhaFinanca.exibeGanhos());
        } else if (comando.equalsIgnoreCase("status")) {
            System.out.println(minhaFinanca.toString());
        } else {
            System.out.println("Comando inválido, digite 'help' para ver a lista de comandos.");
        }
    }

    /**
     * Exibe o menu, com uma lista contendo todos os comandos possíveis.
     * Exibe também, exemplos de como utilizar os comandos.
     */
    private static void menu() {
        System.out.println("\nLista de comandos:");
        System.out.println("- rotina");
            System.out.println("  - descanso 'int'");
            System.out.println("  - semanas 'int'");
            System.out.println("  - status");
        System.out.println("- tempoonline");
            System.out.println("  - adicionar 'int'");
            System.out.println("  - verificar");
            System.out.println("  - status");
        System.out.println("- disciplina");
            System.out.println("  - adicionarhoras 'int'");
            System.out.println("  - adicionarnota 'int' 'double'");
            System.out.println("  - verificar");
            System.out.println("  - status");
        System.out.println("- financas");
            System.out.println("  - adicionar 'int' 'int'");
            System.out.println("  - pagar 'int'");
            System.out.println("  - ganhos");
            System.out.println("  - status");
        System.out.println("\nExemplo de comando válido:\ndisciplina adicionarnota 2 6.0\ndisciplina status\n");
    }
}
