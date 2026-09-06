package ExercicoNeoBank;

public class Conta {
    String nometitular;
    int numConta;
    double saldo;


    public void depositar(double valor){
        saldo= saldo+valor;
    }

    public void sacar (double valor){
        saldo=saldo-valor;
    }


}
