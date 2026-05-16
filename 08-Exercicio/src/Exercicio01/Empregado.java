package Exercicio01;

public abstract class Empregado {
    protected long matricula;
    protected String nome;

    public Empregado(long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "--Empregado--" +
                "\nMatrícula--> " + matricula +
                "\nNome--> '" + nome + "\n";
    }
}
