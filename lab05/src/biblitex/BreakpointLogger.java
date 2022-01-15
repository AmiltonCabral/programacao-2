package biblitex;

/**
 * Um método é escolhido na construção do objeto.
 * Sempre que esse método for invocado, o logger avisa que o método foi utilizado.
 */
public class BreakpointLogger implements AlgoritmoLogger{

    private String metodoEspecifico;

    /**
     * Cria o logger, e armazena o método escolhido.
     * @param metodoEspecifico o método escolhido.
     */
    public BreakpointLogger(String metodoEspecifico) {
        this.metodoEspecifico = metodoEspecifico;
    }

    /**
     * Se o método transforma for o escolhido, sempre que o método for invocado será impresso um aviso.
     * @param nomeTransformacao não é utilizado nesse logger em específico.
     */
    @Override
    public void transforma(String nomeTransformacao) {
        if (this.metodoEspecifico.equals("transforma")) {
            System.out.println("[INVOCADO - transforma]");
        }
    }

    /**
     * Se o método contaTransformacao for o escolhido, sempre que o método for invocado será impresso um aviso.
     */
    @Override
    public void contaTransformacao() {
        if (this.metodoEspecifico.equals("contaTransformacao")) {
            System.out.println("[INVOCADO - contaTransformacao]");
        }
    }

    /**
     * Se o método historico for o escolhido, sempre que o método for invocado será impresso um aviso.
     * @param indice não é utilizado nesse logger em específico.
     */
    @Override
    public void historico(int indice) {
        if (this.metodoEspecifico.equals("historico")) {
            System.out.println("[INVOCADO - historico]");
        }
    }

}
