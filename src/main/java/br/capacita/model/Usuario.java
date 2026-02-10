package br.capacita.model;

public abstract class Usuario {

    private String nome;
    private String email;
    private String cpf;

    public Usuario(String nome, String cpf, String email) {
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }
        this.email = email;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        this.cpf = cpf.replaceAll("\\D", "");
    }

    public abstract String tipoUsuario();
}
