package lab2;

/** 
 * Registra o tempo que um aluno passa estudando online para uma disciplina, contém o nome da disciplina, a carga horaria da disciplina e quantas horas ele estudou até o momento.
 * 
 * @author Amilton Cristian
 */
public class RegistroTempoOnline {

    /** 
     * Nome da disciplina, usado para identificar a disciplina correta.
     */
    private String nomeDaDisciplina;

    /**
     * Define quantas horas o aluno precisa atingir nessa disciplina.
     */
    private int cargaHorariaDaDisciplina;

    /**
     * Quantas horas o aluno estudou até o momento.
     */
    private int horasOnlineNaDisciplina;

    /**
     * Constrói um registro de tempo a partir do nome da disciplina.
     * Por padrão, a carga horaria da disciplina começa por 120, que é o dobro da carga horaria de 60 horas.
     * As horas online dedicadas na disciplina começa zerada por padrão.
     * 
     * @param nomeParaDisciplina Define o nome da disciplina
     */
    public RegistroTempoOnline(String nomeParaDisciplina) {
        this.nomeDaDisciplina = nomeParaDisciplina;
        this.cargaHorariaDaDisciplina = 120;
        this.horasOnlineNaDisciplina = 0;
    }

    /**
     * Constrói um registro de tempo a partir do nome da disciplina, e a carga horaria esperada da disciplina.
     * As horas online dedicadas na disciplina começa zerada por padrão.
     * 
     * @param nomeParaDisciplina Define o nome da disciplina.
     * @param tempoOnlineEsperado Define a carga horaria da disciplina.
     */
    public RegistroTempoOnline (String nomeParaDisciplina, int tempoOnlineEsperado) {
        this.nomeDaDisciplina = nomeParaDisciplina;
        this.cargaHorariaDaDisciplina = tempoOnlineEsperado;
        this.horasOnlineNaDisciplina = 0;
    }

    /**
     * Adiciona horas de estudo, essas horas adicionadas são cumulativas
     * 
     * @param tempoParaAdicionar As horas para serem adicionadas
     */
    public void adicionaTempoOnline(int tempoParaAdicionar) {
        this.horasOnlineNaDisciplina += tempoParaAdicionar;
    }

    /**
     * Verifica se o tempo online na disciplina atingiu o esperado.
     * 
     * @return verdade se a carga horaria foi atingida, e falso caso contrário.
     */
    public boolean atingiuMetaTempoOnline() {
        if (this.horasOnlineNaDisciplina >= this.cargaHorariaDaDisciplina) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna os status da carga horaria da disciplina alcançada.
     * Retorna no formato "Nome da disciplina x/y" onde x é quanto tempo o aluno passou online estudando e y a carga horaria da disciplina.
     * 
     * @return uma f-string contendo status da disciplina.
     */
    public String toString() {
        return String.format("%s %d/%d", this.nomeDaDisciplina, this.horasOnlineNaDisciplina, this.cargaHorariaDaDisciplina);
    }

}
