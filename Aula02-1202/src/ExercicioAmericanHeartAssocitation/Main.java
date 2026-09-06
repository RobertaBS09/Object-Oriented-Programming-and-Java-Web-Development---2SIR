package ExercicioAmericanHeartAssocitation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Paciente p= new Paciente();

        System.out.print("Digite o nome do paciente -->");
        p.nome=sc.nextLine();


        System.out.print("\nDigite a idadade do paciente -->");
        p.idade= sc.nextInt();


        System.out.println("\nFrequência cardíaca máxima -->"+ p.calcularFrequenciaMax());
        System.out.print("Frequência cardíaca alvo --> "+ p.calcularLimiteInferior()+ " | "+ p.calcularLimiteSuperior());
    }
}
