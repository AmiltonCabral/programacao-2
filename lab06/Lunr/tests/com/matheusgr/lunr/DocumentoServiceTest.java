package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.documento.DocumentoService;

class DocumentoServiceTest {
	
	DocumentoService ds = new DocumentoService();
	Map<String, String> metadadoMap = new HashMap<>();
	

	@BeforeEach
	void preparaDocumentoService() {
	}

	// Testa se recebe nenhum documento ao buscar por nenhum metadado
	@Test
	void testBuscaNenhumMetadado() {
		for (Map.Entry<String, String> metadado : metadadoMap.entrySet()) {
			assertEquals(0, ds.busca(metadado).size());
		}
	}

}
