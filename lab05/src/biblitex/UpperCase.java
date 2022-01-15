package biblitex;

/**
 * Transforma um texto em um novo texto.
 * Deixa todo o texto em maiúsculo.
 */
public class UpperCase implements AlgoritmoTransformacao{
	
	private final String NOME = "upperCase";

	/**
	 * Transforma o texto original e retorna o texto transformado.
	 */
	@Override
	public String transforma(String original) {
		if (original == null) {
			throw new NullPointerException("Mensagem a ser transformada não deve ser nula");
		}
		return original.toUpperCase();
	}

	/**
	 * Retorna o nome da transformação.
	 */
	@Override
	public String getNome() {
		return NOME;
	}

}
