package br.fiap.boletim.controller;

import br.fiap.boletim.service.BoletimService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/boletim")
public class BoletimController {

    private final BoletimService service;

    public BoletimController(BoletimService service) {
        this.service = service;
    }

    @GetMapping("/calcular")
    public String calcular(@RequestParam String nome,
                           @RequestParam double n1,
                           @RequestParam double n2,
                           @RequestParam String tipo,
                           Model model){

        model.addAttribute("nome",nome);
        model.addAttribute("n1",n1);
        model.addAttribute("n2",n2);
        model.addAttribute("tipo",tipo);


        try{

            service.validarNome(nome);
            double media = service.calcularMedia(n1, n2, tipo);
            String situacao = service.situacao(media);
            service.registrar(nome,media,situacao);

            model.addAttribute("media",media);
            model.addAttribute("situacao",situacao);
        }catch (IllegalArgumentException e){
            model.addAttribute("erro",e.getMessage());
        }

        return "index";

    }
}
