package Exercicios.PetShopManager.Util;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Util {
    public void menu() {
        int opcao=0;
        String aux;

        aux = """
                [1] Cadastrar Animal
                [2] Cadastrar Serviço
                [3] Calcular a Conta total
                [4] Imprimir Relatório
                [5] Finalizar
                """;
        do {
            try {
                opcao = parseInt(showInputDialog(aux));
            } catch (NumberFormatException e) {  //passa o tipo de erro dentro do parametro
                showMessageDialog(null, "Você deve digitar um número inteiro (entre 1-6) ");
            }
            catch (Exception e ){ //esse aqui é para todos os erros, entao como não sabemos qual é o erro nao vai dar para passar uma tratativa. no caso desse programa nao vai cair nesse catch pq o de cima já pega todos
                showMessageDialog(null, "Deu erro");
            }

        } while (opcao != 5);
    }
}
