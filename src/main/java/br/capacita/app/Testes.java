package br.capacita.app;

import br.capacita.model.Aluno;
import br.capacita.model.Usuario;
import br.capacita.repositories.Repositorie;

import java.util.Scanner;

public class Testes {
    public static void main(String[] args) {
        Repositorie repo = new Repositorie();

        Scanner teclado = new Scanner(System.in);

        String nome;
        String cpf;
        String email;

        for (int i = 0; i < 2; i++) {
            nome = teclado.nextLine();
            cpf = teclado.nextLine();
            email = teclado.nextLine();

            Usuario usuario = new Aluno(nome, cpf, email);
            repo.adicionarUsuario(usuario);

        }

        repo.listarUsuarios();
        System.out.println("Remover um usuario");
        String valor = teclado.nextLine();
        repo.removerUsuario(valor);

        repo.listarUsuarios();
    }
}
