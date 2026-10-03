package view;

import DAO.ReservaDAO;
import model.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuReserva {

    static Scanner sc = new Scanner(System.in);

    public void menu() {

        String menu = """
                ----------- MENU PRINCIPAL ------------
                | 1 - Registrar Reserva               |
                | 2 - Consultar reservas por situação |
                | 3 - Relatório                       |  
                | 0 - Sair                            | 
                ---------------------------------------
                Selecione uma opção: 
                """;

        int opcao = 0;


        do {
            System.out.print(menu);
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> inserirReserva();
                case 2 -> consultarReserva();
                case 3 -> relatorio();
                default -> System.out.println("Não é uma opção válida");
            }

        } while (opcao != 0);


    }

    private void relatorio() {

        List<Reserva> lista = new ReservaDAO().listar();

        int agendada=0, confirmada =0, cancelada =0 ;

        for (Reserva r : lista) {
            if (r.getSituacao().toLowerCase().equals("agendada")) {
                agendada++;
            } else if (r.getSituacao().toLowerCase().equals("confirmada")) {
                confirmada++;
            } else if (r.getSituacao().toLowerCase().equals("cancelada")) {
                cancelada++;
            }


        }
        System.out.println("------ Relatório ------");
        System.out.println("AGENDADA: " + agendada);
        System.out.println("CONFIRMADA: " + confirmada);
        System.out.println("CANCELADA: " + cancelada);
    }

    private void consultarReserva() {

        String situacao;

        System.out.println("Informe a situação a pesquisar -> ");
        situacao = sc.next();

        List<Reserva> lista = new ReservaDAO().listarPorSituacao(situacao);
        String aux = "";

        if (lista.isEmpty()){
            System.out.println(" Não há nenhuma sala com a situação: "+situacao);
        }

        for (Reserva r : lista) {
            aux += r.toString();
        }

        System.out.println(aux);
    }




private void inserirReserva() {

    Reserva reserva = new Reserva();

    System.out.print("Digite a situação da sala (Agendada, Confirmada ou Cancelada) --> ");
    String situacao = sc.next();

    sc.nextLine();

    System.out.print("Digite o nome da sala -->");
    String nomesala = sc.nextLine();



    System.out.print("Digite o responsável -->");
    String responsavel = sc.nextLine();





    reserva.setResponsavel(responsavel);
    reserva.setNome_sala(nomesala);
    reserva.setSituacao(situacao);
    new ReservaDAO().inserir(reserva);


}

}
