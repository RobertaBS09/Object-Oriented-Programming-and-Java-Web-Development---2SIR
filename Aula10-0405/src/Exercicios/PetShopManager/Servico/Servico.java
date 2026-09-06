package Exercicios.PetShopManager.Servico;

import Exercicios.PetShopManager.Animal.Animal;

public abstract class Servico {// a classe é abstrata pq nao da para gerar um servico generico ( nao existe um servico, existe um b que banho que É um servico)
    protected String nome;
    protected int duracaoMinutos;
    protected  Animal animal;

    public Servico(String nome, int duracaoMinutos) {
        this.nome = nome;
        this.duracaoMinutos = duracaoMinutos;
    }

    public abstract double calcularCusto(Animal a);

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
