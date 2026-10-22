package br.fiap.assistencia.dto;

public record ClienteRequest(String nome,
                             String email,
                             String telefone,
                             String senha) { //tem a senha pq chega na base de dados
}
