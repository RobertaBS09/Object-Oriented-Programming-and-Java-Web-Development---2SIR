package Exercicio04;

import javax.sql.rowset.Predicate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Celular", 30000, "eletrônico", 5, true);
        Produto produto2 = new Produto("Garrada", 189.99, "objeto", 3, false);
        Produto produto3 = new Produto("Mouse", 79, "eletrônico", 3, true);
        Produto produto4 = new Produto("Camiseta", 100.0, "vestimenta", 5, false);

        List<Produto> produtos = Arrays.asList(produto, produto2, produto3, produto4);


        List<Produto> produtosBom = produtos.stream()
                .filter(produtoF -> produtoF.avaliacao() >= 4 && produtoF.emEstoque())
                .toList();

        System.out.println("\nProdutos com a avaliação maior que 4 e em estoque");
        produtosBom.forEach(System.out::println);


        List<Produto> nomeMaiusculo = produtos.stream()
                .map(produtoM -> {
                    double precoFinal;
                    String nomeu = produtoM.nome().toUpperCase();

                    if (produtoM.categoria().equalsIgnoreCase("eletrônico")) {
                        precoFinal = produtoM.preco() * 0.85;
                    } else {
                        precoFinal = produtoM.preco() * 1.10;
                    }


                    return new Produto(nomeu, precoFinal, produto.categoria(), produto.avaliacao(), produtoM.emEstoque());
                }).toList();


        System.out.println("\nCom o nome maiusculo e novo preco ");
        nomeMaiusculo.forEach(System.out::println);


        System.out.println("\n Produtos agrupados");
        Map<String, List<Produto>> grupos = produtos.stream()
                .collect(Collectors.groupingBy(Produto::categoria));

        grupos.forEach((cat, prods) -> {
            System.out.println("\n"+ cat);
            prods.forEach(System.out::println);
        });
    }
}
