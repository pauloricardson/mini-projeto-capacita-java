package br.capacita.repositories;

import br.capacita.model.Livro;
import br.capacita.model.Usuario;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;

public class Repositorie {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;

    public Repositorie() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
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
                    throw new IllegalArgumentException("ATENÇÃO: CPF já cadastrado no sistema");
                }
            }
        }
        this.usuarios.add(usuario);
        System.out.println("Usuário " + usuario.getNome() + " cadastrado no sistema");
    }

    public void removerUsuario(String cpf) {

        if (this.usuarios.isEmpty()) {
            throw new IllegalArgumentException("MENSAGEM: Usuário não encontrado.");
        }

        cpf = cpf.replaceAll("\\D", "");

        Iterator<Usuario> iterator = usuarios.iterator();

        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();

            if (usuario.getCpf().equals(cpf)) {
                iterator.remove(); // forma segura
                System.out.println("MENSAGEM: Usuario " + usuario.getNome() + " removido do sistema.");
                return;
            }
        }

        throw new IllegalArgumentException("MENSAGEM: Usuário não encontrado.");
    }

    public void pesquisarUsuario(String nome) {
        String termoNormal = normalizar(nome.toLowerCase());

        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            String nomeUsuario = normalizar(
                    usuario.getNome().toLowerCase()
            );

            if (nomeUsuario.contains(termoNormal)) {
                System.out.format(
                        "\nNome: " + usuario.getNome() +
                                "\nCPF: " + usuario.getCpf() +
                                "\nE-mail: " + usuario.getEmail() +
                                "\nTIPO: " + usuario.tipoUsuario() +
                                "\nSTATUS: " + usuario.getStatus() +
                                "\n\n"
                );
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("MENSAGEM: Sem resultados.");
        }
    }

   public Usuario selecionarUsuario (String cpf) {
        if (this.usuarios.isEmpty()) {
            throw new IllegalArgumentException("MENSAGEM: Usuário não encontrado.");
        }
        cpf = cpf.replaceAll("\\D", "");
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        throw new IllegalArgumentException("MENSAGEM: Usuário não encontrado.");
    }

    public Livro selecionarLivro(long id) {
        if (this.livros.isEmpty()) {
            throw new IllegalArgumentException("MENSAGEM: Lista de livros vazia");
        }

        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }

        throw new IllegalArgumentException("MENSAGEM: Livro não encontrado");
    }

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
        System.out.println("MENSAGEM: Livro adicionado com sucesso.");
    }

    public void removerLivro(long id) {

        if (livros.isEmpty()) {
            throw new IllegalArgumentException("MENSAGEM: Nenhum livro encontrado");
        }

        Iterator<Livro> it = livros.iterator();

        while (it.hasNext()) {
            Livro livro = it.next();

            if (livro.getId() == id) {
                it.remove();
                System.out.println("MENSAGEM: Livro " + livro.getTitulo() + " removido do sistema");
                return;
            }
        }

        throw new IllegalArgumentException("MENSAGEM: Livro não encontrado");
    }

    public void pesquisarLivro(String titulo) {
        String termoNormal = normalizar(titulo.toLowerCase());

        boolean encontrado = false;
        for (Livro livro : livros) {

            String nomeLivro = normalizar(
                    livro.getTitulo().toLowerCase()
            );

            if (nomeLivro.contains(termoNormal)) {
                System.out.println(
                        "ID: " + livro.getId() +
                                "\nTÍTULO: " + livro.getTitulo() +
                                "\nAUTOR: " + livro.getAutor() +
                                "\nN° DE EXEMPLARES: " + livro.getExemplares() +
                                "\nSTATUS: " + (livro.isDisponivel() ? "Disponível" : "Indisponível") + "\n"
                );
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum livro encontrado na pesquisa");
        }
    }

//    public void listarUsuarios() {
//        if (this.usuarios.isEmpty()) {
//            System.out.println("Lista de Usuários Vazia");
//            return;
//        }
//        int count = 0;
//        for (Usuario usuario : usuarios) {
//            count++;
//            System.out.println("#" + count + " | NOME: "
//                    + usuario.getNome() + " | CPF: "
//                    + usuario.getCpf() + " | EMAIL: "
//                    + usuario.getEmail() + " | TIPO: "
//                    + usuario.tipoUsuario());
//        }
//    }

    public String normalizar(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return texto.replaceAll("[^\\p{ASCII}]", "");
    }
}
