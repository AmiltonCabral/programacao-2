package controle.alunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {
	
	private Aluno alunoBase;
	
	/**
	 * Cria um aluno para ser usado em todos os testes.
	 */
	@BeforeEach
	void preparaAluno() {
		this.alunoBase = new Aluno("1942", "Stephen Hawking", "Fisica");
	}

	/**
	 * Testa o construtor Aluno.
	 */
	@Test
	void testAluno() {
		Aluno alunoTest = new Aluno("2001", "Amilton", "Computacao");
		try {
			Aluno alunoTestB = new Aluno(null, "Amilton", "Computacao");
			fail ("Era esperado exceção ao tentar criar aluno com matrícula nula");
		} catch (NullPointerException npe) { }
		try {
			Aluno alunoTestC = new Aluno(" ", "Amilton", "Computacao");
			fail ("Era esperado exceção ao tentar criar aluno com matrícula em branco");
		} catch (IllegalArgumentException iae) { }
	}
	
	/**
	 * Verifica se o hashCode utiliza a matricula do aluno como parâmetro.
	 * Para tal, ele compara dois alunos diferentes de mesma matricula.
	 */
	@Test
	void testHashCode() {
		Aluno alunoMesmaMatricula = new Aluno("1942", "Amilton", "Computacao");
		assertEquals(this.alunoBase.hashCode(), alunoMesmaMatricula.hashCode());
	}

	/**
	 * Testa se o equals funciona de acordo.
	 * O hashCode utiliza a matricula como parâmetro.
	 */
	@Test
	void testEqualsObject() {
		Aluno alunoMesmaMatricula = new Aluno("1942", "Amilton", "Computacao");
		String grupoString = "P2";
		assertTrue(this.alunoBase.equals(alunoMesmaMatricula));
		assertTrue(this.alunoBase.equals(this.alunoBase));
		assertFalse(this.alunoBase.equals(null));
		assertFalse(this.alunoBase.equals(grupoString));
	}

	/**
	 * Verifica se o toString funciona da forma especificada:
	 * matricula+" - "+nome+" - "+curso
	 * 
	 * Exemplo: (123 - Matheus - Professor)
	 */
	@Test
	void testToString() {
		assertEquals(this.alunoBase.toString(), "1942 - Stephen Hawking - Fisica");
	}

}
