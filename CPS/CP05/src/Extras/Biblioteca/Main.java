package Extras.Biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Livro livro1 = new Livro("JGVRZS","Jogos Vorazes","Suzann");
        Livro livro2 = new Livro("HRYPTER","Harry Potter","JK Rowling");
        Livro livro3 = new Livro("MZRNR","Maze Runner","Roberta");
        Livro livro4 = new Livro("DRDUB","Diario de um banana","Ronaldo");

        Emprestimo emprestimo1 = new Emprestimo(livro1,"Gabriela",4);
        Emprestimo emprestimo2 = new Emprestimo(livro2,"Belinha",8);
        Emprestimo emprestimo3= new Emprestimo(livro3,"Maria",0);
        Emprestimo emprestimo4= new Emprestimo(livro2,"Gabriela",0);
        Emprestimo emprestimo5= new Emprestimo(livro1,"Belinha",10);
        Emprestimo emprestimo6= new Emprestimo(livro3,"Gabriela",3);
        Emprestimo emprestimo7= new Emprestimo(livro4,"Belinha",0);

        List<Emprestimo> listaEmprestimos = Arrays.asList(emprestimo1,emprestimo2,emprestimo3,emprestimo4,emprestimo5,emprestimo6,emprestimo7);



        Map<String, Set<Livro>> livrosDeLeitor = listaEmprestimos.stream()
                .collect(Collectors.groupingBy(Emprestimo::getLeitor,
                        Collectors.mapping(Emprestimo::getLivro,
                                Collectors.toCollection(TreeSet::new))));

        livrosDeLeitor.entrySet().stream()
                .filter(leitores -> leitores.getValue().size() >=2)
                .forEach(leitores ->{
                    System.out.println("\n-------Leitor: "+ leitores.getKey() +"-------"+ "\n "+ leitores.getValue());
                });


        System.out.println("\nMédias de dias atrasados ( por leitor ): ");
        Map<String,Double> mediaAtraso = listaEmprestimos.stream()
                .collect(Collectors.groupingBy(
                        Emprestimo::getLeitor,
                        Collectors.averagingDouble(Emprestimo::getDiasAtrasado)
                ));


        mediaAtraso.forEach((leitor,dias)-> System.out.println("Leitor: "+leitor + " | "+ "Dias Atrasado: "+String.format("%.1f",dias)));


        System.out.println("\nLivros com mais de dois leitores atrasados");
        Map<Livro,List<String>> leitoresAtrasa = listaEmprestimos.stream()
                .filter(Emprestimo::atrasado)
                .collect(Collectors.groupingBy(Emprestimo::getLivro,
                        Collectors.mapping(Emprestimo::getLeitor,
                                Collectors.toList())));

        leitoresAtrasa.entrySet().stream()
                .filter(atrasam -> atrasam.getValue().size()>=2)
                .forEach(atrasam -> System.out.println(atrasam.getKey()+ "\nLeitores atrasados:"+ atrasam.getValue()));
    }
}
