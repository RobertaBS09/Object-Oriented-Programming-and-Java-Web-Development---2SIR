package exercicio01;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        Conta conta = new Conta();
        Conta conta2=new Conta();

        // entrada de dados
        System.out.print("Correntista --> ");
        conta.correntista = sc.next();
        conta.numero = random.nextInt(1000, 10000);

        // imprime o saldo
        System.out.println("saldo atual: R$ " + conta.saldo);

        // depósito de R$ 500
        conta.depoisitar(500);

        // imprime o saldo
        System.out.println("saldo atual: R$ " + conta.saldo);

        // saque de R$ 300
        conta.sacar(300);

        // imprime o saldo
        System.out.println("saldo atual: R$ " + conta.saldo);

        conta.transferir(200,conta2);
        System.out.println(conta.saldo);
        System.out.println(conta2.saldo);



    }
}
