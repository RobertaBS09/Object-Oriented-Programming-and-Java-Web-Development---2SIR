package Exercicio02;

public class SenhaAtendimento {
    static int controle=0;
    int senha;
    String paciente;

    public SenhaAtendimento(String paciente){
        this.paciente=paciente;
        this.senha=controle+1;
        controle++;

    }
    public String getDados(){
        return "Senha #"+senha+" | Paciente: "+ paciente;
    }


}
