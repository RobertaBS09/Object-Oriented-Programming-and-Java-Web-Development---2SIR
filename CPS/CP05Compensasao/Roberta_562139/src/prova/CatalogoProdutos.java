package prova;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CatalogoProdutos {
    private List<Produto> produtos;

    public CatalogoProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }


    public List<Produto> catalogo() {

        Map<String, List<Produto>> grupos = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getSku));

        return grupos.keySet().stream()
                .map(sku -> grupos.get(sku).stream()
                        .sorted(Comparator.comparing(Produto::getPreco))
                        .collect(Collectors.toList())
                        .get(0))
                .sorted(Comparator.comparing(Produto::getPreco)
                        .thenComparing(Produto::getSku))
                .collect(Collectors.toList());
    }



    public Map<String, Integer> estoquePorMarca() {
        Map<String, List<Produto>> porMarca = catalogo().stream()
                .filter(p -> !p.getSituacao().equals("DESCONTINUADO"))
                .collect(Collectors.groupingBy(Produto::getMarca));

        Map<String, Integer> resultado = new HashMap<>();
        porMarca.forEach((marca, lista) ->
                resultado.put(marca, lista.stream()
                        .mapToInt(Produto::getEstoque)
                        .sum()));
        return resultado;
    }


    public List<CategoriaInfo> faixaPorCategoria() {
        List<Produto> ativos = catalogo().stream()
                .filter(p -> !p.getSituacao().equals("DESCONTINUADO"))
                .collect(Collectors.toList());


        Set<String> categorias = new HashSet<>();
        ativos.forEach(p -> p.getCategorias().forEach(c -> categorias.add(c)));

        return categorias.stream()
                .filter(c -> !c.isBlank())
                .map(c -> new CategoriaInfo(c,
                        ativos.stream()
                                .filter(p -> p.getCategorias().contains(c))
                                .mapToDouble(Produto::getPreco)
                                .min()
                                .getAsDouble(),
                        ativos.stream()
                                .filter(p -> p.getCategorias().contains(c))
                                .mapToDouble(Produto::getPreco)
                                .max()
                                .getAsDouble()))
                .sorted(Comparator.comparing(CategoriaInfo::maiorPreco).reversed()
                        .thenComparing(CategoriaInfo::categoria))
                .collect(Collectors.toList());
    }


    public List<String> maisBaratos(String categoria, int n) {
        if (categoria == null || categoria.isBlank() || n < 1)
            throw new IllegalArgumentException("Parâmetros inválidos.");

        String cat = categoria.trim().toLowerCase();

        return catalogo().stream()
                .filter(p -> !p.getSituacao().equals("DESCONTINUADO"))
                .filter(p -> p.getCategorias().contains(cat))
                .limit(n)
                .map(Produto::getSku)
                .collect(Collectors.toList());
    }
}