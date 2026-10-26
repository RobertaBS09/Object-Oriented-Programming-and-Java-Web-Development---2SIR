package br.fiap.simuladorparcelamento.controller;

import br.fiap.simuladorparcelamento.service.ParcelamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/parcelamento")
public class ParcelamentoController {

    private final ParcelamentoService service;

    public ParcelamentoController(ParcelamentoService service) {
        this.service = service;
    }

    @GetMapping("/parcelar")
    public String parcelar(@RequestParam double valor,
                           @RequestParam int parcelas,
                           Model model){

        model.addAttribute("valor",valor);
        model.addAttribute("parcelas",parcelas);

        try{
            double total = service.calcularTotal(valor, parcelas);
            double totalParcelas = service.calcularparcelas(total,parcelas);
            model.addAttribute("resultado",total);
            model.addAttribute("totalparcelas",totalParcelas);
        }catch (IllegalArgumentException e){
            model.addAttribute("erro",e.getMessage());
        }

        return "index";


    }

}
