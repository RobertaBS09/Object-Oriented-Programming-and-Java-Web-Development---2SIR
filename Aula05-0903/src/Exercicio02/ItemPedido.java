package Exercicio02;

public class ItemPedido {
    String descProd;
    double precoUni;
    int quantidade;


    public ItemPedido(String descProd, double precoUni, int quantidade){
        this.descProd = descProd;
        this.precoUni=precoUni;
        this.quantidade= quantidade;
    }

    public double CalcularTotal(){
        return this.precoUni*this.quantidade;

    }
}
