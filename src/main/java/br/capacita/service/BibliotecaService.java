package br.capacita.service;

import br.capacita.exceptions.LivroIndisponivelException;
import br.capacita.exceptions.UsuarioIndisponivelException;
import br.capacita.model.Livro;
import br.capacita.model.StatusUsuario;
import br.capacita.model.Usuario;

import java.time.LocalDateTime;

public class BibliotecaService {

    private Livro livro;
    private Usuario usuario;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public BibliotecaService(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
    }

    public void emprestarLivro() {
        if (!(usuario.getStatus().equals(StatusUsuario.ATIVO))) {
            throw new UsuarioIndisponivelException("MENSAGEM! Empréstimo indisponível, usuário não ATIVO.");
        }

        if (livro.getExemplares() <= 0 && !livro.isDisponivel()) {
            throw new LivroIndisponivelException("MENSAGEM: Livro indisponível para empréstimo.");
        }

        this.dataEmprestimo = LocalDateTime.now();
        livro.setExemplares(livro.getExemplares() - 1);
        System.out.println("MENSAGEM: Livro " + livro.getId() + " emprestado para " + usuario.getNome() + ".");
    }

    public void devolverLivro() {

    }
}
