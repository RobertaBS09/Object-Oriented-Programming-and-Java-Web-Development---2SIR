package view;

import DAO.DespesaDAO;
import model.Categoria;
import model.Despesa;

import java.time.LocalDate;
import java.util.List;

import static javax.swing.JOptionPane.*;

public class MenuDespesas {

    public void menu() {

        String[] item = {
                "Cadastrar Despesa",
                "Listar Despesas",
                "Atualizar Despesa",
                "Excluir Despesa",
                "Finalizar"};
        String opcao;
        do {
            opcao = (String) showInputDialog(null, "Selecione uma opção",
                    "--- Menu Despesa ---",
                    INFORMATION_MESSAGE,
                    null,
                    item,
                    item[0]);

            switch (opcao.toLowerCase()) {
                case "cadastrar despesa" -> cadastrar();
                case "listar despesas" -> listar();
                case "atualizar despesa" -> atualizar();
                case "excluir despesa" -> excluir();
            }

        } while (!(opcao.toLowerCase().equals("finalizar")));


    }

    private void excluir() {

        Integer id = Integer.valueOf(showInputDialog("Digite o id da despesa a ser removida"));

        DespesaDAO despesaDAO = new DespesaDAO();

        despesaDAO.excluir(id);
    }

    private void atualizar() {

        String entrada = showInputDialog("Digite o ID da despesa que deseja atualizar: ");
        if (entrada == null || entrada.trim().isEmpty()) {
            return;
        }
        int id = Integer.parseInt(entrada);

        String descricao = showInputDialog("Digite a nova descrição: ");

        Despesa despesa = new Despesa();
        despesa.setId(id);
        despesa.setDescricao(descricao);

        DespesaDAO despesaDAO = new DespesaDAO();
        despesaDAO.atualizar(despesa);

    }


    private void listar() {
        List<Despesa> lista = new DespesaDAO().listar();

        if (lista.isEmpty()) {
            showMessageDialog(null, "Nenhuma despesa cadastrada.");
            return;
        }

        String aux = "";

        for (Despesa d : lista) {
            aux += d.getId() + " | "
                    + d.getDescricao() + " | "
                    + d.getValor() + " | "
                    + d.getData() + " | "
                    + "categoria " + d.getIdCategoria() + "\n";
        }

        showMessageDialog(null, aux);
    }

    private void cadastrar() {
        Despesa despesa = new Despesa();

        String descricao = showInputDialog("Digite a descrição da despesa: ");
        despesa.setDescricao(descricao);

        Double valor = Double.valueOf(showInputDialog("Digite o valor da despesa: "));
        despesa.setValor(valor);

        String dataStr = showInputDialog("Digite a data da despesa (aaaa-mm-dd): ");
        despesa.setData(LocalDate.parse(dataStr));

        Integer idCategoria = Integer.valueOf(showInputDialog("Digite o ID da categoria dessa despesa: "));
        Categoria categoria = new Categoria();
        categoria.setId(idCategoria);
        despesa.setCategoria(categoria);

        new DespesaDAO().inserir(despesa);
    }
}