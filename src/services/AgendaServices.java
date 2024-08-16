package services;

import java.util.Scanner;

public class AgendaServices {

    public static void imprimirAgendaFormatada(String[][] contatos, int indice) {
        System.out.println(
                ">>>> Contatos <<<<\n" +
                        "Id | Nome | Telefone | E-mail"
        );

        for (int i = 0; i < indice; i++) {
            System.out.printf("%d | %s | %s | %s\n", i, contatos[i][0], contatos[i][1], contatos[i][2]);
        }
    }

    public static boolean checarSeContatoExiste(String[][] contatos, String telefone) {
        for (String[] contato : contatos) {
            if (contato[1] != null && contato[1].equals(telefone)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validarTelefone(String telefone) {
        String caracteresPermitidos = "0123456789";

        for (int i = 0; i < telefone.length(); i++) {
            char c = telefone.charAt(i);
            if (caracteresPermitidos.indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }

    public static String adicionarTelefone(String[][] contatos, Scanner sc) {
        String telefone = "";
        boolean telefoneValido = false;

        while (!telefoneValido) {
            System.out.print("Digite o telefone: ");
            telefone = sc.next();


//          TODO: implementar função de sair do modo adicionar telefone
            if (telefone.equals("SAIR")) {
                break;
            } else if (validarTelefone(telefone)) {
                if (checarSeContatoExiste(contatos, telefone)) {
                    System.out.println("Telefone já existe na agenda. Por favor, digite um telefone diferente ou SAIR.");
                } else {
                    telefoneValido = true;
                }
            } else {
                System.out.println("Telefone inválido. Por favor, tente novamente ou SAIR.");
            }
        }

        return telefone;
    }

}
