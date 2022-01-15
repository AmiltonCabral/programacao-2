package com.matheusgr.similaridade;

import com.matheusgr.lunr.documento.DocumentoService;

import java.util.HashSet;
import java.util.Set;
import java.util.Optional;
import com.matheusgr.lunr.documento.Documento;

/**
 * Componente para tratamento da lógica de negócio relativa a similaridade.
 */
public class SimilaridadeService {

	private DocumentoService documentoService;

	/**
	 * Inicialização da lógica de serviço.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         SimilaridadeService.
	 */
	public SimilaridadeService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	/**
	 * Calcula e retorna a similaridade.
	 * 
	 * Para o cálculo da similaridade:
	 * <ul>
	 * <li>Pega o documento 1</li>
	 * <li>Pega o documento 2</li>
	 * <li>Pega os termos do documento 1 e coloca em um conjunto (Termos1)</li>
	 * <li>Pega os termos do documento 2 e coloca em um conjunto (Termos2)</li>
	 * <li>Calcula a interseção entre Termos1 e Termos2 (Inters)</li>
	 * <li>Calcula a união entre Termos1 e Termos2 (Uniao)</li>
	 * <li>A similaridade é o tamanho de Inters sobre o tamanho do conjunto
	 * Uniao</li>
	 * </ul>
	 * 
	 * @param docId1 Documento 1.
	 * @param docId2 Documento 2.
	 * @return Valor de similaridade (entre 0 e 1, inclusives) representando a
	 *         semelhança entre os documentos.
	 */
	public double similaridade(String docId1, String docId2) {
		String[] doc1 = getTexto(docId1);
		String[] doc2 = getTexto(docId2);
		return (double) intersecao(doc1, doc2) / uniao(doc1, doc2);
	}

	/**
	 * Recebe o ID de um documento e retorna um array de string contendo os termos.
	 * Lança exceção se o ID for incorreto.
	 * @param docId1 id do documento a ser buscado no documento service.
	 * @return o array contendo os termos do documento.
	 */
	private String[] getTexto(String docId1) {
		Optional<Documento> doc = this.documentoService.recuperaDocumento(docId1);
		if (doc.isPresent()) {
			return doc.get().getTexto();
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * Faz a interseção dos dermos de A e B.
	 * Uma interseção deve pegar os termos que existem simultaneamente em A e B.
	 * Para garantir que não existe termos repetidos é usado um HashSet.
	 * @param termosA um array de strings com termos do conjunto A.
	 * @param termosB um array de strings com termos do conjunto B.
	 * @return o tamanho da interseção do conjunto A e B.
	 */
	private int intersecao(String[] termosA, String[] termosB) {
		Set<String> conjuntoSet = new HashSet<>();
		for (String palavraA : termosA) {
			for (String palavraB : termosB) {
				if (palavraA.equals(palavraB))
					conjuntoSet.add(palavraB);
			}
		}
		return conjuntoSet.size();
	}

	/**
	 * Faz a união dos dermos de A e B.
	 * Uma união deve juntar os termos que existem em A e B, desde que...
	 *         ...os termos não se repitam.
	 * Para garantir que não existe termos repetidos é usado um HashSet.
	 * @param termosA um array de strings com termos do conjunto A.
	 * @param termosB um array de strings com termos do conjunto B.
	 * @return o tamanho da união do conjunto A e B.
	 */
	private int uniao(String[] termosA, String[] termosB) {
		Set<String> conjuntoSet = new HashSet<>();
		for (String palavra : termosA)
			conjuntoSet.add(palavra);
		for (String palavra : termosB)
			conjuntoSet.add(palavra);
		return conjuntoSet.size();
	}

}