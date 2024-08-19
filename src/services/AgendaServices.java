package services;

import java.util.Scanner;

public class AgendaServices {

//  TODO: Implementar tratamento de erro
    public static boolean checarSeContatoExiste(String[][] contatos, String telefone) {
        for (String[] contato : contatos) {
            if (contato[1] != null && contato[1].equals(telefone)) {
                return true;
            }
        }
        return false;
    }

//  TODO: Implementar tratamento de erro
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
            telefone = sc.nextLine();

            if (validarTelefone(telefone)) {
                if (checarSeContatoExiste(contatos, telefone)) {
                    System.out.println("Telefone já existe na agenda. Por favor, digite um telefone diferente.");
                } else {
                    telefoneValido = true;
                }
            } else {
                System.out.println("Telefone inválido. Por favor, tente novamente.");
            }
        }

        return telefone;
    }

    public static boolean listaCheia(String[][] contatos, int indice) {
        if (indice>=contatos.length) {
            return true;
        }
        return false;
    }
}
