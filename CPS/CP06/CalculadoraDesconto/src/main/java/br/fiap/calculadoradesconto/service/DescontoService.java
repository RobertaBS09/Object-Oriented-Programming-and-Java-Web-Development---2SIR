package br.fiap.calculadoradesconto.service;

import org.springframework.stereotype.Service;

@Service
public class DescontoService {

    public double aplicar(double valor, String cupom) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        return switch (cupom) {
            case "BEMVINDO" -> valor * 0.90;
            case "FIAP20"   -> valor * 0.80;
            case "METADE"   -> {
                if (valor < 100) {
                    throw new IllegalArgumentException("Cupom METADE só vale para compras a partir de R$ 100");
                }
                yield valor * 0.5;
            }
            default -> throw new IllegalArgumentException("Cupom inválido");
        };
    }
}
