package br.fiap.custoviagem.service;

import org.springframework.stereotype.Service;

@Service
public class ViagemService {

    public double calcularLitros(double distancia, double consumo) {

        if (distancia <= 0 || consumo <= 0) {
            throw new IllegalArgumentException("A distância e consumo tem que ser maior que 0!");
        }

        return distancia / consumo;

    }

    public double calcularCusto(double litros, String combustivel) {

        if (combustivel.equalsIgnoreCase("gasolina")) {
            return litros * 6;
        } else if (combustivel.equalsIgnoreCase("etanol")) {
            return litros * 4.2;
        } else if (combustivel.equalsIgnoreCase("diesel")) {
            return litros * 5.8;
        } else {
            throw new IllegalArgumentException("Combustível inválido");
        }

    }

}
