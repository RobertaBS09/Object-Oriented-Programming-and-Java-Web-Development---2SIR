package Exercicio03;

public class Temperatura {
    double celcius;

    public  void calcularFah(double celcius){
        double fah =((9/5)*celcius)+32;

        System.out.println(celcius+"C° = "+fah+" F°");
    }

    public  void calcularKel(double celcius){
        double kel= celcius+273;
        System.out.println(celcius+"C° = "+kel+" K°");
    }
}
