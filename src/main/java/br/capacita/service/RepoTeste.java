package br.capacita.service;

import br.capacita.model.Usuario;

import java.util.ArrayList;

public class RepoTeste {
    private ArrayList<Usuario> usuarios;

    public RepoTeste() {
        this.usuarios = new ArrayList<>();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void listar() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (Usuario u : usuarios) {
            System.out.println(u.getNome());
        }
    }
}
