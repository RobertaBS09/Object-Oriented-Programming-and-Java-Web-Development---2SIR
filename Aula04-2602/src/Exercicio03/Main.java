package Exercicio03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usuario, tipoTarifa;

        System.out.print("Digite o usuário -->");
        usuario = sc.next();
        System.out.print("Tipo de tarifa: Professor ou Estudante ou Normal -->");
        tipoTarifa = sc.next();

        BilheteUnico b1 = new BilheteUnico(usuario, tipoTarifa);

        System.out.println("Saldo atual R$ " + b1.saldo);
        b1.passarCatraca();
        System.out.println("Saldo atual R$ " + b1.saldo);
        b1.carregar(10);
        b1.passarCatraca();
        System.out.println("Saldo atual R$ " + b1.saldo);
    }
}
