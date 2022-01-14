package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	/**
	 * Entra em looping para exibir o menu e capturar a escolha do usuário.
	 * Carrega a agenda.
	 * @param args argumetos.
	 */
	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" + 
						"(A)dicionar Favorito\n" + 
						"(T)ags\n" + 
						"(M)udar telefone\n" +
						"(R)emover...\n" +
						"(B)uscar contato\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Exibe o submenu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String subMenuRemover(Scanner scanner) {
		System.out.print(
				"\n---\nREMOVER:\n" + 
						"(T)ag de um contato\n" +
						"(F)avorito\n" +
						"(C)ontato da agenda\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Exibe o submenu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String subMenuBuscar(Scanner scanner) {
		System.out.print(
				"\n---\nBUSCAR POR:\n" + 
						"(N)ome\n" +
						"(S)obrenome\n" +
						"(T)ag\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			exibeFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "T":
			adicionaTag(agenda, scanner);
			break;
		case "M":
			mudarTelefone(agenda, scanner);
			break;
		case "R":
			String opcaoMenuRemover = subMenuRemover(scanner);
			switch (opcaoMenuRemover) {
				case "T":
					removerTagContato(agenda, scanner);
					break;
				case "F":
					removerFavorito(agenda, scanner);
					break;
				case "C":
					removerContato(agenda, scanner);
					break;
			}
			break;
		case "B":
			String opcaoMenuBuscar = subMenuBuscar(scanner);
			switch (opcaoMenuBuscar) {
				case "N":
					buscarContatoPorNome(agenda, scanner);
					break;
				case "S":
					buscarContatoPorSobrenome(agenda, scanner);
					break;
				case "T":
					buscarContatoPorTag(agenda, scanner);
					break;
			}
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		for (int i=1; i<=agenda.getContatos().length; i++) {
			if (agenda.getContato(i) != null) {
				System.out.println(formataContato(i, agenda));
			}
		}
	}

	/**
	 * Busca todos os contatos com nome igual ao escolhido pelo usuário.
	 * 
	 * @param agenda a agenda sendo manipulada.
	 * @param scanner para capturar entradas do usuário.
	 */
	private static void buscarContatoPorNome(Agenda agenda, Scanner scanner) {
		System.out.print("Nome para buscar> ");
		String nomeBusca = scanner.next();
		scanner.nextLine();
		for (int i=1; i<=agenda.getContatos().length; i++) {
			if (agenda.getContato(i) != null && agenda.getNomeContato(i).equals(nomeBusca)) {
				System.out.println(formataContato(i, agenda));
			}
		}
	}

	/**
	 * Busca todos os contatos com sobrenome igual ao escolhido pelo usuário.
	 * 
	 * @param agenda a agenda sendo manipulada.
	 * @param scanner para capturar entradas do usuário.
	 */
	private static void buscarContatoPorSobrenome(Agenda agenda, Scanner scanner) {
		System.out.print("Sobrenome para buscar> ");
		String sobrenomeBusca = scanner.next();
		scanner.nextLine();
		for (int i=1; i<=agenda.getContatos().length; i++) {
			if (agenda.getContato(i) != null && agenda.getSobrenomeContato(i).equals(sobrenomeBusca)) {
				System.out.println(formataContato(i, agenda));
			}
		}
	}

	/**
	 * Busca todos os contatos que contém uma das tags igual ao escolhido pelo usuário.
	 * @param agenda a agenda sendo manipulada.
	 * @param scanner para capturar entradas do usuário.
	 */
	private static void buscarContatoPorTag(Agenda agenda, Scanner scanner) {
		System.out.print("Tag para buscar contatos> ");
		String tagBusca = scanner.next();
		scanner.nextLine();
		//System.out.println("\n");
		for (int i=1; i<=agenda.getContatos().length; i++) {
			if (agenda.getContato(i) != null && agenda.ehTagDoContato(i, tagBusca)) {
				System.out.println(formataContato(i, agenda));
			}
		}
	}

	/**
	 * Usuário escolhe um contato, escolhe uma posição para a tag e escolhe o nome da tag a ser definida.
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Objeto scanner para receber os dados do usuário.
	 */
	private static void adicionaTag(Agenda agenda, Scanner scanner) {
		System.out.print("Contato(s)> ");
		String[] contatosStr;

		scanner.nextLine();
		contatosStr = scanner.nextLine().split(" ");
		int[] contatosParaAddTag = new int[contatosStr.length];
		for (int i=0; i<contatosStr.length; i++) {
			contatosParaAddTag[i] = Integer.parseInt(contatosStr[i]);
		}

		System.out.print("Tag> ");
		String nameTag = scanner.next();

		System.out.print("Posicao tag> ");
		int posicaoTag = scanner.nextInt();

		for (int i=0; i<contatosParaAddTag.length; i++) {
			agenda.adicionaTag(nameTag, contatosParaAddTag[i], posicaoTag);
		}
	}

	/**
	 * Exibe uma lista com os contatos favoritados.
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void exibeFavoritos(Agenda agenda) {
        for (int i=1; i<=agenda.getFavoritos().length; i++) {
            if (agenda.getFavorito(i) != 0) {
                System.out.println(formataFavoritos(agenda, i));
            }
        }
	}

	/**
	 * Adiciona aos favoritos um contato da escolha do usuário.
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Objeto scanner para receber dados do usuário.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicaoContato = scanner.nextInt();
		if (agenda.ehFavorito(posicaoContato)) {
			System.out.println("\nJÁ FAVORITADO!");
			return;
		}

		System.out.print("Posicao> ");
		int posicaoFavorito = scanner.nextInt();

		agenda.setFavorito(posicaoContato, posicaoFavorito);
		System.out.printf("%nCONTATO FAVORITADO NA POSIÇÃO %d!%n", posicaoFavorito);
	}

	/**
	 * Remove o contato escolhido pelo usuário da lista de favoritos.
	 * @param agenda agenda sendo manipulada.
	 * @param scanner para capturar entradas do usuário.
	 */
	private static void removerFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("Posição dos favoritos remover> ");
		int posicaoFavorito = scanner.nextInt();
		scanner.nextLine();
		agenda.removerFavorito(posicaoFavorito);
		System.out.println("\nCONTATO REMOVIDO DOS FAVORITOS");
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("Qual contato> ");
		int posicao = scanner.nextInt();

		if (posicao >= 101 || posicao <= 0 || agenda.getContato(posicao) == null) {
			System.out.println("POSIÇÃO INVÁLIDA!");
			return;
		}
		if (agenda.ehFavorito(posicao)) {
			System.out.println("\n❤️ "+agenda.exibirContato(posicao));
		} else {
			System.out.println("\n"+agenda.exibirContato(posicao));
		}
		if (agenda.temTags(posicao)) {
			System.out.println(agenda.exibirTags(posicao));
		}
	}

	/**
	 * Remove o contato da agenda.
	 * Caso o contato esteja na lista de favoritos, também será removido da lista.
	 * @param agenda a agenda sendo manipulada.
	 * @param scanner para capturar entradas do usuário.
	 */
	private static void removerContato(Agenda agenda, Scanner scanner) {
		System.out.print("Qual contato remover da agenda> ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		agenda.removerContato(posicao);
		System.out.println("\nCONTATO REMOVIDO");
	}

	/**
	 * Formata um contato para impressão na interface. 
	 * @param posicao A posição do contato (que é exibida)/
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Agenda agenda) {
		return posicao + " - " + agenda.getNomeCompleto(posicao);
	}

	/**
	 * Envia os favoritos uma linha abaixo.
	 * @param agenda A agenda sendo manipulada.
	 * @param indice do favorito.
	 * @return O favorito uma linha abaixo.
	 */
	private static String formataFavoritos(Agenda agenda, int indice) {
		return "\n" + agenda.exibirContato(agenda.getFavorito(indice));
	}

	/**
	 * Cadastra um contato na agenda.
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		// Recebe a posição na agenda.
		System.out.print("Posição na agenda> ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		if (posicao < 1 || posicao > 100) {
			System.out.println("\nPOSIÇÃO INVÁLIDA");
			return;
		}
		// Recebe o nome.
		System.out.print("Nome> ");
		String nome = scanner.nextLine();
		if (nome.isBlank()) {
			System.out.println("\nCONTATO INVALIDO");
			return;
		}
		// Recebe o sobrenome.
		System.out.print("Sobrenome> ");
		String sobrenome = scanner.nextLine();
		String nomeCompleto = nome;
		if (!sobrenome.isBlank()) {
			nomeCompleto = nome + " " + sobrenome;
		}
		for (int i=1; i<=agenda.getContatos().length; i++) {
			if (nomeCompleto.equalsIgnoreCase(agenda.getNomeCompleto(i))){
				System.out.println("\nCONTATO JA CADASTRADO");
				return;
			}
		}
		// Recebe o telefone.
		System.out.print("Telefone> ");
		String telefone = scanner.nextLine();
		if (telefone.isBlank()) {
			System.out.println("\nCONTATO INVALIDO");
			return;
		}
		// Se os dados estiverem como especificados, o cadastro é realizado.
		agenda.cadastraContato(posicao, nome, sobrenome, telefone);
		System.out.println("\nCADASTRO REALIZADO");
	}

	/**
	 * Troca o número de telefone do contato.
	 * @param agenda agenda sendo manipulada.
	 * @param scanner para capturar entradas do usuário.
	 */
	private static void mudarTelefone(Agenda agenda, Scanner scanner) {
		System.out.print("Qual contato> ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Novo telefone> ");
		String novoTelefone = scanner.nextLine();
		if (novoTelefone.isBlank()) {
			System.out.println("\nTELEFONE INVÁLIDO");
			return;
		}
		agenda.alterarTelefone(posicao, novoTelefone);
		System.out.println("\nTELEFONE TROCADO");
	}

	/**
	 * Remove uma tag do contato, de acordo com sua posição.
	 * @param agenda agenda sendo manipulada.
	 * @param scanner para capturar entradas do usuário.
	 */
	private static void removerTagContato(Agenda agenda, Scanner scanner) {
		System.out.print("Qual contato> ");
		int posicaoContato = scanner.nextInt();
		System.out.print("Qual posição da tag> ");
		int posicaoTag = scanner.nextInt();
		scanner.nextLine();
		agenda.removerTag(posicaoContato, posicaoTag);
		System.out.println("\nTAG REMOVIDA!");
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
