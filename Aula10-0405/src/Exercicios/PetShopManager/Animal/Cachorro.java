package Exercicios.PetShopManager.Animal;

public class Cachorro extends Animal {
    public Cachorro(String nome, double peso) {
        super(nome, peso);
    }


    public double precoBase() {
        double precobase;
        if (peso <= 10) {
            precobase = 40;
        } else if (peso <= 25) {
            precobase = 60;
        } else {
            precobase = 85;
        }
        return precobase;
    }


}
