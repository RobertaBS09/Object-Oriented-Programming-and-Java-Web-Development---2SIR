package Exemplo01;

public class Main {
    public static void main(String[] args) {
        Produto[] produtos = new Produto[3];

        produtos[0] = new Produto("Camiseta", 50, 1000);
        produtos[1] = new Produto("Calça", 500, 100);
        produtos[2] = new Produto("camisa", 900, 10);
        System.out.println(produtos[0]);

        imprimir(produtos);
        imprimirValorTotalEstoque(produtos);

    }

    public static void imprimir(Produto[] produtos) {
        for (Produto i : produtos) {
            System.out.println("Nome: " + i.nome + " | Quantidade: " + i.quantidadeEstoque + " | Valor: R$" + i.valor);
        }
    }

    public static void imprimirValorTotalEstoque(Produto[] produtos) {
        double aux = 0;
        for (Produto p : produtos) {
            aux += p.quantidadeEstoque * p.valor;
        }
        System.out.println("Valor total R$" + aux);
    }
}
