package br.fiap.mediaaluno.service;

import org.springframework.stereotype.Service;

@Service
public class MediaService {

    public double calcularMedia(double n1, double n2, String tipo) {
        if (n1<0 || n1>10 || n2<0 ||n2>10 ){
            throw new IllegalArgumentException("A nota tem que ser de 0 a 10");
        }
        return switch (tipo) {
            case "ponderada" -> n1 * 0.4 + n2 * 0.6;
            case "simples" -> (n1 + n2) / 2;

            default -> throw new IllegalArgumentException("Valor inesperado: " + tipo);
        };



    }

    public String situacao (double media){
        if (media >= 6) {
            return "Aprovado";
        } else if (media >= 4) {
            return "Exame";
        } else {
            return "Reprovado";
        }
    }

}
