package DAO;

import factory.ConnectionFactory;
import model.Venda;
import model.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendedorDAO implements GenericDAO<Vendedor, Integer> {

    @Override
    public void inserir(Vendedor entidade) {

        String sql = "insert into java_vendedor (nome) values (?)";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, entidade.getNome());
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Vendedor> listar() {

        List<Vendedor> lista = new ArrayList<>();
        String sql = "select * from java_vendedor";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setId_vendedor(rs.getInt("id_vendedor"));
                vendedor.setNome(rs.getString("nome"));
                lista.add(vendedor);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    @Override
    public Optional atualizar(Vendedor entidade) {

        String sql = "update java_vendedor set nome =? where id_vendedor = ?";

        try (Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setString(1,entidade.getNome());
            ps.setInt(2,entidade.getId_vendedor());

            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void remover(Integer id) {

        String sql = "delete from java_vendedor where id_vendedor = ? ";

        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1,id);
            ps.execute();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
