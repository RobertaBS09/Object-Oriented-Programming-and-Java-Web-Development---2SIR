package view;

import DAO.VendaDAO;
import DAO.VendedorDAO;
import model.Venda;
import model.Vendedor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class MenuVenda {
    public void menu() {

        String[] opcoes = {"Cadastrar Venda",
                "Listar Venda",
                "Remover Venda",
                "Finalizar"};

        String opcao;

        do {
            opcao = (String) showInputDialog(null,
                    "Selecione uma opção",
                    "--MENU VENDA--",
                    INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            switch (opcao.toLowerCase()) {
                case "cadastrar venda" -> cadastrar();
                case "listar venda" -> listar();
                case "remover venda" -> remover();
            }

        } while (!(opcao.toLowerCase().equals("finalizar")));

    }

    private void remover() {

        List<Venda> lista = new VendaDAO().listar();

        if (lista.isEmpty()) {
            showMessageDialog(null, "Nenhuma venda cadastrada.");
            return;
        }

        Venda venda = (Venda) showInputDialog(null,
                "Selecione a venda a remover",
                "--Vendas--",
                INFORMATION_MESSAGE,
                null,
                lista.toArray(),
                lista.get(0));

        new VendaDAO().remover(venda.getId_venda());
    }

    private void listar() {
        List<Venda> lista = new VendaDAO().listar();

        String aux="";

        for (Venda v: lista){
            aux+= v.getVendedor().getNome() + " | Total: R$" + v.getTotal() +"\n";
        }
        showMessageDialog(null,aux);

    }

    private void cadastrar() {

        List<Vendedor> lista = new VendedorDAO().listar(); //criando essa lista para o usuario conseguir selecionar o vendedor em que a venda vai ser inserido

        Double total;
        String data;
        Vendedor vendedor;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        vendedor = (Vendedor) showInputDialog(null,
                "Selecione um vendedor",
                "--Vendedores--",
                INFORMATION_MESSAGE,
                null,
                lista.toArray(),
                lista.get(0));

        total = parseDouble(showInputDialog("Total das vendas: "));
        data = showInputDialog("Data da venda: ");

        Venda venda = new Venda();

        venda.setTotal(total);
        venda.setData(LocalDate.parse(data, formatter));
        venda.setVendedor(vendedor);//vendedor a ser atualizado

        new VendaDAO().inserir(venda);


    }
}
