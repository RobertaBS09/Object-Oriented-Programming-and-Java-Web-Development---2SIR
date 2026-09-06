package Exercicio01;

public class MonitorEnergia {
    double[] Consumo;
    int index = 0; // fora do método pq se não a variável vai morrer depois q terminar de puxar o método , não pode ser static pq nem todo mundo vai querer contar o mesmo número de dias

    public MonitorEnergia(int tamanho) {
        this.Consumo = new double[tamanho]; // inicializando o vetor com o tamanho que é passado do mains
    }

    public void consumoEnergia(double valor) {

        if (index < Consumo.length) {
            Consumo[index] = valor;
            index++;
        }
    }

    public double calcularMedia() {// nao recebe valor porque o vetor ta aqui na classe (linha 4/8)
        double aux = 0;
        int total = 0;
        for (double valor : Consumo) { // o double valor representa a variavel dentro Consumo[indice]
            if (valor != 0) {
                aux += valor;
                total++;
            }
        }

        return aux / total;
    }

    public double CalcularMedia(int inicio, int fim) {
        double aux = 0;
        int total = 0; //quantidade de valores
        for (int i = inicio - 1; i < fim; i++) {  //porderia ter feito fim-inicio para usar de lenght
            if (Consumo[i] != 0) {
                aux += Consumo[i];
                total++;
            }

        }
        return aux / total;

    }


}
