import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class ExercicioGit1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Digite o número de linhas:");
        int linhas=sc.nextInt();
        System.out.println("Digite o número de colunas:");
        int colunas = sc.nextInt();

        double [][] matrizTemp = new double[linhas][colunas];
        preencher(matrizTemp);
        double[][]mediaTemps = media(matrizTemp,linhas,colunas);
        imprimir(mediaTemps);
        maiormedia(mediaTemps);
    }

    public static void preencher(double[][]matrizTemp){
        Random rd= new Random();
        for (int i =0;i< matrizTemp.length;i++){
            for (int j = 0; j < matrizTemp[i].length; j++) {
                matrizTemp[i][j]=rd.nextDouble(0,40);
            }
        }
    }
    public static double[][] media(double[][]matrizTemp,int linhas , int colunas){
        double[][] mediaTemps = new double[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                double soma = matrizTemp[i][j];
                int count = 1;
                // cima
                if (i - 1 >= 0) {
                    soma += matrizTemp[i - 1][j];
                    count++;
                }
                // esquerda
                if (j - 1 >= 0) {
                    soma += matrizTemp[i][j - 1];
                    count++;
                }
                // direita
                if (j + 1 < colunas) {
                    soma += matrizTemp[i][j + 1];
                    count++;
                }
                mediaTemps[i][j] = soma / count;
            }
        }

        return mediaTemps;
    }

    public static void imprimir(double[][] mediaTemps){
        for (int i = 0; i < mediaTemps.length; i++) {
            for (int j = 0; j < mediaTemps[i].length; j++) {
                System.out.printf( "%.2f  ", mediaTemps[i][j]);

            }
            System.out.println();
        }
    }
    public static void maiormedia(double[][]mediaTemps){
        double maior=0;
        int indice=0;
        for (int i = 0; i < mediaTemps.length; i++) {
            for (int j = 0; j < mediaTemps[i].length; j++) {
                if (mediaTemps[i][j]>maior){
                    maior=mediaTemps[i][j];
                    indice =i;
                }
            }
        }
        System.out.printf("Maior media:%.2f , na posicao %d ",maior,indice+1);
    }

}
