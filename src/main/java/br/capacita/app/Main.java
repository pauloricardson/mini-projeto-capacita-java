package br.capacita.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Empréstimo de Livros");

        int opcao = 0;

        while (opcao != 7) {
            System.out.printf(
                    "\nEsolha o que deseja fazer: "
                    + "\n1 - Cadastar Livro"
                    + "\n2 - Cadatrar Aluno"
                    + "\n3 - Cadatrar Professor"
                    + "\n4 - Pesquisar Livro"
                    + "\n5 - Emprestar Livro"
                    + "\n6 - Desvolver Livro"
                    + "\n7 - Sair\n"
            );

            System.out.print("Digite sua opção >>> ");
            opcao = teclado.nextInt();
            limparConsole();
            if (opcao <= 0 || opcao > 7) {
                System.out.println("Opção Inválida, tente novamente");
            }

            switch (opcao) {
                case 1:
                    System.out.println("<<< Caradastro de Usuário >>>");
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
