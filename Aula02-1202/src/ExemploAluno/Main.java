package ExemploAluno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Aluno a = new Aluno();
        double media;
        String situacao;
        Scanner sc= new Scanner(System.in);

        System.out.print("RM->");
        a.rm=sc.nextInt();
        sc.nextLine();

        System.out.print("Nome->");
        a.nome=sc.nextLine();

        System.out.print("Curso_>");
        a.curso= sc.nextLine();

        System.out.print("Nota 1->");
        a.nota1 =sc.nextDouble();

        System.out.print("Nota 2->");
        a.nota2=sc.nextDouble();

        media= a.calcularmedia();
        System.out.println("media ="+media);

        situacao=a.situacionar();
        System.out.println("situação :"+situacao);

    }
}
