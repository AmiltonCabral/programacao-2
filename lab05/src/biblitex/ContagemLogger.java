package biblitex;

/**
 * Sempre que um método é utilizado, é adicionado +1 a contagem de vezes que o método foi utilizado.
 * É possível ver quantas vezes os métodos foram invocados, utilizando o método toString.
 */
public class ContagemLogger implements AlgoritmoLogger{

    private int[] armazenamentoLogger = new int[3];

    /**
     * Adiciona +1 em quantas vezes o método transforma foi utilizado.
     * @param nomeTransformacao não utilizado nesse logger em específico.
     */
    @Override
    public void transforma(String nomeTransformacao) {
        armazenamentoLogger[0] ++;
    }

    /**
     * Adiciona +1 em quantas vezes o método contaTransformacao foi utilizado.
     */
    @Override
    public void contaTransformacao() {
        armazenamentoLogger[1] ++;
    }

    /**
     * Adiciona +1 em quantas vezes o método historico foi utilizado.
     * @param indice não utilizado nesse logger em específico.
     */
    @Override
    public void historico(int indice) {
        armazenamentoLogger[2] ++;
    }

    /**
     * Se o método foi utilizado ao menos uma vez, é impresso o método utilizado e quantas vezes ele foi utilizado
     */
    @Override
    public String toString() {
        String strRetorno = "";
        if (armazenamentoLogger[0] > 0) {
            strRetorno += "transforma - " + armazenamentoLogger[0];
        }
        if (armazenamentoLogger[1] > 0) {
            if (!strRetorno.isEmpty()) {
                strRetorno += "\n";
            }
            strRetorno += "contaTransformacao - " + armazenamentoLogger[1];
        }
        if (armazenamentoLogger[2] > 0) {
            if (!strRetorno.isEmpty()) {
                strRetorno += "\n";
            }
            strRetorno += "historico - " + armazenamentoLogger[2];
        }
        return strRetorno;
    }

}
