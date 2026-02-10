package br.capacita.repositories;

import br.capacita.model.Livro;
import br.capacita.model.Usuario;

import java.util.ArrayList;

public class Repositorie {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;

    public Repositorie() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public void adicionarUsuario(Usuario usuario) {
        if (!this.usuarios.isEmpty()) {
            for (Usuario u : usuarios) {
                if (usuario.getCpf().equals(u.getCpf())) {
                    throw new IllegalArgumentException("CPF já cadastrado no sistema");
                }
            }
        }
        this.usuarios.add(usuario);
        System.out.println("Usuário " + usuario.getNome() + "cadastrado no sistema");
    }

    public void removerUsuario(String cpf) {
        if (this.usuarios.isEmpty()) {
            System.out.println("Lista de Usuários Vazia");
            return;
        }
        cpf = cpf.replaceAll("\\D", "");
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                this.usuarios.remove(usuario);
                System.out.println("Usuario " + usuario.getNome() + " removido do sistema");
                return;
            }
        }
        System.out.println("Usuário não encontrado");
    }

    public void listarUsuarios() {
        if (this.usuarios.isEmpty()) {
            System.out.println("Lista de Usuários Vazia");
            return;
        }
        int count = 0;
        for (Usuario usuario : usuarios) {
            count++;
            System.out.println("#" + count + " | NOME: "
                    + usuario.getNome() + " | CPF: "
                    + usuario.getCpf() + " | EMAIL: "
                    + usuario.getEmail() + " | TIPO: "
                    + usuario.tipoUsuario());
        }
    }
}
