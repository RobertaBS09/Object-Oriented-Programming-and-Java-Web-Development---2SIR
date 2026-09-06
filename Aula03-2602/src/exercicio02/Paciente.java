package exercicio02;

public class Paciente {
    // atributos ou propriedades ou variáveis de instância
    String nome;
    int idade;

    public int frequenciaMaxima() {
        return 220 - idade;
    }

    public double[] frequenciaAlvo() {
        double[] alvo = new double[2];
        int frequencia = frequenciaMaxima();
        alvo[0] = frequencia * 0.5;
        alvo[1] = frequencia * 0.85;
        return alvo;
    }

}
