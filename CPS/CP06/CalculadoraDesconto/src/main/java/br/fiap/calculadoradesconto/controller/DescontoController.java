package br.fiap.calculadoradesconto.controller;

import br.fiap.calculadoradesconto.service.DescontoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/calcular")
public class DescontoController {
    private final DescontoService service;

    public DescontoController(DescontoService service) {
        this.service = service;
    }

    @GetMapping("/descontar")
    public Map<String, Object> aplicaDesconto(@RequestParam double valor,
                                              @RequestParam String cupom){

        try {
            double finalComDesconto = service.aplicar(valor, cupom);
            return Map.of("original",valor,"desconto",valor- service.aplicar(valor, cupom),"final",service.aplicar(valor, cupom));
        }catch (IllegalArgumentException e ){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

    }
}
