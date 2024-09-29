package biblioteca.somativa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Livro> livros;
	private ArrayList<Usuario> usuarios;

	// Construtor
	public Biblioteca() {
		this.livros = new ArrayList<>();
		this.usuarios = new ArrayList<>();
		carregarLivrosDoArquivo(); // Carrega os livros salvos

	}

	public void escreverArquivoLivroEmprestado(Livro livro, Usuario usuario) {
		String path = "C:\\Users\\nicol\\eclipse-workspace\\biblioteca.somativa\\arquivoCsv\\livrosEmprestados.csv"; // Caminho
																														// do
																														// CSV

		try (FileWriter fw = new FileWriter(path, true); BufferedWriter bw = new BufferedWriter(fw)) {

			// Formatação dos dados do livro emprestado para o CSV
			String linha = String.format("%s,%s,%s,%s%n", livro.getTitulo(), livro.getAutor(), livro.getIsbn(),
					usuario.getNumeroRegistro());
			bw.write(linha);

			System.out.println("Livro emprestado registrado no arquivo com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo de livros emprestados: " + e.getMessage());
		}
	}

	public void escreverArquivoUsuario(Usuario usuario) {
		String path = "C:\\Users\\nicol\\eclipse-workspace\\biblioteca.somativa\\arquivoCsv\\usuarios.csv"; // Caminho
																											// do CSV

		try (FileWriter fw = new FileWriter(path, true); BufferedWriter bw = new BufferedWriter(fw)) {

			// Formatação dos dados do usuário para o CSV
			String linha = String.format("%s,%s%n", usuario.getNome(), usuario.getNumeroRegistro());
			bw.write(linha);

			System.out.println("Usuário adicionado ao arquivo com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo de usuários: " + e.getMessage());
		}
	}

	public void carregarUsuariosDoArquivo() {
	    String path = "C:\\Users\\nicol\\eclipse-workspace\\biblioteca.somativa\\arquivoCsv\\usuarios.csv";
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	        String linha;
	        boolean primeiraLinha = true;

	        while ((linha = br.readLine()) != null) {
	            // Ignora a primeira linha, que é o cabeçalho
	            if (primeiraLinha) {
	                primeiraLinha = false;
	                continue;
	            }

	            String[] dados = linha.split(",");
	            String nome = dados[0];
	            String numeroRegistro = dados[1];

	            // Verifica se o usuário já existe
	            boolean usuarioExistente = false;
	            for (Usuario u : this.usuarios) {
	                if (u.getNumeroRegistro().equals(numeroRegistro)) {
	                    usuarioExistente = true;
	                    break;
	                }
	            }

	            if (!usuarioExistente) {
	                Usuario usuario = new Usuario(nome, numeroRegistro);
	                this.cadastrarUsuario(usuario); // Adiciona o usuário
	            }
	        }
	        System.out.println("Usuários carregados do arquivo com sucesso!");
	    } catch (IOException e) {
	        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
	    }
	}

	public void escreverArquivoLivro(Livro livro) {
		String path = "C:\\Users\\nicol\\eclipse-workspace\\biblioteca.somativa\\arquivoCsv\\livros.csv"; // Caminho
																											// para o
																											// CSV de
																											// livros

		try (FileWriter fr = new FileWriter(path, true); // 'true' para adicionar ao final
				BufferedWriter br = new BufferedWriter(fr)) {

			// Formate os dados do livro como uma linha CSV
			String linha = String.format("%s,%s,%s,%b%n", livro.getTitulo(), livro.getAutor(), livro.getIsbn(),
					livro.isDisponivel());
			br.write(linha);

			System.out.println("Livro adicionado ao arquivo com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	public void carregarLivrosDoArquivo() {
	    String path = "C:\\Users\\nicol\\eclipse-workspace\\biblioteca.somativa\\arquivoCsv\\livros.csv";
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	        String linha;
	        boolean primeiraLinha = true;

	        while ((linha = br.readLine()) != null) {
	            // Ignora a primeira linha, que é o cabeçalho
	            if (primeiraLinha) {
	                primeiraLinha = false;
	                continue;
	            }

	            String[] dados = linha.split(",");
	            String titulo = dados[0];
	            String autor = dados[1];
	            String isbn = dados[2];

	            // Verifica se o livro já existe
	            boolean livroExistente = false;
	            for (Livro l : this.livros) {
	                if (l.getIsbn().equals(isbn)) {
	                    livroExistente = true;
	                    break;
	                }
	            }

	            if (!livroExistente) {
	                boolean disponivel = Boolean.parseBoolean(dados[3]);
	                Livro livro = new Livro(titulo, autor, isbn);
	                livro.setDisponivel(disponivel); // Se você tiver um método para definir a disponibilidade
	                this.cadastrarLivro(livro); // Adiciona o livro
	            }
	        }
	        System.out.println("Livros carregados do arquivo com sucesso!");
	    } catch (IOException e) {
	        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
	    }
	}

	public void atualizarArquivoLivros() {
		String path = "C:\\Users\\nicol\\eclipse-workspace\\biblioteca.somativa\\arquivoCsv\\livros.csv";

		try (FileWriter fileWriter = new FileWriter(path, false); // 'false' para reescrever o arquivo
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			for (Livro livro : livros) {
				// Formate os dados do livro como uma linha CSV
				String linha = String.format("%s,%s,%s,%b%n", livro.getTitulo(), livro.getAutor(), livro.getIsbn(),
						livro.isDisponivel());
				bufferedWriter.write(linha);
			}

			System.out.println("Arquivo de livros atualizado com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	// Método para cadastrar um novo livro
	public void cadastrarLivro(Livro livro) {
	    // Verifica se o ISBN já existe
	    for (Livro l : this.livros) {
	        if (l.getIsbn().equals(livro.getIsbn())) {
	            System.out.println("Erro: Livro com o mesmo ISBN já cadastrado!");
	            return; // Retorna sem cadastrar
	        }
	    }
	    
	    // Se não existir, adiciona o livro
	    this.livros.add(livro);
	    escreverArquivoLivro(livro);
	} 

	// Método para cadastrar um novo usuário
	public void cadastrarUsuario(Usuario usuario) {
	    // Verifica se o número de registro já existe
	    for (Usuario u : this.usuarios) {
	        if (u.getNumeroRegistro().equals(usuario.getNumeroRegistro())) {
	            System.out.println("Erro: Número de registro já cadastrado!");
	            return; // Retorna sem cadastrar
	        }
	    }
	    
	    // Se não existir, adiciona o usuário
	    this.usuarios.add(usuario);
	    escreverArquivoUsuario(usuario); // Opcional: salve aqui se preferir
	}


	// Método para realizar o empréstimo de um livro
	public void emprestarLivro(String ISBN, String numeroRegistro) {
	    Livro livro = encontrarLivroPorISBN(ISBN);
	    Usuario usuario = encontrarUsuarioPorRegistro(numeroRegistro);

	    if (livro != null && usuario != null && livro.isDisponivel()) {
	        livro.setDisponivel(false); // Define que o livro está emprestado
	        usuario.adicionarLivroEmprestado(livro); // Adiciona o livro à lista de livros emprestados do usuário
	        
	        // Salva o empréstimo no arquivo CSV de livros emprestados
	        escreverArquivoLivroEmprestado(livro, usuario);
	        
	        System.out.println("Livro " + livro.getTitulo() + " emprestado para " + usuario.getNome());
	        atualizarArquivoLivros(); // Atualiza o CSV após o empréstimo
	    } else {
	        System.out.println("Empréstimo não pode ser realizado.");
	    }
	}


	// Método para devolver um livro
	public void devolverLivro(String ISBN, String numeroRegistro) {
		Livro livro = encontrarLivroPorISBN(ISBN);
		Usuario usuario = encontrarUsuarioPorRegistro(numeroRegistro);

		if (livro != null && usuario != null) {
			livro.setDisponivel(true); // Define que o livro está disponível novamente
			usuario.devolverLivro(livro); // Remove o livro da lista de livros emprestados do usuário
			System.out.println("Livro " + livro.getTitulo() + " devolvido por " + usuario.getNome());
			atualizarArquivoLivros(); // Atualiza o CSV após a devolução
		} else {
			System.out.println("Devolução não pode ser realizada.");
		}
	}

	// Método para exibir a lista de livros disponíveis
	public void exibirLivrosDisponiveis() {
	    System.out.println("--- Livros Disponíveis para Empréstimo ---");
	    for (Livro livro : this.livros) {
	        if (livro.isDisponivel()) { // Verifica se o livro está disponível
	            System.out.println("Título: " + livro.getTitulo() + 
	                               ", Autor: " + livro.getAutor() + 
	                               ", ISBN: " + livro.getIsbn());
	        }
	    }
	}


	// Método para encontrar um livro pelo ISBN
	private Livro encontrarLivroPorISBN(String ISBN) {
		for (Livro livro : livros) {
			if (livro.getIsbn().equals(ISBN)) {
				return livro;
			}
		}
		return null;
	}

	// Método para encontrar um usuário pelo número de registro
	private Usuario encontrarUsuarioPorRegistro(String numeroRegistro) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNumeroRegistro().equals(numeroRegistro)) {
				return usuario;
			}
		}
		return null;
	}

	public Livro[] getLivrosDisponiveis() {
		// TODO Auto-generated method stub
		return null;
	}
}
