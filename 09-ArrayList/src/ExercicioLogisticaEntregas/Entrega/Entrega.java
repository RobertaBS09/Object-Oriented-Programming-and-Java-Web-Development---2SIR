package ExercicioLogisticaEntregas.Entrega;

public class Entrega {
    protected String destino;
    protected double distancia;

    public Entrega(String destino, double distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public double calcularTempoEntrega() {
        return distancia / 100;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

}
