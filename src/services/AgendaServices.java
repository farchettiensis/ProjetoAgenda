package services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AgendaServices {

    public static boolean checarSeContatoExiste(String[][] contatos, String telefone) {
        try {
            for (String[] contato : contatos) {
                if (contato[1] != null && contato[1].equals(telefone)) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Erro: Contato ou telefone nulo encontrado.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Acesso inválido ao array de contatos.");
        } catch (Exception e) {
            System.out.println("Erro desconhecido ao verificar se o contato existe: " + e.getMessage());
        }
        return false;
    }


    public static boolean validarTelefone(String telefone) {
        try {
            String caracteresPermitidos = "0123456789";

            for (int i = 0; i < telefone.length(); i++) {
                char c = telefone.charAt(i);
                if (caracteresPermitidos.indexOf(c) == -1) {
                    return false;
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Erro: Índice de string fora dos limites ao validar telefone.");
        } catch (Exception e) {
            System.out.println("Erro desconhecido ao validar o telefone: " + e.getMessage());
            return false;
        }
        return true;
    }


    public static String adicionarTelefone(String[][] contatos, Scanner sc) {
        String telefone = "";
        boolean telefoneValido = false;

        while (!telefoneValido) {
            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Erro: Tipo de entrada inválido.");
                sc.next();
            } catch (Exception e) {
                System.out.println("Erro desconhecido ao adicionar telefone: " + e.getMessage());
            }
        }

        return telefone;
    }

    public static boolean validarEmail(String email) {
        try {
            int indiceArroba = email.indexOf("@");
            int indiceOutroArroba = email.indexOf("@", indiceArroba + 1);
            if (indiceArroba == -1 || indiceOutroArroba != -1 || indiceArroba == email.length() - 1) {
                System.out.println("E-mail inválido, digite novamente!");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro desconhecido ao validar E-mail: " + e.getMessage());
        }
        return true;
    }

    public static boolean listaCheia(String[][] contatos, int indice) {
        return indice >= contatos.length;
    }
}
