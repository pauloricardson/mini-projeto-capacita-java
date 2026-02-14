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

        while (opcaoMenuPrincipal != 10) {

            traco();
            System.out.println("Sistema de Empréstimo de Livros");
            traco();

            System.out.printf(
                    "\nEsolha o que deseja fazer: "
                            + "\n1. Cadastrar Usuário"
                            + "\n2. Remover Usuario"
                            + "\n3. Pesquisar Usuário"
                            + "\n4. Cadastro de Livro"
                            + "\n5. Editar Livro"
                            + "\n6 - Sair\n"
                            + "Digite sua opção > "
            );

            try {
                opcaoMenuPrincipal = teclado.nextInt();
            } catch (InputMismatchException e) {
                teclado.nextLine();
            }

            limparConsole();

            if (opcaoMenuPrincipal <= 0 || opcaoMenuPrincipal > 10) {
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

                    System.out.print("Confirmar (s/n)? ");

                    opcao = '\0';

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

                    traco();

                    if (opcao == 's') {
                        try {
                            repo.removerUsuario(removerPorCpf);
                        } catch (IllegalArgumentException e) {
                            System.out.printf(e.getMessage() + "\n");
                        }
                    } else {
                        System.out.printf("MENSAGEM: Opreação de remoção de Usuário Cancelada\n");
                    }
                    traco();
                    System.out.printf("Pressiona ENTER para voltar ao menu principal...\n");
                    teclado.nextLine();
                    teclado.nextLine();

                    limparConsole();

                    break;

                case 3:
                    traco();
                    System.out.println("<<< Pesquisar Usuário >>>");
                    traco();

                    System.out.print("Pesquisar por nome: ");

                    teclado.nextLine();

                    entrada = teclado.nextLine();

                    traco();

                    repo.pesquisarUsuario(entrada);

                    traco();
                    System.out.printf("Pressiona ENTER para voltar ao menu principal...\n");
                    teclado.nextLine();

                    limparConsole();

                    break;

                case 4:

                    traco();
                    System.out.println("<<< CADASTRO DE LIVRO >>>");
                    traco();

                    String titulo, autor;
                    int exemplares;

                    teclado.nextLine();

                    System.out.print("TÍTULO: ");
                    titulo = teclado.nextLine();

                    System.out.print("AUTOR: ");
                    autor = teclado.nextLine();

                    System.out.print("N° DE EXEMPLATES: ");

                    while (true) {
                        try {
                            exemplares = teclado.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.print("Informe um número inteiro, tente novamente: ");
                            teclado.nextLine();
                        }
                    }

                    traco();
                    System.out.println(
                            "<<< CONFERIR INFORMAÇÕES >>>" +
                            "\nTÍTULO: " + titulo +
                            "\nAUTOR: " + autor +
                            "\nN° EXEMPLATES: " + exemplares
                    );
                    traco();

                    System.out.print("Confirmar (s/n)? ");

                    entrada = "\0";
                    opcao = '\0';

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

                    traco();

                    if (opcao == 's') {
                        Livro livro = new Livro(titulo, autor, exemplares);
                        repo.adicionarLivro(livro);
                    } else {
                        System.out.printf("MENSAGEM: Opreação de cadastro de livro cancelada\n");
                    }

                    teclado.nextLine();

                    traco();

                    System.out.printf("Pressiona ENTER para voltar ao menu principal...\n");
                    teclado.nextLine();

                    limparConsole();

                    break;

                // Editar Livro
                case 5:
                    traco();
                    System.out.println("<<< EDITAR LIVRO >>>");
                    traco();

                    int opcaoLivro;
                    long id = 0;

                    System.out.print("Informe o ID: ");
                    teclado.nextLine(); // limpar buffer

                    while (true) {
                        try {
                            id = teclado.nextLong();
                            break;
                        } catch (Exception e) {
                            System.out.println("MENSAGEM: ID inválido, tente novamente: ");
                            teclado.nextLine();
                        }
                    }

                    Livro livro;

                    try {
                        livro = repo.selecionarLivro(id);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        teclado.nextLine();

                        traco();

                        System.out.printf("Pressiona ENTER para voltar ao menu principal...\n");
                        teclado.nextLine();

                        limparConsole();
                        break;
                    }

                    traco();
                    System.out.println("<<< Livro selecionado >>>");

                    System.out.println(
                            "#" + livro.getId() +
                            "\nTÍTULO: " + livro.getTitulo() +
                                    "\nN° DE EXEMPLARES: " + livro.getExemplares() +
                                    "\nSTATUS: " + (livro.isDisponivel() ? "Disponível" : "Indisponível")
                    );

                    traco();

                    System.out.println("O que deseja fazer?\n1. Editar n° de exemplares\n2. Tornar Livro dispoível/indisponível\n3. Voltar ao menu principal");

                    while (true) {
                        try {
                            System.out.print("> ");
                            opcaoLivro = teclado.nextInt();

                            if (opcaoLivro != 1 && opcaoLivro != 2 && opcaoLivro!= 3) {
                                throw new IllegalArgumentException();
                            }

                            break; // sai do loop se válido

                        } catch (Exception e) {
                            traco();
                            System.out.println("MENSAGEM: Opção inválida. Tente novamente.");
                            teclado.nextLine(); // limpar entrada inválida
                        }
                    }

                    teclado.nextLine();

                    if (opcaoLivro == 1) {
                        System.out.print("NOVO NÚMERO DE EXEMPLARES: ");
                        livro.setExemplares(teclado.nextInt());
                        if (livro.getExemplares() <= 0) {
                            livro.setDisponivel(false);
                        }

                        System.out.println("MENSAGEM: Número de exemplares atualizado.");

                    } else if (opcaoLivro == 2){
                        try {
                            if (!livro.isDisponivel()) {
                                if (livro.getExemplares() <= 0) {
                                    throw new IllegalArgumentException("MESNAGEM: O livro não pode ser habilitado, não há exemplares");
                                }
                                livro.setDisponivel(true);
                                System.out.println("MENSAGEM: Livro habilidado.");
                            } else {
                                livro.setDisponivel(false);
                                System.out.println("MENSAGEM: Livro desabilidado.");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    traco();

                    System.out.printf("Pressiona ENTER para voltar ao menu principal...\n");
                    teclado.nextLine();

                    limparConsole();
                    break;
                case 6:

                    traco();
                    System.out.println("<<< BUSCAR LIVRO >>>");
                    traco();

                    System.out.print("Busque por título: ");
                    entrada = "\0";
                    teclado.nextLine();
                    entrada = teclado.nextLine();

                    traco();

                    repo.pesquisarLivro(entrada);

                    traco();

                    System.out.printf("Pressiona ENTER para voltar ao menu principal...\n");
                    teclado.nextLine();

                    limparConsole();

                    break;

                case 7:
                    traco();
                    System.out.println("<<< REMOVER LIVRO >>>");
                    traco();

                    System.out.print("Informe o ID do LIVRO: ");

                    id = 0;

                    teclado.nextLine();

                    while (true) {
                        try {
                            id = teclado.nextLong();
                            break;
                        } catch (Exception e) {
                            System.out.println("MENSAGEM: ID inválido, tente novamente.");
                            teclado.nextLine();
                        }
                    }

                    try {
                        repo.removerLivro(id);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    traco();

                    System.out.printf("Pressiona ENTER para voltar ao menu principal...\n");
                    teclado.nextLine();
                    teclado.nextLine();

                    limparConsole();

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
