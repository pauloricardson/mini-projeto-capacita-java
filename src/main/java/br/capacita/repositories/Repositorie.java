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
        this.usuarios.add(usuario);
        System.out.println("Usuário " + usuario.getNome() + "cadastrado no sistema");
    }
}
