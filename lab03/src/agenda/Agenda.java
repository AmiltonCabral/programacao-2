package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	
	private String[] contatos;
	private Contato[] dadosContatos;
	private Tag[] tags;
	private int[] contatosFavoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new String[TAMANHO_AGENDA];
		this.dadosContatos = new Contato[TAMANHO_AGENDA];
		this.contatosFavoritos = new int[TAMANHO_FAVORITOS];
		this.tags = new Tag[TAMANHO_AGENDA];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public String[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		return contatos[posicao-1];
	}

	/**
	 * Remove o contato da agenda.
	 * Se o contato estiver na lista de favoritos, também será removido.
	 * @param posicao do contato a ser removido.
	 */
	public void removerContato(int posicao) {
		this.contatos[posicao-1] = null;
		this.dadosContatos[posicao-1] = null;
		for (int i=0; i<contatosFavoritos.length; i++) {
			if (contatosFavoritos[i] == posicao) {
				contatosFavoritos[i] = 0;
			}
		}
	}

	/**
	 * Retorna o nome do contato.
	 * @param posicao do contato.
	 * @return o nome.
	 */
	public String getNomeContato(int posicao) {
		return this.contatos[posicao-1];
	}

	/**
	 * Retorna o sobrenome do contato.
	 * @param posicao do contato.
	 * @return o sobrenome.
	 */
	public String getSobrenomeContato(int posicao) {
		return dadosContatos[posicao-1].getSobrenome();
	}

	/**
	 * Se o contato existir, envia o nome e sobrenome separado por um espaço, caso exista um sobrenome.
	 * Caso o contato não exista, envia uma String vazia.
	 * @param posicao do contato.
	 * @return uma String vazia ou nome completo.
	 */
	public String getNomeCompleto(int posicao) {
		if (dadosContatos[posicao-1] == null) {
			return "";
		}
		return dadosContatos[posicao-1].getNomeCompleto();
	}

	/**
	 * Envia o nome completo de um contato mais o número de telefone separado por uma quebra de linha.
	 * @param posicao do contato.
	 * @return o contato formatado.
	 */
	public String exibirContato(int posicao) {
		return getNomeCompleto(posicao) + "\n" + dadosContatos[posicao-1].getTelefoneContato();
	}

	/**
	 * Retorna uma cópia dos favoritos.
	 * @return array de inteiros, contendo a posição dos contatos favoritos.
	 */
	public int[] getFavoritos() {
        return this.contatosFavoritos.clone();
    }

	/**
	 * Retorna o índice do contato, de acordo com seu índice na lista dos favoritos.
	 * @param indice do favorito.
	 * @return índice do contato.
	 */
	public int getFavorito(int indice) {
		return this.contatosFavoritos[indice-1];
	}

	/**
	 * Define um índice de contato como favorito, de acordo com o índice escolhido para os favoritos.
	 * @param posicaoContato índice do contato.
	 * @param posicaoFavorito índice para lista de favoritos.
	 */
	public void setFavorito(int posicaoContato, int posicaoFavorito) {
		contatosFavoritos[posicaoFavorito-1] = posicaoContato;
	}

	/**
	 * Remove um contato dos favoritos.
	 * @param posicaoFavorito índice dos favoritos.
	 */
	public void removerFavorito(int posicaoFavorito) {
		this.contatosFavoritos[posicaoFavorito-1] = 0;		
	}

	/**
	 * Recebe a posicao de um contato e verifica se esse contato esta favoritado.
	 * 
	 * @param posicaoContato a posicao do contato na agenda
	 * @return true se for contato favorito, false caso contrário.
	 */
	public boolean ehFavorito(int posicaoContato) {
		for (int i=0; i<contatosFavoritos.length; i++) {
			if (contatosFavoritos[i] == posicaoContato) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adiciona uma tag ao contato, cada contato pode ter até 5 tags.
	 * @param nome da tag.
	 * @param posicaoContato a posição do contato que vai receber a tag.
	 * @param posicaoTag a posição da tag, pois podemos ter até 5 tags.
	 */
	public void adicionaTag(String nome, int posicaoContato, int posicaoTag) {
		if (tags[posicaoContato-1] == null) {
			tags[posicaoContato-1] = new Tag();
		}
		this.tags[posicaoContato-1].setTag(nome, posicaoTag-1);
	}

	/**
	 * Retorna todas as tags do contato escolhido, as tags são separadas por espaços.
	 * @param posicao do contato.
	 * @return as tags formatadas.
	 */
	public String exibirTags(int posicao) {
		return this.tags[posicao-1].getTags();
	}

	/**
	 * Verifica se o contato escolhido tem tag(s).
	 * @param posicao do contato.
	 * @return true se tiver tags, false caso contrário.
	 */
	public boolean temTags(int posicao) {
		if (this.tags[posicao-1] == null) {
			return false;
		}
		return true;
	}

	/**
	 * Verifica se uma tag pertence a um contato.
	 * @param posicaoContato índice do contato.
	 * @param tagBusca a tag a ser verificada.
	 * @return true caso a tag pertença a o contato, false caso contrário.
	 */
	public boolean ehTagDoContato(int posicaoContato, String tagBusca) {
		if (!temTags(posicaoContato)) {
			return false;
		} else if (tags[posicaoContato-1].existeTag(tagBusca)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Altera o número de telefone de um contato.
	 * @param posicao índice do contato.
	 * @param novoTelefone o novo número de telefone para o contato.
	 */
	public void alterarTelefone(int posicao, String novoTelefone) {
		this.dadosContatos[posicao-1].alterarTelefone(novoTelefone);
	}

	/**
	 * Remove uma tag de um contato.
	 * @param posicaoContato índice do contato.
	 * @param posicaoTag índice da tag.
	 */
	public void removerTag(int posicaoContato, int posicaoTag) {
		if (this.tags[posicaoContato-1] != null) {
			this.tags[posicaoContato-1].removerTag(posicaoTag-1);
		}
	}
	
	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		this.contatos[posicao-1] = nome;
		this.dadosContatos[posicao-1] = new Contato(nome, sobrenome, telefone);
	}

}
