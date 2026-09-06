package Exercicios.PetShopManager.Servico;

import Exercicios.PetShopManager.Animal.Animal;

public class Atendimento {
    private Animal animal;
    private  Servico servico;

    public Atendimento(Animal animal, Servico servico) {
        this.animal = animal;
        this.servico = servico;
    }
}
