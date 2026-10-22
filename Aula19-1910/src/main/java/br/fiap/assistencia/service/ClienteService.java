package br.fiap.assistencia.service;

import br.fiap.assistencia.domain.Cliente;
import br.fiap.assistencia.dto.ClienteRequest;
import br.fiap.assistencia.dto.ClienteResponse;
import br.fiap.assistencia.mapper.Mapper;
import br.fiap.assistencia.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor // para não precisar colocar o construtor
public class ClienteService {
    private final ClienteRepository repo;
    private final Mapper mapper;

    //inserir
    @Transactional  //trnasações são operacoes seguidas (inserir e pesquisar)
    public ClienteResponse save(ClienteRequest dto){//recebemos um request e retornamos um response
        //o dto vai virar um cliente
        Cliente cliente = mapper.paraEntidade(dto); // vai sair de dto e virar uma entidade (cliente)
        Cliente clienteSalvo = repo.save(cliente); //inserir no banco de dados
        return mapper.paraResposta(cliente); //para mandar de volta para o navegador
    }

    public ClienteResponse pesquisar(Long id) {
        Cliente cliente = repo.findById(id).orElseThrow();
        return mapper.paraResposta(cliente);
    }
}
