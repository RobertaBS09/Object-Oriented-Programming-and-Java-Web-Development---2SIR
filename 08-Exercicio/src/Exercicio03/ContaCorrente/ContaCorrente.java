package Exercicio03.ContaCorrente;

import Exercicio03.Conta.Conta;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numero, double saldo, double limite) {
        super(numero, saldo);
        this.limite = limite;
    }

    @Override
    public double getSaldoDisponivel() {
        return super.getSaldoDisponivel()+this.limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Conta Corrente" +
                "Limite: R$" + limite;
    }
}
