package Extras.Simulado;

import java.util.Objects;

public class Pedido {

    private int numero;
    private String cliente;
    private String item;
    private double valor;
    private String formaPagamento;

    public Pedido(int numero, String cliente, String item, double valor, String formaPagamento) {
        this.numero = numero;
        this.cliente = cliente;
        this.item = item;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return numero == pedido.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }

    @Override
    public String toString() {
        return "Pedido: " + "| Número: " + numero + "| Cliente: " + cliente + " | Item: " + item  + " | Valor: R$" + valor + "| Forma de Pagamento: " + formaPagamento;
    }
}
