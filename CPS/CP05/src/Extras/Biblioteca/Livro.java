package Extras.Biblioteca;

import java.util.Objects;

public class Livro implements Comparable<Livro> {

    private String isbn;
    private String titulo;
    private String autor;

    public Livro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(isbn, livro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public int compareTo(Livro o) {
        return this.titulo.compareTo(o.getTitulo());
    }

    @Override
    public String toString() {
        return  "\n-------Livro------"+
                "\nTítulo: " + titulo +
                "\nISBN: " + isbn +
                "\nAutor:" + autor;

    }
}
