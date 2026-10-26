package br.fiap.conversormoedas.controller;

import br.fiap.conversormoedas.service.CambioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;


@RestController
@RequestMapping("api/cambio")
public class CambioApiController {
    final CambioService service;

    public CambioApiController(CambioService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> apiConverte(@RequestParam double reais,
                                           @RequestParam String moeda){

        try{
            double resultado = service.converter(reais, moeda);
            return Map.of("reais",reais,"moeda",moeda,"convertido",resultado);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
