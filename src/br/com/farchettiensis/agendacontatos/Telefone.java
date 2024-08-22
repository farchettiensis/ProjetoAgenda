package br.com.farchettiensis.agendacontatos;

public class Telefone {
    private TipoTelefone tipo;
    private String numero;

    public Telefone(String numero) {
        this.numero = numero;
    }

    public Telefone(String numero, TipoTelefone tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }
}
