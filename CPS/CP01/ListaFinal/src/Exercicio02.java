import java.text.DecimalFormat;
import java.util.Random;

public class Exercicio02 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0");
        Random rd= new Random();
        int numiEj= rd.nextInt(1,5);
        double[][] tempMedia = new double[numiEj][numiEj];

        preencher(tempMedia);
        imprimir(tempMedia, df);
        double media = calcularMedia(tempMedia, df);
        double[][]alerta = Alerta(tempMedia,media);
        imprimir(alerta,df);
    }

    public static void preencher(double[][] tempMedia) {
        Random rd = new Random();
        for (int i = 0; i < tempMedia.length; i++) {
            for (int j = 0; j < tempMedia[i].length; j++) {
                tempMedia[i][j] = rd.nextDouble(-50, 70);
            }
        }
    }

    public static void imprimir(double[][] tempMedia, DecimalFormat df) {

        for (int i = 0; i < tempMedia.length; i++) {
            for (int j = 0; j < tempMedia[i].length; j++) {
                System.out.print(df.format(tempMedia[i][j]) + "  ");
            }
            System.out.println();
        }
    }

    public static double calcularMedia(double[][] tempMedia, DecimalFormat df) {
        double media = 0;
        double contador = 0;
        for (int i = 0; i < tempMedia.length; i++) {
            for (int j = 0; j < tempMedia[i].length; j++) {
                media += tempMedia[i][j];
                contador++;
            }
        }
        media = media / contador;
        System.out.println("\nmedia: " + df.format(media));
        return media;
    }

    public static double[][] Alerta(double[][] tempMedia, double media) {
        double[][] alerta = new double[tempMedia.length][tempMedia[0].length];
        for (int i = 0; i < tempMedia.length; i++) {
            for (int j = 0; j < tempMedia[i].length; j++) {
                if (tempMedia[i][j] > media) {
                    alerta[i][j] = 1;
                } else {
                    alerta[i][j] = 0;
                }
            }
        }
        return alerta;
    }
}
