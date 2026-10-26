package br.fiap.custoviagem.controller;

import br.fiap.custoviagem.service.ViagemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api/viagem")
public class ViagemApiController {

    private final ViagemService service;

    public ViagemApiController(ViagemService service) {
        this.service = service;
    }

    @GetMapping   // sem ele a rota não existe
    public Map<String, Object> calcular(@RequestParam double distancia,
                                        @RequestParam double consumo,
                                        @RequestParam String combustivel) {
        try {
            double litros = service.calcularLitros(distancia, consumo);
            double custo = service.calcularCusto(litros, combustivel);
            return Map.of("litros", litros, "combustivel", combustivel, "custo", custo);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}