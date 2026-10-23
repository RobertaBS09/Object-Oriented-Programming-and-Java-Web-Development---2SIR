package org.example.calculadorathymeleaf.controller;

import org.example.calculadorathymeleaf.service.CalculadoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculadora")
public class CalculadoraController {
    private final CalculadoraService service;

    public CalculadoraController(CalculadoraService service) {
        this.service = service;
    }

    @GetMapping("/calcular")
    public String calcular(@RequestParam("n1") int num1,
                           @RequestParam("n2") int num2,
                           @RequestParam("operacao") String operacao,
                           Model model) {

        model.addAttribute("n1", num1);
        model.addAttribute("n2", num2);
        model.addAttribute("operacao", operacao);

        try {
            double resultado = service.calcular(num1, num2, operacao);
            model.addAttribute("resultado", resultado);
        } catch (IllegalArgumentException e) {
            model.addAttribute("erro", e.getMessage());
        }

        return "index";
    }
}