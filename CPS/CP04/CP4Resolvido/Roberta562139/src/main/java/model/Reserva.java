package model;

public class Reserva {

    private Integer id_reserva;
    private String nome_sala;
    private String responsavel;
    private String situacao;

    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getNome_sala() {
        return nome_sala;
    }

    public void setNome_sala(String nome_sala) {
        this.nome_sala = nome_sala;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "ID: " + id_reserva +
                " | Sala: '" + nome_sala +
                " | Responsável " + responsavel +
                " | Situação: " + situacao;

    }
}
