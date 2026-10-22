package br.fiap.assistencia.controller;

import br.fiap.assistencia.dto.ClienteRequest;
import br.fiap.assistencia.dto.ClienteResponse;
import br.fiap.assistencia.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController // pq nao tem html , se tivesse html seria so @Controller
@RequestMapping("/cliente") //tem que ter pq quando digitar vai entrar aqui
@AllArgsConstructor
public class ClienteController {
    private final ClienteService service;

    @PostMapping("/salvar") //post pa nao quero que os dados aparecam na barra do link
    public ClienteResponse salvar(@RequestBody ClienteRequest dto){//precisa ter essa anotacao se nao nao vai transformar
        return service.save(dto);

    }

    @GetMapping("/pesquisar/{id}")
    public ClienteResponse pesquisaPorId(@PathVariable Long id){ //o id pode mudar, o pesquisar vai ser sempro o mesmo. A parte que varia é o id
        return service.pesquisar(id);
    }
}
