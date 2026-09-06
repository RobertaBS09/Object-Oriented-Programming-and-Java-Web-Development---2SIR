package ExemploAluno;

public class Aluno {
    // atributos ou propiedades ou variáveis de instância (=objeto)
    int rm;
    String nome;
    String curso;
    double nota1;
    double nota2;
    String situacao;

    // não tem parametro pq os dados que ele vai usar para calcular a media (nota1 e nota2) já estão dentro do objeto.
    public double calcularmedia() {
        double media;
        media = (nota1 + nota2) / 2;
        return media;
    }

    public String situacionar() {
        String situacao;

        if (calcularmedia() >= 6) {
            situacao = "Aprovado";
        } else if (calcularmedia() < 6 && calcularmedia() >= 4) {
            situacao = "em exame";

        } else {
            situacao = "reprovado";
        }
        return situacao;
    }

}
