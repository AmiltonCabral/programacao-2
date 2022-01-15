package biblitex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Testa o algoritmo de transformação
 */
class CaMeLcAsEfY_Test {
	
	private CaMeLcAsEfY algoritmoBase = new CaMeLcAsEfY();

	/**
	 * Verifica se a transformação é feita como esperado
	 * As letras em posições pares devem ser convertidas para maiúsculas
	 * As letras em posições ímpares devem ser convertidas para minúsculas
	 */
	@Test
	void testTransforma() {
		assertEquals("Oi, CoMo vC VaI?", this.algoritmoBase.transforma("oi, como vc vai?"));
	}

	/**
	 * Verifica se lança exceção ao tentar transformar objeto nulo
	 */
	@Test
	void testTransformaNull() {
		try {
			this.algoritmoBase.transforma(null);
			fail ("Era esperado exceção ao tentar transformar texto nulo");
		} catch (NullPointerException npe) {}
	}
	
	/**
	 * Verifica se o nome está correto
	 */
	@Test
	void testGetNome() {
		assertEquals("CaMeLcAsEfY", this.algoritmoBase.getNome());
	}

}
