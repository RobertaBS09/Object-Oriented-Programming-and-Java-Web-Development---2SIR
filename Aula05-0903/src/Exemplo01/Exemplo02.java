package Exemplo01;

public class Exemplo02 {
    public static void main(String[] args) {
        System.out.println(somar(2,3));
        System.out.println(somar(2,3,5));
        System.out.println(somar(1,2,3,4,5,6));
    }
    public static int somar(int ...v){// para travbalhar com um numero tal de parametros (metodo com quantidade variavel de parametros)
        // os ... serve para mostrar que não tem um número de parâmetros fixos
        int soma=0;
        for (int i: v){
            soma+=i;}
        return soma;
    }
}
