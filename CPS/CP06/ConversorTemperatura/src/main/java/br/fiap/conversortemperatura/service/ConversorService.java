package br.fiap.conversortemperatura.service;

import org.springframework.stereotype.Service;

@Service
public class ConversorService {
    public double converter(double valor, String tipo){

        if (tipo.equalsIgnoreCase("c-f") || tipo.equalsIgnoreCase("c-k")){
            if (valor<-273.15){
                throw new IllegalArgumentException("Temperatura abaixo do zero absoluto");
            }
        }

        return switch (tipo){
            case "c-f" -> valor * 1.8 + 32;

            case "f-c" -> (valor - 32) / 1.8;

            case "c-k" ->valor + 273.15;

            default -> throw new IllegalArgumentException("operação inválida!");

        };
    }

}
