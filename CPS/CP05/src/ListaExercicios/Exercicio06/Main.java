package ListaExercicios.Exercicio06;

import ListaExercicios.Exercicio06.Classes.Historico;
import ListaExercicios.Exercicio06.Classes.Video;
import ListaExercicios.Exercicio06.Classes.Visualizacao;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Historico historico = new Historico();

        Video v1 = new Video("Collections", "Java Fácil", 20,
                new HashSet<>(Arrays.asList("java", "backend")));

        Video v2 = new Video("Streams", "Java Fácil", 30,
                new HashSet<>(Arrays.asList("java", "backend")));

        Video v3 = new Video("APIs", "Web Prática", 25,
                new HashSet<>(Arrays.asList("backend", "web")));

        Video v4 = new Video("Currículo", "Carreira Tech", 10,
                new HashSet<>(Arrays.asList("carreira", "tecnologia")));

        Video v5 = new Video("Entrevistas", "Carreira Tech", 15,
                new HashSet<>(Arrays.asList("carreira", "java")));

        Video v6 = new Video("SQL", "Dados Hoje", 40,
                new HashSet<>(Arrays.asList("dados", "backend")));

        Video v7 = new Video("Modelagem", "Dados Hoje", 35,
                new HashSet<>(Arrays.asList("dados", "backend")));

        historico.registrar(v1, 50);
        historico.registrar(v2, 90);
        historico.registrar(v3, 40);
        historico.registrar(v4, 100);
        historico.registrar(v5, 60);
        historico.registrar(v6, 25);
        historico.registrar(v7, 80);
        historico.registrar(v3, 95);
        historico.registrar(v2, 30);


        System.out.println("\n-----Vídeos assistidos recentemente----- ");
        historico.getRecentes().forEach(System.out::println);


        System.out.println("\n-----Minutos Efetivamente Assistidos-----");
        Map<String,Double>minutosPorCanal = historico.getVisualizacoes().stream()
                .collect(Collectors.groupingBy(
                        visu -> visu.getVideo().getCanal(),
                        Collectors.summingDouble(visu ->
                                visu.getVideo().getDuracaoMinutos() * visu.getPercentualAssistido() / 100.0)
                ));

        minutosPorCanal.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Double> a) -> a.getValue()).reversed())
                .forEach(a-> System.out.println(a.getKey() + " - "+ String.format("%.2f",a.getValue())));


        System.out.println("\n-----Vídeos Concluídos-----");
        Set<Video>concluidos = historico.getVisualizacoes().stream()
                .filter(a -> a.getPercentualAssistido() >= 90)
                .map(Visualizacao::getVideo)
                .collect(Collectors.toSet());

        concluidos.forEach(System.out::println);



        System.out.println("\n-----Vídeos Não Concluídos-----");
        Set<Video> iniciadosNaoConcluidos = historico.getVisualizacoes().stream()
                .map(Visualizacao::getVideo)
                .collect(Collectors.toCollection(HashSet::new));

        iniciadosNaoConcluidos.removeAll(concluidos);
        iniciadosNaoConcluidos.forEach(System.out::println);

        System.out.println("\n-----Media percentual-----");
        System.out.printf("%.2f%%%n", mediaPercentual(historico.getVisualizacoes().stream()));

    }

    public static double mediaPercentual (Stream<Visualizacao>visualizacoes){
        return visualizacoes
                .mapToInt(Visualizacao::getPercentualAssistido)
                .average()
                .orElse(0.0);
    }
}
