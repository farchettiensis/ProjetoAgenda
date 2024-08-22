package br.com.farchettiensis.agendacontatos;

public class Contato {
    private String nome;
    private String apelido;
    private String empresa;
    private String email;
    private String endereco;
    private Telefone telefone;

    public Contato(String nome) {
        this.nome = nome;
    }

    public Contato(String nome, Telefone telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public Contato(String nome,
                   Telefone telefone,
                   String apelido,
                   String endereco,
                   String email,
                   String empresa) {
        this.nome = nome;
        this.telefone = telefone;
        this.apelido = apelido;
        this.endereco = endereco;
        this.email = email;
        this.empresa = empresa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return this.apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return this.telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}