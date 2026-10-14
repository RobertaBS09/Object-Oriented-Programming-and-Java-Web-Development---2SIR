package ListaExercicios.Exercicio05.Classes;

import java.util.Objects;

public class Aluno implements Comparable<Aluno> {

    String rm;
    String nome;
    String curso;

    public Aluno(String rm, String nome, String curso) {
        this.rm = rm;
        this.nome = nome;
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(rm, aluno.rm);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rm);
    }

    public String getRm() {
        return rm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "-----Aluno-----" +
                "\nRM: " + rm +
                "\nNome: " + nome +
                "\nCurso: " + curso;
    }

    @Override
    public int compareTo(Aluno o) {
        return this.rm.compareTo(o.getRm());
    }
}
