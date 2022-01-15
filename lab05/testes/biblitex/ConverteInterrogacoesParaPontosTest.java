package biblitex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Testa o algoritmo de transformação
 */
class ConverteInterrogacoesParaPontosTest {

	private ConverteInterrogacoesParaPontos algoritmoBase = new ConverteInterrogacoesParaPontos();

	/**
	 * Verifica se a transformação é feita como esperado
	 * Pontos de interrogações devem ser convertidos para pontos finais.
	 */
	@Test
	void testTransforma() {
		assertEquals("oi, como vc vai.", this.algoritmoBase.transforma("oi, como vc vai?"));
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
		assertEquals("InterrogaPraPontos", this.algoritmoBase.getNome());
	}

}
