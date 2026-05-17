package Exercicio04.Main;

import Exercicio04.Bebida.Bebida;
import Exercicio04.ItemCardapio.ItemCardapio;
import Exercicio04.Prato.Prato;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Prato p1 = new Prato("Pão com ovo", 15);
        Prato p2 = new Prato("Salada de macarrão", 45);

        Bebida b1 = new Bebida("Margarita", 40, true);
        Bebida b2 = new Bebida("Suco de Laranja", 30, false);

        ArrayList<ItemCardapio> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(b1);
        lista.add(b2);

        double total = 0;
        for (ItemCardapio i : lista) {
            System.out.println("Nome --> " + i.getNome());
            System.out.println("Valor Calculado: R$" + i.calcularValor());
            System.out.println("--------------------");
            total += i.calcularValor();
        }

        System.out.println("Valor total: R$"+total);
    }
}
