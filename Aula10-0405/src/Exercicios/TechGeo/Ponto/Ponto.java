package Exercicios.TechGeo.Ponto;

import Exercicios.TechGeo.FigurasGeometricas.Forma;

public class Ponto {
    private int coordenadaX;
    private int coordenadaY;

    public Ponto(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String toString() {
        return "(" + coordenadaX +
                ", " + coordenadaY+") | ";
    }
}
