package Material.Exemplos;

import java.util.stream.IntStream;

public class SeparadorPares {
    public static void main(String[] args) {

        int [] lista = {3,10,6,1,4,8,2,5};


        IntStream.of(lista).filter(x -> x%2==0) //filtra
                .map(x -> x*10) //transforma
                .sorted()//arruma
                .forEach(x -> System.out.println(x+ "")); //printa

    }
}
