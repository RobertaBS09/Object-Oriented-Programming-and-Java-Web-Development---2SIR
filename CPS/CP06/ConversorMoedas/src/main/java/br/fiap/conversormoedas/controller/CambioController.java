package br.fiap.conversormoedas.controller;

import br.fiap.conversormoedas.service.CambioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cambio")
public class CambioController {
    private final CambioService service;

    public CambioController(CambioService service) {
        this.service = service;
    }

    @GetMapping("/converter")
    public String converter(@RequestParam double reais,
                            @RequestParam String moeda,
                            Model model){

        model.addAttribute("reais",reais);
        model.addAttribute("moeda",moeda);

        try{
            double convertido = service.converter(reais, moeda);
            model.addAttribute("resultado",convertido);
        }catch (IllegalArgumentException e ){
            model.addAttribute("erro",e.getMessage());
        }
        return "index";


    }
}
