package prova;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Produto> ofertas = Arrays.asList(
                new Produto("SKU-10", "Sonix", 12, 199.90, Arrays.asList("audio", "fone"), "DISPONIVEL"),
                new Produto(" sku-11 ", "Vexa", 0, 89.90, Arrays.asList("audio"), "SOB_ENCOMENDA"),
                new Produto("SKU-12", "Sonix", 5, 349.00, Arrays.asList("video", "tv"), "disponivel"),
                new Produto("SKU-10", "Sonix", 3, 179.90, Arrays.asList("audio", "fone"), "DISPONIVEL"),
                new Produto("SKU-13", "Kora", 8, 59.90, Arrays.asList("acessorio", "cabo", "Cabo"), "DISPONIVEL"),
                new Produto("SKU-14", "Vexa", 2, 1299.00, Arrays.asList("video", "tv"), "DISPONIVEL"),
                new Produto("SKU-11", "Vexa", 4, 99.90, Arrays.asList("audio"), "DISPONIVEL"),
                new Produto("SKU-15", "Kora", 0, 39.90, Arrays.asList("acessorio"), "DESCONTINUADO"),
                new Produto("SKU-16", "Sonix", 7, 89.90, Arrays.asList("audio", "fone"), "DISPONIVEL"),
                new Produto("SKU-17", "Lumo", 1, 749.00, Arrays.asList("video", "projetor"), "disponivel"),
                new Produto("SKU-18", "Lumo", 0, 129.00, Arrays.asList("Audio", "Caixa"), "sob_encomenda"),
                new Produto(" sku-13 ", "Kora", 20, 59.90, Arrays.asList("acessorio"), "DISPONIVEL"),
                new Produto("SKU-19", "Vexa", 6, 24.90, Arrays.asList("cabo"), "DISPONIVEL"),
                new Produto("SKU-20", "Kora", 0, 15.00, Arrays.asList("cabo"), "DESCONTINUADO"),
                new Produto("SKU-21", "Lumo", 9, 159.90, Arrays.asList("audio"), "DISPONIVEL")
        );

        CatalogoProdutos catalogo = new CatalogoProdutos(Collections.unmodifiableList(ofertas));

        System.out.println("== A ==");
        for (Produto p : catalogo.catalogo()) {
            System.out.println(p.getSku() + ";"
                    + String.format(Locale.US, "%.2f", p.getPreco()));
        }

        System.out.println("== B ==");
        Map<String, Integer> estoque = catalogo.estoquePorMarca();
        estoque.keySet().stream().sorted()
                .forEach(m -> System.out.println(m + ";" + estoque.get(m)));

        System.out.println("== C ==");
        for (CategoriaInfo c : catalogo.faixaPorCategoria()) {
            System.out.println(c.categoria() + ";"
                    + String.format(Locale.US, "%.2f", c.menorPreco()) + ";"
                    + String.format(Locale.US, "%.2f", c.maiorPreco()));
        }

        System.out.println("== D ==");
        System.out.println(catalogo.maisBaratos(" Audio ", 3));
    }
}