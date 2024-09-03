package br.com.farchettiensis.agendacontatos;

public class Main {
    public static void main(String[] args) {
        Telefone telefone1 = new Telefone("12345678909", TipoTelefone.CELULAR);
        Telefone telefone2 = new Telefone("98765432109", TipoTelefone.CASA);
        Telefone telefone3 = new Telefone("12345678909", TipoTelefone.TRABALHO);

        Contato contato1 = new Contato("Donald Fagen", telefone1, "Rua Custerdome, 1", "dfagen@steely.dan", "deaconBlues");
        String cont1Detalhes = contato1.detalharContato();
        System.out.println(cont1Detalhes);

        Contato contato2 = new Contato("Walter Becker", telefone2, "Rua Custerdome, 2", "wbecker@steely.dan", "homeAtLast");
        Contato contato3 = new Contato("Skunk Baxter", telefone3, "Rua Custerdome, 3", "sbaxter@doobie.bros", "46346585");

        Agenda agenda = new Agenda();
        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        agenda.adicionarContato(contato3);
        System.out.println(agenda.listarTodosOsContatos());

        agenda.removerContato(contato3);
        System.out.println(agenda.listarTodosOsContatos());
    }
}
