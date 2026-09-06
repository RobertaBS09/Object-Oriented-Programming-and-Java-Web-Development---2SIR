package Exercicio02;

public class Main {
    public static void main(String[] args) {
        //ordem do exercicio item>pedido>cliente , um item é de um pedido que é de um cliente
        // gerando 3 itens

        ItemPedido i1 = new ItemPedido("Garrafa Stanley",180,3);
        ItemPedido i2 = new ItemPedido("Capinha celular",14,5);
        ItemPedido i3 = new ItemPedido("Cadeira ergonomica",870,2);

        //gerando dois pedidos
        Pedido p1 = new Pedido("11/01/2007",2);
        p1.adicionarPedido(i1);
        p1.adicionarPedido(i2);

        Pedido p2 = new Pedido("11/02/2003",1);
        p2.adicionarPedido(i3);

        //gerando um cliente
        Cliente c1= new Cliente("Roberta",123,2);

        c1.adicionarPedidio(p1);
        c1.adicionarPedidio(p2);

        System.out.println("Total de todos os pedidos: R$"+c1.Total());

    }
}
