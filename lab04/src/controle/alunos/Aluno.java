package controle.alunos;

import java.util.Objects;

/**
 * Um aluno, que contém matrícula (usada para identificar o aluno), nome e curso.
 * 
 * @author Amilton Cristian
 */
public class Aluno {

    private String matricula;
    private String nome;
    private String curso;

    /**
     * Constrói o aluno.
     * @param matricula a identificação do aluno.
     * @param nome nome do aluno.
     * @param curso curso do aluno.
     */
    public Aluno(String matricula, String nome, String curso) {
        if (matricula == null) {
            throw new NullPointerException("Matrícula não deve ser null");
        } else if (matricula.isBlank()) {
            throw new IllegalArgumentException("Matrícula não deve ser vazia");
        }
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * hashCode passa a usar a matricula do aluno.
     */
    @Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

    /**
     * equals que usa matricula como parâmetro.
     * @param obj Aluno recebido.
     * @return true caso tenham a mesma matricula, false caso contrário.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}

	/**
     * toString passa a retornar o aluno da seguinte forma:
     * Ex.: "55 - Amilton - Computacao".
     */
    @Override
    public String toString() {
        return matricula+" - "+nome+" - "+curso;
    }
    
}
