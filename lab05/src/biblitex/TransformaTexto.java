package biblitex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.LinkedHashSet;

/**
 * Gerencia todos os algoritmos de transformação, e os armazena.
 * É possível cadastrar novas transformações.
 * É feito uma contagem e armazenamento de historico de transformações feitas.
 * 
 * @author Amilton_Cristian's LTDA 2077
 */
public class TransformaTexto {

    private Map<String, AlgoritmoTransformacao> transformacoesCadastradas;
    private int numTransformacoes = 0;
    private Collection<String> textosOriginais;
    private List<String> historicoTransformacoes;
    private AlgoritmoLogger logger;

    /**
     * Cria o objeto TransformaTexto.
     * Inicia as coleções básicas para funcionamento da classe.
     * Cadastra as transformações padrões.
     */
    public TransformaTexto() {
        transformacoesCadastradas = new HashMap<String, AlgoritmoTransformacao>();
        textosOriginais = new LinkedHashSet<String>();
        historicoTransformacoes = new ArrayList<String>();
        AlgoritmoTransformacao camelcasefy = new CaMeLcAsEfY();
        AlgoritmoTransformacao clean = new Clean();
        AlgoritmoTransformacao cleanSpaces = new CleanSpaces();
        AlgoritmoTransformacao interrogaPraPonto = new ConverteInterrogacoesParaPontos();
        AlgoritmoTransformacao upperCase = new UpperCase();
        AlgoritmoTransformacao letraParaNumeros = new LetraParaNumeros();
        cadastraTransformacao("CaMeLcAsEfY", camelcasefy);
        cadastraTransformacao("clean", clean);
        cadastraTransformacao("cleanSpaces", cleanSpaces);
        cadastraTransformacao("InterrogaPraPontos", interrogaPraPonto);
        cadastraTransformacao("upperCase", upperCase);
        cadastraTransformacao("LetraParaNumeros", letraParaNumeros);
    }

    /**
     * Cria o objeto TransformaTexto.
     * Cadastra um novo tipo logger.
     * Inicia as coleções básicas para funcionamento da classe.
     * Cadastra as transformações padrões.
     * @param logger O logger que vai ser utilizado.
     */
    public TransformaTexto(AlgoritmoLogger logger) {
        transformacoesCadastradas = new HashMap<String, AlgoritmoTransformacao>();
        textosOriginais = new LinkedHashSet<String>();
        historicoTransformacoes = new ArrayList<String>();
        this.logger = logger;
        AlgoritmoTransformacao camelcasefy = new CaMeLcAsEfY();
        AlgoritmoTransformacao clean = new Clean();
        AlgoritmoTransformacao cleanSpaces = new CleanSpaces();
        AlgoritmoTransformacao interrogaPraPonto = new ConverteInterrogacoesParaPontos();
        AlgoritmoTransformacao upperCase = new UpperCase();
        AlgoritmoTransformacao letraParaNumeros = new LetraParaNumeros();
        cadastraTransformacao("CaMeLcAsEfY", camelcasefy);
        cadastraTransformacao("clean", clean);
        cadastraTransformacao("cleanSpaces", cleanSpaces);
        cadastraTransformacao("InterrogaPraPontos", interrogaPraPonto);
        cadastraTransformacao("upperCase", upperCase);
        cadastraTransformacao("LetraParaNumeros", letraParaNumeros);
    }
	
    /**
     * Cadastra uma nova transformação.
     * @param nomeTransformacao nome da transformação, que será usada como key no mapa.
     * @param meuAlgoritmo o algoritmo de transformação.
     */
    public void cadastraTransformacao(String nomeTransformacao, AlgoritmoTransformacao meuAlgoritmo) {
        if (nomeTransformacao == null) {
            throw new NullPointerException("Nome da transformação não deve ser nulo");
        } else if (meuAlgoritmo == null) {
            throw new NullPointerException("Não é permitido armazenar algoritmo nulo");
        }
        transformacoesCadastradas.put(nomeTransformacao, meuAlgoritmo);
    }

    /**
     * Transforma um texto de acordo com o algoritmo escolhido.
     * Armazena o texto original em uma coleção.
     * Armazena a mudança no historico de transfomação.
     * Adiciona +1 na quantidade de transformações feitas.
     * @param nomeTransformacao nome da transformação escolhida.
     * @param entrada o texto a ser formatado.
     * @return o texto formatado.
     */
    public String transforma(String nomeTransformacao, String entrada) {
        if (this.logger != null) {
            this.logger.transforma(nomeTransformacao);
        }
        String textoTransformado = transformacoesCadastradas.get(nomeTransformacao).transforma(entrada);
        textosOriginais.add(entrada);
        addHistorico(nomeTransformacao, entrada, textoTransformado);
        numTransformacoes ++;
        return textoTransformado;
    }

    /**
     * Adiciona uma mudança no historico.
     * Ex.: TextoOriginal -> TransformaçãoEscolhida -> TextoTransformado
     * @param nomeTransformacao a transformação escolhida.
     * @param entrada o texto original a ser transformado.
     * @param textoTransformado o novo texto após ser transformado.
     */
    private void addHistorico(String nomeTransformacao, String entrada, String textoTransformado) {
        String novoHistorico = "";
        novoHistorico += entrada + " -> ";
        novoHistorico += transformacoesCadastradas.get(nomeTransformacao).getNome() + " -> ";
        novoHistorico += textoTransformado;
        historicoTransformacoes.add(novoHistorico);
    }

    /**
     * Informa quantas transformações foram feitas
     * @return quantas transformações foram concluidas.
     */
    public int contaTransformacao() {
        if (this.logger != null) {
            this.logger.contaTransformacao();
        }
        return numTransformacoes;
    }

    /**
     * Exibe o histórico de transformação de acordo com o índice escolhido.
     * @param indice qual histórico foi escolhido.
     * @return o histórico.
     */
    public String historico(int indice) {
        if(indice < 0) {
            throw new IllegalArgumentException("Não existe historico com indice abaixo de 0");
        }
        if (this.logger != null) {
            this.logger.historico(indice);
        }
        return historicoTransformacoes.get(indice);
    }

    /**
     * Lista todas as frases originais.
     * Não existem frases repetidas.
     * @return as frases originais.
     */
    public String listarOriginais() {
        return transformaListaParaString(textosOriginais);
    }

    /**
     * Cria um TreeSet para deixar os elementos ordenados.
     * Pega os nomes de todas as transformações cadastradas e adiciona no TreeSet.
     * @return uma String contendo todos os nomes.
     */
    public String listarTransformacoes() {
        Collection<String> listaTransformacoes = new TreeSet<String>();
        for(AlgoritmoTransformacao algoritmo : transformacoesCadastradas.values()) {
            listaTransformacoes.add(algoritmo.getNome());
        }
        return transformaListaParaString(listaTransformacoes);
    }

    /**
     * Transforma uma lista de strings em uma única string
     * Separa os elementos com uma quebra de linha
     * @param listaOriginal a lista de strings
     * @return a string
     */
    private String transformaListaParaString(Collection<String> listaOriginal) {
        String saidaListaTransformacoes = "";
        int i = 0;
        for(String itemDaLista : listaOriginal) {
            i++;
            saidaListaTransformacoes += itemDaLista;
            if(i == listaOriginal.size()) {
                break;
            }
            saidaListaTransformacoes += "\n";
        }
        return saidaListaTransformacoes;
    }

}
