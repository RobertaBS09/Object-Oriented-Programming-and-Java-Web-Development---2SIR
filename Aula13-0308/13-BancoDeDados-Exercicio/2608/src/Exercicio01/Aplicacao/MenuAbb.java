package Exercicio01.Aplicacao;

import Exercicio01.Arvores.AbbInt;

import java.util.Scanner;

public class MenuAbb {
    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);
        AbbInt abb = new AbbInt();
        int opcao = 0;

        do {
            System.out.println("0 - Sair do programa\n" +
                    "1 - Insere 1 valor na ABB\n" +
                    "2 - Apresenta em ordem os elementos da ABB \n");

            System.out.print("Opção: ");
            opcao = le.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Encerrando o programa");
                    break;

                case 1:
                    System.out.print("Informe o valor a ser inserido: ");
                    int valor = le.nextInt();
                    abb.root = abb.inserir(abb.root,valor);
                    break;

                case 2:
                    System.out.println("Apresentação dos elementos presentes na ABB");
                    abb.mostrarEmOrdem(abb.root);
                    System.out.println();
                    break;

                default:
                    System.out.println("Opção inválida! ");
            }

        } while (opcao != 0);
    }
}
