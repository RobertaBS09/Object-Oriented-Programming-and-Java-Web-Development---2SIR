package Exercicios.PetShopManager.Animal;

public class Gato extends Animal{
    String tipoDePelagem;

    public Gato(String nome, double peso, String tipoDePelagem) {
        super(nome, peso);
        this.tipoDePelagem = tipoDePelagem;
    }

    @Override
    public double precoBase() {
        double precoBase;
        if (tipoDePelagem.equalsIgnoreCase("curto")){
            precoBase=45;
        }else{
            precoBase=65;
        }
        return precoBase;
    }

    public String toString() {
        String aux = "";
        aux += super.toString();
        return aux;
    }
}
