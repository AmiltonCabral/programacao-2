package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {

	private Contato contatoBase;
	private Contato contatoSec;

	/** Cria um contato para todos os testes */
	@BeforeEach
	void preparaContatos() {
		this.contatoBase = new Contato("Matheus", "Gaudencio", "(81) 99845-4545");
	}

	@Test
	void testGetNomeContato() {
		assertEquals("Matheus Gaudencio", this.contatoBase.getNomeCompleto());
	}
	
	@Test
	void testGetNomeContatoSemSobrenome() {
		this.contatoSec = new Contato("Amilton", "", "(81) 9901-0101");
		assertEquals("Amilton", this.contatoSec.getNomeCompleto());
	}

	@Test
	void testGetTelefoneContato() {
		assertEquals("(81) 99845-4545", this.contatoBase.getTelefoneContato());
	}
	
	/** Verifica se ocorre uma exceção ao criar contato com nome nulo */
	@Test
	public void testNomeNull() {
		try {
	    	Contato contatoInvalido = new Contato(null, "Gaudencio", "21010000");
	    	fail("Era esperado exceção ao passar código nulo");
		} catch (NullPointerException npe) {

		}
	}
	
	/** Verifica se ocorre uma exceção ao criar contato com sobrenome ou telefone nulo */
	@Test
	public void testParametrosNulos() {
		try {
			Contato contatoInvalido = new Contato("Amilton", null, "123123123");
			fail("Era esperado exceção ao passar código nulo");
		} catch (NullPointerException npe) {
		}
		try {
			Contato contatoInvalido = new Contato("Amilton", "Cristian", null);
			fail("Era esperado exceção ao passar código nulo");
		} catch (NullPointerException npe) {
		}
	}
	
	/** Verifica se ocorre uma exceção ao criar contato com nome ou telefone vazio ou só com espaços */
	@Test
	public void testStringsVazias() {
		try {
			Contato contatoBranco = new Contato("", "Cristian", "123123123");
			fail("Era esperado exceção ao passar parametros em branco");
		} catch (IllegalArgumentException iae) {
		}
		try {
			Contato contatoBranco = new Contato("     ", "Cristian", "123123123");
			fail("Era esperado exceção ao passar parametros em branco");
		} catch (IllegalArgumentException iae) {
		}
		try {
			Contato contatoBranco = new Contato("Amilton", "Cristian", "");
			fail("Era esperado exceção ao passar parametros em branco");
		} catch (IllegalArgumentException iae) {
		}
		try {
			Contato contatoBranco = new Contato("Amilton", "Cristian", "     ");
			fail("Era esperado exceção ao passar parametros em branco");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	/** Verifica se consegue alterar o telefone */
	@Test
	public void testAlterarTelefone() {
		assertEquals("(81) 99845-4545", contatoBase.getTelefoneContato());
		contatoBase.alterarTelefone("(+N) 0000-0000");
		assertEquals("(+N) 0000-0000", contatoBase.getTelefoneContato());
	}
	
	/** Verifica se ao alterar o telefone para nulo, é lançada uma exceção */
	@Test
	public void testAlterarTelefoneNulo() {
		try {
			contatoBase.alterarTelefone(null);
			fail("Era esperado exceção ao alterar telefone para um nulo");
		} catch (NullPointerException npe) {
		}
	}

	/** Verifica se ao alterar o telefone para vazio ou só com espaços, é lançada uma exceção */
	@Test
	public void testAlterarTelefoneVazio() {
		try {
			contatoBase.alterarTelefone("");
			fail("Era esperado exceção ao alterar telefone para vazio");
		} catch (IllegalArgumentException iae) {
		}
		try {
			contatoBase.alterarTelefone("     ");
			fail("Era esperado exceção ao alterar telefone para vazio");
		} catch (IllegalArgumentException iae) {
		}
	}

}
