package Exercicios.TechGeo.Main;

import Exercicios.TechGeo.FigurasGeometricas.Cilindro;
import Exercicios.TechGeo.FigurasGeometricas.Circulo;
import Exercicios.TechGeo.FigurasGeometricas.Forma;
import Exercicios.TechGeo.FigurasGeometricas.Volume;
import Exercicios.TechGeo.Ponto.Ponto;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Forma> lista= new ArrayList<>();

        lista.add(new Circulo(2,new Ponto(2,2)));
        lista.add(new Circulo(4,new Ponto(4,4)));
        lista.add(new Cilindro(3,4,new Ponto(0,0)));
        lista.add(new Cilindro(3,4,new Ponto(0,0)));

        //impressao
        for (Forma f: lista){
            System.out.println(f);// se nao tiver nenhum metodo escrito , ele ta chamando o to string
            System.out.println("Area= "+f.calcularArea());
            if (f instanceof Volume){
                System.out.println("Volume = "+((Volume) f).calcularVolume());
            }
        }

    }
}
