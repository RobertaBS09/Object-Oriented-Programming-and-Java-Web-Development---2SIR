package Extras.Biblioteca;

public class Emprestimo {
    private Livro livro;
    private String leitor;
    private int diasAtrasado;

    public Emprestimo(Livro livro, String leitor, int diasAtrasado) {
        this.livro = livro;
        this.leitor = leitor;
        this.diasAtrasado = diasAtrasado;
    }

    public boolean atrasado(){
        return diasAtrasado>0;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getLeitor() {
        return leitor;
    }

    public void setLeitor(String leitor) {
        this.leitor = leitor;
    }

    public int getDiasAtrasado() {
        return diasAtrasado;
    }

    public void setDiasAtrasado(int diasAtrasado) {
        this.diasAtrasado = diasAtrasado;
    }

    @Override
    public String toString() {
        return "------\nEmpréstimo------" +
                "\nLivro:" + livro +
                "\nLeitor: " + leitor +
                "\nDias atrasados: " + diasAtrasado+
                "------------";
    }
}
