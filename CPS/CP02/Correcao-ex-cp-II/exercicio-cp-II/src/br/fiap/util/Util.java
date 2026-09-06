package br.fiap.util;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

import br.fiap.cliente.Cliente;
import br.fiap.item.ItemPedido;
import br.fiap.pedido.Pedido;

import java.text.DecimalFormat;

public class Util {
    private Pedido[] pedido = new Pedido[100];
    private int index = 0;
    private DecimalFormat df = new DecimalFormat("#,##0.00");

    public void menu() {
        String aux = gerarMenu();
        int opcao;

        do {
            opcao = parseInt(showInputDialog(aux));
            switch(opcao) {
                case 1 -> registrar();
                case 2 -> adicionarItem();
                case 3 -> finalizarPedido();
                case 4 -> pedidosAberto();
                case 5 -> faturamento();
                case 6 -> showMessageDialog(null, "Sistema Bean & Code encerrado. Até logo!");
                default -> showMessageDialog(null, "Opção inválida");
            }
        } while(opcao != 6);
    }

    private void faturamento() {
        double total = 0.0;
        for(int i = 0; i < index; i++) {
            total += pedido[i].calcularTotal();
        }
        showMessageDialog(null, "Faturamento total: R$ " + df.format(total));
    }

    private void pedidosAberto() {
        String aux = "Pedidos Abertos\n";
        for(int i = 0; i < index; i++) {
            if(pedido[i].getStatus().equalsIgnoreCase("aberto")) {
                aux += pedido[i].getDados() + "\n";
                aux += "--------------------------------------\n";
            }
        }
        showMessageDialog(null, aux);
    }

    private void finalizarPedido() {
        Pedido pedidoEncontrado;
        int numeroDoPedido;
        double total;

        numeroDoPedido = parseInt(showInputDialog("Número do pedido"));
        pedidoEncontrado = buscarPedido(numeroDoPedido);
        if(pedidoEncontrado == null) {
            showMessageDialog(null, "Pedido não encontrado");
        }
        else if(pedidoEncontrado.getStatus().equalsIgnoreCase("finalizado")) {
            showMessageDialog(null, "Pedido já está fechado");
        }
        else {
            total = pedidoEncontrado.calcularTotal();
            pedidoEncontrado.setStatus("finalizado");
            showMessageDialog(null, pedidoEncontrado.getDados() +
                    "\n\nTotal a pagar R$ " + df.format(total));
        }
    }

    private void adicionarItem() {
        String nomeDoProduto;
        double precoUnitario;
        int quantidade;
        Pedido pedidoEncontrado;
        ItemPedido itemPedido;
        int numeroDoPedido;

        numeroDoPedido = parseInt(showInputDialog("Número do pedido"));
        pedidoEncontrado = buscarPedido(numeroDoPedido);
        if(pedidoEncontrado == null) {
            showMessageDialog(null, "Pedido não encontrado");
        }
        else if(pedidoEncontrado.getStatus().equalsIgnoreCase("finalizado")) {
            showMessageDialog(null, "Não é possível adicionar novos itens");
        }
        else {
            nomeDoProduto = showInputDialog("Nome do produto");
            precoUnitario = parseDouble(showInputDialog("Preço unitário"));
            quantidade = parseInt(showInputDialog("Quantidade"));
            itemPedido = new ItemPedido(nomeDoProduto, precoUnitario, quantidade);
            pedidoEncontrado.adicionarItem(itemPedido);
        }
    }

    private void registrar() {
        String nome, cpf;
        Pedido pedidoEncontrado;
        Cliente cliente;
        int numeroDoPedido;

        numeroDoPedido = parseInt(showInputDialog("Número do pedido"));
        pedidoEncontrado = buscarPedido(numeroDoPedido);

        if(pedidoEncontrado != null) {
            showMessageDialog(null, "Pedido já existe");
        }
        else {
            nome = showInputDialog("Nome do cliente");
            cpf = showInputDialog("CPF do cliente");
            cliente = new Cliente(nome, cpf);
            this.pedido[index] = new Pedido(numeroDoPedido, cliente);
            this.index++;
        }
    }

    private String gerarMenu() {
        String aux = "#### Bean & Code Café ####\n";
        aux += "[1] Registrar novo pedido\n";
        aux += "[2] Adicionar item a um pedido\n";
        aux += "[3] Finalizar pedido\n";
        aux += "[4] Listar pedidos em aberto\n";
        aux += "[5] Exibir faturamento do dia\n";
        aux += "[6] Sair\n";
        return aux;
    }

    private Pedido buscarPedido(int numeroDoPedido) {
        for(int i = 0; i < index; i++) {
            if(pedido[i].getNumeroPedido() == numeroDoPedido) {
                return pedido[i];
            }
        }
        return null;
    }
}
