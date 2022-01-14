package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TagTest {
	
	private Tag tagBase;
	
	/** Cria uma tag */
	@BeforeEach
	void preparaTag() {
		this.tagBase = new Tag();
	}

	/** Verifica se o get tags retorna todas as tags separadas por espaço em ordem de índice */
	@Test
	void testGetTags() {
		assertEquals("", this.tagBase.getTags());
		this.tagBase.setTag("CCC", 4);
		assertEquals("CCC", this.tagBase.getTags());
		this.tagBase.setTag("Professor", 0);
		assertEquals("Professor CCC", this.tagBase.getTags());
	}
	
	/** Verifica se a tag passa a existir quando criada, ou não existe quando removida */
	@Test
	void testExisteTag() {
		assertFalse(this.tagBase.existeTag("CCC"));
		this.tagBase.setTag("CCC", 2);
		this.tagBase.setTag("ADM", 3);
		assertTrue(this.tagBase.existeTag("CCC"));
		this.tagBase.removerTag(2);
		assertFalse(this.tagBase.existeTag("CCC"));
	}

}
