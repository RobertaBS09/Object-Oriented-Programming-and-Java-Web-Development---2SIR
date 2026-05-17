package Exercicio04.ItemCardapio;

public abstract class ItemCardapio {
    protected String nome;
    protected double precoBase;

    public ItemCardapio(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public abstract double calcularValor();


    public String getNome() {
        return nome;
    }
}
