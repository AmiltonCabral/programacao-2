package agenda;

/**
 * Armazena as tags que um contato pode ter, cada contato pode ter 5 tags.
 * Os índices das tags vão de 0 a 4.
 * 
 * @author Amilton Cristian
 * 
 */
public class Tag {
    
    private static final int TAMANHO_TAGS = 5;
    private String[] nameTag;

    /**
     * Cria uma Tag.
     */
    public Tag() {
        this.nameTag = new String[TAMANHO_TAGS];
    }

    /**
     * Define a tag em sua posição determinada.
     * @param nome escolhido para a tag.
     * @param posicao da tag no array de String.
     */
    public void setTag(String nome, int posicao) {
        this.nameTag[posicao] = nome;
    }

    /**
     * Envia as tags separadas por espaço caso exista mais de uma.
     * Envia uma String vazia caso não tenha tags.
     * @return as tags caso existam.
     */
    public String getTags() {
        String tags = "";
        
        for (int i=0; i<TAMANHO_TAGS; i++) {
            if (nameTag[i] != null) {
                if (!tags.isBlank()) {
                    //Adiciona espaços para separar uma tag da outra.
                    tags += " ";
                }
                tags += nameTag[i];
            }
        }
        return tags;
    }

    /**
     * Verifica a existencia de uma tag específica.
     * @param tagBusca a tag a ser verificada.
     * @return true caso a tag exista, false caso não exista.
     */
    public boolean existeTag(String tagBusca) {
        for (String tag : nameTag) {
            if (tag != null && tag.equals(tagBusca)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Transforma uma tag em null, na lógica do sistema está removendo a tag.
     * @param posicaoTag qual tag remover.
     */
    public void removerTag(int posicaoTag) {
        this.nameTag[posicaoTag] = null;
    }
    
}
