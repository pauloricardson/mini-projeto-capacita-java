package br.capacita.service;

import br.capacita.model.Livro;
import br.capacita.model.Usuario;

import java.time.LocalDateTime;

public class BibliotecaService {

    private Livro livro;
    private Usuario usuario;
    private LocalDateTime dataEmprestimo;

    public BibliotecaService(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDateTime.now();
    }
}
