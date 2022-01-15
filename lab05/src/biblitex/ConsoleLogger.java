package biblitex;

/**
 * Imprime qual o método e parâmetro invocado.
 */
public class ConsoleLogger implements AlgoritmoLogger{

    /**
     * Imprime o método utilizado transforma e parâmetro invocado.
     * @param nomeTransformacao nome do algoritmo de transformação utilizado.
     */
    @Override
    public void transforma(String nomeTransformacao) {
        System.out.println("[transforma] " + nomeTransformacao);
    }

    /**
     * Imprime o método utilizado contaTransformacao.
     */
    @Override
    public void contaTransformacao() {
        System.out.println("[contaTransformacao]");
    }

    /**
     * Imprime o método utilizado historico e o indice usado.
     * @param indice o historico desejado.
     */
    @Override
    public void historico(int indice) {
        System.out.println("[historico] " + indice);
    }

}
