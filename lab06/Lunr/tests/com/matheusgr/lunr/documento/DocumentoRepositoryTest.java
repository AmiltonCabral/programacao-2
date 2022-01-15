package com.matheusgr.lunr.documento;


import java.util.Map;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.matheusgr.lunr.busca.BuscaController;
import com.matheusgr.similaridade.SimilaridadeController;

class DocumentoRepositoryTest {

	DocumentoController documentoController;
	BuscaController buscaController;
	SimilaridadeController similaridadeController;

	DocumentoRepository dr = new DocumentoRepository();
	Map.Entry<String, String> md;

	@Test
	void preparaMetadado() {
		Map<String, String> metadados = new HashMap<>();
		metadados.put("TIPO", "txt");
		metadados.put("LINHAS", "1");
		for (Map.Entry<String, String> metadado : metadados.entrySet()) {
			testBuscaMetadado(metadado);
		}
	}

	void testBuscaMetadado(Map.Entry<String, String> metadado) {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
	}

}
