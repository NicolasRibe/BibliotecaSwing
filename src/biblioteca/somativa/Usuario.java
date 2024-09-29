package biblioteca.somativa;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String numeroRegistro;
    private ArrayList<Livro> livrosEmprestados;

    // Construtor
    public Usuario(String nome, String numeroRegistro) {
        this.nome = nome;
        this.numeroRegistro = numeroRegistro;
        this.livrosEmprestados = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    // Método para adicionar livro emprestado
    public void adicionarLivroEmprestado(Livro livro) {
        livrosEmprestados.add(livro);
    }

    // Método para devolver livro
    public void devolverLivro(Livro livro) {
        livrosEmprestados.remove(livro);
    }
}
