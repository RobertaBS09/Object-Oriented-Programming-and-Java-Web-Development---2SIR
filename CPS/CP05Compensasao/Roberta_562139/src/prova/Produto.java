package prova;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String sku;
    private String marca;
    private int estoque;
    private double preco;
    private List<String> categorias;
    private String situacao;

    public Produto(String sku, String marca, int estoque, double preco,
                   List<String> categorias, String situacao) {

        if (sku == null || marca == null || situacao == null) {
            throw new IllegalArgumentException("SKU, marca e situacao não podem ser null!");
        }

        String skuNormalizado = sku.trim().toUpperCase();
        String marcaNormalizada = marca.trim();
        String situacaoNormalizada = situacao.trim().toUpperCase();

        if (skuNormalizado.isBlank() || marcaNormalizada.isBlank()) {
            throw new IllegalArgumentException("SKU e marca não podem estar em branco!");
        }
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo!");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço não pode ser zero ou negativo!");
        }
        if (!(situacaoNormalizada.equals("DISPONIVEL")
                || situacaoNormalizada.equals("SOB_ENCOMENDA")
                || situacaoNormalizada.equals("DESCONTINUADO"))) {
            throw new IllegalArgumentException("Situação inválida!");
        }
        if (situacaoNormalizada.equals("DISPONIVEL") && estoque == 0) {
            throw new IllegalArgumentException("Um produto disponível precisa ter estoque!");
        }

        List<String> categoriasNormalizadas = new ArrayList<>();
        if (categorias != null) {
            for (String c : categorias) {
                categoriasNormalizadas.add(c.trim().toLowerCase());
            }
        }

        this.sku = skuNormalizado;
        this.marca = marcaNormalizada;
        this.estoque = estoque;
        this.preco = preco;
        this.categorias = categoriasNormalizadas;
        this.situacao = situacaoNormalizada;
    }

    public String getSku() { return sku; }
    public String getMarca() { return marca; }
    public int getEstoque() { return estoque; }
    public double getPreco() { return preco; }
    public List<String> getCategorias() { return categorias; }
    public String getSituacao() { return situacao; }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Produto) {
            return this.sku.equals(((Produto) o).getSku());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.sku.hashCode();
    }
}