package br.fiap.conversortemperatura.controller;

import br.fiap.conversortemperatura.service.ConversorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/conversor")
public class ConversorController {

    private final ConversorService service;

    public ConversorController(ConversorService service) {
        this.service = service;
    }

    @GetMapping("/converter")
    public String converter(@RequestParam("valor") double valor,
                            @RequestParam("tipo") String tipo, Model model){

        model.addAttribute("valor",valor);
        model.addAttribute("tipo",tipo);

        try{
            double resultado = service.converter(valor, tipo);
            model.addAttribute("resultado",resultado);
        }catch (IllegalArgumentException e ){
            model.addAttribute("erro",e.getMessage());
        }
        return "index";
    }


}
