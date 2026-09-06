package Exercicio02;

public class Main {
    public static void main(String[] args) {
        //cade o hamburguer desse lancheeeee
        SenhaAtendimento senha1=new SenhaAtendimento("Roberta");
        SenhaAtendimento senha2=new SenhaAtendimento("Felipe lixo");
        SenhaAtendimento senha3=new SenhaAtendimento("Pina ina ");

        System.out.println(senha1.getDados());
        System.out.println(senha2.getDados());
        System.out.println(senha3.getDados());

    }
}
