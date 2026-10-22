package br.fiap.assistencia.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //para falar que é uma tabela
@Table(name = "JAVA_CLIENTE") // usar se o nome da classe for diferente do nome da tabela no banco de dados
@Getter // getters para tudo
@Setter //setters para tudo
@NoArgsConstructor //nao tem construtor com argumentos (nao precisa colocar mas colocou para a gente ver)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_CLIENTE")
    private Long id;

    @Column(name = "NOME", nullable = false,length = 120)
    private String nome;

    @Column(name = "TELEFONE",length = 20)
    private String telefone;

    @Column(name = "EMAIL",length = 120,unique = true)
    private String email;

    @Column(name = "SENHA",length = 512)
    private String senha;

}
