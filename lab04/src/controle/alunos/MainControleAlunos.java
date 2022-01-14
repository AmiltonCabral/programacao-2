package controle.alunos;

import java.util.Scanner;


/**
 * Gerencia alunos e grupos. 
 * 
 * @author Amilton Cristian
 */
public class MainControleAlunos {
    
    /**
     * Cria um sistema que gerencia Alunos e Grupos.
     * Contém um looping que exibe menu e encaminha comandos.
     * @param args não é utilizado.
     */
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner input = new Scanner(System.in);

        while (true) {
            String opcao = menu(input);
            comandos(input, opcao, sistema);
        }
    }

    /**
     * Exibe o menu e captura o comando do usuário.
     * @param input usado para receber entradas do usuário.
     * @return retorna a escolha do usuário.
     */
    private static String menu(Scanner input) {
        System.out.print(
            "\n" +
            "(C)adastrar Aluno\n" +
            "(E)xibir Aluno\n" +
            "(N)ovo Grupo\n" +
            "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
            "(R)egistrar Aluno que Respondeu\n" +
            "(I)mprimir Alunos que Responderam\n" +
            "(O)lhaí quais Grupos o Aluno Tá.\n" +
            "(S)im, quero Fechar o Programa!\n" +
            "\nOpção> "
        );
        return input.next().toUpperCase();
    }

    /**
     * Encaminha a escolha do usuário para tarefas específicas.
     * Caso o usuário escolha a opção A, é encaminhado a um submenu.
     * @param input para receber entradas do usuário.
     * @param opcao a escolha do usuário.
     * @param sistema gerenciamento de alunos e grupos.
     */
    private static void comandos(Scanner input, String opcao, Sistema sistema) {
        switch (opcao) {
            case "C":
                cadastrarAlunos(input, sistema);
                break;
            case "E":
                consultarAluno(input, sistema);
                break;
            case "N":
                cadastrarGrupo(input, sistema);
                break;
            case "A":
                String subOpcao = alocarVerificarGrupo(input);
                switch (subOpcao) {
                    case "A":
                        alocarAluno(input, sistema);
                        break;
                    case "P":
                        pertineciaGrupo(input, sistema);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                break;
            case "R":
                registrarAlunoRespondeu(input, sistema);
                break;
            case "I":
                imprimirAlunosResponderam(sistema);
                break;
            case "O":
                imprimirGruposAlunos(input, sistema);
                break;
            case "S":
                sair(input);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    /**
     * Recebe a matricula de um aluno, e imprime todos os grupos que o aluno participa.
     * @param input Scanner para receber entradas do usuário.
     * @param sistema gerenciamento de alunos e grupos.
     */
    private static void imprimirGruposAlunos(Scanner input, Sistema sistema) {
        System.out.print("Aluno: ");
        String matricula = input.next();
        input.nextLine();
        System.out.print(sistema.imprimirGruposAlunos(matricula));
    }

    /**
     * Imprime em ordem todos os alunos que responderam ao quadro.
     * Exibe a posição, matricula, nome e curso do aluno.
     * Um aluno pode responder ao quadro mais de uma vez.
     * @param sistema gerenciamento de alunos e grupos.
     */
    private static void imprimirAlunosResponderam(Sistema sistema) {
        System.out.println("Alunos:");
        System.out.print(sistema.imprimirAlunosResponderam());
    }

    /**
     * Se o aluno existir, marcar que o aluno respondeu atividade no quadro.
     * @param input Scanner para receber entradas do usuário.
     * @param sistema gerenciamento de alunos e grupos.
     */
    private static void registrarAlunoRespondeu(Scanner input, Sistema sistema) {
        System.out.print("Matricula: ");
        String matricula = input.next();
        input.nextLine();
        if (!sistema.existeAluno(matricula)) {
            System.out.println("\nAluno não cadastrado.");
            return;
        }
        sistema.registrarAlunoRespondeu(matricula);
        System.out.println("\nALUNO REGISTRADO!");
    }

    /**
     * Exibe um submenu e retorna a escolha do usuário.
     * @param input para receber entradas do usuário.
     * @return a escolha do usuário.
     */
    private static String alocarVerificarGrupo(Scanner input) {
        System.out.print("(A)locar Aluno ou (P)ertinência a Grupo? ");
        return input.next().toUpperCase();
    }
    
    /**
     * Cadastra um aluno.
     * Cada matrícula é unica, ou seja, se já existir um aluno com uma matrícula, outro aluno com a mesma matrícula não pode ser criado.
     * @param input para receber entradas do usuário.
     * @param sistema gerenciamento de alunos e grupos.
     */
    private static void cadastrarAlunos(Scanner input, Sistema sistema) {
        System.out.print("Matrícula: ");
        String matricula = input.next();
        input.nextLine();
        System.out.print("Nome: ");
        String nome = input.next();
        input.nextLine();
        System.out.print("Curso: ");
        String curso = input.next();
        input.nextLine();
        if (sistema.existeAluno(matricula)) {
            System.out.println("\nMATRÍCULA JÁ CADASTRADA!");
            return;
        }
        sistema.cadastrarAlunos(matricula, nome, curso);
        System.out.println("\nCADASTRO REALIZADO!");
    }

    /**
     * Exibe o aluno caso ele esteja cadastrado.
     * Caso contrário, é informado ao usuário que o aluno não está cadastrado.
     * @param input para receber entradas do usuário.
     * @param sistema gerenciamento de alunos e grupos.
     */
    private static void consultarAluno(Scanner input, Sistema sistema) {
        System.out.print("Matrícula: ");
        String matricula = input.next();
        input.nextLine();
        if (sistema.existeAluno(matricula)) {
            System.out.println(sistema.formataAluno(matricula));
        } else {
            System.out.println("\nAluno não cadastrado.");
        }
    }

    /**
     * Cadastra um grupo, que pode ter alunos.
     * Se o usuário quiser, o grupo pode ou não ter limite. O usuário escolhe qual será o limite.
     * Não pode existir grupos com o mesmo nome, mesmo se tiver diferença de maiúscula para minúscula.
     * O nome do grupo é criado da forma que o usuário digita, mas a key é definida completamente minúscula.
     * @param input para receber entradas do usuário.
     * @param sistema gerenciamento de alunos e grupos.
     */
    private static void cadastrarGrupo(Scanner input, Sistema sistema) {
        System.out.print("Grupo: ");
        String nomeGrupo = input.next();
        input.nextLine();
        System.out.print("Tamanho: ");
        String strTamanhoGrupo = input.nextLine();
        if (sistema.existeGrupo(nomeGrupo)) {
            System.out.println("\nGRUPO JÁ CADASTRADO!");
            return;
        }
        sistema.cadastrarGrupo(nomeGrupo, strTamanhoGrupo);
        System.out.println("\nCADASTRO REALIZADO!");
    }

    /**
     * Se existir o aluno e o grupo, aloca o aluno ao grupo.
     * @param input para receber entradas do usuário.
     * @param sistema gerenciamento de alunos e grupos.
     */
    private static void alocarAluno(Scanner input, Sistema sistema) {
        System.out.print("Matricula: ");
        String matricula = input.next();
        input.nextLine();
        System.out.print("Grupo: ");
        String grupoEscolha = input.next().toLowerCase();
        input.nextLine();
        if (!sistema.existeAluno(matricula)) {
            System.out.println("\nAluno não cadastrado.");
            return;
        } else if (!sistema.existeGrupo(grupoEscolha)) {
            System.out.println("\nGrupo não cadastrado.");
            return;
        }
        if (sistema.alocarAluno(matricula, grupoEscolha)) {
            System.out.println("\nALUNO ALOCADO!");
            return;
        }
        System.out.println("\nGRUPO CHEIO");
    }

    /**
     * Se existir o grupo, verifica se um aluno pertence a um grupo.
     * @param input para receber entradas do usuário.
     * @param sistema gerenciamento de alunos e grupos.
     */
    private static void pertineciaGrupo(Scanner input, Sistema sistema) {
        System.out.print("Grupo: ");
        String grupo = input.next().toLowerCase();
        input.nextLine();
        System.out.print("Aluno: ");
        String aluno = input.next();
        input.nextLine();
        if (!sistema.existeGrupo(grupo)) {
            System.out.println("\nGrupo não cadastrado.");
            return;
        }
        if (sistema.pertineciaGrupo(grupo, aluno)) {
            System.out.println("\nALUNO PERTENCE AO GRUPO");
            return;
        }
        System.out.println("\nALUNO NÃO PERTENCE AO GRUPO");
    }

    /**
     * Fecha o Scanner e sai do programa.
     */
    private static void sair(Scanner input) {
        input.close();
        System.exit(0);
    }

}
