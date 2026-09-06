package Exercicios.PetShopManager.Servico;

import Exercicios.PetShopManager.Animal.Animal;

public class Banho extends Servico{
    public Banho(String nome, int duracaoMinutos) {
        super(nome, duracaoMinutos);
    }

    @Override
    public double calcularCusto(Animal a) {
        return a.precoBase()+(duracaoMinutos*0.5);
    }
}
