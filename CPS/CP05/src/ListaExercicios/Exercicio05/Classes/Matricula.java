package ListaExercicios.Exercicio05.Classes;

public class Matricula {
    private Aluno aluno;
    private Disciplina disciplina;
    private double nota;


    public Matricula(Aluno aluno, Disciplina disciplina, double nota) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean aprovado(){
        return nota>=6;
    }

    @Override
    public String toString() {
        return "-----Matricula-----" +
                "\nAluno: " + aluno +
                "\nDisciplina: "+ disciplina +
                "\nNota: " + nota;
    }
}
