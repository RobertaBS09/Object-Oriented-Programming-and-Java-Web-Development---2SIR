package Material.Exercicio01;

import java.util.Arrays;
import java.util.List;

public class Exercicio01 {
    public static void main(String[] args) {

        List<String> lista = Arrays.asList("Amelia", "Meredith", "Derek", "Anna", "Cristina");


        List<String>NomesComA = lista.stream()
                .filter(nome -> nome.startsWith("A")) //filtra com A
                .map(nome -> nome.toUpperCase()) // grita
                .toList(); // coloca na lista (nomes com A)


        NomesComA.forEach(System.out::println);
    }
}
