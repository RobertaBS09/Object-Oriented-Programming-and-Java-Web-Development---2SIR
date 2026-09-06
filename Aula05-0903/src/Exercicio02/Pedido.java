package Exercicio02;

import java.util.Random;

public class Pedido {
    int Numero;
    String data;
    ItemPedido [] item ; //criando um vetor do tipo pedido VOCÊ PENSOU CERTO
    int index=0;

    public Pedido(String data, int totalItens){
        Random rd= new Random();
        this.Numero= rd.nextInt(1000,9999);
        this.data=data;
        this.item=new ItemPedido[totalItens];

    }

    public void adicionarPedido(ItemPedido pedido){ //ACERTOU DEMAIS DIVA, ERA ESSE TIPO DE VARIAVEL MESMO
        if (index<item.length){
            item[index]=pedido;
            index++;
        }

    }

    public double calcularTotal(){
        double total=0;
        for (int i=0; i<index;i++){
            total+= item[i].precoUni;
        }
        return total;
    }


    }

