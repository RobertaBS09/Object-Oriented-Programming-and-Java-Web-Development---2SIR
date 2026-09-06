package exercicio01;

public class Conta {
    String correntista;
    int numero;
    double saldo;

    public void sacar(double valor) {
        saldo = saldo - valor;
    }

    public void depoisitar(double valor) {
        saldo = saldo + valor;
    }

    public void transferir( double valor , Conta destino){
        sacar(valor);
        destino.depoisitar(valor);
    }

}
