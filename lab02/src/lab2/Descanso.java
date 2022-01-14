package lab2;

/**
 * Representa a rotina de descanso de um aluno. Todo aluno precisa descansar pelo menos 26 horas por semana, excluindo horas de sono.
 * 
 * @author Amilton Cristian
 */
public class Descanso {

	/**
	 * Quantas horas o aluno descansou até o momento.
	 */
	private int horasDescansadasDoAluno;

	/**	
	 * Quantas semanas desde o inicio dos registros.
	 */
	private int numeroDeSemanasRegistradas;

	/**
	 * Só é possível ter dois valores, "cansado" ou "descansado", para indicar o status do aluno.
	 */
	private String statusDescansoDoAluno;

	/**
	 * Guarda o emoji da sensação do aluno, se o status do aluno mudar, o emoji é descartado.
	 */
	private String emojiUltimaSensacaoDoAluno;

	/**
	 * Constrói os dados de descanso de um aluno.
	 * Por padrão as horas de descanso do aluno começam zeradas.
	 * Por padrão as semanas registradas começam pela primeira semana.
	 * Por padrão o status inicial do aluno é "cansado".
	 */
	public Descanso() {
		this.horasDescansadasDoAluno = 0;
		this.numeroDeSemanasRegistradas = 0;
		this.statusDescansoDoAluno = "cansado";
		this.emojiUltimaSensacaoDoAluno = "";
	}

	/**
	 * Verifica se o número de semanas é maior que zero, só então prossegue.
	 * Verifica quantas horas o aluno descansou, se essa hora for igual ou maior a 26, o status do aluno se torna "descansado". Caso contrário "cansado".
	 */
	private void atualizarStatusDeDescanso() {
		if (this.numeroDeSemanasRegistradas > 0) {	
			if (this.horasDescansadasDoAluno / this.numeroDeSemanasRegistradas >= 26 & !this.statusDescansoDoAluno.equals("descansado")) {
				this.statusDescansoDoAluno = "descansado";
				this.emojiUltimaSensacaoDoAluno = "";
			} else if (this.horasDescansadasDoAluno / this.numeroDeSemanasRegistradas < 26 & !this.statusDescansoDoAluno.equals("cansado")){
				this.statusDescansoDoAluno = "cansado";
				this.emojiUltimaSensacaoDoAluno = "";
			}
		}
	}

	/**
	 * Define quantas horas o aluno descansou.
	 * 
	 * @param horasDescansadas As horas que o aluno descansou.
	 */
	public void defineHorasDescanso(int horasDescansadas) {
		this.horasDescansadasDoAluno = horasDescansadas;
		atualizarStatusDeDescanso();
	}

	/**
	 * Define quantas semanas foram registradas.
	 * 
	 * @param semanasRegistradas As semanas registradas.
	 */
	public void defineNumeroSemanas(int semanasRegistradas) {
		this.numeroDeSemanasRegistradas = semanasRegistradas;
		atualizarStatusDeDescanso();
	}

	/**
	 * Define o emoji da sensação do aluno. O emoji pode ser substituído por outro ou ser descartado posteriormente.
	 * 
	 * @param setEmoji o emoji escolhido.
	 */
	public void definirEmoji(String setEmoji) {
		this.emojiUltimaSensacaoDoAluno = setEmoji;
	}

	/**
	 * Retorna o status de descanso do aluno. Os únicos status possívels são "cansado" e "descansado".
	 * 
	 * @return o status do aluno.
	 */
	public String getStatusGeral() {
		if (this.emojiUltimaSensacaoDoAluno.length() > 0) {
			return this.statusDescansoDoAluno +" - "+ emojiUltimaSensacaoDoAluno;
		}
		return this.statusDescansoDoAluno;
	}

}
