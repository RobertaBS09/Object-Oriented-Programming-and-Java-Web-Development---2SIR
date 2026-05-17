package Exercicio03.Main;

import Exercicio03.Conta.Conta;
import Exercicio03.ContaCorrente.ContaCorrente;
import Exercicio03.ContaPoupanca.ContaPoupanca;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ContaCorrente contaCorrente= new ContaCorrente("123",6700.42,18000);
        ContaPoupanca contaPoupanca= new ContaPoupanca("234",4332,50);

        ArrayList<Conta> lista = new ArrayList<>();
        lista.add(contaCorrente);
        lista.add(contaPoupanca);

        for (Conta c: lista){
            c.depositar(10000);
            System.out.println(c);
            System.out.println("Saldo: R$"+c.getSaldoDisponivel());
            if (c instanceof ContaPoupanca){
                ((ContaPoupanca) c).aplicarRendimento();
            }
        }


    }
}
