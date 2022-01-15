package com.matheusgr.lunr.busca;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidadorBuscaTest {

	private ValidadorBusca vb = new ValidadorBusca();
	private Map<String, String> metadados = new HashMap<>();


	@BeforeEach
	void preparaTestes() {
		metadados.put("TIPO", "txt");
		metadados.put("LINHAS", "1");
	}

	/**
	 * Verifica se em uma validação padrão não ocorre nenhum erro.
	 * É o teste mais simples.
	 */
	@Test
	void testValidaMetadado() {
		vb.valida(metadados);
	}
	
	@Test
	void testValidaMetadadoKeyVazia() {
		metadados.clear();
		metadados.put("", "java");
		try {
			vb.valida(metadados);
			Assert.fail("No IllegalArgumentException");
		} catch (Exception e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
		}
	}

	@Test
	void testValidaMetadadoValueVazia() {
		metadados.clear();
		metadados.put("TIPO", "");
		try {
			vb.valida(metadados);
			Assert.fail("No IllegalArgumentException");
		} catch (Exception e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
		}
	}

	@Test
	void testValidaMetadadoNulo() {
		metadados = null;
		try {
			vb.valida(metadados);
			Assert.fail("No NullPointerException");
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
	}

}
