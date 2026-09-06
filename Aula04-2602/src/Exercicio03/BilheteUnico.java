package Exercicio03;

import java.util.Random;

public class BilheteUnico {
    int numBilhete;
    String usuario;
    double saldo;
    final static double ValorTarifa = 5.40;
    String tarifa;


    public BilheteUnico(String usuario, String tarifa)//oq vai receber do main
    {
        Random rd = new Random();
        this.numBilhete = rd.nextInt(1000, 9999);
        this.usuario = usuario;
        this.saldo = 0.0;
        this.tarifa = tarifa;

    }

    public void carregar(double valor) {
        this.saldo += valor;
    }

    public void passarCatraca() {
        double valor = ValorTarifa;
        if (tarifa.equalsIgnoreCase("Estudante") || tarifa.equalsIgnoreCase("Professor")) {
            valor = ValorTarifa / 2;
        }

        if (saldo < valor) {
            return; // return para sair do metodo ( o break dos metodos)
        }

        saldo -= valor;
    }


}
