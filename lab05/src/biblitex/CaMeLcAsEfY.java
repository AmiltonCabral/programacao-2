package biblitex;

/**
 * Transforma um texto em um novo texto.
 * Os caracteres nas posições pares ficam em maiúsculo.
 * Os caracteres nas posições ímpares ficam em minúsculo.
 */
public class CaMeLcAsEfY implements AlgoritmoTransformacao {

	private final String NOME = "CaMeLcAsEfY";

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

		for (int i=0; i<frase_arr.length; i++) {
			if(i%2 == 1) {
				novaFrase += frase_arr[i].toLowerCase(); //Par
			} else {
				novaFrase += frase_arr[i].toUpperCase(); //Impar
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
