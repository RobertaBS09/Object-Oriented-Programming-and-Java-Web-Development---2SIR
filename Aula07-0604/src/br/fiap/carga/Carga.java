package br.fiap.carga;

import br.fiap.cliente.Cliente;

import java.util.Random;

public class Carga {
    private int id;
    private double peso;
    private String destino;
    private Cliente cliente;

    public Carga(String destino, Cliente cliente) {
        this.destino = destino;
        this.cliente = cliente;
        this.id = gerarId();
        this.peso = gerarPeso();
    }

    private int gerarId() {
        Random random = new Random();
        return random.nextInt(1000, 9999);
    }

    private double gerarPeso() {
        Random random = new Random();
        return random.nextDouble(50, 200);
    }

    public String getDados() {
        String aux = "";
        aux += "ID: " + id + "\n";
        aux += "Destino: " + destino + "\n";
        aux += "Peso: " + peso + "Kg\n";
        aux += cliente.getDados();
        return aux;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public double getPeso() {
        return peso;
    }

    public String getDestino() {
        return destino;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
