package Exercicio03;

import java.util.Scanner;

public class Main {
    static BilheteUnico[] bilhete = new BilheteUnico[3];
    static Scanner sc = new Scanner(System.in);
    static int index;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("[1] Cadastrar bilhete");
            System.out.println("[2] Carregar bilhete");
            System.out.println("[3] Consultar bilhete");
            System.out.println("[4] Passar na catraca ");
            System.out.println("[5] Finalizar ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> carregar();
                case 3 -> consultar();
                case 4 -> passarNaCatraca();

            }
        } while (opcao != 5);


    }
    public static void consultar() {
        BilheteUnico bilhete = Pesquisar();
        if (bilhete != null) {
            System.out.println("Valor do blihete R$" + bilhete.saldo);
        }
    }
    public static double calcularTarifa() {

        return 0.0;
    }
    public static void passarNaCatraca() {
        BilheteUnico bilheteUnico= Pesquisar();
        if (bilhete!= null){
            if (!bilheteUnico.passarNaCatraca()){
                System.out.println("Saldo insuficiente");
            }
        }
        System.out.println("Saldo atual: R$"+bilheteUnico.saldo);
    }

    public static void cadastrar() {
        String nome;
        long cpf;
        String tipoTarifa;

        if (index < bilhete.length) {
            System.out.println("Nome do usuário :");
            nome = sc.next();
            System.out.println("CPF: ");
            cpf = sc.nextLong();
            System.out.println("Tipo de tarifa: estudante| professor | comum");
            tipoTarifa = sc.next();
            bilhete[index] = new BilheteUnico(new Usuario(nome, cpf, tipoTarifa));
            index++;
        } else {
            System.out.println("Erro ao gerar bilhete ");
        }
    }

    public static BilheteUnico Pesquisar() {
        long cpf;
        System.out.println("Digite o cpf:");
        cpf = sc.nextLong();

        for (int i = 0; i < index; i++) {
            if (bilhete[i].usuario.cpf == cpf) {
                return bilhete[i];
            }
        }
        System.out.println("Bilhete unico");
        return null;
    }

    public static void carregar() {
        double valor;
        BilheteUnico bilhete = Pesquisar();
        if (bilhete != null) {
            System.out.println("Valor da recarga");
            valor = sc.nextDouble();
        }
    }



}
