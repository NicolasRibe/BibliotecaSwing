package biblioteca.somativa;

public class Livro {
	private String titulo;
	private String autor;
	private String isbn;
	private boolean disponivel;

	// Construtor
	public Livro(String titulo, String autor, String ISBN) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = ISBN;
		this.disponivel = true; // Por padrão, o livro está disponível
	}

	
	// Getters e Setters
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
}
