package br.fiap.mediaaluno.controller;

import br.fiap.mediaaluno.service.MediaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/media")
public class mediaController {

    private final MediaService service;

    public mediaController(MediaService service) {
        this.service = service;
    }

    @GetMapping("/calcular")
    public String calcular(@RequestParam("nome") String nome,
                           @RequestParam ("n1") double n1,
                           @RequestParam ("n2")double n2,
                           @RequestParam ("tipo") String tipo,
                           Model model){

        model.addAttribute("nome",nome);
        model.addAttribute("n1",n1);
        model.addAttribute("n2",n2);
        model.addAttribute("tipo",tipo);

        try {
            double media = service.calcularMedia(n1, n2, tipo);
            model.addAttribute("media",media);
            String situacao = service.situacao(media);
            model.addAttribute("situacao",situacao);
        }catch (IllegalArgumentException e ){
            model.addAttribute("erro",e.getMessage());
        }

        return "index";


    }
}
