package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.matheusgr.lunr.documento.DocumentoService;
import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.similaridade.SimilaridadeService;

class SimilaridadeServiceTest {
	
	private DocumentoService documentoService = new DocumentoService();
	private SimilaridadeService similaridadeService = new SimilaridadeService(documentoService);

	@BeforeEach
	void preparaTestes() {
	}

	/**
	 * Testa se o construtor funciona corretamente.
	 * O construtor deve receber um DocumentoService como parâmetro.
	 */
	@Test
	void testSimilaridadeService() {
		SimilaridadeService similaridadeService = new SimilaridadeService(documentoService);
	}


	@Test
	void testSimilaridade() {
		DocumentoController documentoController = new DocumentoController(documentoService);
		documentoController.adicionaDocumentoTxt("txt1", "Uma casa feliz é uma casa bonita");
		documentoController.adicionaDocumentoTxt("txt2", "Um dia feliz é um bom dia");
		assertEquals(0.2, similaridadeService.similaridade("txt1", "txt2"));
	}

	@Test
	void testSimilaridadeNenhumTermo() {
		DocumentoController documentoController = new DocumentoController(documentoService);
		documentoController.adicionaDocumentoTxt("txt1", "Uma");
		documentoController.adicionaDocumentoTxt("txt2", "Um");
		assertEquals(0, similaridadeService.similaridade("txt1", "txt2"));
	}

	@Test
	void testSimilaridadeUmTermo() {
		DocumentoController documentoController = new DocumentoController(documentoService);
		documentoController.adicionaDocumentoTxt("txt1", "Feliz");
		documentoController.adicionaDocumentoTxt("txt2", "Feliz");
		assertEquals(1, similaridadeService.similaridade("txt1", "txt2"));
	}
	
	@Test
	void testSimilaridadeExcecao() {
		DocumentoController documentoController = new DocumentoController(documentoService);
		documentoController.adicionaDocumentoTxt("txt1", "Uma casa feliz é uma casa bonita");
		try {
			similaridadeService.similaridade("txt1", "txt2");
			fail ("Era esperado exceção ao usar buscar um documento inexistente");
		} catch (UnsupportedOperationException uoe) {}
	}

}
