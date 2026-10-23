package prova;

public record CategoriaInfo(String categoria, double menorPreco, double maiorPreco) {
    public CategoriaInfo {
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("Deve ter categoria!");
        }
        if (menorPreco <= 0) {
            throw new IllegalArgumentException("Menor preço inválido!");
        }
        if (maiorPreco < menorPreco) {
            throw new IllegalArgumentException("O maior preço não pode ser menor que o menor preço!");
        }
        categoria = categoria.trim().toLowerCase();
    }
}