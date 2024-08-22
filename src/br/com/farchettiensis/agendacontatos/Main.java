package br.com.farchettiensis.agendacontatos;

public class Main {
    public static void main(String[] args) {
        Telefone telefone1 = new Telefone("12345678909", TipoTelefone.CELULAR);

        Contato contato1 = new Contato(
                "Jamil Assis",
                telefone1,
                "The Hutt",
                "Rua Dr. Jamil, 584",
                "dr.jamil@jamil.org.br",
                "Instituto Jamil"

        );

        System.out.printf("Nome: %s%n", contato1.getNome());
        System.out.printf("Telefone: %s (%s)%n", contato1.getTelefone().getNumero(), contato1.getTelefone().getTipo().getDescricao());
        System.out.printf("Apelido: %s%n", contato1.getApelido());
        System.out.printf("Endereço: %s%n", contato1.getEndereco());
        System.out.printf("Email: %s%n", contato1.getEmail());
        System.out.printf("Empresa: %s%n",contato1.getEmpresa());
    }
}
