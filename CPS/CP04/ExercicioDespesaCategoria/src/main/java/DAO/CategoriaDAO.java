package DAO;

import factory.ConnectionFactory;
import model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements GenericDAO<Categoria, Integer> {
    @Override
    public void inserir(Categoria categoria) {
        String sql = "insert into java_categoria (categoria) VALUES (?)";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, categoria.getCategoria());

            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();

        String sql = "select * from java_categoria";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("id"));
                categoria.setCategoria(rs.getString("categoria"));

                lista.add(categoria);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public void atualizar(Categoria entidade) {
        String sql = "UPDATE java_categoria set categoria = ? where id = ?";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setString(1, entidade.getCategoria());
            ps.setInt(2, entidade.getId());

            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void excluir(Integer integer) {

        String sql = "delete from java_categoria where id=?";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql);) {

            ps.setInt(1, integer);
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Categoria pesquisarPorId(Integer id){
        String sql = "select * from java_categoria where id = ?";

        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1,id);

            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getInt("id"));
                    categoria.setCategoria(rs.getString("categoria"));

                    return categoria;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
