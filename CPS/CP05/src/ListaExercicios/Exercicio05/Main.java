package ListaExercicios.Exercicio05;

import ListaExercicios.Exercicio05.Classes.Aluno;
import ListaExercicios.Exercicio05.Classes.Disciplina;
import ListaExercicios.Exercicio05.Classes.Matricula;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Aluno aluno1 = new Aluno("562139", "Roberta Barbosa", "Sistemas de Informacao");
        Aluno aluno2 = new Aluno("561752", "Felipe Gomes", "Sistemas de Informacao");
        Aluno aluno3 = new Aluno("672367", "Julia Camargo", "Gestao de Negocios");
        Aluno aluno4 = new Aluno("674532", "Matheus Pina", "Gestao de Negocios");
        Aluno pinaRepetido = new Aluno("674532", "Matheus Pina", "Gestao de Negocios");


        Disciplina disciplina1 = new Disciplina("1", "Estatistica", 1);
        Disciplina disciplina2 = new Disciplina("2", "Logica de programacao", 1);
        Disciplina disciplina3 = new Disciplina("3", "Logistica de negocios", 3);


        Matricula matricula2 = new Matricula(aluno2, disciplina1, 8);
        Matricula matricula4 = new Matricula(aluno1, disciplina1, 9);
        Matricula matricula5 = new Matricula(aluno3, disciplina1, 5);
        Matricula matricula6 = new Matricula(aluno4, disciplina1, 3);

        Matricula matricula7 = new Matricula(aluno4, disciplina2, 9);
        Matricula matricula1 = new Matricula(aluno1, disciplina2, 10);
        Matricula matricula9 = new Matricula(aluno2, disciplina2, 10);

        Matricula matricula3 = new Matricula(aluno3, disciplina3, 7);
        Matricula matricula8 = new Matricula(pinaRepetido, disciplina3, 3);

        List<Matricula> listaMatricula = Arrays.asList(matricula1, matricula2, matricula3, matricula4, matricula5, matricula6, matricula7, matricula8, matricula9);

        Map<Disciplina, Set<Aluno>> matriculados = listaMatricula.stream()
                .collect(Collectors.groupingBy(Matricula::getDisciplina,
                        Collectors.mapping(Matricula::getAluno,
                                Collectors.toCollection(TreeSet::new))));


        matriculados.entrySet().stream()
                .filter(entrada -> entrada.getValue().size() >= 3)
                .forEach(entrada -> {
                    System.out.println(entrada.getKey() + "\nNúmero de alunos na disciplina: " + entrada.getValue().size() + "\n");
                    entrada.getValue().forEach(System.out::println);
                });

        Map<String, Double> mediasPorCurso = listaMatricula.stream()
                .collect(Collectors.groupingBy(
                        matricula ->
                                matricula.getAluno().getCurso(),
                        Collectors.averagingDouble(Matricula::getNota

                        )));

        System.out.println("\n---Médias por curso---");
        mediasPorCurso.forEach((curso, media)-> System.out.println("Curso: "+ curso+ " | Média: "+String.format("%.2f",media)));

        System.out.println("\n---Alunos Reprovados---");
        Map<Aluno,List<String>>reprovacoes = listaMatricula.stream()
                .filter(matricula -> !matricula.aprovado())
                .collect(Collectors.groupingBy(Matricula::getAluno,
                        Collectors.mapping(matricula -> matricula.getDisciplina().getNome(),
                                Collectors.toList())));

        reprovacoes.entrySet().stream()
                .filter(reprovados ->reprovados.getValue().size() >=2)
                .forEach(reprovados -> System.out.println(reprovados.getKey() + "\nReprovado em: "+ reprovados.getValue()));
    }
}
