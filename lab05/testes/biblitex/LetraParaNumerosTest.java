package biblitex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Testa o algoritmo de transformação
 */
class LetraParaNumerosTest {

	private LetraParaNumeros algoritmoBase = new LetraParaNumeros();

	/**
	 * Verifica se a transformação é feita como esperado
	 * Substitui algumas letras (tanto maiúscula quanto minúscula) por números.
 	 * O -> 0; i -> 1; e -> 3; a -> 4; s ->5.
	 */
	@Test
	void testTransforma() {
		assertEquals("0L4 M0N1T0R, C0M0 V0C3 35T4?", this.algoritmoBase.transforma("OLA MONITOR, COMO VOCE ESTA?"));
		assertEquals("0l4 m0n1t0r, c0m0 v0c3 35t4?", this.algoritmoBase.transforma("ola monitor, como voce esta?"));
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
		assertEquals("LetraParaNumeros", this.algoritmoBase.getNome());
	}

}
