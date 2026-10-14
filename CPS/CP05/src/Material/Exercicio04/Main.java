package Material.Exercicio04;

import java.util.*;
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

        List<Produto> ListaDesconto = listaInicial.stream()
                .map(produto -> {

                    double novoPreco;

                    if (produto.categoria().equalsIgnoreCase("Eletrônico")) {
                        novoPreco = produto.preco() * 0.85;
                    } else {
                        novoPreco = produto.preco() * 0.9;
                    }
                    return new Produto(produto.nome().toUpperCase(), novoPreco, produto.categoria(), produto.avaliacao(), produto.emEstoque());
                }).toList();


        System.out.println("------Produtos com Desconto: ------");
        ListaDesconto.forEach(System.out::println);
        System.out.println("------------------------------------------\n");


        Map<String, DoubleSummaryStatistics> resumo = ListaDesconto.stream()
                .collect(Collectors.groupingBy(
                        Produto::categoria,
                        Collectors.summarizingDouble(Produto::preco)
                ));


        System.out.println("------Produtos por categoria: ------");

        resumo.forEach((cat, st) ->
                System.out.println(cat + " | qtd=" + st.getCount()
                        + " | soma=" + st.getSum()
                        + " | média=" + st.getAverage()
                        + " | mín=" + st.getMin()
                        + " | máx=" + st.getMax()));

        System.out.println("------------------------------------------\n");


        System.out.println("------Produtos em cada categoria: ------");

        Map<String, List<Produto>> grupos = ListaDesconto.stream()
                .collect(Collectors.groupingBy(Produto::categoria));

        grupos.forEach((cat, produtos) -> {
            System.out.println(cat);
            produtos.stream()
                    .sorted(Comparator.comparing(Produto::preco).reversed())
                    .forEach(p -> System.out.println("  " + p.nome() + " - " + p.preco()));
        });

        System.out.println("------------------------------------------\n");

        System.out.println("------Top 3 produtos: ------");
        List<Produto> top3 = ListaDesconto.stream()
                .sorted(Comparator.comparing(Produto::preco).reversed())
                .limit(3)
                .toList();

        top3.forEach(System.out::println);

        System.out.println("------------------------------------------\n");


    }
}
