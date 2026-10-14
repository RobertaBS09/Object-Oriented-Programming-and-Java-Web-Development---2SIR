package view;

import DAO.VendaDAO;
import DAO.VendedorDAO;
import model.Vendedor;

import java.util.List;
import java.util.Scanner;

public class MenuVendedor {
    static Scanner sc = new Scanner(System.in);
    public void menu(){

        String aux = """
                ---- MENU VENDEDOR ----
                -------------
                | Adicionar |
                | Listar    |
                | Atualizar |
                | Remover   |
                | Finalizar |
                -------------
                
                Digite uma opção:
                """;

        String opcao;

        do {
            System.out.print(aux);
            opcao=sc.next();

            switch (opcao.toLowerCase()){
                case "adicionar" -> adicionar();
                case "listar" -> listar();
                case "atualizar" -> atualizar();
                case "remover" -> remover();
            }

        }while (!(opcao.toLowerCase().equals("finalizar")));

    }

    private void remover() {
        listar();

        Integer id;

        System.out.print("Digite o ID do vendedor a ser removido: ");
        id= sc.nextInt();

        new VendedorDAO().remover(id);

    }

    private void atualizar() {

        listar();

        Integer id;
        String nome;

        System.out.print("Digite o ID do vendedor a ser atualizado: ");
        id= sc.nextInt();

        System.out.println("Digite o novo nome do vendedor: ");
        nome=sc.next();

        Vendedor vendedor = new Vendedor();
        vendedor.setId_vendedor(id);
        vendedor.setNome(nome);

        new VendedorDAO().atualizar(vendedor);

    }

    public void listar() {

        List<Vendedor> lista= new VendedorDAO().listar();

        String aux ="";

        for (Vendedor v: lista){
            aux +="ID: "+v.getId_vendedor() + " | Nome: "+ v.getNome()+ "\n";
        }

        System.out.println(aux);

    }

    private void adicionar() {

        String nome;

        System.out.println("----Adicionar Vendedor----");

        System.out.print("Digite o nome do vendedor: ");
        nome = sc.next();

        Vendedor vendedor= new Vendedor();

        vendedor.setNome(nome);

        new VendedorDAO().inserir(vendedor);
    }

}
