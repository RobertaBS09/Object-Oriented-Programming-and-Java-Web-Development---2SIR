package br.fiap.item;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ItemPedido {

    private String nomeProduto;
    private double precoUnitario;
    private int quantidade;

    public ItemPedido(String nomeProduto, double precoUnitario, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return precoUnitario * quantidade;
    }

    public String getDados() {
        DecimalFormat df = new DecimalFormat("#,##0.00");

        return nomeProduto +
                " | Quantidade: " + quantidade +
                " | Unitário: " + df.format(precoUnitario) +
                " | Subtotal: " + df.format(calcularSubtotal());
    }
}