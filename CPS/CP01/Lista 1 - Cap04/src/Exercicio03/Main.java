package Exercicio03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Temperatura t= new Temperatura();

        System.out.println("Digite a temperatura EM CELCIUS : ");
        t.celcius= sc.nextDouble();

        t.calcularFah(t.celcius);
        t.calcularKel(t.celcius);
    }
}
