package DAO;

import factory.ConnectionFactory;
import model.Venda;
import model.Vendedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendaDAO implements GenericDao<Venda, Integer> {


    @Override
    public void inserir(Venda venda) {

        String sql = "INSERT INTO CP04_VENDA (id_vendedor,total,data) VALUES (?,?,?)";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {


            ps.setInt(1, venda.getVendedor().getId_vendedor());
            ps.setDouble(2, venda.getTotal());
            ps.setDate(3, Date.valueOf(venda.getData()));

            ps.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Venda> listar() {

        List<Venda> lista = new ArrayList<>();

        String sql = "SELECT vd.id_venda, v.nome_vendedor, vd.data , vd.total from CP04_VENDEDOR v  " +
                "inner join CP04_VENDA vd on v.id_vendedor= vd.id_vendedor";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Venda venda = new Venda();
                Vendedor vendedor = new Vendedor();

                venda.setId_venda(rs.getInt("id_venda"));
                vendedor.setNome(rs.getString("nome_vendedor"));
                venda.setData(rs.getDate("data").toLocalDate());
                venda.setTotal(rs.getDouble("total"));


                venda.setVendedor(vendedor);

                lista.add(venda);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public Optional atualizar(Venda entidade) {
        return Optional.empty();
    }

    @Override
    public void remover(Integer id) {

        String sql = "DELETE FROM CP04_VENDA WHERE id_venda=?";

        try(Connection connection = ConnectionFactory.obterConexao();
        PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.execute();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
