package Exercicios.TechGeo.FigurasGeometricas;

import Exercicios.TechGeo.Ponto.Ponto;

public class Circulo extends Forma {
    private double raio;
    private Ponto ponto;

    public Circulo(double raio, Ponto ponto) {

        this.raio = raio;
        this.ponto = ponto;
    }

    public double calcularArea(){
        return Math.PI*Math.pow(raio,2);
    }

    @Override
    public String toString() {
        String aux ="\n---Circulo---\n";
        aux+= ponto.toString();
        aux+=" | Raio: "+ String.format("%.2f",raio);
        return aux;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }
}
