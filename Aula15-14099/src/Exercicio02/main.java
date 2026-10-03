package Exercicio02;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {


        Empregado empregadoF = new Empregado("Felipe", 100, 10);
        Empregado empregadoL = new Empregado("Lorrayne", 1000, 5);
        Empregado empregadoK = new Empregado("Kloh", 10, 1);

        List<Empregado> lista = Arrays.asList(empregadoF, empregadoL, empregadoK);

        List<Empregado> Reajuste = lista.stream()
                .map(empregado -> { //empregado é enviado (->) para um método
                    double novoSalario;
                    if (empregado.anos() >= 5) {
                        novoSalario = empregado.salario() * 1.20;
                    } else {
                        novoSalario = empregado.salario() * 1.10;
                    }
                    return new Empregado(empregado.nome(), novoSalario, empregado.anos());
                })
                .sorted(Comparator.comparing(Empregado::nome)) //da classe empregados eu quero ordenar pelo nome
                .toList(); // todos os objetos serao adicionados no reajustado


        Reajuste.forEach(System.out::println);
    }

}
