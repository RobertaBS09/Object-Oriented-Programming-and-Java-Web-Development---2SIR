package ListaExercicios.Exercicio06.Classes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Historico {

    private List<Visualizacao> visualizacoes = new ArrayList<>();
    private Deque<Video> recentes = new ArrayDeque<>();

    public void registrar(Video v, int percentual) {

        Visualizacao visualizacao = new Visualizacao(v, percentual);

        visualizacoes.add(visualizacao);
        recentes.remove(v);

        recentes.addFirst(v);

        if (recentes.size() > 5) {
            recentes.removeLast();
        }
    }

    public List<Visualizacao> getVisualizacoes() {
        return visualizacoes;
    }

    public Deque<Video> getRecentes() {
        return recentes;
    }
}
