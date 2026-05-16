package Exercicio02.Moto;

import Exercicio02.Veiculo.Veiculo;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String placa, String marca, int cilindradas) {
        super(placa, marca);
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\n---Moto---"+
                "\nCilindradas: "+cilindradas;
    }
}
