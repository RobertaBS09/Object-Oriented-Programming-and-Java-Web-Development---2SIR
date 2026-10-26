package br.fiap.classificacaoimc.controller;

import br.fiap.classificacaoimc.service.ImcService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api/imc")
public class ImcController {
    private final ImcService service;

    public ImcController(ImcService service) {
        this.service = service;
    }

    @GetMapping("/classificar")
    public Map<String, Object> calcular(@RequestParam double peso,
                                        @RequestParam double altura){
        try {
            double imc = service.calcular(peso, altura);
            return Map.of("imc", imc, "classificacao", service.classificar(imc));
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
