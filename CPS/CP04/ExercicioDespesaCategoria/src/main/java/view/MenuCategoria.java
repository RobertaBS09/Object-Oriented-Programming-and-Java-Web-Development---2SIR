package view;

import DAO.CategoriaDAO;
import model.Categoria;

import java.util.List;

import static javax.swing.JOptionPane.*;

public class MenuCategoria {

    public void menu() {

        String[] item = {
                "Cadastrar Categoria",
                "Listar Categorias",
                "Buscar Categorias por ID",
                "Atualizar Categoria",
                "Excluir Categoria",
                "Finalizar"};
        String opcao;
        do {
            opcao = (String) showInputDialog(null, "Selecione uma opção",
                    "--- Menu Categoria ---",
                    INFORMATION_MESSAGE,
                    null,
                    item,
                    item[0]);

            switch (opcao.toLowerCase()) {
                case "cadastrar categoria" -> cadastrar();
                case "listar categorias" -> listar();
                case "buscar categorias por id" -> puscarPorID();
                case "atualizar categoria" -> atualizar();
                case "excluir categoria" -> excluir();
            }

        } while (!(opcao.toLowerCase().equals("finalizar")));


    }

    private void excluir() {

        Integer id = Integer.valueOf(showInputDialog("Digite o id da categoria a ser removida"));

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        categoriaDAO.excluir(id);
    }

    private void atualizar() {

        String entrada = showInputDialog("Digite o ID da categoria que deseja atualizar: ");
        if (entrada == null || entrada.trim().isEmpty()) {
            return;
        }
        int id = Integer.parseInt(entrada);

        String categoriaNova = showInputDialog("Digite a nova categoria: ");

        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.setCategoria(categoriaNova);

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.atualizar(categoria);

    }

    private void puscarPorID() {
        Integer id = Integer.valueOf((showInputDialog("Digite o ID: ")));
        Categoria categoria = new CategoriaDAO().pesquisarPorId(id);

        if (categoria == null) {
            showMessageDialog(null, "Categoria com ID: " + id + " não encontrado!");
            return;
        }

        showMessageDialog(null, categoria.getId() + " | " + categoria.getCategoria());

    }

    private void listar() {
        List<Categoria> lista = new CategoriaDAO().listar();
        String aux = "";

        for (Categoria c : lista) {
            aux += c.getId() + " | " + c.getCategoria() + "\n";
        }

        showMessageDialog(null, aux);
    }

    private void cadastrar() {
        Categoria categoria = new Categoria();
        String nome = showInputDialog("Digite a categoria: ");
        categoria.setCategoria(nome);

        new CategoriaDAO().inserir(categoria);


    }
}
