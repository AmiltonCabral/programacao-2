package biblitex;

/**
 * Uma interface para padronizar os diversos tipos de transformações de texto
 */
public interface AlgoritmoLogger {

    /**
     * Invoca o logger referente ao método transforma.
     * @param nomeTransformacao o nome do algoritmo de transformação utilizado pelo método transforma.
     */
    public void transforma(String nomeTransformacao);

    /**
     * Invoca o logger referente ao método contaTransformacao.
     */
    public void contaTransformacao();

    /**
     * Invoca o logger referente ao método historico.
     * @param indice o indice utilizado para encontrar o histórico de transformação desejado.
     */
    public void historico(int indice);
}
