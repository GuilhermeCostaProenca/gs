package br.fiap.model;

public class Usuario {

    private int id;
    private String email;
    private String senha;
    private String nome;
    private String tipo;

    public Usuario(int id, String email, String senha, String nome, String tipo) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
}

