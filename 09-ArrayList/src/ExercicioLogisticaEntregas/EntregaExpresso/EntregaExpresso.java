package ExercicioLogisticaEntregas.EntregaExpresso;

import ExercicioLogisticaEntregas.Entrega.Entrega;

public class EntregaExpresso extends Entrega {
    public EntregaExpresso(String destino, double distancia) {
        super(destino, distancia);
    }

    @Override
    public double calcularTempoEntrega() {
        return super.calcularTempoEntrega() / 2;
    }
}
