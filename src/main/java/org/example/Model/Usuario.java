package org.example.Model;

public class Usuario {
    private String nome;
    private String email;
    private int idade;

    public Usuario() {
    }

    public Usuario(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }
}
