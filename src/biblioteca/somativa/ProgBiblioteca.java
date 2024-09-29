package biblioteca.somativa;

import java.util.Scanner;

public class ProgBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao;

        // Carregar dados existentes de livros e usuários ao iniciar o sistema
        biblioteca.carregarLivrosDoArquivo();
        biblioteca.carregarUsuariosDoArquivo();

        do {
            System.out.println("\n--- Sistema de Gestão de Biblioteca ---");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Exibir Livros Disponíveis");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("\n-- Cadastro de Livro --");
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String ISBN = scanner.nextLine();

                    Livro livro = new Livro(titulo, autor, ISBN); // Instancia o livro
                    biblioteca.cadastrarLivro(livro); // Adiciona o livro à biblioteca
                    biblioteca.escreverArquivoLivro(livro); // Salva o livro no arquivo CSV
                    System.out.println("Livro cadastrado e salvo com sucesso!");
                    break;

                case 2:
                    System.out.println("\n-- Cadastro de Usuário --");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Número de Registro: ");
                    String numeroRegistro = scanner.nextLine();

                    Usuario usuario = new Usuario(nome, numeroRegistro); // Instancia o usuário
                    biblioteca.cadastrarUsuario(usuario); // Adiciona o usuário à biblioteca
                    biblioteca.escreverArquivoUsuario(usuario); // Salva o usuário no arquivo CSV
                    System.out.println("Usuário cadastrado e salvo com sucesso!");
                    break;

                case 3:
                    System.out.println("\n-- Empréstimo de Livro --");
                    System.out.print("ISBN do livro: ");
                    String isbnEmprestimo = scanner.nextLine();
                    System.out.print("Número de Registro do usuário: ");
                    String regEmprestimo = scanner.nextLine();

                    biblioteca.emprestarLivro(isbnEmprestimo, regEmprestimo); // Realiza o empréstimo
                    break;

                case 4:
                    System.out.println("\n-- Devolução de Livro --");
                    System.out.print("ISBN do livro: ");
                    String isbnDevolucao = scanner.nextLine();
                    System.out.print("Número de Registro do usuário: ");
                    String regDevolucao = scanner.nextLine();

                    biblioteca.devolverLivro(isbnDevolucao, regDevolucao); // Realiza a devolução
                    break;

                case 5:
                    System.out.println("\n-- Livros Disponíveis --");
                    biblioteca.exibirLivrosDisponiveis(); // Exibe apenas os livros disponíveis para empréstimo
                    break;


                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close(); // Fechar o scanner ao final
    }
}
