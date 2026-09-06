import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Exercicio03 {
    /*
    pegar o numero de lijnha(setores) e colunas(meses)
    preenhcer a matriz com o numero de quanto tal setor gastou em cada mes
    pergutar qual sera o limite
    imprimir a matriz
    quanto cada setor (linha) gastou no total(um double for mas tem a variavel zerada embaixo d oprimeiro for para que ele zere por coluna, p valor vai ter que ser amazenado em um vetor)
     qual mes (coluna) teve o maior gasto ( um double for mas so pega o matriz[j]??)
    qual setor (linha) gastou mais(comparar o valor gasto de cada linha, entao pra isso vamos ter que ter um outro vetor pra armazenar o valor gasto em cada linha)
    quais setores passaram do limite( comparar o valor gasto de cada coluna, entao pra isso vamos ter que ter um outro vetor pra armazenar o valor gasto em cada coluna)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int linha, coluna;

        System.out.print("Quantos setores?");
        linha = sc.nextInt();
        System.out.print("Quantos meses?");
        coluna = sc.nextInt();
        System.out.println("Qual sera o limite?");
        double limite = sc.nextInt();

        double[][] matriz = matriz(linha, coluna);
        preencher(matriz);
        double[] gastoSetor = calcularGastoSetor(matriz, linha);
        double[] gastoMes = calcularGastoMes(matriz, coluna);
        calcularMaioresValores(matriz, gastoSetor, gastoMes);
        passarLimite(limite,gastoSetor);
    }

    public static double[][] matriz(int linha, int coluna) {
        Random rd = new Random();
        double[][] matriz = new double[linha][coluna];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rd.nextInt(0, 10000);
            }
        }
        return matriz;
    }

    public static void preencher(double[][] matriz) {
        DecimalFormat df = new DecimalFormat("0");
        System.out.println("--------------------------");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(df.format(matriz[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public static double[] calcularGastoSetor(double[][] matriz, int linha) {
        System.out.println();
        System.out.println("----------GASTO SETOR----------------");

        double[] gastoSetor = new double[linha];
        for (int i = 0; i < matriz.length; i++) {
            gastoSetor[i] = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                gastoSetor[i] += matriz[i][j];

            }

            System.out.println("gasto do setor " + (i + 1) + ":" + gastoSetor[i]);

        }
        System.out.println("--------------------------");
        return gastoSetor;
    }

    public static double[] calcularGastoMes(double[][] matriz, int coluna) {
        System.out.println();
        System.out.println("----------GASTO DE MÊS----------------");

        double[] gastoMes = new double[coluna];

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {
                gastoMes[j] += matriz[i][j];
            }

        }
        for (int k = 0; k < coluna; k++) {
            System.out.println("Gasto do mês " + (k + 1) + ": " + gastoMes[k]);
        }
        System.out.println("-----------------------------");
        return gastoMes;
    }

    public static void calcularMaioresValores(double[][] matriz, double[] gastoSetor, double[] gastoMes) {
        int indiceSetorMaior = 0;
        double maiorSetor = gastoSetor[0];
        for (int i = 1; i < gastoSetor.length; i++) {
            if (gastoSetor[i] > maiorSetor) {
                maiorSetor = gastoSetor[i];
                indiceSetorMaior = i;
            }
        }
        System.out.println("Setor com maior gasto: " + (indiceSetorMaior + 1) + " -> " + maiorSetor);
        int indiceMesMaior = 0;
        double maiorMes = gastoMes[0];
        for (int i = 1; i < gastoMes.length; i++) {
            if (gastoMes[i] > maiorMes) {
                maiorMes = gastoMes[i];
                indiceMesMaior = i;
            }
        }
        System.out.println("Mês com maior gasto: " + (indiceMesMaior + 1) + " -> " + maiorMes);


    }

    public static void passarLimite(double limite, double[]gastoSetor){

        for (int i = 0; i <gastoSetor.length ; i++) {
            if (gastoSetor[i]>limite){
                System.out.println("O setor "+(i+1)+" passou do limite");
            }
        }
    }
}