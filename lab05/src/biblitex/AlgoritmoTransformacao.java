package biblitex;

/**
 * Uma interface para padronizar os diversos tipos de transformações de texto.
 */
public interface AlgoritmoTransformacao {

    /**
     * Transforma um texto em um novo texto.
     * @param original o texto original a ser transformado.
     * @return o texto transformado.
     */
    public String transforma(String original);

    /**
     * Retorna o nome da transformação
     * @return o nome do algoritmo de transformação.
     */
    public String getNome();
}