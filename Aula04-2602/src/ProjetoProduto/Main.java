package ProjetoProduto;

public class Main {
    public static void main(String[] args) {
        Produto p = new Produto(1,"arroz",100);
        System.out.println(p.getDados());
        p.Aumentar(20);
        System.out.println(p.getDados());

    }
}
