package br.fiap.pedido;

import br.fiap.cliente.Cliente;
import br.fiap.item.ItemPedido;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Pedido {

    private int numeroPedido;
    private Cliente cliente;
    private ItemPedido[] itens;
    private int index;
    private String status;

    public Pedido(int numeroPedido, Cliente cliente) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.itens = new ItemPedido[20];
        this.index = 0;
        this.status = "ABERTO";
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public void setItens(ItemPedido[] itens) {
        this.itens = itens;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void adicionarItem(ItemPedido item) {
        if (index < itens.length) {
            itens[index] = item;
            index++;
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < index; i++) {
            total += itens[i].calcularSubtotal();
        }
        return total;
    }

    public String getDados() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String aux = "";

        aux += "Pedido: " + numeroPedido + "\n";
        aux += cliente.getDados() + "\n";
        aux += "Itens:\n";

        for(int i = 0; i < index; i++) {
            aux += "- " + itens[i].getDados() + "\n";
        }

        aux += "Total: " + df.format(calcularTotal());
        return aux;
    }
}