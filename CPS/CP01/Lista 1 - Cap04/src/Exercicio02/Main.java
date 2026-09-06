package Exercicio02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Retangulo r= new Retangulo();
        System.out.print("Base -->");
        r.base=sc.nextDouble();
        System.out.print("Altura -->");
        r.altura=sc.nextDouble();

        double perimetro=r.CalcularPerimetro(r.base,r.altura);

        System.out.print("Perimetro = " + perimetro);// eu poderia ter passado o perimetro dentro do metódo para ele imprimir mas quis usar o return rs


    }
}
