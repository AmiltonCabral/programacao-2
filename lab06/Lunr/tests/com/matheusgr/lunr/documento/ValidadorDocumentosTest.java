package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

class ValidadorDocumentosTest {

	ValidadorDocumentos vd = new ValidadorDocumentos();
	String[] texto = {"Alo", "tenha", "bom", "dia"};

	@Test
	void testValidacaoArray() {
		vd.validacao("99", texto);
	}

	@Test
	void testValidacaoIdNulo() {
		try {
			vd.validacao(null, texto);
			Assert.fail("No NullPointerException");
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
	}

	@Test
	void testValidacaoIdVazio() {
		try {
			vd.validacao("", texto);
			Assert.fail("No IllegalArgumentException");
		} catch (Exception e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
		}
	}

	@Test
	void testValidacaoTextoNulo() {
		texto[1] = null;
		try {
			vd.validacao("10", texto);
			Assert.fail("No NullPointerException");
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
	}

	@Test
	void testValidacaoTextoVazio() {
		texto[1] = "";
		try {
			vd.validacao("99", texto);
			Assert.fail("No IllegalArgumentException");
		} catch (Exception e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
		}
	}

}
