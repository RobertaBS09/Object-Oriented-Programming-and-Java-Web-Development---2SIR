package view;

import static javax.swing.JOptionPane.*;

public class MainMenu {
    public void menu() {
        String[] item = {"Categoria", "Despesa", "Finalizar"};
        String opcao;

        do {
            opcao = (String) showInputDialog(null,
                    "Selecione uma opção",
                    "--- Menu Principal ---",
                    INFORMATION_MESSAGE,
                    null,
                    item,
                    item[0]);
            switch(opcao.toLowerCase()) {
                case "categoria" -> new MenuCategoria().menu();
                case "despesa" -> new MenuDespesas().menu();
            }
        }
        while(!opcao.toLowerCase().equals("finalizar"));
    }
}
