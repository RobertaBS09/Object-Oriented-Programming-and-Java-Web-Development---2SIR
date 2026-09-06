package Exercicio04;

public class Ponto {
    double metros;


    public void metroMilhas(double metros){
        double milhas = metros*0.000621371;
        System.out.println(metros+ " metros = "+ milhas +" milhas");
    }

    public void metrosPe(double metros){
        double pes = metros *3.28084;
        System.out.println(metros+ " metros = "+ pes +" pés");
    }
}
