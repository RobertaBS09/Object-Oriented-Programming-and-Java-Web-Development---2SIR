package Exercicio02;

public class Cliente {
    String Nome;
    long CPF;
    Pedido [] pedido;
    int index;

    public Cliente(String Nome, long CPF, int totalPedidos){
        this.Nome=Nome;
        this.CPF=CPF;
        this.pedido= new Pedido[totalPedidos];
    }

    public  void adicionarPedidio(Pedido pedido){
        if(index<this.pedido.length){
            this.pedido[index]=pedido;
            index++;
        }
    }

    public double Total(){
        double valorTotal=0;
        for (int i=0; i<index; i++){
            valorTotal+= pedido[i].calcularTotal();
        }
        return valorTotal;
    }
}
