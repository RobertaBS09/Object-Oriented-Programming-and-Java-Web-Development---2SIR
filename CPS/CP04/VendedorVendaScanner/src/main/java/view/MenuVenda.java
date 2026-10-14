package view;

import DAO.VendaDAO;
import DAO.VendedorDAO;
import model.Venda;
import model.Vendedor;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MenuVenda {

    static Scanner sc= new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void menu(){

        String aux = """
                ---- MENU VENDA ----
                ----------------
                | Adicionar    |
                | Listar       |
                | Remover      |
                | Total        |
                | Finalizar    |
                ----------------
                
                Digite uma opção:
                """;

        String opcao;

        do {
            System.out.print(aux);
            opcao=sc.next();

            switch (opcao.toLowerCase()){
                case "adicionar" -> adicionar();
                case "listar" -> listar();
                case "total"-> totalVendas();
                case "remover" -> remover();
            }

        }while (!(opcao.toLowerCase().equals("finalizar")));

    }

    private void totalVendas() {
        List <Venda> lista = new VendaDAO().listar();

        Double total = 0.0;

        for (Venda v: lista){
            total+=v.getTotal();
        }

        System.out.println("--- Total das vendas: R$"+total);

    }

    private void remover() {
        listar();

        Integer id;

        System.out.print("Digite o ID da venda a ser removida: ");
        id= sc.nextInt();

        new VendaDAO().remover(id);

    }


    private void listar() {

        List<Venda> lista= new VendaDAO().listar();

        String aux ="";

        for (Venda v: lista){
            aux +="ID Venda: " + v.getId_venda() +" | Vendedor: "+v.getVendedor().getNome() + " | Total: "+ v.getTotal()+ " | Data: "+ v.getData().format(formatter) +"\n";
        }

        System.out.println(aux);

    }

    private void adicionar() {

        Integer id;
        Double total;
        String data;
        Vendedor vendedor = new Vendedor();

        System.out.println("----Adicionar Venda----");

        new MenuVendedor().listar();

        System.out.print("Digite o id do vendedor que vendeu: ");
        id = sc.nextInt();

        System.out.print("\nDigite o total da compra: R$");
        total =sc.nextDouble();

        System.out.print("\n Digite a data da compra: ");
        data = sc.next();

        Venda venda = new Venda();

        vendedor.setId_vendedor(id);

        venda.setTotal(total);
        venda.setData(LocalDate.parse(data,formatter));
        venda.setVendedor(vendedor);

        new VendaDAO().inserir(venda);
    }

    }


