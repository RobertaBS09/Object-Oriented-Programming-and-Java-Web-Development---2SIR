package ExercicioProfessores;

import java.text.DecimalFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Professor[] professors= new Professor[3];
        Scanner sc= new Scanner(System.in);

        for (int i = 0; i < professors.length ; i++) {
            professors[i]=new Professor();
            System.out.println("------PROFESSOR "+ (i+1)+"------");
            System.out.print("Numero de aulas do professor "+(i+1)+ " -->");
            professors[i].numerodDeAulas=sc.nextInt();
            System.out.print("Valor aula do professor "+ (i+1)+" -->");
            professors[i].valorHoraAula=sc.nextDouble();
            System.out.print("Numero horas extras do professor "+(i+1)+" -->");
            professors[i].horasExtras=sc.nextDouble();

            System.out.println("Salario Base professor "+(i+1) + "-->R$"+professors[i].caluclarsalrioBase());
            System.out.println("------------------------------");
            System.out.println("Aicional hora atividade professor "+(i+1) + "-->R$"+professors[i].calcularAdicionalHoraAtiv());
            System.out.println("------------------------------");
            System.out.println("Horas extras professors "+(i+1) + "-->R$"+professors[i].calcularHorasExtras());
            System.out.println("------------------------------");
            System.out.println("DSR professor "+(i+1) + "-->R$"+professors[i].calcularDescansoSemanal());
            System.out.println("------------------------------");
            System.out.println("Salario bruto professor "+(i+1) + "-->R$"+professors[i].calcularsalarioBruto());


        }



        /*Professor p = new Professor();
        Professor p2= new Professor();
        Professor p3= new Professor();


        System.out.print("Digite o numero de aulas semanais do professor 1 -->");
        p.numerodDeAulas=sc.nextInt();
        System.out.print("Digite o numero de aulas semanais do professor 2 -->");
        p2.numerodDeAulas=sc.nextInt();
        System.out.print("Digite o numero de aulas semanais do professor 3 -->");
        p3.numerodDeAulas=sc.nextInt();

        System.out.print("Digite o valor da hora-aula do professor 1-->");
        p.valorHoraAula=sc.nextDouble();
        System.out.print("Digite o valor da hora-aula do professor 2-->");
        p2.valorHoraAula=sc.nextDouble();
        System.out.print("Digite o valor da hora-aula do professor 3-->");
        p3.valorHoraAula=sc.nextDouble();

        System.out.print("Digite o número de horas extras do professor 1 -->");
        p.horasExtras=sc.nextDouble();
        System.out.print("Digite o número de horas extras do professor 2-->");
        p2.horasExtras=sc.nextDouble();
        System.out.print("Digite o número de horas extras do professor 3-->");
        p3.horasExtras=sc.nextDouble();

        System.out.println("-------Professor 1----------");
        System.out.print("Salario base: R$ "+p.caluclarsalrioBase());
        System.out.print("\nAdicional dee hora-Atividade: R$ "+p.calcularAdicionalHoraAtiv());
        System.out.print("\nHoras Extras: R$"+p.calcularHorasExtras());
        System.out.println("\nDSR : R$"+p.calcularDescansoSemanal());
        System.out.println("\nSalário Bruto: R$"+p.calcularsalarioBruto());
        System.out.println("-------Professor 2----------");
        System.out.print("Salario base: R$ "+p2.caluclarsalrioBase());
        System.out.print("\nAdicional dee hora-Atividade: R$ "+p2.calcularAdicionalHoraAtiv());
        System.out.print("\nHoras Extras: R$"+p2.calcularHorasExtras());
        System.out.println("\nDSR : R$"+p2.calcularDescansoSemanal());
        System.out.println("\nSalário Bruto: R$"+p2.calcularsalarioBruto());
        System.out.println("-------Professor 3----------");
        System.out.print("Salario base: R$ "+p3.caluclarsalrioBase());
        System.out.print("\nAdicional dee hora-Atividade: R$ "+p3.calcularAdicionalHoraAtiv());
        System.out.print("\nHoras Extras: R$"+p3.calcularHorasExtras());
        System.out.println("\nDSR : R$"+p3.calcularDescansoSemanal());
        System.out.println("\nSalário Bruto: R$"+p3.calcularsalarioBruto());*/

    }



}
