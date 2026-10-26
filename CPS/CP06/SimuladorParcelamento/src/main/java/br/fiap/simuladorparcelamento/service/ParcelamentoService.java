package br.fiap.simuladorparcelamento.service;

import org.springframework.stereotype.Service;

@Service
public class ParcelamentoService {

    public double calcularTotal(double valor, int parcelas) {

        if (valor <= 0) {
            throw new IllegalArgumentException("O valor não pode ser menor ou igual a 0!");
        }

        return switch (parcelas) {
            case 1 -> valor * 1;
            case 3 -> valor * 1.02;
            case 6 -> valor * 1.04;
            case 12 -> valor * 1.08;
            default -> throw new IllegalArgumentException("Parcela fora da lista!");
        };


    }

    public double calcularparcelas(double total, int parcelas) {

        if (total / parcelas < 20) {
            throw new IllegalArgumentException("Parcela mínima de R$20.00");
        }

        return total/(double) parcelas;

    }

}
