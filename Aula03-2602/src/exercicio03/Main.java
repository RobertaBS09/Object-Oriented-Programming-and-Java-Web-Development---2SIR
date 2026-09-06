package exercicio03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        Professor professor = new Professor();

        System.out.print("Nome: ");
        professor.nome = sc.next();
        System.out.print("Total de aulas semanais: ");
        professor.totalDeAulas = sc.nextInt();
        System.out.print("Valor da aula: R$ ");
        professor.valorDaAula = sc.nextDouble();

        System.out.println("Salário bruto R$ " + professor.calcularSalarioBruto());
        System.out.println("Salário base R$ " + professor.salarioBase());
        System.out.println("Hora atividade R$ " + professor.adicionalHoraAtividade());
        System.out.println("Descanso semanal R$ " + professor.descansoSemanal());

    }
}
