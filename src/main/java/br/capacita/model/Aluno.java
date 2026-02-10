package br.capacita.model;

public class Aluno extends Usuario {

    public Aluno(String nome, String cpf, String email) {
        super(nome, cpf, email);
    }

    @Override
    public String tipoUsuario() {
        return "Aluno";
    }
}
