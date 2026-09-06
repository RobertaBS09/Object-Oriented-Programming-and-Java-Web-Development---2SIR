package Exercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bicicleta B= new Bicicleta();

        System.out.print("Digite a cor da bicicleta--> ");
        B.cor= sc.next();
        System.out.print("Digite o número de marchas -->");
        B.NumMarchas= sc.nextInt();
        System.out.print("Digite o valor --> R$");
        B.valor=sc.nextDouble();

        B.RetornarDados(B.cor,B.NumMarchas,B.valor);
    }
}
