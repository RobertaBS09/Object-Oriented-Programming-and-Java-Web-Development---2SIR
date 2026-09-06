package br.fiap.viagem;

import br.fiap.carga.Carga;
import br.fiap.cliente.Cliente;

public class Viagem {
    private int capacidade;
    private int index;
    private Carga[] carga;
    private Cliente cliente;
    private Carga carga2;

    public Viagem() {
        this.capacidade = 10000;
        this.index = 0;
        this.carga = new Carga[20];
    }


    public boolean reservar(Carga cargas) {
        if (permitidoReservar(cargas.getPeso())) {
            this.carga[index] = cargas;
            this.index++;
            return true;
        }
        return false;
    }

    public boolean permitidoReservar(double peso) {
        double total = capacidadeReservada();
        return (total + peso) <= capacidade;
    }

    public String getDados() {
        String aux = "";
        for (int i = 0; i < index; i++) {
            aux += carga[i].getDados();
        }
        return aux;
    }

    public double capacidadeReservada() {

        double total = 0;
        for (int i = 0; i < index; i++) {
            total += carga[i].getPeso();
        }
        return total;
    }


}
