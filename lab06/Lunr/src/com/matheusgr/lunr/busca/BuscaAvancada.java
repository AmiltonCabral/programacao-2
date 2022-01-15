package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * BuscaAvancada realiza uma operação de busca a partir de metadados.
 * 
 * A busca avançada deve selecionar TODOS os documentos
 * que tenham TODOS OS METADADOS indicados.
 * 
 * Quanto mais termos da busca estão presentes, mais relevância tem o documento.
 * 
 * Não é necessário ordenar os resultados retornados,
 * nem limitar a quantidade de respostas.
 * 
 * Os documentos que não tem nenhum dos termos pesquisados, não devem ser
 * retornados.
 */
class BuscaAvancada implements Busca {

	private Map<String, String> metadados;

	/**
	 * Construtor padrão com os termos a serem encontrados.
	 * 
	 * Os termos não vazios são ignorados. Pelo menos 1 termo deve ser não vazio.
	 * 
	 * @param termos Termos a serem pesquisados.
	 */
	public BuscaAvancada(Map<String, String> metadados) {
		(new ValidadorBusca()).valida(metadados);
		this.metadados = metadados;
	}

	/**
	 * Realiza a busca a partir da consulta ao DocumentoService.
	 * 
	 * O DocumentoService realiza apenas operações simples de busca, mas sem
	 * ordenação ou tratamento da lógica de relevância.
	 * 
	 * A busca avançada deve selecionar TODOS os documentos
	 * que tenham TODOS OS METADADOS indicados.
	 * 
	 * @param ds DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados e o fator de relevância de cada
	 *         operação.
	 */
	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> qtdMetadadosDocumento = new HashMap<>();
		boolean primeiroMetadado = true;
		for (Map.Entry<String, String> metadado : this.metadados.entrySet()) {
			if (metadado.getKey().isBlank() || metadado.getValue().isBlank()) 
				continue;

			for (Documento doc : ds.busca(metadado)) {
				if (primeiroMetadado) {
					qtdMetadadosDocumento.put(doc, 1);
					continue;
				}
				if (qtdMetadadosDocumento.containsKey(doc))
					qtdMetadadosDocumento.put(doc, qtdMetadadosDocumento.get(doc) + 1);
			}
			primeiroMetadado = false;
		}
		return docComTodosMetadados(qtdMetadadosDocumento);
	}
	
	/**
	 * Recebe um mapa com os documentos e quantos metadados foram encontrados no doc.
	 * De acordo com a quantidade de metadados, seleciona os documentos que atende todos.
	 * Os documentos que não contém todos os metadados são descartados.
	 * 
	 * @param qtdMetadadosDocumento um mapa contendo os Documentos e Integer de quantos 
	 * 								metadados foram atendidos.
	 * @return apenas os documentos que atendem todos os metadados.
	 */
	private Map<Documento, Integer> docComTodosMetadados(Map<Documento, Integer> qtdMetadadosDocumento) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		for (Map.Entry<Documento, Integer> doc : qtdMetadadosDocumento.entrySet()) {
			if (doc.getValue() == this.metadados.size())
				respostaDocumento.put(doc.getKey(), respostaDocumento.getOrDefault(doc, 0) + 1);
		}
		return respostaDocumento;
	}
	
	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descrição da busca, onde cada linha representa um parâmetro de busca
	 *         e as colunas representam um detelhamento de cada parâmetro.
	 */
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.metadados.size()][];
		int i = 0;
		for (Map.Entry<String, String> metadado : metadados.entrySet()) {
			resultado[i] = new String[] {"TERMO " + (i + 1),
			"<" + metadado.getKey() + ", " + metadado.getValue() + ">"};
			i++;
		}
		return resultado;
	}

}