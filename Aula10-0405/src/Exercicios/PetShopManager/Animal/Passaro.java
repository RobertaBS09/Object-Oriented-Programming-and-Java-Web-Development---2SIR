package Exercicios.PetShopManager.Animal;

public class Passaro extends Animal{
    public Passaro(String nome, double peso) {
        super(nome, peso);
    }

    @Override
    public double precoBase() {
        return 30;
    }

}
