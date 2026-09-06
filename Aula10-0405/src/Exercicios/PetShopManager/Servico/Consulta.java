package Exercicios.PetShopManager.Servico;

import Exercicios.PetShopManager.Animal.Animal;

public class Consulta extends Servico{
    public Consulta(String nome, int duracaoMinutos) {
        super(nome, duracaoMinutos);
    }

    @Override
    public double calcularCusto(Animal a) {
        return a.precoBase()+35;
    }
}
