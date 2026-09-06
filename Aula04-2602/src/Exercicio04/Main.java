package Exercicio04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Estacionamento e1=new Estacionamento("a1","urus");
        Estacionamento e2=new Estacionamento("a2","top");

        System.out.println(Estacionamento.getTotal());
    }
}
