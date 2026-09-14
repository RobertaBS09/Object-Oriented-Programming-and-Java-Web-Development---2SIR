package view;

import DAO.VendaDAO;
import DAO.VendedorDAO;
import model.Venda;
import model.Vendedor;


import java.util.List;
import static javax.swing.JOptionPane.*;

public class MenuVendedor {
    public void menu() {

        String[] opcoes = {"Cadastrar Vendedor",
                "Listar Vendedor",
                "Atualizar Vendedor",
                "Remover Vendedor",
                "Finalizar"};

        String opcao;

        do {
            opcao = (String) showInputDialog(null,
                    "Selecione uma opção",
                    "--MENU VENDEDOR--",
                    INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            switch (opcao.toLowerCase()) {
                case "cadastrar vendedor" -> cadastrar();
                case "listar vendedor" -> listar();
                case "atualizar vendedor" -> atualizar();
                case "remover vendedor" -> remover();
            }

        } while (!(opcao.toLowerCase().equals("finalizar")));

    }

    private void atualizar() {
        List<Vendedor> lista= new VendedorDAO().listar();
        Vendedor vendedor;

        vendedor = (Vendedor) showInputDialog(null,
                "Selecione o vendedor a ser atualizado",
                "--Vendedores--",
                INFORMATION_MESSAGE,
                null,
                lista.toArray(),
                lista.get(0));

        Integer id_vendedor = vendedor.getId_vendedor();

        String nome = showInputDialog("Digite o novo nome do vendedor: ");

        vendedor.setId_vendedor(id_vendedor);
        vendedor.setNome(nome);

        new VendedorDAO().atualizar(vendedor);
    }

    private void remover() {

        List<Vendedor> lista = new VendedorDAO().listar();

        if (lista.isEmpty()) {
            showMessageDialog(null, "Nenhum vendedor cadastrado.");
            return;
        }

        Vendedor vendedor = (Vendedor) showInputDialog(null,
                "Selecione um vendedor",
                "--Vendedores--",
                INFORMATION_MESSAGE,
                null,
                lista.toArray(),
                lista.get(0));

        Integer id_vendedor = vendedor.getId_vendedor();

        new VendedorDAO().remover(id_vendedor);
    }

    private void listar() {
        List<Venda> lista = new VendaDAO().listar();

        String aux = "";

        for (Venda v : lista) {
            aux += v.getVendedor().getNome() + " | Total: R$" + v.getTotal() + " | Data: " + v.getData() + "\n";
        }
        showMessageDialog(null, aux);
    }

    private void cadastrar() {

        Vendedor vendedor = new Vendedor();
        String nome = showInputDialog("Digite o nome do vendedor: ");

        vendedor.setNome(nome);

        new VendedorDAO().inserir(vendedor);


    }
}
