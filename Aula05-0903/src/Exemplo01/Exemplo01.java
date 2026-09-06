package Exemplo01;

public class Exemplo01 {
    public static void main(String[] args) {
        int[] x = {1, 2, 3};
        double[] y = {0.5, 1.5, 3.0};
        String[] z = {"a", "b", "c"};
        imprimir(x);
        imprimir(y);
        imprimir(z);

    }

    public static void imprimir(int x[]) {
        System.out.println("--- Vetor x ---");
        for (int i : x) {
            System.out.print(i + " | ");
        }
    }

    public static void imprimir(double y[]) {
        System.out.println("\n--- vetor y ---");
       /** for (int i = 0; i < y.length; i++) {
            System.out.print(y[i] + " | ");
        } **/
        // ou
        for (double i : y) {
            System.out.print(i + " | ");
        }
    }

    public static void imprimir(String z[]) {
        System.out.println("\n --- vetor z ---");
        /** for (int i = 0; i < z.length; i++) {
         System.out.print(z[i]+ " | ");
         } **/
        // ou
        for (String i : z) {
            System.out.print(i + " | ");
        }
    }
}
//to gag