package ListaExercicios.Exercicio06.Classes;

public class Visualizacao {

    private Video video;
    private int percentualAssistido;

    public Visualizacao(Video video, int percentualAssistido) {
        this.video = video;
        this.percentualAssistido = percentualAssistido;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public int getPercentualAssistido() {
        return percentualAssistido;
    }

    public void setPercentualAssistido(int percentualAssistido) {
        this.percentualAssistido = percentualAssistido;
    }
}
