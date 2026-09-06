package br.techcorp.departamento;

import br.techcorp.funcionario.Funcionario;

public class Departamento {
    private  String codigo;
    private  String nome;
    private  Funcionario[] funcionarios;
    private  int index;

    public Departamento(String codigo, String nome, int tamanho) {
        this.codigo = codigo;
        this.nome = nome;
        this.funcionarios=new Funcionario[tamanho];
    }
    public void adicionarFuncionario(Funcionario funcionario){
        if (index< funcionarios.length){
            if (funcionario.isAtivo()){
                this.funcionarios[index]=funcionario;
                this.index++;
            }
        }
    }

    public Funcionario buscarFuncionario(String matricula){
        for (int i = 0; i < index; i++) {
            if (funcionarios[i].getMatricula().equals(matricula)){
                return funcionarios[i];
            }
        }return null;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
