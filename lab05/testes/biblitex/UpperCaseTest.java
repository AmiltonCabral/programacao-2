package biblitex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Testa o algoritmo de transformação
 */
class UpperCaseTest {

	private UpperCase algoritmoBase = new UpperCase();

	/**
	 * Verifica se a transformação é feita como esperado
	 * Todas as letras devem estar em maiúsculo
	 */
	@Test
	void testTransforma() {
		assertEquals("OI, COMO VC VAI?", this.algoritmoBase.transforma("oi, como vc vai?"));
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
		assertEquals("upperCase", this.algoritmoBase.getNome());
	}

}
