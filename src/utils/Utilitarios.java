package utils;

import java.util.Scanner;

public class Utilitarios {

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

    public static void validarTelefone(String telefone, Scanner sc) throws Exception {
        String caracteresPermitidos = "0123456789";
        try {
            for (int i = 0; i < telefone.length(); i++) {
                char c = telefone.charAt(i);
                if (caracteresPermitidos.indexOf(c) == -1) {
                    throw new Exception("O telefone contém caracteres inválidos. Apenas números são permitidos.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sc.close();
        }
    }


    public static String adicionarTelefone(String[][] contatos, Scanner sc) throws Exception {
        String telefone = sc.next();
        validarTelefone(telefone, sc);
        if (checarSeContatoExiste(contatos, telefone)) {
            throw new Exception("Telefone já exste na agenda.");
        } else {
            return telefone;
        }
    }

}
