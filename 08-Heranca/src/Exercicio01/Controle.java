package Exercicio01;

import java.util.ArrayList;

public class Controle {
    public static void main(String[] args) {
        ArrayList <Empregado> lista = new ArrayList<>();

        lista.add(new EmpregadoHorista(123,"Felipe",6,50));
        lista.add(new EmpregadoHorista(321,"Arthur",30,15));
        lista.add(new EmrpregadoComissionado(456,"Isabelli",400,100));
        lista.add(new EmrpregadoComissionado(789,"Lorrayne",70,67));

        for (Empregado e : lista){
            System.out.println(e);
            System.out.println("\nSalario: R$"+e.calcularSalario());
        }

    }
}
