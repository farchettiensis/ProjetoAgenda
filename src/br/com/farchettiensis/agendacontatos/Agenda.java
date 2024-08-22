package br.com.farchettiensis.agendacontatos;

public class Agenda {
    private Contato[] contatos;
    private int contador;
    private String nome;

    public Agenda() {
        this.contatos = new Contato[5];
    }

    public Agenda(String nome) {
        this.contatos = new Contato[5];
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void adicionarContato(Contato contato) {
        if (contador < contatos.length) {
            contatos[contador] = contato;
            contador++;
        }

    }
}
