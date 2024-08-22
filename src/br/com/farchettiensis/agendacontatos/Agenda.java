package br.com.farchettiensis.agendacontatos;

public class Agenda {
    private Contato[] contatos;
    private int contador;
    private String nome;

    public Agenda() {
        this.contatos = new Contato[10];
    }

    public Agenda(String nome) {
        this.contatos = new Contato[10];
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void adicionarContato(Contato contato) {
        if (contador >= contatos.length) {
            this.redimensionarArray();
        }
        contatos[contador] = contato;
        contador++;
    }

    private void redimensionarArray() {
        int novoTamanho = contatos.length + (contatos.length / 2);
        if (novoTamanho == contatos.length) {
            novoTamanho++;
        }
        Contato[] novoArray = new Contato[novoTamanho];
        for (int i = 0; i < contatos.length; i++) {
            novoArray[i] = contatos[i];
        }
        contatos = novoArray;
    }


    public int getTamanhoArray() {
        return contatos.length;
    }
}
