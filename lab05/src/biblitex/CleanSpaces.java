package biblitex;

/**
 * Transforma um texto em um novo texto.
 * Remove todos os espaços em branco.
 */
public class CleanSpaces implements AlgoritmoTransformacao{

	private final String NOME = "cleanSpaces";

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
			if(letra.equals(" ")) {
				continue;
			}
			novaFrase += letra;
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
