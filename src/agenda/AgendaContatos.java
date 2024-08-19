package agenda;

import Enums.Operacoes;
import services.AgendaServices;
import java.util.Scanner;


public class AgendaContatos {
    static String[][] contatos = new String[100][3];
    static int indice = 0;

    private static void icreaseIndex() {
        indice++;
    }

    private static void decreaseIndex() {
        indice++;
    }

    static public void iniciarSistema() {
        Scanner sc = new Scanner(System.in);
        Operacoes operacao = null;

        do {
            System.out.println(
                    """
                            ##################
                            ##### AGENDA #####
                            ##################
                            """);

            System.out.println("\n>>>> Menu Contato <<<<");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Detalhar Contato");
            System.out.println("3 - Editar Contato");
            System.out.println("4 - Remover Contatos");
            System.out.println("5 - Listar Contatos");
            System.out.println("6 - Sair\n");
            System.out.print("Escolha uma opção: ");

            int opcao = 0;
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();

                if (opcao >= 1 && opcao <= Operacoes.values().length) {
                    operacao = Operacoes.values()[opcao - 1];
                } else {
                    operacao = null;
                }
            } else {
                System.out.println("Opção inválida. Tente novamente!");
                sc.next();
                continue;
            }

            if (operacao == null) {
                System.out.println("Opção inválida. Tente novamente!");
                continue;
            }

            switch (operacao) {
                case ADICIONAR:
                    agendaAdaptavel();
                    adicionarContato(contatos, sc, indice);
                    break;
                case DETALHAR:
                    detalharContato(contatos, sc);
                    break;
                case EDITAR:
                    editarContato(contatos, sc);
                    break;
                case REMOVER:
                    removerContato(sc);
                    break;
                case LISTAR:
                    listarTodosContatos();
                    break;
                case SAIR:
                    System.out.println("Saindo do programa...");
                    break;
            }

        } while (operacao != Operacoes.SAIR);
    }

    private static void adicionarContato(String[][] contatos, Scanner sc, int indice) {
        System.out.println(">>>>>Adicionando Contato<<<<<");

        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        String telefone = AgendaServices.adicionarTelefone(contatos, sc);

        System.out.print("Digite o E-mail: ");
        String email = sc.nextLine();
        contatos[indice][0] = nome;
        contatos[indice][1] = telefone;
        contatos[indice][2] = email;
        icreaseIndex();
        System.out.println("Contato adicionado com sucesso!");
    }

    private static void detalharContato(String[][] contatos, Scanner sc) {
        System.out.println(">>>>>Detalhando contato<<<<<");
        System.out.print("Digite o número de telefone do contato: ");
        String telefone = sc.next();

        for (String[] contato : contatos) {
            if (AgendaServices.checarSeContatoExiste(contatos, telefone)) {
                System.out.println("\n-----Informações-----");
                System.out.println("Nome: " + contato[0] + "\t|Telefone: " + contato[1] + "\t |E-mail: " + contato[2]);
                break;
            } else {
                System.out.println("Contato nao encontrado!");
                break;
            }
        }
    }

    //  TODO: criar "tem certeza"
    private static void editarContato(String[][] contatos, Scanner sc) {
        System.out.print("Digite o número de telefone do contato: ");
        String telefone = sc.next();

        boolean contatoJaExiste = false;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][1] != null && contatos[i][1].equals(telefone)) {
                System.out.println(">>>>Atualizando contato<<<<");
                System.out.print("Novo Nome: ");
                contatos[i][0] = sc.next();
                System.out.print("Novo Telefone: ");
                contatos[i][1] = sc.next();
                System.out.print("Novo E-mail: ");
                contatos[i][2] = sc.next();
                System.out.println("Contato atualizado!");
                contatoJaExiste = true;
                break;
            }
        }
        if (!contatoJaExiste) {
            System.out.println("Contato não encontrado!");
        }
    }

    //  TODO: criar "tem certeza"
    private static void removerContato(Scanner sc) {
        System.out.println("Digite o número de telefone do contato a ser removido: ");
        String telefone = sc.next();

        for (int i = 0; i < indice; i++) {
            if (contatos[i][1].equals(telefone)) {
                for (int j = i; j < indice - 1; j++) {
                    contatos[j] = contatos[j + 1];
                }
                contatos[indice - 1] = new String[3];
                decreaseIndex();
                System.out.println("Contato removido com sucesso.");
                return;
            }
        }
        System.out.println("Não encontrado.");
    }

    private static void listarTodosContatos() {
        System.out.println(">>>>>>> CONTATOS <<<<<<<");

        System.out.printf("%-5s %-20s %-15s %-30s\n", "Id", "Nome", "Telefone", "E-mail");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < indice; i++) {
            System.out.printf("%-5d %-20s %-15s %-30s\n", i, contatos[i][0], contatos[i][1], contatos[i][2]);
        }

        System.out.println("---------------------------------------------------------------");
    }

    private static void agendaAdaptavel() {
        if (AgendaServices.listaCheia(contatos,indice)) {
            String[][] novosContatos = new String[2*indice][3];
            for (int i=0;i<contatos.length;i++) {
                for (int j=0;j<contatos[i].length;j++){
                    novosContatos[i][j] = contatos[i][j];
                }
            }
            contatos = novosContatos;
        }
    }

}