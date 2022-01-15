package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.lunr.documento.DocumentoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoControllerTest {

	private DocumentoService ds = new DocumentoService();
	private DocumentoController dc = new DocumentoController(ds);

	@BeforeEach
	void preparaTestes() {
	}
	
	@Test
	void testTotalDocumentos() {
		var exemplo = new DocumentoExemplos();
		assertEquals(0, dc.totalDocumentos());

		dc.adicionaDocumentoHtml("1", exemplo.sampleHTML());
		assertEquals(1, dc.totalDocumentos());

		dc.adicionaDocumentoHtml("2", exemplo.sampleJava());
		assertEquals(2, dc.totalDocumentos());

		dc.adicionaDocumentoTxt("3", "um arquivo! texto simples.\r\nuse DUAS linhas apenas.");
		dc.adicionaDocumentoTxt("4", "um arquivo! texto simples.\r\nuse TRÊS linhas agora.\r\nMAIS AVANÇO!");
		assertEquals(4, dc.totalDocumentos());
	}
	
	@Test
	void testConcatenaDocumentos() {
		var exemplo = new DocumentoExemplos();
		dc.adicionaDocumentoTxt("1", "um arquivo!\r\n");
		dc.adicionaDocumentoTxt("2", "um arquivo!\r\nMAIS AVANÇO!");

		String novoId = dc.concatenaDocumentos("1", "2");
		String textoEsperado = "===_MERGE1|2\nAVANÇOMAISarquivoumAVANÇOMAISarquivoum";
		assertEquals(textoEsperado, dc.recuperarDocumento(novoId).get().toString());
	}

}
