package biblitex;

/**
 * Logger baseado no ConsoleLogger, com diferencial de mostrar o momento que o método foi utilizado.
 * O momento é relacionado ao momento que o objeto foi criado.
 */
public class TimeConsoleLogger implements AlgoritmoLogger{

    /**
     * Imprime o método utilizado transforma, o momento e parâmetro invocado.
     * @param nomeTransformacao nome do algoritmo de transformação utilizado.
     */
    @Override
    public void transforma(String nomeTransformacao) {
        System.out.printf("[transforma - %.0fms] " + nomeTransformacao + "%n", tempoAtualAbreviado());
    }

    /**
     * Imprime o método utilizado contaTransformacao e o momento.
     */
    @Override
    public void contaTransformacao() {
        System.out.printf("[contaTransformacao - %.0fms]%n", tempoAtualAbreviado());
    }

    /**
     * Imprime o método utilizado historico, o momento e o indice usado.
     * @param indice o historico desejado.
     */
    @Override
    public void historico(int indice) {
        System.out.printf("[historico - %.0fms] %d%n", tempoAtualAbreviado(), indice);
    }

    /**
     * Retorna o momento que o método foi utilizado em relação o momento que o objeto foi criado.
     * Divide o momento para que seja exibido apenas uma abreviação de 2 números.
     * @return o momento que o método foi utilizado.
     */
    private double tempoAtualAbreviado() {
        double tempo = (double) System.currentTimeMillis() / 100000000000.0;
        return tempo;
    }

}
