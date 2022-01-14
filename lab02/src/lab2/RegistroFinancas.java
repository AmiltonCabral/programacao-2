package lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Organiza as finanças de um aluno. Contém seus ganhos, despesas pagas, e saldo disponível.
 * 
 * @author Amilton Cristian
 */
public class RegistroFinancas {

    /**
     * Registra o ganho inicial do aluno.
     */
    private int ganhoInicialGuardado;

    /**
     * É um array que guarda os ganhos adicionais do aluno, o tamanho do array é definido pelo aluno no construtor.
     */
    private int[] ganhosAdicionaisGuardado;

    /**
     * A soma dos ganhos adicionais com o ganho inicial.
     */
    private int dinheiroTotalRecebido;

    /**
     * Quanto dinheiro o aluno gastou para pagar as despesas.
     */
    private int totalDespesasPagas;

    /**
     * A soma dos ganhos adicionais com o ganho inicial menos as despesas pagas.
     */
    private int dinheiroTotalDisponivel;

    /**
     * Cria uma lista para armazenar os motivos das despesas.
     */
    private List<String> registroMotivosDespesas;
    
    /**
     * Constrói o registro das finanças a partir dos ganhos iniciais e quantos ganhos adicionais terá.
     * Os ganhos adicionais são adicionados posteriormente, e podem ser alterados a qualquer momento.
     * 
     * @param ganhosIniciais Quanto dinheiro inicial o aluno tem.
     * @param totalDeGanhos Quantas vezes o aluno vai acrescentar dinheiro adicional.
     */
    public RegistroFinancas(int ganhosIniciais, int totalDeGanhos) {
        this.ganhoInicialGuardado = ganhosIniciais;
        this.ganhosAdicionaisGuardado = new int[totalDeGanhos];
        this.dinheiroTotalDisponivel = 0;
        this.totalDespesasPagas = 0;
        this.dinheiroTotalRecebido = 0;
        this.registroMotivosDespesas = new ArrayList<>();
        atualizarDinheiroTotal();
    }

    /**
     * Adiciona os ganhos adicionais.
     * 
     * @param valorCentavos Quando dinheiro em centavos o aluno vai adicionar.
     * @param posicaoGanho Qual posição o aluno vai adicionar o dinheiro.
     */
    public void adicionaGanhos(int valorCentavos, int posicaoGanho) {
        this.ganhosAdicionaisGuardado[posicaoGanho -1] = valorCentavos;
        atualizarDinheiroTotal();
    }

    /**
     * A despesa que o aluno pagou. Essa despesa paga é somada com as anteriores.
     * 
     * @param valorCentavos O valor em centavos da despesa que o aluno pagou.
     */
    public void pagaDespesa(int valorCentavos) {
        this.totalDespesasPagas += valorCentavos;
        atualizarDinheiroTotal();
    }

    /**
     * A despesa que o aluno pagou. Essa despesa paga é somada com as anteriores.
     * Adiciona também, um comentário com o motivo da despesa.
     * 
     * @param valorCentavos o valor em centavos da despesa que o aluno pagou.
     * @param detalhes o motivo da despesa paga.
     */
    public void pagaDespesa(int valorCentavos, String detalhes) {
        this.totalDespesasPagas += valorCentavos;
        atualizarDinheiroTotal();
        registroMotivosDespesas.add(detalhes);
    }

    /**
     * Atualiza o saldo total que o aluno tem disponível.
     * Atualiza também o total de dinheiro que o aluno recebel, excluindo as despesas pagas.
     */
    private void atualizarDinheiroTotal() {
        this.dinheiroTotalDisponivel = 0;
        this.dinheiroTotalRecebido = 0;
        for (int i=0; i<this.ganhosAdicionaisGuardado.length; i++) {
            this.dinheiroTotalDisponivel += this.ganhosAdicionaisGuardado[i];
            this.dinheiroTotalRecebido += this.ganhosAdicionaisGuardado[i];
        }
        this.dinheiroTotalDisponivel += this.ganhoInicialGuardado;
        this.dinheiroTotalDisponivel -= this.totalDespesasPagas;
        this.dinheiroTotalRecebido += this.ganhoInicialGuardado;
    }

    /**
     * Cria uma tabela com os ganhos adicionais do aluno, infomando a posição e o valor.
     * 
     * @return a tabela criada.
     */
    public String exibeGanhos() {
        String tabelaGanhosAdicionais = "";
        for (int i=0; i<this.ganhosAdicionaisGuardado.length; i++) {
            if (tabelaGanhosAdicionais.length() != 0) {
                tabelaGanhosAdicionais += "\n";
            }
            tabelaGanhosAdicionais += i+1 + " - " + this.ganhosAdicionaisGuardado[i];
        }
        return tabelaGanhosAdicionais;
    }

    /**
     * Reune todos os status das finanças do aluno.
     * 
     * @return os status das finanças.
     */
    public String toString() {
        return String.format("Total recebidos: %d, Despesas totais: %d, Total disponível: %d", 
            this.dinheiroTotalRecebido, this.totalDespesasPagas, this.dinheiroTotalDisponivel);
    }

    /**
     * Retorna os motivos dos últimos 5 gastos do aluno, só conta os gastos com descrições.
     * 
     * @return os 5 últimos gastos.
     */
    public String listarDetalhes() {
        String listaMotivosDasDespesas = "";
        if (registroMotivosDespesas.size() > 5) {
            for (int i=registroMotivosDespesas.size() - 5; i<registroMotivosDespesas.size(); i++) {
                listaMotivosDasDespesas += i+1 +"º motivo: "+ registroMotivosDespesas.get(i);
                if (i == registroMotivosDespesas.size()-1) {break;}
                listaMotivosDasDespesas += "\n";
            }
        } else {
            for (int i=0; i<registroMotivosDespesas.size(); i++) {
                listaMotivosDasDespesas += i+1 +"º motivo: "+ registroMotivosDespesas.get(i);
                if (i == registroMotivosDespesas.size()-1) {break;}
                listaMotivosDasDespesas += "\n";
            }
        }
        return listaMotivosDasDespesas;
    }
}
