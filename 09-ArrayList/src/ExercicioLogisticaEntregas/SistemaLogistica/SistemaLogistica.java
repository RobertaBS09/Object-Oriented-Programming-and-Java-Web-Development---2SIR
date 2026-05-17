package ExercicioLogisticaEntregas.SistemaLogistica;

import ExercicioLogisticaEntregas.Entrega.Entrega;
import ExercicioLogisticaEntregas.EntregaExpresso.EntregaExpresso;
import ExercicioLogisticaEntregas.EntregaInternacional.EntregaInternacional;

import java.util.ArrayList;

public class SistemaLogistica {
    public static void main(String[] args) {
        Entrega EN = new Entrega("São Paulo",300);
        EntregaExpresso EE = new EntregaExpresso("Rio de Janeiro",300);
        EntregaInternacional EI= new EntregaInternacional("New York",8000);

        ArrayList<Entrega>lista= new ArrayList<>();
        lista.add(EN);
        lista.add(EE);
        lista.add(EI);

        String tipoEntrega=" ";
        for (Entrega e : lista){
            if (e instanceof EntregaInternacional){
                tipoEntrega ="(Internacional)";
            } else if (e instanceof EntregaExpresso) {
                tipoEntrega ="(Expresso)";
            }else{
                tipoEntrega = "(Normal)";
            }

            System.out.println("Destino: "+e.getDestino()+" - Distância: "+e.getDistancia()+"km - Tempo de entrega "+tipoEntrega+": "+ processarEntrega(e)+" dias");
        }

    }



    public static double processarEntrega(Entrega entrega){
        return entrega.calcularTempoEntrega();
    }
}
