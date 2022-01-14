package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {

	private Agenda agendaBase;
	
	/**
	 * Cria uma agenda.
	 * Cadastra alguns contatos.
	 * Define alguns contatos como favorito.
	 */
	@BeforeEach
	void preparaAgenda() {
		this.agendaBase = new Agenda();
		this.agendaBase.cadastraContato(1, "Amilton", "Cristian", "(81) 99999-8888");
		this.agendaBase.cadastraContato(100, "Lewis", "Hamilton", "(10) 99999-8888");
		this.agendaBase.cadastraContato(14, "Max", "Verstapen", "(11) 99999-8888");
		this.agendaBase.cadastraContato(15, "Lando", "Norriz", "(83) 99999-8888");
		this.agendaBase.cadastraContato(16, "George", "Russel", "(99) 99999-8888");
		this.agendaBase.setFavorito(15, 10);
		this.agendaBase.setFavorito(100, 1);
	}

	@Test
	void testGetContato() {
		assertEquals("Amilton", this.agendaBase.getContato(1));
	}

	@Test
	void testGetNomeCompleto() {
		assertEquals("Amilton Cristian", this.agendaBase.getNomeCompleto(1));
		assertEquals("", this.agendaBase.getNomeCompleto(77));
	}

	/**
	 * Verifica se o método exibe o contato na formatação correta.
	 * A formatação é nome completo, mais quebra de linha, mais telefone contato.
	 */
	@Test
	void testExibirContato() {
		assertEquals("Amilton Cristian\n(81) 99999-8888", this.agendaBase.exibirContato(1));
	}

	/** Verifica se retorna os favoritos corretamente */
	@Test
	void testGetFavoritos() {
		assertEquals(15, this.agendaBase.getFavorito(10));
		assertEquals(100, this.agendaBase.getFavorito(1));
	}
	
	/** Verifica se funciona corretamente a definição de favorito */
	@Test
	void testSetFavorito() {
		this.agendaBase.setFavorito(16, 3);
	}

	/** Verifica se um contato é favorito e/ou falso funciona corretamente */
	@Test
	void testEhFavorito() {
		assertTrue(this.agendaBase.ehFavorito(100));
		assertFalse(this.agendaBase.ehFavorito(1));
	}
	
	/** Verifica se adicionar tags funciona corretamente */
	@Test
	void testAdicionaTag() {
		this.agendaBase.adicionaTag("NoPiloto", 1, 4);
	}
	
	/** 
	 * Verifica se após adicionar uma tag, a tag é exibida corretamente
	 * e de acordo com a ordem do índice.
	 */
	@Test
	void testExibirTags() {
		this.agendaBase.adicionaTag("Williams", 16, 3);
		this.agendaBase.adicionaTag("Racing", 16, 5);
		this.agendaBase.adicionaTag("Piloto", 16, 1);
		assertEquals("Piloto Williams Racing", this.agendaBase.exibirTags(16));
	}
	
	/** Verifica se o boolean de existência de tag funciona corretamente. */
	@Test
	void testTemTags() {
		assertFalse(this.agendaBase.temTags(14));
		this.agendaBase.adicionaTag("PitBull", 14, 2);
		assertTrue(this.agendaBase.temTags(14));
	}
	
	/** Verifica se cadastra um novo contato corretamente */
	@Test
	void testCadastraContato() {
		this.agendaBase.cadastraContato(1, "Primeira", "Pessoa", "40024002");
		this.agendaBase.cadastraContato(100, "Ultima", "", "55554444");
	}
	
	/** Verifica se alterar o número de telefone de um contato funciona de acordo */
	@Test
	void testAlterarContato() {
		assertEquals("Lewis Hamilton\n(10) 99999-8888", this.agendaBase.exibirContato(100));
		this.agendaBase.alterarTelefone(100, "(+N) 00-11");
		assertEquals("Lewis Hamilton\n(+N) 00-11", this.agendaBase.exibirContato(100));
	}
	
	/** Verifica se remover um contato dos favoritos funciona */
	@Test
	void testRemoverFavorito() {
		assertTrue(this.agendaBase.ehFavorito(100));
		this.agendaBase.removerFavorito(1);
		assertFalse(this.agendaBase.ehFavorito(100));
	}
	
	/** 
	 * Verifica se remover um contato da agenda funciona corretamente.
	 * Verifica também, se ao remover da agenda, também é removido da lista de favoritos.
	 */
	@Test
	void testRemoverContato() {
		assertEquals("Amilton Cristian", this.agendaBase.getNomeCompleto(1));
		assertFalse(this.agendaBase.ehFavorito(1));
		this.agendaBase.setFavorito(1, 2);
		assertTrue(this.agendaBase.ehFavorito(1));
		this.agendaBase.removerContato(1);
		assertNotEquals("Lewis Hamilton", this.agendaBase.getNomeCompleto(1));
		assertFalse(this.agendaBase.ehFavorito(1));
	}
	
	/** Verifica se uma tag faz parte de um contato */
	@Test
	void testEhTagDoContato() {
		assertFalse(this.agendaBase.ehTagDoContato(100, "BEST"));
		this.agendaBase.adicionaTag("BEST", 100, 2);
		assertTrue(this.agendaBase.ehTagDoContato(100, "BEST"));
		assertFalse(this.agendaBase.ehTagDoContato(100, "WORST"));
	}
	
	/** Verifica se remover uma tag funciona corretamente */
	@Test
	void testRemoverTag() {
		assertFalse(this.agendaBase.ehTagDoContato(100, "BEST"));
		this.agendaBase.adicionaTag("BEST", 100, 2);
		assertTrue(this.agendaBase.ehTagDoContato(100, "BEST"));
		this.agendaBase.removerTag(100, 2);
		this.agendaBase.removerTag(14, 2);
		assertFalse(this.agendaBase.ehTagDoContato(100, "BEST"));
	}
}
