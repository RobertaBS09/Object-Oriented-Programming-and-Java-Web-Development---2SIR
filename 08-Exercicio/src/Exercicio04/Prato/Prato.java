package Exercicio04.Prato;

import Exercicio04.ItemCardapio.ItemCardapio;

public class Prato extends ItemCardapio {
    public Prato(String nome, double precoBase) {
        super(nome, precoBase);
    }

    @Override
    public double calcularValor() {
        return precoBase*1.10;
    }


}
