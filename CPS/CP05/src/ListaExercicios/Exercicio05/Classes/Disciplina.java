package ListaExercicios.Exercicio05.Classes;

import java.util.Objects;

public class Disciplina {
    String codigo;
    String nome;
    int semestreSugerido;

    public Disciplina(String codigo, String nome, int semestreSugerido) {
        this.codigo = codigo;
        this.nome = nome;
        this.semestreSugerido = semestreSugerido;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestreSugerido() {
        return semestreSugerido;
    }

    public void setSemestreSugerido(int semestreSugerido) {
        this.semestreSugerido = semestreSugerido;
    }

    @Override
    public String toString() {
        return "---Disciplina---" +
                "\nCodigo: " + codigo +
                "\nNome: " + nome  +
                "\nSemestre Sugerido=" + semestreSugerido +
                "\n ------------------";
    }
}
