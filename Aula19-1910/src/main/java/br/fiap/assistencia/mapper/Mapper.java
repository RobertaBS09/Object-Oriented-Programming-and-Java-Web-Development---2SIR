package br.fiap.assistencia.mapper;

import br.fiap.assistencia.domain.Cliente;
import br.fiap.assistencia.dto.ClienteRequest;
import br.fiap.assistencia.dto.ClienteResponse;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    //oq vai para o banco de dados
    public Cliente paraEntidade(ClienteRequest dto){
        Cliente cliente =  new Cliente();

        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setSenha(dto.senha());
        cliente.setTelefone(dto.telefone());

        return cliente;
    }

    public ClienteResponse paraResposta (Cliente entidade){ //oque vai para o navegador
       return new  ClienteResponse(entidade.getId(), entidade.getNome(), entidade.getEmail(), entidade.getTelefone());
    }
}
