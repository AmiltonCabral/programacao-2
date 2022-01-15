package biblitex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Teste da classe que controla as transformações de texto
 */
class TransformaTextoTest {
	
	private TransformaTexto tt;
	private TransformaTexto ttcl;
	private AlgoritmoLogger cl;

	/**
	 * Cria um logger.
	 * Cria alguns objetos de transformação de texto, com ou sem logger
	 */
	@BeforeEach
	void preparaTransformaTexto() {
		this.cl = new ConsoleLogger();
		this.tt = new TransformaTexto();      //transforma texto normal
		this.ttcl = new TransformaTexto(cl);  //transforma texto com logger
	}
	
	/**
	 * Testa os construtores, com ou sem logger
	 */
	@Test
	void testTransformaTexto() {
		AlgoritmoLogger logger = new ConsoleLogger();
		TransformaTexto testeConstrutor = new TransformaTexto();
		TransformaTexto ConstrutorComLogger = new TransformaTexto(logger);
	}

	/**
	 * Testa o cadastramento de novas transformações de texto no controlador.
	 */
	@Test
	void testCadastraTransformacao() {
        AlgoritmoTransformacao meuAlgoritmo = new ConverteInterrogacoesParaPontos();
        tt.cadastraTransformacao("InterrogaPraPontos", meuAlgoritmo);
	}
	
	/**
	 * Testa se lança a exceção ao tentar cadastrar transformação de texto com nome nulo.
	 */
	@Test
	void testCadastraTransformacaoNomeNulo() {
		AlgoritmoTransformacao meuAlgoritmo = new ConverteInterrogacoesParaPontos();
		try {
			tt.cadastraTransformacao(null, meuAlgoritmo);
			fail ("Era esperado exceção ao cadastrar transformação com nome nulo");
		} catch(NullPointerException npe) {}
	}
	
	/**
	 * Testa se lança a exceção ao tentar cadastrar transformação de texto com objeto nulo.
	 */
	@Test
	void testCadastraTransformacaoObjetoNulo() {
		try {
			tt.cadastraTransformacao("InterrogaPraPontos", null);
			fail ("Era esperado exceção ao cadastrar transformação com objeto nulo");
		} catch(NullPointerException npe) {}
	}

	/**
	 * Testa a transformação de texto, com e sem logger.
	 */
	@Test
	void testTransforma() {
		assertEquals("oi como vc vai", tt.transforma("clean", "oi, como vc vai?"));
		assertEquals("oi como vc vai", ttcl.transforma("clean", "oi, como vc vai?"));
	}

	/**
	 * Verifica se cada transformação feita é contada corretamente.
	 */
	@Test
	void testContaTransformacao() {
		assertEquals(0, tt.contaTransformacao());
		tt.transforma("clean", "oi, como vc vai?");
		assertEquals(1, tt.contaTransformacao());
		tt.transforma("clean", "oi monitor, palmeiras nao tem mundial! kkk");
		tt.transforma("CaMeLcAsEfY", "sera que eu tiro uma nota boa");
		assertEquals(3, tt.contaTransformacao());
	}
	
	/**
	 * Verifica se cada transformação feita é contada corretamente com logger.
	 */
	@Test
	void testContaTransformacaoComLogger() {
		assertEquals(0, ttcl.contaTransformacao());
		ttcl.transforma("clean", "oi, como vc vai?");
		assertEquals(1, ttcl.contaTransformacao());
		ttcl.transforma("clean", "oi monitor, palmeiras nao tem mundial! kkk");
		ttcl.transforma("CaMeLcAsEfY", "sera que eu tiro uma nota boa");
		assertEquals(3, ttcl.contaTransformacao());
	}

	/**
	 * Verifica se o historico exibe corretamente o texto antigo,
	 *   o algoritmo de transformação usado e a nova transformação.
	 */
	@Test
	void testHistorico() {
		tt.transforma("clean", "oi, como vc vai?");
		assertEquals("oi, como vc vai? -> clean -> oi como vc vai", tt.historico(0));
	}
	
	/**
	 * Verifica se o historico exibe corretamente o texto antigo,
	 *   o algoritmo de transformação usado e a nova transformação utilizando um logger.
	 */
	@Test
	void testHistoricoComLogger() {
		ttcl.transforma("clean", "oi, como vc vai?");
		assertEquals("oi, como vc vai? -> clean -> oi como vc vai", ttcl.historico(0));
	}
	
	/**
	 * Verifica se é lançado uma exceção ao tentar verificar o historico utilizando um indice negativo.
	 */
	@Test
	void testHistoricoIndiceNegativo() {
		tt.transforma("clean", "oi, como vc vai?");
		try {
			tt.historico(-1);
			fail ("Era esperado exceção ao tentar acessar um item da lista com indice negativo");
		} catch (IllegalArgumentException iae) {}
	}

	/**
	 * Testa se todos os textos originais (antes da transformação) são armazenados corretamente.
	 * Repetições devem ser suprimidas
	 */
	@Test
	void testListarOriginais() {
		assertEquals("", tt.listarOriginais());
		tt.transforma("CaMeLcAsEfY", "eh, to sem criatividade :v");
		tt.transforma("clean", "eh, to sem criatividade :v");
		tt.transforma("clean", "Eh, To Sem Criatividade :v");
		assertEquals("eh, to sem criatividade :v\nEh, To Sem Criatividade :v", tt.listarOriginais());
	}

	/**
	 * Verifica se é exibido todas os algoritmos de transformação cadastrados.
	 * Deve esta listado em ordem alfabetica (maiúscula antes de minúscula).
	 */
	@Test
	void testListarTransformacoes() {
		assertEquals("CaMeLcAsEfY\nInterrogaPraPontos\nLetraParaNumeros\nclean\ncleanSpaces\nupperCase",
				tt.listarTransformacoes());
	}

}