package DAO;

import factory.ConnectionFactory;
import model.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public void inserir(Reserva reserva) {

        String sql = "INSERT INTO JAVA_RESERVA (nome_sala, responsavel, situacao) VALUES (?,?,?)";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, reserva.getNome_sala());
            ps.setString(2, reserva.getResponsavel());
            ps.setString(3, reserva.getSituacao());

            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Reserva> listarPorSituacao(String situacao) {

        List<Reserva> lista = new ArrayList<>();

        String sql = "SELECT * FROM JAVA_RESERVA where situacao = ?";


        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql);

        ) {

            ps.setString(1, situacao);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Reserva reserva = new Reserva();
                reserva.setId_reserva(rs.getInt("id_reserva"));
                reserva.setSituacao(rs.getString("situacao"));
                reserva.setNome_sala(rs.getString("nome_sala"));
                reserva.setResponsavel(rs.getString("responsavel"));

                lista.add(reserva);

            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    public List<Reserva> listar() {


        List<Reserva> lista = new ArrayList<>();

        String sql = "SELECT * FROM JAVA_RESERVA";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reserva reserva = new Reserva();

                reserva.setId_reserva(rs.getInt("id_reserva"));
                reserva.setSituacao(rs.getString("situacao"));
                reserva.setResponsavel(rs.getString("responsavel"));
                reserva.setNome_sala(rs.getString("nome_sala"));

                lista.add(reserva);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;

    }


}
