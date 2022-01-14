package controle.alunos;

import java.util.HashSet;
import java.util.Objects;

/**
 * Um grupo, que pode ter infinitos alunos, ou pode ter um limite de alunos.
 * Um grupo tem seu tema, que é próprio, é como o grupo é chamado.
 * Se o limite estiver como -1, é por que o grupo não tem limite. Se for maior ou igual a 0 tem limite.
 *
 * @author Amilton Cristian
 */
public class Grupo {

    private String tema;
    private HashSet<String> grupo;
    private int limiteAlunos;
    private int quantidadeAlunos = 0;

    /**
     * Constroi o grupo.
     * @param tema tema do grupo, como é chamado.
     */
    public Grupo(String tema) {
        if (tema == null) {
            throw new NullPointerException("Tema não deve ser nulo");
        } else if (tema.isBlank()) {
            throw new IllegalArgumentException("Tema não deve ser vazio");
        }
        this.tema = tema;
        this.limiteAlunos = -1;
        this.grupo = new HashSet<>();
    }

    /**
     * Constrói o grupo com limite de membros.
     * @param tema tema do grupo, como é chamado.
     * @param tamanho tamanho máximo do grupo.
     */
    public Grupo(String tema, int tamanho) {
        if (tema == null) {
            throw new NullPointerException("Tema não deve ser nulo");
        } else if (tema.isBlank()) {
            throw new IllegalArgumentException("Tema não deve ser vazio");
        }
        this.tema = tema;
        this.limiteAlunos = tamanho;
        this.grupo = new HashSet<>();
    }

    /**
     * Verifica se o aluno pertence ao grupo.
     * @param aluno o aluno a ser verificado.
     * @return true caso o aluno pertença ao grupo, false caso contrário.
     */
    public boolean pertinenciaGrupo(String aluno) {
        if (this.grupo.contains(aluno)) {
            return true;
        }
        return false;
    }

    /**
     * Aloca o aluno ao grupo.
     * Se o grupo tiver limite e estiver cheio, o aluno não é alocado.
     * Se o grupo tiver limite e o aluno for alocado, é somado +1 ao total de alunos alocados.
     * Caso o aluno já esteja alocado, ele é alocado novamente, mas não é somado +1 ao total de alunos alocados.
     * @param aluno o aluno a ser alocado.
     * @return true se o aluno foi alocado ou false se o grupo estiver cheio.
     */
    public boolean alocarAluno(String aluno) {
        if (limiteAlunos>=0 & quantidadeAlunos>=limiteAlunos) {
            return false;
        }
        if (limiteAlunos>=0 & !grupo.contains(aluno)) {
            grupo.add(aluno);
            quantidadeAlunos++;
        } else {
            grupo.add(aluno);
        }
        return true;
    }
    
    /**
     * o toString passa a retornar o tema.
     */
    @Override
    public String toString() {
        return this.tema;
    }

    /**
     * o hashCode passa a retornar o hash do tema.
     */
	@Override
	public int hashCode() {
		return Objects.hash(tema);
	}

    /**
     * equals que usa tema como parâmetro.
     * @param obj objeto grupo recebido.
     * @return true caso tenham o mesmo hashCode, false caso contrário.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(tema, other.tema);
	}
    
}
