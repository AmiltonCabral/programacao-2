package biblitex;

/**
 * Transforma um texto em um novo texto.
 * Substitui algumas letras (tanto maiúscula quanto minúscula) por números.
 * O -> 0; i -> 1; e -> 3; a -> 4; s ->5.
 */
public class LetraParaNumeros implements AlgoritmoTransformacao {

	private final String NOME = "LetraParaNumeros";

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
			// EAI CARA COMO ESTA?  //Exemplo pré transformação
			// EA1 C4R4 C0M0 E5T4?  //Esperado após a transformação
			if (letra.toLowerCase().equals("o")) {
				novaFrase += "0";
			} else if (letra.toLowerCase().equals("i")) {
				novaFrase += "1";
			} else if (letra.toLowerCase().equals("e")) {
				novaFrase += "3";
			} else if (letra.toLowerCase().equals("a")) {
				novaFrase += "4";
			} else if (letra.toLowerCase().equals("s")) {
				novaFrase += "5";
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
