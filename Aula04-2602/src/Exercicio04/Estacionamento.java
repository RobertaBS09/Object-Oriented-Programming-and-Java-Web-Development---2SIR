package Exercicio04;

public class Estacionamento {
    String placa;
    String modelo;
    static int contador = 0;

    public Estacionamento(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        contador++;
    }

    public static int getTotal() {
        return contador;
    }
}
