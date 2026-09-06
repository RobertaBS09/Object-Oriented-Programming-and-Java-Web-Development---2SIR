package Exercicio01;

public class Main {
    public static void main(String[] args) {

        MonitorEnergia monitor = new MonitorEnergia(10); //passando o tamanho do vetor

        monitor.consumoEnergia(2);
        monitor.consumoEnergia(1);
        monitor.consumoEnergia(3);
        monitor.consumoEnergia(4);
        monitor.consumoEnergia(2);
        monitor.consumoEnergia(1);


       System.out.println("Media -> "+monitor.calcularMedia());
       System.out.println("Media de dias distintos -> "+monitor.CalcularMedia(3,5));


    }
}
