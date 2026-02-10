package br.capacita.service;

import br.capacita.model.Usuario;

import java.util.ArrayList;

public class RepoTeste {
    private ArrayList<Usuario> usuarios;

    public RepoTeste(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    }
}
