package br.fiap.boletim.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoletimService {

    private final List<String> historico = new ArrayList<>();

    public String validarNome(String nome) {
        if (nome.isBlank()) {
            throw new IllegalArgumentException("Informe o nome do aluno!");
        }
        return nome;
    }

    public double calcularMedia(double n1, double n2, String tipo) {

        if (n1 < 0 || n1 > 10 || n2 < 0 || n2 > 10) {
            throw new IllegalArgumentException("A nota deve ser de 0-10");
        }

        if (tipo.equalsIgnoreCase("simples")) {
            return (n1 + n2) / 2;
        } else if (tipo.equalsIgnoreCase("ponderada")) {
            return n1 * 0.4 + n2 * 0.6;
        } else {
            throw new IllegalArgumentException("Tipo de média inválido!");
        }

    }

    public String situacao(double media) {

        if (media >= 6) {
            return "Aprovado";
        } else if (media >= 4) {
            return "Exame";
        } else {
            return "Reprovado";
        }
    }

    public void registrar(String nome, double media, String situacao) {
        historico.add(String.format("%s - %.2f - %s", nome, media, situacao));
    }

    public List<String> getHistorico() { return historico; }

    public void limparHistorico() { historico.clear(); }


}
