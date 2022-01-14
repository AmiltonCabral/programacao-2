package lab2;

/**
 * Organiza as notas de um aluno. As notas adicionadas podem ser ajustadas posteriormente.
 * Guarda também as horas de estudo de um aluno, que é somada com as horas anteriores.
 * A menos que o aluno especifique, a disciplina tem quatro notas.
 * A menos que o aluno especifique, a média adotada por padrão é média aritmetica.
 * 
 * @author Amilton Cristian
 */
public class Disciplina {
    
    /**
     * Nome da disciplina criada.
     */
    private String nomeDaDisciplina;

    /**
     * Quantas horas o aluno estudou, quando o aluno adiciona determinada quantidade de horas, essas horas são somadas com as anteriores.
     */
    private int numeroHorasEstudo;

    /**
     * Um array com todas as notas do aluno.
     */
    private double[] notasDoAluno;

    /**
     * Uma média com as notas do aluno. Média aritmetica por padrão.
     */
    private double mediaNotasDoAluno;

    /**
     * Se o sistema de notas for média ponderada, um array com os pesos das notas é criada.
     */
    private int[] pesoDasNotas;

    /**
     * Se for especificado quantas notas a disciplina terá.
     */
    private int numNotasDaDisciplina;

    /**
     * Cria uma disciplina a partir do nome da disciplina.
     * Por padrão, a disciplina tem quatro notas.
     * É calculada a média aritmética, e para ser considerado aprovado, precisa de média maior ou igual a 7.0.
     * Não contém peso nas notas.
     * 
     * @param nomeDisciplina Nome para a disciplina.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDaDisciplina = nomeDisciplina;
        this.numeroHorasEstudo = 0;
        this.numNotasDaDisciplina = 4;
        this.notasDoAluno = new double[this.numNotasDaDisciplina];
        this.pesoDasNotas = new int[0];
        this.mediaNotasDoAluno = 0;
    }

    /**
     * Cria uma disciplina a partir do nome da disciplina e quantidade de notas da disciplina.
     * É calculada a média aritmética, e para ser considerado aprovado, precisa de média maior ou igual a 7.0.
     * Não contém peso nas notas.
     * 
     * @param nomeDisciplina Nome para a disciplina.
     * @param numNotasDaDisciplina Quantidade de notas que a disciplina terá.
     */
    public Disciplina(String nomeDisciplina, int numNotasDaDisciplina) {
        this.nomeDaDisciplina = nomeDisciplina;
        this.numeroHorasEstudo = 0;
        this.numNotasDaDisciplina = numNotasDaDisciplina;
        this.notasDoAluno = new double[this.numNotasDaDisciplina];
        this.pesoDasNotas = new int[0];
        this.mediaNotasDoAluno = 0;
    }

    /**
     * Cria uma disciplina a partir do nome da disciplina e quantidade de notas da disciplina.
     * É calculada a média ponderada, e para ser considerado aprovado, precisa de média maior ou igual a 7.0.
     * 
     * @param nomeDisciplina Nome para a disciplina.
     * @param numNotasDaDisciplina Quantidade de notas que a disciplina terá.
     * @param pesoDeCadaNota Os pesos que as notas terão.
     */
    public Disciplina(String nomeDisciplina, int numNotasDaDisciplina, int[] pesoDeCadaNota) {
        this.nomeDaDisciplina = nomeDisciplina;
        this.numeroHorasEstudo = 0;
        this.numNotasDaDisciplina = numNotasDaDisciplina;
        this.notasDoAluno = new double[this.numNotasDaDisciplina];
        this.pesoDasNotas = pesoDeCadaNota;
        this.mediaNotasDoAluno = 0;
    }
    
    /**
     * Quantas horas o aluno estudou, é somada com as horas anteriores.
     * 
     * @param horasParaCadastrar As horas para adicionar.
     */
    public void cadastraHoras(int horasParaCadastrar) {
        this.numeroHorasEstudo += horasParaCadastrar;
    }

    /**
     * Quando é adicionado uma nota, ou a nota é substituída, é necessário atualizar a média.
     * Primeiro verifica-se se é média ponderada ou aritmetica.
     */
    private void atualizarMediaNotas() {
        double somaDasNotas = 0;
        if (this.pesoDasNotas.length > 0) {
            int somaDosPesos = 0;
            this.mediaNotasDoAluno = 0;
            for (int i=0; i<this.numNotasDaDisciplina; i++) {
                somaDasNotas += this.pesoDasNotas[i] * this.notasDoAluno[i];
                somaDosPesos += this.pesoDasNotas[i];
            }
            this.mediaNotasDoAluno = somaDasNotas / somaDosPesos;
        } else {
            for (int i=0; i<this.numNotasDaDisciplina; i++) {
                somaDasNotas += this.notasDoAluno[i];
            }
            this.mediaNotasDoAluno = somaDasNotas / numNotasDaDisciplina;
        }
    }

    /**
     * Adiciona ou altera a nota do aluno.
     * 
     * @param identificacaoNota a posição de qual nota alterar.
     * @param valorNota o valor da nota.
     */
    public void cadastraNota(int identificacaoNota, double valorNota) {
        this.notasDoAluno[identificacaoNota-1] = valorNota;
        atualizarMediaNotas();
    }

    /**
     * Se o aluno possuir média maior ou igual a 7.0 ele é considerado aprovado, reprovado caso contrário.
     * 
     * @return true caso aprovado, false caso reprovado.
     */
    public boolean aprovado() {
        if (this.mediaNotasDoAluno >= 7.0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna os status da disciplina, organizado da seguinte forma:
     * "NOME DA DISCIPLINA x' y' [n1', n2', n3', n4']"
     * Onde x' é quantas horas o aluno estudou, y' a media das notas e n' são as notas.
     * 
     * @return os status da disciplina.
     */
    public String toString() {
        String statusDasNotas = this.nomeDaDisciplina+" "+this.numeroHorasEstudo+" "+this.mediaNotasDoAluno+" [";
        for (int i=0; i<this.numNotasDaDisciplina; i++) {
            statusDasNotas += notasDoAluno[i];
            if (i == numNotasDaDisciplina -1) {break;}
            statusDasNotas += ", ";
        }
        statusDasNotas += "]";
        return statusDasNotas;
    }

}
