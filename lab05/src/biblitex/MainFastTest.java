package biblitex;


 /**
  * OQ falta:
  * Nada, acabo
  *
  * ATENÇÃO MONITOR QUE TIVER CORRIGINDO:
  * Classe criada unicamente para testes rapidos, não deve ser levada em consideração, pois o projeto nem pede :)
  */
public class MainFastTest {
    public static void main(String[] args) {
        AlgoritmoLogger cl = new ConsoleLogger();
        AlgoritmoLogger ctl = new ContagemLogger();
        AlgoritmoLogger il = new BreakpointLogger("transforma");
        AlgoritmoLogger tcl = new TimeConsoleLogger();
        TransformaTexto tt = new TransformaTexto(tcl);

        // teste 1
        AlgoritmoTransformacao meuAlgoritmo = new ConverteInterrogacoesParaPontos();
        tt.cadastraTransformacao("InterrogaPraPontos", meuAlgoritmo);
        System.out.println(tt.transforma("InterrogaPraPontos", "oi, como vc vai?"));

        // teste 2
        System.out.println(tt.transforma("CaMeLcAsEfY", "oi, como vc vai?"));
            //System.out.println(tt.transforma("CaMeLcAsEfY", null));

        // teste 3
        System.out.println(tt.transforma("clean", "oi, como vc vai?"));

        // teste 4
        AlgoritmoTransformacao meuAlgoritmo4 = new UpperCase();
        tt.cadastraTransformacao("upperCase", meuAlgoritmo4);
        System.out.println(tt.transforma("upperCase", "oi, como vc vai?"));

        // teste 5
        AlgoritmoTransformacao meuAlgoritmo5 = new CleanSpaces();
        tt.cadastraTransformacao("cleanSpaces", meuAlgoritmo5);
        System.out.println(tt.transforma("cleanSpaces", "oi, como vc vai?"));

        // teste lista transformacoes
        System.out.println("\n"+tt.listarTransformacoes());

        // teste contagem
        System.out.println("\n"+tt.contaTransformacao());

        // teste originais
        System.out.println("\n"+tt.listarOriginais());

        // teste historico
        System.out.println("\n"+tt.historico(3));

        // teste letra pra numeros
        System.out.println("\n"+tt.transforma("LetraParaNumeros", "OLA MONITOR, COMO VOCE ESTA?"));
        System.out.println(tt.transforma("LetraParaNumeros", "ola monitor, como voce esta?"));


    }

}
