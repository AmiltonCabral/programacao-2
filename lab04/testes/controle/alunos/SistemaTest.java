package controle.alunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
	
	private Sistema sistema;

	/**
	 * Cria alunos para serem usados nos testes
	 */
	@BeforeEach
	void testSistema() {
		this.sistema = new Sistema();
		sistema.cadastrarAlunos("250", "Gabriel Reyes", "Computacao");
		sistema.cadastrarAlunos("200", "Lili Camposh", "Computacao");
		sistema.cadastrarAlunos("202", "Angela Ziegler", "Computacao");
		sistema.cadastrarAlunos("201", "Torbjorn Lindholm", "Engenharia Mecânica");
	}

	/**
	 * Testa se é possível criar um aluno.
	 * Testa as exceções.
	 */
	@Test
	void testCadastrarAlunos() {
		sistema.cadastrarAlunos("2001", "Amilton", "CCC");
		try {
			sistema.cadastrarAlunos("2001", "Cristian", "Engenharia Mecânica");
			fail ("Era esperado exceção ao tentar matrícula com mesma matrícula");
		} catch (IllegalArgumentException iae) { }
	}

	/**
	 * Testa se existe ou não existe um aluno cadastrado no sistema.
	 */
	@Test
	void testExisteAluno() {
		assertTrue(sistema.existeAluno("250"));
		assertFalse(sistema.existeAluno("40028922"));
	}
	
	/**
	 * Testa o método de formatação de aluno.
	 */
	@Test
	void testFormataAluno() {
		assertEquals("\nAluno: 250 - Gabriel Reyes - Computacao", sistema.formataAluno("250"));
	}

	/**
	 * Testa se é possível cadastrar um grupo com e sem limite.
	 * Testa as exceções.
	 */
	@Test
	void testCadastrarGrupo() {
		sistema.cadastrarGrupo("Programação OO", "\n");
		sistema.cadastrarGrupo("Listas", "11");
		try {
			sistema.cadastrarGrupo("Listas", "\n");
			fail ("Era esperado exceção ao criar outro grupo com mesmo tema");
		} catch (IllegalArgumentException iae) { }
	}
	
	/**
	 * Testa se existe ou não um grupo.
	 */
	@Test
	void testExisteGrupo() {
		sistema.cadastrarGrupo("Mercedes", "\n");
		assertTrue(sistema.existeGrupo("Mercedes"));
		assertFalse(sistema.existeGrupo("Ferrari"));
	}

	/**
	 * Testa se é possível alocar um aluno ao grupo.
	 */
	@Test
	void testAlocarAluno() {
		sistema.cadastrarGrupo("Programação OO", "\n");
		assertTrue(sistema.alocarAluno("200", "Programação OO"));
		assertTrue(sistema.alocarAluno("202", "Programação OO"));
		try {
			sistema.alocarAluno("40028922", "Programação OO");
			fail ("Era esperado exceção ao tentar alocar aluno inexistente");
		} catch (IllegalArgumentException iae) { }
	}
	
	/**
	 * Testa o que acontece ao cadastrar um aluno no mesmo grupo duas vezes.
	 */
	@Test
	void testAlocarAlunoJaAlocado() {
		sistema.cadastrarGrupo("Programação OO", "\n");
		assertTrue(sistema.alocarAluno("200", "Programação OO"));
		assertTrue(sistema.alocarAluno("202", "Programação OO"));
		assertTrue(sistema.alocarAluno("200", "Programação OO"));
	}
	
	/**
	 * Testa exceção ao tentar cadastrar um aluno a um grupo inexistente.
	 */
	@Test
	void testAlocarAlunoGrupoInexistente() {
		try {
			sistema.alocarAluno("200", "Anatomia");
			fail ("Era esperado exceção ao tentar alocar aluno a um grupo inexistente");
		} catch (IllegalArgumentException iae) { }
	}
	
	/**
	 * Testa alocação de aluno em um grupo com restrição.
	 */
	@Test
	void testAlocarAlunoGrupoRestricao() {
		sistema.cadastrarGrupo("listas", "1");
		assertTrue(sistema.alocarAluno("250", "listas"));
		assertFalse(sistema.alocarAluno("202", "listas"));
	}

	/**
	 * Testa se um aluno pertence ou não a um grupo.
	 */
	@Test
	void testPertineciaGrupo() {
		sistema.cadastrarGrupo("listas", "\n");
		assertTrue(sistema.alocarAluno("250", "listas"));
		assertTrue(sistema.pertineciaGrupo("listas", "250"));
		assertFalse(sistema.pertineciaGrupo("listas", "202"));
	}
	
	/**
	 * Testa se ao verificar a pertinencia de um aluno a um grupo inexistente retorna falso.
	 */
	@Test
	void testPertineciaGrupoInexistente() {
		assertFalse(sistema.pertineciaGrupo("listas", "200"));
	}
	
	/**
	 * Testa se ao verificar a pertinencia de um aluno inexistente a um grupo retorna falso.
	 */
	@Test
	void testPertineciaAlunoInexistente() {
		sistema.cadastrarGrupo("Programação OO", "\n");
		assertFalse(sistema.pertineciaGrupo("Programação OO", "100"));
	}

	/**
	 * Testa se é possível registrar que um aluno respondeu ao quadro.
	 * Testa exceção ao registrar um aluno inexistente.
	 */
	@Test
	void testRegistrarAlunoRespondeu() {
		sistema.registrarAlunoRespondeu("200");
		try {
			sistema.registrarAlunoRespondeu("40028922");
			fail ("Era esperado exceção ao tentar registrar aluno inexistente");
		} catch (IllegalArgumentException iae) { }
	}

	/**
	 * Testa a impressão de alunos que responderam ao quadro.
	 */
	@Test
	void testImprimirAlunosResponderam() {
		sistema.registrarAlunoRespondeu("200");
		sistema.registrarAlunoRespondeu("202");
		assertEquals("1. 200 - Lili Camposh - Computacao\n2. 202 - Angela Ziegler - Computacao\n", sistema.imprimirAlunosResponderam());
	}

	/**
	 * Testa a impressão dos grupos de um aluno.
	 */
	@Test
	void testImprimirGruposAlunos() {
		sistema.cadastrarGrupo("Programacao OO", "\n");
		sistema.cadastrarGrupo("listas", "\n");
		sistema.cadastrarGrupo("Grupo Inutilizado", "\n");
		sistema.alocarAluno("250", "listas");
		sistema.alocarAluno("250", "Programacao OO");
		assertEquals("- Programacao OO\n- listas\n", sistema.imprimirGruposAlunos("250"));
	}
	
	/**
	 * Testa a impressão de grupos vazia, de um aluno sem grupo.
	 */
	@Test
	void testImprimirGruposAlunoSemGrupo() {
		assertEquals("", sistema.imprimirGruposAlunos("202"));
	}

}
