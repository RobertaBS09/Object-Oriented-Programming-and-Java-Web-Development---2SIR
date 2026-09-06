package Exercicio04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ponto p=new Ponto();

        System.out.print("Metros -->");
        p.metros = sc.nextDouble();

        p.metroMilhas(p.metros);
        p.metrosPe(p.metros);
    }
}
