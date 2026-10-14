package DAO;

import factory.ConnectionFactory;
import model.Pedidos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.*;

public class PedidosDAO {

    public void inserir(Pedidos pedido) {

        String sql = "insert into CP04_PEDIDOS (data_pedido,cliente,valor_total) VALUES (?,?,?)";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(pedido.getData()));
            ps.setString(2, pedido.getCliente());
            ps.setDouble(3, pedido.getValor_total());

            ps.execute();

            System.out.println("O pedido do cliente "+ pedido.getCliente() + "foi inserido com sucesso!");
            //showMessageDialog(null, "O pedido do cliente: " + pedido.getCliente() + " foi inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ;
        }

    }

    public List<Pedidos> listar() {

        String sql = "SELECT * FROM CP04_PEDIDOS";
        List<Pedidos> lista = new ArrayList<>();

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()){
                Pedidos pedido = new Pedidos();

               pedido.setId(rs.getInt("id"));
               pedido.setData(rs.getDate("data_pedido").toLocalDate());
               pedido.setCliente(rs.getString("cliente"));
               pedido.setValor_total(rs.getDouble("valor_total"));

               lista.add(pedido);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;

    }
}
