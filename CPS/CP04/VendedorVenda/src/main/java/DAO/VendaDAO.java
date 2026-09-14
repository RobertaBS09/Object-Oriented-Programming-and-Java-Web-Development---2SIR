package DAO;

import factory.ConnectionFactory;
import model.Venda;
import model.Vendedor;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendaDAO implements GenericDAO<Venda, Integer> {
    @Override
    public void inserir(Venda entidade) {

        String sql = "insert into java_venda (id_vendedor,total,data) values (?,?,?)";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, entidade.getVendedor().getId_vendedor());
            ps.setDouble(2, entidade.getTotal());
            ps.setDate(3, Date.valueOf(entidade.getData()));

            ps.execute();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Venda> listar() {
        List<Venda> lista = new ArrayList<>();
        String sql = "select vd.id_venda, v.nome, vd.total, vd.data from java_vendedor v inner join java_venda vd on v.id_vendedor = vd.id_vendedor";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                Venda venda = new Venda();

                venda.setId_venda(rs.getInt("id_venda"));
                vendedor.setNome(rs.getString("nome"));
                venda.setTotal(rs.getDouble("total"));
                venda.setData(rs.getDate("data").toLocalDate());

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

        String sql = "delete from java_venda where id_venda = ?";

        try (Connection connection = ConnectionFactory.obterConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1,id);
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
