package view;

import DAO.PedidosDAO;
import model.Pedidos;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MenuPedido {
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void menu() {


        String aux = """
                ---------
                Adicionar
                Listar
                Encerrar
                ---------
                escolha uma opcão:
                """;

        String opcao;

        do {
            System.out.print(aux);
            opcao = sc.next();

            switch (opcao.toLowerCase()) {
                case "adicionar" -> adicionar();
                case "listar" -> listar();
            }


        } while (!(opcao.toLowerCase().equals("encerrar")));

    }

    private void listar() {

        List<Pedidos> lista = new PedidosDAO().listar();
        String aux = "";

        for (Pedidos p : lista) {
            aux += "ID Pedido: " + p.getId() + " | " + " Cliente: " + p.getCliente() + " | Total: R$" + p.getValor_total() + " | Data: " + p.getData().format(formatter) + "\n";
        }
        System.out.println(aux);

    }

    private void adicionar() {


        String data_pedido, cliente;
        Double total;

        System.out.print("Digite a data do pedido:");
        data_pedido = sc.next();

        System.out.print("\nDigite o nome do cliente: ");
        cliente = sc.next();

        System.out.println("Digite o total da compra: ");
        total = sc.nextDouble();

        Pedidos pedido = new Pedidos();

        pedido.setData(LocalDate.parse(data_pedido, formatter));
        pedido.setCliente(cliente);
        pedido.setValor_total(total);

        new PedidosDAO().inserir(pedido);


    }
}
