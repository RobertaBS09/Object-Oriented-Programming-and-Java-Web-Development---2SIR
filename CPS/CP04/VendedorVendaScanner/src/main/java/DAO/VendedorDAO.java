package DAO;

import factory.ConnectionFactory;
import model.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendedorDAO implements GenericDao<Vendedor, Integer> {
    @Override
    public void inserir(Vendedor entidade) {

        String sql = "INSERT INTO CP04_VENDEDOR (nome_vendedor) VALUES (?)";

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

        String sql = "SELECT * FROM CP04_VENDEDOR";
        List<Vendedor> lista = new ArrayList<>();

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()){
                Vendedor vendedor = new Vendedor();

                vendedor.setId_vendedor(rs.getInt("id_vendedor"));
                vendedor.setNome(rs.getString("nome_vendedor"));

                lista.add(vendedor);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public Optional atualizar(Vendedor entidade) {

        String sql = "UPDATE CP04_VENDEDOR SET nome_vendedor=? where id_vendedor=?";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, entidade.getNome());
            ps.setInt(2, entidade.getId_vendedor());
            ps.execute();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public void remover(Integer id) {

        String sql = "DELETE FROM CP04_VENDEDOR WHERE id_vendedor=?";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.execute();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
