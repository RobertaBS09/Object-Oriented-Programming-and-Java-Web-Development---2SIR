package DAO;

import factory.ConnectionFactory;
import model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfessorDAO implements GenericDAO<Professor, Integer> {
    @Override
    public void inserir(Professor professor) {
        String sql = " insert into java_professor (id_professor,nome,aulas_semanais,valor_hora,salario) VALUES  (?,?,?,?,?)";
        try (
                Connection connection = ConnectionFactory.obterConexao();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            Integer novoId = gerarProximoId(connection);
            professor.setId_professor(novoId);


            ps.setInt(1, professor.getId_professor());
            ps.setString(2, professor.getNome());
            ps.setInt(3, professor.getAulas_semanais());
            ps.setDouble(4, professor.getValor_hora());
            ps.setDouble(5, professor.getSalario());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Professor> listar() {
        List<Professor> lista = new ArrayList<>();
        String sql = "select id_professor, nome, aulas_semanais, valor_hora from java_professor";

        try (
                Connection connection = ConnectionFactory.obterConexao();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setId_professor(rs.getInt("id_professor"));
                professor.setNome(rs.getString("nome"));
                professor.setAulas_semanais(rs.getInt("aulas_semanais"));
                professor.setValor_hora(rs.getDouble("valor_hora"));

                // exigência: cálculo em Java
                professor.calcularSalario();

                lista.add(professor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public Professor buscarPorId(Integer id) {

        String sql = "select * from java_professor where id = ?";

        try (Connection conn = ConnectionFactory.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Professor p = new Professor();
                    p.setId_professor(rs.getInt("id_professor"));
                    p.setNome(rs.getString("nome"));
                    p.setAulas_semanais(rs.getInt("aulas_semanais"));
                    p.setValor_hora(rs.getDouble("valor_hora"));

                    // Recalcula as parcelas em Java (exigência do enunciado)
                    p.calcularSalario();

                    return p;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar professor por ID: "+e);
        }

        return null;


    }

    public int gerarProximoId(Connection conn) throws SQLException {
        String sql = "SELECT MAX(id_professor) AS maior_id FROM professor";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int maiorId = rs.getInt("maior_id");
                if (rs.wasNull()) { // tabela vazia => MAX retornou NULL
                    return 1000;
                }
                return maiorId + 1;
            }
            return 1000;
        }
    }
}
