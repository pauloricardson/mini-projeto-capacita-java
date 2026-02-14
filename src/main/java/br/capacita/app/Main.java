package br.capacita.app;

import br.capacita.model.Aluno;
import br.capacita.model.Livro;
import br.capacita.model.Professor;
import br.capacita.model.Usuario;
import br.capacita.repositories.Repositorie;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        1. Cadastrar Usuário:
            1. Aluno
            2. Professor
        2. Remover Usuário
            >> Remove por CPF: void (Talvez)
        3. Pesquisar Usuário
            >> Pesquisa pelo nome: void
                #1 | Nome: Paulo Ricardson Silva Costa | CPF: 60325749388 | EMAIL: paulo@email.com
        4. Cadastrar Livro
            >> Cadastro Simples
        5. Editar Livro
            >> Editar variáveis como número de exemplares, e talvez outro
        6. Pesquisar Livro
            >> Pesquisa livro por nome: void
                ID: 78898009828 | TÍTULO: Desenvolvimento Web | AUTOR: Paulo | EXEMPLARES: 5
        7. Empréstimo e Devolução
            1. Emprestar
            2. Devolver
            3. Listar -> enums: EMPRESTADO, DEVOLVIDO.
        8. Sair
         */

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
                            + "\n3 - Cadastrar Livro"
                            + "\n4 - Empréstimo e Devolução"
                            + "\n5 - Pesquisar Livros"
                            + "\n6 - Sair\n"
                            + "Digite sua opção > "
            );

            try {
                opcaoMenuPrincipal = teclado.nextInt();
            } catch (InputMismatchException e) {
                teclado.nextLine();
            }

            limparConsole();

            if (opcaoMenuPrincipal <= 0 || opcaoMenuPrincipal > 7) {
                System.out.println("ATENÇÃO! Opção Inválida, tente novamente");
            }

            switch (opcaoMenuPrincipal) {
                case 1:
                    traco();
                    System.out.println("<<< Cadastro de Usuário >>>");
                    traco();

                    int opcaoUsuario = 0;

                    do {
                        System.out.println("1. Aluno");
                        System.out.println("2. Professor");
                        System.out.println("3. Voltar");
                        System.out.print("> ");

                        try {
                            opcaoUsuario = teclado.nextInt();

                            if (opcaoUsuario != 1 && opcaoUsuario != 2 && opcaoUsuario != 3) {
                                throw new IllegalArgumentException();
                            }

                        } catch (Exception e) {
                            teclado.nextLine();
                            limparConsole();
                            System.out.println("ATENÇÃO! Opção inválida.");
                            traco();
                            System.out.println("<<< Cadastro de Usuário >>>");
                            traco();
                        }

                    } while (opcaoUsuario != 1 && opcaoUsuario != 2 && opcaoUsuario != 3);

                    teclado.nextLine();

                    limparConsole();

                    if (opcaoUsuario == 1) {
                        traco();
                        System.out.println("<<< Cadastro de Usuário (ALUNO) >>>");
                        traco();
                    } else if (opcaoUsuario == 2){
                        traco();
                        System.out.println("<<< Cadastro de Usuário (PROFESSOR) >>>");
                        traco();
                    } else {
                        break;
                    }

                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();

                    System.out.print("Email: ");
                    String email = teclado.nextLine();

                    System.out.print("CPF (somente números): ");
                    String cpf = teclado.nextLine();

                    traco();

                    System.out.printf("Nome: " + nome +
                            "\nE-mail: " + email +
                            "\nCPF: " + cpf + "\n");

                    traco();

                    System.out.print("Confirmar (s/n)? ");

                    String entrada;
                    char opcao = '\0';

                    do {
                        try {

                            entrada = teclado.next();

                            if (entrada.length() == 1) {
                                opcao = entrada.toLowerCase().charAt(0);
                            } else {
                                throw new IllegalArgumentException();
                            }

                            if (opcao != 's' && opcao != 'n') {
                                throw new IllegalArgumentException();
                            }

                        } catch (Exception e) {
                            System.out.print("ATENÇÃO! Opção inválida. Digite novamente (s/n): ");
                            teclado.nextLine();
                        }

                    } while (opcao != 's' && opcao != 'n');

                    limparConsole();

                    if (opcao == 's') {
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
                    } else {
                        System.out.println("ATENÇÃO! Operação cancelada");
                    }

                    break;
                case 2:
                    traco();
                    System.out.println("<<< Remoção de Usuário >>>");
                    traco();

                    teclado.nextLine();

                    System.out.print("Informe o CPF: ");
                    String removerPorCpf = teclado.nextLine();

                    Usuario obj = repo.selecionarUsuario(removerPorCpf);

                    if (obj != null) {
                        System.out.println("Deseja remover o usuário " + obj.getNome() + "?");
                        System.out.println("1 - SIM");
                        System.out.println("2 - NÃO");
                        System.out.println("> ");
                        limparConsole();
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
                    traco();
                    System.out.println("Cadastrar Livro");
                    traco();

                    teclado.nextLine();

                    System.out.print("Título: ");
                    String titulo = teclado.nextLine();

                    System.out.print("Autor: ");
                    String autor = teclado.nextLine();

                    System.out.print("Número de exemplares: ");
                    int exemplares = teclado.nextInt();

                    traco();
                    System.out.println("Deseja Cadastrar Livros?");
                    traco();
                    System.out.println("1 - Sim\n2 - Não\n> ");
                    int opcaoCadastroLivro = teclado.nextInt();

                    limparConsole();

                    if (opcaoCadastroLivro == 1) {
                        Livro livro = new Livro(titulo, autor, exemplares);
                        repo.adicionarLivro(livro);
                    } else {
                        System.out.println("Opreração não concluída");
                    }


                    break;
                case 4:
                    System.out.println("Pesquise o livro");
                    teclado.nextLine();
                    titulo = teclado.nextLine();
                    System.out.println("Resultados: ");
                    repo.pesquisarLivro(titulo);

                    System.out.println("Pressione Qualquer tecla para sair");
                    teclado.nextLine();

                    limparConsole();



                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }
        traco();
        System.out.println("<<< PROGRAMA FINALIZADO >>>");
        traco();
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
