package br.fiap.conversormoedas.service;

import org.springframework.stereotype.Service;

@Service
public class CambioService {

    public double converter(double reais, String moeda) {
        if (reais<= 0){
            throw new IllegalArgumentException("O valor não pode ser negativo");
        }
        if (reais >10000){
            throw new IllegalArgumentException("Limite de R$ 10.000 por conversão");
        }

        if (moeda.equalsIgnoreCase("USD")) {
            return reais / 5.50;
        } else if (moeda.equalsIgnoreCase("EUR")) {
            return reais / 6.00;
        } else if (moeda.equalsIgnoreCase("GBP")){
            return reais / 7.00;
        }else {
            throw new IllegalArgumentException("Moeda inválida!");
        }

    }



}

