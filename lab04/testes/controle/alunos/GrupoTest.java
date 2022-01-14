package controle.alunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoTest {
	
	private Grupo grupoBase;
	private Grupo grupoBaseComLimite;

	/**
	 * Cria dois grupos disponíveis para todos os testes.
	 * Um com limite, outro sem.
	 */
	@BeforeEach
	void prepararGrupo() {
		this.grupoBase = new Grupo("P2");
		this.grupoBaseComLimite = new Grupo("LP2", 2);
	}
	
	/**
	 * Testa o construtor de grupo sem limite.
	 */
	@Test
	void testGrupo() {
		Grupo grupoTeste = new Grupo("TESTADO");
		try {
			Grupo grupoTesteB = new Grupo(null);
			fail ("Era esperado exceção ao tentar criar grupo com tema nulo");
		} catch (NullPointerException npe) { }
		try {
			Grupo grupoTesteC = new Grupo(" ");
			fail ("Era esperado exceção ao tentar criar grupo com tema em branco");
		} catch (IllegalArgumentException iae) { }
		try {
			Grupo grupoTesteD = new Grupo(null, 10);
			fail ("Era esperado exceção ao tentar criar grupo com tema nulo");
		} catch (NullPointerException npe) { }
		try {
			Grupo grupoTesteE = new Grupo(" ", 10);
			fail ("Era esperado exceção ao tentar criar grupo com tema em branco");
		} catch (IllegalArgumentException iae) { }
	}
	
	/**
	 * Testa o construtor de grupo com limite.
	 */
	@Test
	void testConstrutorGrupoComLimite() {
		Grupo grupoComLimiteTeste = new Grupo("Cachaca", 51);
	}
	
	/**
	 * Testa se o hashCode de um grupo com um nome específico, é igual a outro grupo de mesmo nome.
	 */
	@Test
	void testHashCode() {
		Grupo grupoP2 = new Grupo("P2", 50);
		assertEquals(this.grupoBase.hashCode(), grupoP2.hashCode());
	}

	/**
	 * Testa se o toString de um grupo retorna seu nome.
	 */
	@Test
	void testToString() {
		assertEquals(this.grupoBase.toString(), "P2");
	}

	/**
	 * Verifica se um aluno já está em um grupo ou não.
	 * Alunos são armazenados em forma de String, com seu nome.
	 */
	@Test
	void testPertinenciaGrupo() {
		this.grupoBase.alocarAluno("Amilton");
		assertTrue(this.grupoBase.pertinenciaGrupo("Amilton"));
		assertFalse(this.grupoBase.pertinenciaGrupo("Cristian"));
	}

	/**
	 * Testa se um aluno pode ser alocado em um grupo.
	 */
	@Test
	void testAlocarAluno() {
		assertTrue(this.grupoBase.alocarAluno("Amilton"));
	}
	
	/**
	 * O grupo usado para teste tem o limite de 2 alunos.
	 * 
	 * Verifica se um aluno "Amilton" pode ser alocado em um grupo com limite.
	 * Verifica se um aluno de mesmo nome "Amilton" pode ser...
	 * 		...alocado novamente sem aumentar a quantidade de alunos.
	 * Verifica se pode ser adicionado 2 alunos em um grupo com limite de 2 alunos.
	 * Verifica se não pode ser adicionado 3 alunos em um grupo com limite de 2 alunos.
	 */
	@Test
	void testAlocarAlunoNoGrupoCheio() {
		assertTrue(this.grupoBaseComLimite.alocarAluno("Amilton"));
		assertTrue(this.grupoBaseComLimite.alocarAluno("Amilton"));
		assertTrue(this.grupoBaseComLimite.alocarAluno("Ailton"));
		assertFalse(this.grupoBaseComLimite.alocarAluno("Matheus"));
	}

	/**
	 * Testa se o equals funciona de forma adequada.
	 * O hashCode de deve usar o nome do grupo como parâmetro.
	 */
	@Test
	void testEqualsObject() {
		Grupo grupoP2 = new Grupo("P2", 50);
		String grupoString = "P2";
		assertTrue(this.grupoBase.equals(this.grupoBase));
		assertFalse(this.grupoBase.equals(null));
		assertFalse(this.grupoBase.equals(grupoString));
		assertTrue(this.grupoBase.equals(grupoP2));
		assertFalse(this.grupoBaseComLimite.equals(grupoP2));
	}

}
