package Exercicios.PetShopManager.Animal;

    public abstract class Animal {// a classe é abstrata pq nao da para gerar um animal generico ( nao existe um animal, existe um cachorro que É um animal)
    protected String nome;
    protected double peso;

    public Animal(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public abstract double precoBase();

    @Override
    public String toString() {
        return "Animal:  Nome --> " + nome + "Peso-->" + peso;
    }
}

