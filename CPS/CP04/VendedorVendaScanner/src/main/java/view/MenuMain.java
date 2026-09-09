package view;

import java.util.Scanner;

public class MenuMain {

    public void menu(){

        Scanner sc = new Scanner(System.in);

        String aux = """
                ---- MENU PRINCIPAL ----
                ------------
                | Vendedor |
                | Venda    |
                | Finalizar    |
                ------------
                
                Digite uma opção:
                """;

        String opcao;

        do {
            System.out.print(aux);
            opcao=sc.next();

            switch (opcao.toLowerCase()){
                case "vendedor" -> new MenuVendedor().menu();
                case "venda" -> new MenuVenda().menu();
            }

        }while (!(opcao.toLowerCase().equals("finalizar")));

    }
}
