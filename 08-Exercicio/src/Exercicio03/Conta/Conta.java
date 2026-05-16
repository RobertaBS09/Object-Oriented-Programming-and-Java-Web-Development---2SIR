package Exercicio03.Conta;

public class Conta {
    protected String numero;
    protected double saldo;

    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    public void depositar(double valor){
        this.saldo += valor;
    }
    public double getSaldoDisponivel(){
        return this.saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "---Conta---" +
                "\nNúmero: '" + numero +
                "\nSaldo: R$" + saldo+
                "\nTipo de conta: ";
    }
}
