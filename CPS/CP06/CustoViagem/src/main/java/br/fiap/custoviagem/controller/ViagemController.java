package br.fiap.custoviagem.controller;

import br.fiap.custoviagem.service.ViagemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/viagem")
public class ViagemController {

    private final ViagemService service;

    public ViagemController(ViagemService service) {
        this.service = service;
    }

    @GetMapping("/calcular")
    public String calcular(@RequestParam double distancia,
                           @RequestParam double consumo,
                           @RequestParam String combustivel,
                           Model model) {

        model.addAttribute("distancia", distancia);
        model.addAttribute("consumo", consumo);
        model.addAttribute("combustivel", combustivel);

        try {
            double litros = service.calcularLitros(distancia, consumo);
            double custo = service.calcularCusto(litros, combustivel);

            model.addAttribute("litros", litros);
            model.addAttribute("custo", custo);

            if (custo > 500) {   // era >=
                model.addAttribute("aviso", "Viagem cara! Considere dividir com alguém.");
            }
        } catch (IllegalArgumentException e) {
            model.addAttribute("erro", e.getMessage());
        }
        return "index";
    }
}