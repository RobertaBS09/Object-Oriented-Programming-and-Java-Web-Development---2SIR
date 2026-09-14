package DAO;

import factory.ConnectionFactory;
import model.Despesa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO implements GenericDAO<Despesa, Integer> {

    @Override
    public void inserir(Despesa despesa) {
        String sql = "insert into java_despesa (descricao, valor, data, id_categoria) VALUES (?,?,?,?)";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setDate(3, Date.valueOf(despesa.getData()));
            ps.setInt(4, despesa.getCategoria().getId());
            ps.execute();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Despesa> listar() {
        List<Despesa> lista = new ArrayList<>();

        String sql = "select * from java_despesa";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setId(rs.getInt("id"));
                despesa.setDescricao(rs.getString("descricao"));
                despesa.setValor(rs.getDouble("valor"));
                despesa.setData(rs.getDate("data").toLocalDate());
                despesa.setIdCategoria(rs.getInt("id_categoria"));
                lista.add(despesa);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public void atualizar(Despesa despesa) {
        String sql = "update java_despesa set descricao = ? where id = ?";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, despesa.getDescricao());
            ps.setInt(2, despesa.getId());
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void excluir(Integer ID) {
        String sql = "DELETE FROM java_despesa where id =?";

        try(Connection connection= ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ){

            ps.setInt(1,ID);
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
