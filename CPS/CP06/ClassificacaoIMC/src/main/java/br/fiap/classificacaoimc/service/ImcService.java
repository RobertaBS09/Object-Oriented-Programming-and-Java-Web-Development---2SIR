package br.fiap.classificacaoimc.service;


import org.springframework.stereotype.Service;

@Service
public class ImcService {

    public double calcular(double peso, double altura){

        if (peso<=0 || altura<= 0 ){
            throw new IllegalArgumentException("O peso ou a altura não podem ser igual ou menor que 0!");
        }

        return peso/(altura*altura);
    }

    public String classificar(double imc){

       if (imc <18.5){
           return "Abaixo do peso";
       }
       if (imc <25){
           return "Peso Normal";
       }
       if (imc<30){
           return "Obesidade Grau I";
       }
       if (imc<35){
           return "Obesidade Grau II";
       }
       if (imc<40){
           return "Obesidade Grau III";
       }
        return "Obesidade grau III";

    }

}
