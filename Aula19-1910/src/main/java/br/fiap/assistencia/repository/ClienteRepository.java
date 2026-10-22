package br.fiap.assistencia.repository;

import br.fiap.assistencia.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente,Long> { //com essa linha o crud ta pronto, não vai precisar escrever sql (inserir, pesquisar, alterar ,deletar)
}
