package org.example.calculadorathymeleaf.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
    public double calcular(int num1, int num2, String operacao) {

        return switch (operacao) {
            case "adicionar" -> num1 + num2;
            case "subtrair" -> num1 - num2;
            case "dividir" -> dividir(num1, num2);
            case "multiplicar" -> num1 * num2;

            default -> throw new IllegalArgumentException("operação inválida!");
        };

    }

    private double dividir(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Não existe divisão por 0");
        }
        return (double) num1 / num2;
    }


}
