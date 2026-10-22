package Extras.Funcionarios;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Funcionario fun1 = new Funcionario("Roberta","Tecnologia",3000);
        Funcionario fun2 = new Funcionario("Gabriel","Tecnologia",4000);
        Funcionario fun3 = new Funcionario("Gabriela","Turismo",6000);
        Funcionario fun4 = new Funcionario("Julia","Turismo",2000);
        Funcionario fun5 = new Funcionario("Ronaldo","Administração",1000);

        List<Funcionario> listaFuncionarios= Arrays.asList(fun1,fun2,fun3,fun4,fun5);


        System.out.println("\n------Funcionários por departamento------ ");
        Map<String,List<String>> funPorDep = listaFuncionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getDepartamento,
                        Collectors.mapping(Funcionario::getNome,
                                Collectors.toList())));

        funPorDep.forEach((departamento,funcionario)-> System.out.println("Departamento: "+departamento +" | "+ "Funcionário: "+funcionario));

        System.out.println("\n------Média Salarial por Departamento------");

        Map<String,Double> mediaSalDep = listaFuncionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getDepartamento,
                        Collectors.averagingDouble(Funcionario::getSalario)));

        mediaSalDep.forEach((departamento,media)-> System.out.println("Departamento: "+departamento + " | Média Salarial: R$"+ String.format("%.2f",media)));






    }
}
