package agenda;

/**
 * Um contato que tem nome, sobrenome e telefone.
 * Por padrão o sobrenome pode ser uma String vazia, os demais não.
 * 
 * @author Amilton Cristian
 * 
 */
public class Contato {

    private String nome;
    private String sobrenome;
    private String telefone;

    /**
     * Cria um Contato.
     * @param nome do contato.
     * @param sobrenome do contato, pode vir uma String vazia.
     * @param telefone do contato.
     */
    public Contato(String nome, String sobrenome, String telefone) {
        if (nome == null) {
            throw new NullPointerException("Nome nulo");
        } else if (sobrenome == null) {
            throw new NullPointerException("Sobrenome nulo");
        } else if (telefone == null) {
            throw new NullPointerException("Telefone nulo");
        } else if (nome.isBlank()) {
            throw new IllegalArgumentException("Nome em branco");
        } else if (telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone em branco");
        }
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    /**
     * Se tiver sobrenome, envia o nome mais sobrenome separado por um espaço.
     * Caso não tenha sobrenome, envia apenas o nome.
     * @return nome completo salvo no Contato.
     */
    public String getNomeCompleto() {
        if (sobrenome.isBlank()) {
            return this.nome;
        }
        return this.nome + " " + this.sobrenome;
    }

    /**
     * Retorna o sobrenome do contato.
     * @return o sobrenome.
     */
    public String getSobrenome() {
        return this.sobrenome;
    }

    /**
     * Envia o telefone do contato.
     * @return número de telefone.
     */
    public String getTelefoneContato() {
        return this.telefone;
    }

    /**
     * Troca o número de telefone do contato, para um novo.
     * @param novoTelefone o novo número de telefone a ser trocado.
     */
    public void alterarTelefone(String novoTelefone) {
        if (novoTelefone == null) {
            throw new NullPointerException("Novo telefone não pode ser nulo");
        } else if (novoTelefone.isBlank()) {
            throw new IllegalArgumentException("Novo telefone não pode ser vazio/branco");
        }
        this.telefone = novoTelefone;
    }

}
