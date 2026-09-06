package ExercicoNeoBank;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rd= new Random();
        Scanner sc= new Scanner(System.in);
        Conta c= new Conta();
        double valor;


        System.out.print("Digite o nome do titular da conta -->");
        c.nometitular=sc.nextLine();
        c.numConta=rd.nextInt(1000,9999);
        System.out.print("Numero da conta: "+c.numConta);
        System.out.println();

        System.out.print("Digite o valor a ser depositado -->");
        valor=sc.nextDouble();
        System.out.println();

        c.depositar(valor);
        System.out.print("Saldo atual: R$"+c.saldo);
        System.out.println();

        System.out.print("Digite o valor a ser sacado -> ");
        valor=sc.nextDouble();

        c.sacar(valor);
        System.out.print("Saldo atual: R$"+c.saldo);
    }
}
