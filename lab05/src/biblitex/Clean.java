package biblitex;

import java.util.Arrays;
import java.util.List;

/**
 * Transforma um texto em um novo texto.
 * Remove todos os sinais de pontuação.
 * Sinais de pontuação:  . , : ; ! ? ( ) ' —  ...
 */
public class Clean implements AlgoritmoTransformacao {

	private final String NOME = "clean";    
    private List<String> sinaisDePontuacao = Arrays.asList(
            ".", ",", ":", ";", "!", "?", "(", ")", "'", "—");

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
            if(sinaisDePontuacao.contains(letra)) {
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
