package br.fiap.simuladorparcelamento.controller;

import br.fiap.simuladorparcelamento.service.ParcelamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;


@RestController
@RequestMapping("/api/parcelamento")
public class ParcelamentoApiController {

    private final ParcelamentoService service;

    public ParcelamentoApiController(ParcelamentoService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> parcelar(@RequestParam double valor,
                                        @RequestParam int parcelas) {

        try {
            double resultado = service.calcularTotal(valor, parcelas);
            double totalparcelas = service.calcularparcelas(resultado, parcelas);
            return Map.of("valor", valor, "parcelas", parcelas, "resultado", resultado, "totalparcelas", totalparcelas);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
