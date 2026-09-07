package view;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;

public class MainMenu {
    public void menu() {

        String[] opcoes = {"Menu Vendedor",
                "Menu Venda"};

        String opcao;

        do {
            opcao = (String) showInputDialog(null,
                    "Selecione uma opção",
                    "--MENU PRINCIPAL--",
                    INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            switch (opcao.toLowerCase()) {
                case "menu vendedor" -> new MenuVendedor().menu();
                case "menu venda" -> new MenuVenda().menu();
            }

        } while (!(opcao.toLowerCase().equals("finalizar")));

    }
}
