package br.capacita.model;

public class Professor extends Usuario {

    public Professor(String nome, String cpf, String email) {
        super(nome, cpf, email);
    }

    @Override
    public String tipoUsuario() {
        return "Professor";
    }
}
