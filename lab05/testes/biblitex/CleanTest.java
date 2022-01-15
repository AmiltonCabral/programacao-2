package biblitex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Testa o algoritmo de transformação
 */
class CleanTest {

	private Clean algoritmoBase = new Clean();

	/**
	 * Verifica se a transformação é feita como esperado
	 * Devem ser removidos todos os sinais de pontuação
	 */
	@Test
	void testTransforma() {
		assertEquals("oi como vc vai", this.algoritmoBase.transforma("oi, como vc vai?"));
	}

	/**
	 * Verifica se lança exceção ao tentar transformar objeto nulo
	 */
	@Test
	void testTransformaNull() {
		try {
			this.algoritmoBase.transforma(null);
			fail ("Era esperado exceção ao tentar transformar texto nulo");
		} catch(NullPointerException npe) {}
	}
	
	/**
	 * Verifica se o nome está correto
	 */
	@Test
	void testGetNome() {
		assertEquals("clean", this.algoritmoBase.getNome());
	}

}
