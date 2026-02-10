package br.capacita.model;

public class Aluno extends Usuario {

    public Aluno(String nome, String email) {
        super(nome, email);
    }

    @Override
    public String tipoUsuario() {
        return "Aluno";
    }
}
