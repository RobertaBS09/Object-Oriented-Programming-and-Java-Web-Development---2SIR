package Extras.Simulado;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Pedido pedido1 = new Pedido(1, "Felipe", "Leque", 13, "CARTAO");
        Pedido pedido2 = new Pedido(2, "Lorrayne", "Borrachinha de brinco", 10, "PIX");
        Pedido pedido3 = new Pedido(3, "Lorrayne", "Assinatura Claude", 110, "PIX");
        Pedido pedido4 = new Pedido(4, "Isabelli", "Livro", 40, "DINHEIRO");
        Pedido pedido5 = new Pedido(5, "Roberta", "Celular", 7000, "PIX");
        Pedido pedido6 = new Pedido(6, "Isabelli", "Rimel", 50, "CARTAO");
        Pedido pedido7 = new Pedido(6, "Roberta", "Perfume", 300, "DINHEIRO");
        Pedido pedido8 = new Pedido(8, "Felipe", "Essencia", 70, "PIX");


        List<Pedido> listaPedidos = Arrays.asList(pedido1, pedido2, pedido3, pedido4, pedido5, pedido6, pedido7, pedido8);


        Set<String>pagaramCartao = listaPedidos.stream()
                .filter(pedido -> pedido.getFormaPagamento().equalsIgnoreCase("CARTAO"))
                .map(Pedido::getCliente)
                .collect(Collectors.toSet());


        Set<String>pagaramPix = listaPedidos.stream()
                .filter(pedido -> pedido.getFormaPagamento().equalsIgnoreCase("PIX"))
                .map(Pedido::getCliente)
                .collect(Collectors.toSet());


        System.out.println("Pagamento somente no PIX: "+ pagaramPix.size());

        Set<String> nosDois = new HashSet<>(pagaramPix);
        nosDois.retainAll(pagaramCartao);

        Set<String>soNoPix = new HashSet<>(pagaramPix);
        soNoPix.removeAll(pagaramCartao);

        System.out.println("\n===== USARAM SOMENTE PIX =====");
        soNoPix.forEach(System.out::println);

        System.out.println("\n===== USARAM PIX E CARTAO ===== ");
        nosDois.forEach(System.out::println);

        System.out.println( "\n===== PEDIDOS ACIMA DE R$ 20,00 =====");
        List<String> pedidosCaros = listaPedidos.stream()
                .filter(pedido -> pedido.getValor()>20)
                .sorted(Comparator.comparing(Pedido::getValor).reversed())
                .map(pedido ->{
                    String texto="";
                    texto+=pedido.getCliente() +" - " +pedido.getItem() +" - R$"+pedido.getValor();
                            return texto;
                        }
                ).toList();

        pedidosCaros.forEach(System.out::println);

        // ===== a) faturamento por forma de pagamento, decrescente =====
        Map<String, Double> faturamento = listaPedidos.stream()
                .collect(Collectors.groupingBy(
                        Pedido::getFormaPagamento,              // chave
                        Collectors.summingDouble(Pedido::getValor)));  // valor

        System.out.println("\n===== FATURAMENTO POR PAGAMENTO =====");
        faturamento.entrySet().stream()
                .sorted(Comparator.comparing(
                        (Map.Entry<String, Double> e) -> e.getValue()).reversed())
                .forEach(e -> System.out.println(
                        e.getKey() + ": R$ " + String.format("%.2f", e.getValue())));


// ===== b) quantidade de pedidos por cliente =====
        Map<String, Long> pedidosPorCliente = listaPedidos.stream()
                .collect(Collectors.groupingBy(
                        Pedido::getCliente,
                        Collectors.counting()));                 // conta cada grupo

        System.out.println("\n===== PEDIDOS POR CLIENTE =====");
        pedidosPorCliente.forEach((cliente, qtd) ->
                System.out.println(cliente + ": " + qtd + " pedido(s)"));


// ===== c) itens por cliente, só quem tem 2 ou mais ====
        Map<String, List<String>> itensPorCliente = listaPedidos.stream()
                .collect(Collectors.groupingBy(
                        Pedido::getCliente,
                        Collectors.mapping(                      // troca pedido → nome do item
                                Pedido::getItem,
                                Collectors.toList())));

        System.out.println("\n===== CLIENTES COM 2+ PEDIDOS =====");
        itensPorCliente.entrySet().stream()
                .filter(e -> e.getValue().size() >= 2)
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));





    }
}
