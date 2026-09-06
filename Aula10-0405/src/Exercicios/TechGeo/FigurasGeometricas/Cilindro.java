package Exercicios.TechGeo.FigurasGeometricas;

import Exercicios.TechGeo.Ponto.Ponto;

public class Cilindro extends Forma implements Volume { // a classe cilindro é uma subclasse de forma e de volume, sempre primeiro o extends e o segundo implements, do extend pode receber atributos e metodos, do implements recebe somente metodos que devem estar no codigo
    private double raio;
    private double altura;
    private Ponto ponto;

    public Cilindro(double raio, double altura, Ponto ponto) {
        this.raio = raio;
        this.altura = altura;
        this.ponto = ponto;
    }
    public double calcularArea(){
        return 2*Math.PI*raio*(raio+altura);
    }

    public double calcularVolume(){
        return Math.PI*Math.pow(raio,2)*altura;
    }

    @Override
    public String toString() {
        String aux ="\n---Cilindro---\n";
        aux+= ponto.toString();
        aux+="| Raio:"+ String.format("%.2f",raio);
        aux+=" | Altura:"+ String.format("%.2f",altura);
        return aux;

    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }
}
