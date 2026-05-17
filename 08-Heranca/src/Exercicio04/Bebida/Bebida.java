package Exercicio04.Bebida;

import Exercicio04.ItemCardapio.ItemCardapio;

public class Bebida extends ItemCardapio {
    private boolean acolica;

    public Bebida(String nome, double precoBase, boolean acolica) {
        super(nome, precoBase);
        this.acolica = acolica;
    }

    @Override
    public double calcularValor() {
        return acolica ? precoBase * 1.20 : precoBase;
    }

    public boolean isAcolica() {
        return acolica;
    }

    public void setAcolica(boolean acolica) {
        this.acolica = acolica;
    }


}
