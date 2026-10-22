package ListaExercicios.Exercicio06.Classes;

import java.util.Objects;
import java.util.Set;

public class Video {

    private String titulo;
    private String canal;
    private int duracaoMinutos;
    private Set<String> tags;

    public Video(String titulo, String canal, int duracaoMinutos, Set<String> tags) {
        this.titulo = titulo;
        this.canal = canal;
        this.duracaoMinutos = duracaoMinutos;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "|Video|  " +  "Título: " + titulo + " Canal: " + canal + " Duração (em minutos): " + duracaoMinutos + " Tags:" + tags;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(titulo, video.titulo) && Objects.equals(canal, video.canal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, canal);
    }

    public String getTitulo() {
        return titulo;
    }


    public String getCanal() {
        return canal;
    }


    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
