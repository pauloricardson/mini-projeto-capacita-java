package br.capacita.app;

import br.capacita.model.Aluno;
import br.capacita.model.Professor;
import br.capacita.model.Usuario;
import br.capacita.repositories.Repositorie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Repositorie repo = new Repositorie();

        Scanner teclado = new Scanner(System.in);
        limparConsole();

        int opcaoMenuPrincipal = 0;

        while (opcaoMenuPrincipal != 5) {

            traco();
            System.out.println("Sistema de Empréstimo de Livros");
            traco();

            System.out.printf(
                    "\nEsolha o que deseja fazer: "
                    + "\n1 - Cadastrar Usuário"
                    + "\n2 - Remover Usuario"
                    + "\n3 - Empréstimo e Devolução"
                    + "\n4 - Pesquisar Livros"
                    + "\n5 - Sair\n"
                    + "Digite sua opção > "
            );

            opcaoMenuPrincipal = teclado.nextInt();

            limparConsole();

            if (opcaoMenuPrincipal <= 0 || opcaoMenuPrincipal > 7) {
                System.out.println("ATENÇÃO! Opção Inválida, tente novamente");
            }

            switch (opcaoMenuPrincipal) {
                case 1:
                    traco();
                    System.out.println("<<< Cadastro de Usuário >>>");
                    traco();

                    int opcaoUsuario;

                    do {
                        System.out.println("1 - Aluno");
                        System.out.println("2 - Professor");
                        System.out.print("> ");
                        opcaoUsuario = teclado.nextInt();
                    } while (opcaoUsuario != 1 && opcaoUsuario != 2);

                    teclado.nextLine();

                    limparConsole();

                    traco();
                    System.out.println("<<< Cadastro de Usuário >>>");
                    traco();

                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();

                    System.out.print("Email: ");
                    String email = teclado.nextLine();

                    System.out.print("CPF (somente números): ");
                    String cpf = teclado.nextLine();

                    limparConsole();

                    if (opcaoUsuario == 1) {
                        Usuario usuario = new Aluno(nome, cpf, email);
                        try {
                            repo.adicionarUsuario(usuario);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    if (opcaoUsuario == 2) {
                        Usuario usuario = new Professor(nome, cpf, email);
                        try {
                            repo.adicionarUsuario(usuario);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;
                case 2:
                    traco();
                    System.out.println("<<< Remoção de Usuário >>>");
                    traco();

                    teclado.nextLine();

                    System.out.print("Informe o CPF: ");
                    String removerPorCpf = teclado.nextLine();

                    Usuario obj = repo.remover2(removerPorCpf);

                    if (obj != null) {
                        teclado.nextLine();
                        System.out.println("Deseja remover o usuário " + obj.getNome() + "?");
                        System.out.println("1 - SIM");
                        System.out.println("2 - NÃO");
                        int opcaoRemocao = teclado.nextInt();
                        if (opcaoRemocao == 1) {
                            repo.removerUsuario(removerPorCpf);
                        } else {
                            System.out.println("Operação Cancelada");
                        }
                    } else {
                        System.out.println("Usuário não encontrado");
                    }
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

    public static void traco() {
        System.out.println("--------------------------------------------------");
    }
}
