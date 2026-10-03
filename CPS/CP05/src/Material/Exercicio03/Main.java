package Material.Exercicio03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Produto produto1 = new Produto("Garrafa", 120, "Objeto");
        Produto produto2 = new Produto("Camiseta", 200, "Vestimenta");
        Produto produto3 = new Produto("Celular", 10000, "Eletrônico");
        Produto produto4 = new Produto("Cooler", 500, "Eletrônico");

        List<Produto> listaInicial = Arrays.asList(produto1, produto2, produto3, produto4);

        List<String> ListaFinal = listaInicial.stream()
                .filter(produto -> produto.categoria().equalsIgnoreCase("Eletrônico") && produto.preco() >= 1000)
                .map(produto -> {
                    String novaString;

                    novaString = String.format("%s - Preço com desconto: %.2f", produto.nome(), produto.preco() * 0.9);

                    return novaString;
                })
                .toList();

        ListaFinal.forEach(System.out::println);

    }
}
