package Exercicio02.Main;

import Exercicio02.Carro.Carro;
import Exercicio02.Moto.Moto;
import Exercicio02.Veiculo.Veiculo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Veiculo> lista = new ArrayList<>();

        lista.add(new Carro("FEY-5741","Chevrolet",4));
        lista.add(new Moto("RTX-567","YAHAMA",700));

        for (Veiculo v:lista){
            System.out.println(v.toString());
        }
    }
}
