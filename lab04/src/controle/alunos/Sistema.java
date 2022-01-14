package controle.alunos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Objeto Sistema que gerencia Alunos e Grupos.
 * Também armazena alunos que responderam ao quadro.
 * 
 * @author Amilton Cristian
 */
public class Sistema {
    
    //Key do grupoEstudo sempre em minúsculo, mesmo que o nome do grupo não esteja.
    private HashMap<String, Grupo> gruposEstudo;
    private HashMap<String, Aluno> mapaMatriculaAlunos;
    private ArrayList<String> responderamAoQuadro;

    /**
     * Cria o mapa para grupos de estudo e alunos.
     * E cria a lista dos alunos que responderam ao quadro.
     */
    public Sistema() {
        gruposEstudo = new HashMap<>();
        mapaMatriculaAlunos = new HashMap<>();
        responderamAoQuadro = new ArrayList<>();
    }

    /**
     * Cria um aluno com uma matrícula única e o armazena no mapaMatriculaAlunos.
     * Não é possível criar um aluno que já tenha uma matrícula registrada.
     * @param matricula matricula do aluno em string, por padrão apenas números.
     * @param nome nome do aluno.
     * @param curso curso do aluno.
     */
    public void cadastrarAlunos(String matricula, String nome, String curso) {
        if (existeAluno(matricula)) {
            throw new IllegalArgumentException("Já existe aluno com essa matrícula");
        }
        Aluno novoAluno = new Aluno(matricula, nome, curso);
        mapaMatriculaAlunos.put(matricula, novoAluno);
    }

    /**
     * Verifica se o aluno existe.
     * @param matricula identificação do aluno.
     * @return true caso o aluno exista, false caso contrário.
     */
    public boolean existeAluno(String matricula) {
        if (mapaMatriculaAlunos.containsKey(matricula)) {
            return true;
        }
        return false;
    }

    /**
     * Formata o aluno para o formato específico.
     * Ex.: "\nAluno: 10 - Amilton - Computação".
     * Parte da formatação é feita pelo toString do Objeto Aluno.
     * @param matricula identificação do aluno.
     * @return uma string no formato específicado.
     */
    public String formataAluno(String matricula) {
        return "\nAluno: "+mapaMatriculaAlunos.get(matricula);
    }

    /**
     * Cria um grupo e armazena no mapa gruposEstudo.
     * Um grupo é identificado pelo seu nome.
     * Não é possível criar dois grupos com o mesmo nome.
     * Um grupo pode ou não ter limite.
     * @param nomeGrupo nome do grupo, é usado para identificar o grupo, também é a key no mapa de grupos.
     * @param strTamanhoGrupo se tiver um número, esse será o limite do grupo. Caso seja vazio/branco não terá limite.
     */
    public void cadastrarGrupo(String nomeGrupo, String strTamanhoGrupo) {
        if (existeGrupo(nomeGrupo)) {
            throw new IllegalArgumentException("Já existe um grupo com esse tema");
        }
        Grupo novoGrupo;
        if (strTamanhoGrupo.isBlank()) {
            novoGrupo = new Grupo(nomeGrupo);
        } else {
            int tamanhoGrupo = Integer.parseInt(strTamanhoGrupo);
            novoGrupo = new Grupo(nomeGrupo, tamanhoGrupo);
        }
        gruposEstudo.put(nomeGrupo.toLowerCase(), novoGrupo);
    }

    /**
     * Verifica se o grupo existe.
     * @param tema identificação do grupo.
     * @return true caso o grupo exista, false caso contrário.
     */
    public boolean existeGrupo(String tema) {
        if (gruposEstudo.containsKey(tema.toLowerCase())) {
            return true;
        }
        return false;
    }

    /**
     * Se o aluno e o grupo existe, aloca o aluno no grupo.
     * @param matricula matrícula/identificação do aluno.
     * @param grupoEscolha nome/identificação do grupo.
     * @return true se o aluno foi alocado ou false se o grupo estiver cheio.
     */
    public boolean alocarAluno(String matricula, String grupoEscolha) {
        if (!existeAluno(matricula)) {
            throw new IllegalArgumentException("Não existe aluno com essa matrícula");
        }
        if (!existeGrupo(grupoEscolha)) {
            throw new IllegalArgumentException("Não existe grupo com esse tema");
        }
        return gruposEstudo.get(grupoEscolha.toLowerCase()).alocarAluno(matricula);
    }

    /**
     * Se o grupo existir, verifica se o aluno pertence ao grupo.
     * @param grupo nome/identificação do grupo.
     * @param aluno matricula/identificação do aluno.
     * @return true se o aluno pertence ao grupo, false caso contrário.
     */
    public boolean pertineciaGrupo(String grupo, String aluno) {
        if (!existeGrupo(grupo)) {
            return false;
        }
        if (gruposEstudo.get(grupo.toLowerCase()).pertinenciaGrupo(aluno)) {
            return true;
        }
        return false;
    }

    /**
     * Se o aluno existir, registra que o aluno respondeu ao quadro.
     * @param matricula identificação/matrícula do aluno.
     */
    public void registrarAlunoRespondeu(String matricula) {
        if (!existeAluno(matricula)) {
            throw new IllegalArgumentException("Não existe aluno com essa matrícula");
        }
        responderamAoQuadro.add(matricula);
    }

    /**
     * Armazena em uma String todos os alunos que responderam ao quadro.
     * @return a String contendo todos os alunos que responderam.
     */
    public String imprimirAlunosResponderam() {
        String alunosQueResponderam = "";
        for (int i=0; i<responderamAoQuadro.size(); i++) {
            alunosQueResponderam += i+1+". ";
            alunosQueResponderam += mapaMatriculaAlunos.get(responderamAoQuadro.get(i))+"\n";
        }
        return alunosQueResponderam;
    }

    /**
     * Armazena em uma String todos os grupos que o aluno faz parte.
     * @param matricula identificação do aluno.
     * @return a String com todos os grupos que o aluno participa.
     */
    public String imprimirGruposAlunos(String matricula) {
        String gruposDoAluno = "";
        for (Grupo grupo : gruposEstudo.values()) {
            if (grupo.pertinenciaGrupo(matricula)) {
                gruposDoAluno += "- "+grupo+"\n";
            }
        }
        return gruposDoAluno;
    }

}
