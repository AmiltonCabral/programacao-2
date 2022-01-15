package biblitex;

/**
 * Transforma um texto em um novo texto.
 * Converte todos os pontos de interrogação em ponto final.
 */
public class ConverteInterrogacoesParaPontos implements AlgoritmoTransformacao {

	private final String NOME = "InterrogaPraPontos";

	/**
	 * Transforma o texto original e retorna o texto transformado.
	 */
	@Override
	public String transforma(String original) {
		if (original == null) {
			throw new NullPointerException("Mensagem a ser transformada não deve ser nula");
		}
		String novaFrase = "";
		String[] frase_arr = original.split("");
		
		for (String letra : frase_arr) {
			if(letra.equals("?")) {
				novaFrase += ".";
			} else {
				novaFrase += letra;
			}
		}
		return novaFrase;
	}

	/**
	 * Retorna o nome da transformação.
	 */
	@Override
	public String getNome() {
		return NOME;
	}

}
