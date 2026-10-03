package Material.Exercicio04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Produto produto1 = new Produto("Notebook", 5000.0, "Eletrônico", 3, true);
        Produto produto2 = new Produto("Tablet", 3000.0, "Eletrônico", 5, true);
        Produto produto3 = new Produto("Camista", 400.0, "Vestimenta", 5, false);
        Produto produto4 = new Produto("Tenis", 7000.0, "Calcado", 4, true);

        List<Produto> listaInicial = Arrays.asList(produto1, produto2, produto3, produto4);

        List<Produto> ListaRatings = listaInicial.stream()
                .filter(produto -> produto.avaliacao() >= 4).toList();


        System.out.println("------Produtos com uma nota >= 4: ------");
        ListaRatings.forEach(System.out::println);
        System.out.println("------------------------------------------\n");

        List<Produto>ListaDesconto = listaInicial.stream()
                .map(produto -> {

                    double novoPreco;

                    if (produto.categoria().equalsIgnoreCase("Eletônico")) {
                        novoPreco = produto.preco() * 0.85;
                    } else {
                        novoPreco = produto.preco() * 0.9;
                    }
                    return new Produto(produto.nome().toUpperCase(), novoPreco, produto.categoria(), produto.avaliacao(), produto.emEstoque());
                }).toList();




        System.out.println("------Produtos com Desconto: ------");
        ListaDesconto.forEach(System.out::println);
        System.out.println("------------------------------------------\n");










                }
}
