package agenda;

import services.AgendaServices;
import java.util.Scanner;


public class AgendaContatos {
    static String[][] contatos = new String[100][3];
    static int opcao, indice = 0;

    static public void iniciarSistema() {

//      TODO: remover try cath
        try (Scanner sc = new Scanner(System.in)) {
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

                opcao = sc.nextInt();
//              TODO: Usar ENUM
                switch (opcao) {
                    case 1:
                        if (adicionarContato(contatos, sc, indice)) {
                            indice++;
                        }
                        break;
                    case 2:
                        detalharContato(contatos, sc);
                        break;
                    case 3:
                        editarContato(contatos, sc);
                        break;
                    case 4:
                        removerContato(sc);
                        indice--;
                        break; 
                    case 5:
                        listarTodosContatos();
                        break;
                    case 6:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente!");
                        break;
                }

            } while (opcao != 6);
        } catch (Exception e) {
            System.out.println("Opção inválida. Tente novamente!");
            e.printStackTrace();
        }
    }


//   TODO: Criar Formatação
    private static void listarTodosContatos() {

        System.out.println(">>>>>>> CONTATOS <<<<<<<");
        System.out.printf("%-10s %-10s %-10s %-10s\n","Id", "Nome", "Telefone", "E-mail");
        for (int i = 0; i < indice; i++) {
            System.out.printf("%d %-10s %-10s %-10s %-10s\n",i,"",contatos[i][0],contatos[i][1],contatos[i][2]);
        }
    }

    private static boolean adicionarContato(String[][] contatos, Scanner sc, int indice) {
        System.out.println(">>>>>Adicionando Contato<<<<<");
        sc.nextLine();
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        String telefone = AgendaServices.adicionarTelefone(contatos, sc);
        System.out.print("Digite o E-mail: ");
        String email = sc.nextLine();

        contatos[indice][0] = nome;
        contatos[indice][1] = telefone;
        contatos[indice][2] = email;
        System.out.println("Contato adicionado com sucesso!");
        return true;

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
                indice--;
                System.out.println("Contato removido com sucesso.");
                return;
            }
        }
        System.out.println("Não encontrado.");
    }
}