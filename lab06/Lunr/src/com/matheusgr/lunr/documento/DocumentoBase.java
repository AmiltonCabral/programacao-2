package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.Map;
import biblitex.TransformaTexto;
import java.util.Objects;

/**
 * DocumentoBase é uma superclasse abstrata para as classes Documento.
 */
public abstract class DocumentoBase implements Documento {

    protected String id;
	protected String original;
	protected String limpo;
	protected Map<String, String> metadados;
	protected String[] split;

    /**
     * Construtor padrão para parametros genericos.
     * @param id ID do documento a ser criado.
     * @param original texto original a ser processado.
     */
    public DocumentoBase(String id, String original) {
        this.id = id;
		this.original = original;
    }

    @Override
    public double metricaTextoUtil() {
        long extractedSize = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanSpaces, this.limpo)
        .length();
        return (1.0 * extractedSize) / this.original.length();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String[] getTexto() {
        if (this.split == null) {
			this.split = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanLines, this.limpo)
					.split(" ");
			Arrays.sort(this.split);
		}
		return this.split;
    }

    /**
     * Linhas de código generica, é utilizada por todos os documentos.
     * Auxilia os métodos getMetadados() das classes filhas.
     * Evita a repetição de código.
     */
    protected void getMetadadosAux() {
        this.metadados.put("LINHAS", "" + this.original.chars().filter((value) -> '\n' == value).count());
		this.metadados.put("TAMANHO", "" + this.limpo.length());
		this.metadados.put("METADATADATE", "" + System.currentTimeMillis());
    }

    public int hashCode() {
		return Objects.hash(id);
	}

    public String toString() {
		return "===" + this.id + System.lineSeparator() + this.limpo;
	}

}
