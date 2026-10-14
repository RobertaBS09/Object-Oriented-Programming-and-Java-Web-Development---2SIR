package Exemplo01;

import java.util.Arrays;
import java.util.List;

public class Exemplo {
    public static void main(String[] args) {

        List<String> lista = Arrays.asList("Ana","Maria","Bento","Judite","Amanda");

        List<String> listaNova = lista.stream()//criando uma lista nova pois na progamação funcional a lista original não é alterada
                .filter(nome-> nome.startsWith("A"))
                .map(nome -> nome.toUpperCase())  // nao colocar o ponto e virgula aqui pq ainda não acabou
                .toList();
        /*stream -> fa a esteira começar a funcionar e vai colocando os objetos dentro da esteira (ligar a esteira)
          filter -> filtra o vc quer  (filtrar quem o nome comeca com a letra A)
          map -> alterar o valor
          toList() -> pega tudo e coloca para dentro da lista

        */

        System.out.println(listaNova);
    }
}
