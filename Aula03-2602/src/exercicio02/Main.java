package exercicio02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Paciente paciente = new Paciente();
        DecimalFormat df = new DecimalFormat("#,##0.00");

        int frequenciaMaxima;
        double[] alvo;

        System.out.print("Nome: ");
        paciente.nome = sc.next();
        System.out.print("Idade: ");
        paciente.idade = sc.nextInt();

        frequenciaMaxima = paciente.frequenciaMaxima();
        alvo = paciente.frequenciaAlvo();

        System.out.println("Frequência máxima --> " + frequenciaMaxima);
        System.out.println("Alvo inicial --> " + df.format(alvo[0]));
        System.out.println("Alvo final --> " + df.format(alvo[1]));
    }
}
