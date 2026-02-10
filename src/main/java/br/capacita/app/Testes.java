package br.capacita.app;

import br.capacita.model.Aluno;
import br.capacita.model.Livro;
import br.capacita.model.Usuario;
import br.capacita.repositories.Repositorie;

import java.util.Scanner;

public class Testes {
    public static void main(String[] args) {
        Repositorie repo = new Repositorie();

        Livro l1 = new Livro("Livro tal", "Paulo");

        System.out.println(l1.getId());

        repo.adicionarLivro(l1);

        repo.pesquisarLivro("tal");
    }
}
