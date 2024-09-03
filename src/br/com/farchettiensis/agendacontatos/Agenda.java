package br.com.farchettiensis.agendacontatos;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private final List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        this.contatos.add(contato);
    }

    public void removerContato(Contato contato) {
        this.contatos.remove(contato);
    }

    public List<Contato> listarContatos() {
        return this.contatos;
    }

    public String buscarContato(String telefone) {
        for (Contato contato : this.contatos) {
            if (contato.getTelefone().getNumero().equals(telefone)) {
                return contato.detalharContato();
            }
        }
        return "Contato não encontrado.";
    }

    public String listarTodosOsContatos() {
        StringBuilder sb = new StringBuilder();
        for (Contato contato : this.contatos) {
            sb.append(String.format("%-20s %-15s %-30s %-30s %-20s%n",
                    contato.getNome(),
                    contato.getTelefone() != null ? contato.getTelefone().getNumero() : "N/A",
                    contato.getEndereco() != null ? contato.getEndereco() : "N/A",
                    contato.getEmail() != null ? contato.getEmail() : "N/A",
                    contato.getChavePix() != null ? contato.getChavePix() : "N/A"
            ));
        }
        return sb.toString();
    }


}
