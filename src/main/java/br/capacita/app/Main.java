package br.capacita.app;

import br.capacita.model.Aluno;
import br.capacita.model.Usuario;
import br.capacita.service.RepoTeste;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        limparConsole();

        System.out.println("Bem-vindo ao Sistema de Empréstimo de Livros");

        int opcao = 0;

        while (opcao != 7) {
            System.out.printf(
                    "\nEsolha o que deseja fazer: "
                    + "\n1 - Cadastar de Usuário"
                    + "\n2 - Cadatrar Aluno"
                    + "\n3 - Cadatrar Professor"
                    + "\n4 - Pesquisar Livro"
                    + "\n5 - Emprestar Livro"
                    + "\n6 - Desvolver Livro"
                    + "\n7 - Sair\n"
            );

            System.out.print("Digite sua opção > ");
            opcao = teclado.nextInt();

            limparConsole();

            if (opcao <= 0 || opcao > 7) {
                System.out.println("Opção Inválida, tente novamente");
            }

            switch (opcao) {
                case 1:

                    System.out.println("<<< Cadastro de Usuário >>>");

                    int opcaoUsuario;

                    do {
                        System.out.println("1 - Aluno");
                        System.out.println("2 - Professor");
                        System.out.print("> ");
                        opcaoUsuario = teclado.nextInt();
                    } while (opcaoUsuario != 1 && opcaoUsuario != 2);

                    teclado.nextLine(); // limpar buffer

                    System.out.print("Nome > ");
                    String nome = teclado.nextLine();

                    System.out.print("Email > ");
                    String email = teclado.nextLine();

                    if (opcaoUsuario == 1) {
                        Usuario u = new Aluno(nome, email);
                    }

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }
    }

    public static void limparConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
