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

    public void removerContato(String nome) {
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equals(nome)) {
                removerContatoPorIndice(i);
                return;
            }
        }
    }

    public void removerContato(Telefone telefone) {
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getTelefone().getNumero().equals(telefone.getNumero())) {
                removerContatoPorIndice(i);
                return;
            }
        }
    }

    public void removerContato(String nome, Telefone telefone) {
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equals(nome) &&
                    contatos[i].getTelefone().getNumero().equals(telefone.getNumero())) {
                removerContatoPorIndice(i);
                return;
            }
        }
    }

    private void removerContatoPorIndice(int indice) {
        for (int i = indice; i < contador - 1; i++) {
            contatos[i] = contatos[i + 1];
        }
        contatos[contador - 1] = null;
        contador--;
    }

    public void listarContatos() {
        ordenarContatos();

        for (int i = 0; i < contador; i++) {
            System.out.printf("%d - %s", i, contatos[i].getNome());
        }
    }

    private void ordenarContatos() {
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - 1 - i; j++) {
                if (contatos[j].getNome().compareTo(contatos[j + 1].getNome()) > 0) {
                    Contato contatoTemporario = contatos[j];
                    contatos[j] = contatos[j + 1];
                    contatos[j + 1] = contatoTemporario;
                }
            }
        }
    }


    public void editarContato() {

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
