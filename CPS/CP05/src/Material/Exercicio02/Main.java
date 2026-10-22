package Material.Exercicio02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Empregado empregado1 = new Empregado("Sheldon", 15000, 20);
        Empregado empregado2 = new Empregado("Howard", 10000, 15);
        Empregado empregado3 = new Empregado("Bernadette", 20000, 17);

        List<Empregado> listaInicial = Arrays.asList(empregado1, empregado2, empregado3);


        List<Empregado> listaNova = listaInicial.stream()
                .map(empregado -> {
                    double novoSalario;
                    if (empregado.AnosExp() >= 5) {
                        novoSalario = empregado.SalarioAtual() * 1.20;
                    } else {
                        novoSalario = empregado.SalarioAtual() * 1.10;
                    }
                    return new Empregado(empregado.nome(), novoSalario, empregado.AnosExp()); //nao esquecer do return
                }).sorted(Comparator.comparing(Empregado::nome)) // em ordem alfabetica
                .toList();

        listaNova.forEach(System.out::println);

    }
}
