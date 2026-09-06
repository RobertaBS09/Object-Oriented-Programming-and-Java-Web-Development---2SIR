package Exercicios.TechGeo.Main;

import Exercicios.TechGeo.FigurasGeometricas.Cilindro;
import Exercicios.TechGeo.FigurasGeometricas.Circulo;
import Exercicios.TechGeo.Ponto.Ponto;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Ponto ponto;


        //objeto circulo
        ponto = new Ponto(0,0);
        Circulo circulo = new Circulo(5,ponto);

        //objeto cilindro
        ponto = new Ponto(2,-3);
        Cilindro cilindro= new Cilindro(8,2,ponto);

        //impressao dos dados
        System.out.println("----Circulo----");
        System.out.println(circulo);
        System.out.println("Area = "+circulo.calcularArea());


        System.out.println("----Cilindro----");
        System.out.println(cilindro);
        System.out.println("Area= "+cilindro.calcularArea());
        System.out.println("Volume= "+cilindro.calcularVolume());




    }
}
