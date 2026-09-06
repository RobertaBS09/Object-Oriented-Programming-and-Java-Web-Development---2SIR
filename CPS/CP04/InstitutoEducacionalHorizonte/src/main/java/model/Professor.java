package model;

public class Professor {
    private Integer id_professor;
    private String nome;
    private Integer aulas_semanais;
    private Double valor_hora;
    private Double salario;
    private Double salario_base;
    private Double DSR;
    private Double hora_atividade;


    public Integer getId_professor() {
        return id_professor;
    }

    public void setId_professor(Integer id_professor) {
        this.id_professor = id_professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAulas_semanais() {
        return aulas_semanais;
    }

    public void setAulas_semanais(Integer aulas_semanais) {
        this.aulas_semanais = aulas_semanais;
    }

    public Double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(Double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(Double salario_base) {
        this.salario_base = salario_base;
    }

    public Double getDSR() {
        return DSR;
    }

    public void setDSR(Double DSR) {
        this.DSR = DSR;
    }

    public Double getHora_atividade() {
        return hora_atividade;
    }

    public void setHora_atividade(Double hora_atividade) {
        this.hora_atividade = hora_atividade;
    }

    public void calcularSalario() {
        this.salario_base = this.valor_hora * this.aulas_semanais * 4.5;
        this.DSR = this.salario_base / 6;
        this.hora_atividade = (this.salario_base + this.DSR) * 0.05;
        double salario = this.salario_base + DSR + this.hora_atividade;
        setSalario(salario);
    }

    public String RegimeTrabalho(){
        if (this.aulas_semanais<12){
            return "Horista";
        } else if (this.aulas_semanais>=13 && this.aulas_semanais<=29) {
            return "Parcial";
        }else {
            return "Integral";
        }
    }
}
