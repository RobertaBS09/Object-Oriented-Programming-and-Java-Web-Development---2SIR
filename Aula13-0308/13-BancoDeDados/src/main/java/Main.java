import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        //System.out.println(connection);
        String sql;
        PreparedStatement ps;
        ResultSet rs;

        // inserção v1
        sql = "insert into java_categoria(categoria) values(?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,"vestimenta");
            //ps.execute();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        // select v1
        sql = "select * from java_categoria";
        try{
            ps = connection.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                System.out.print("ID: " +rs.getInt("id") );
                System.out.println(" Categoria: " +  rs.getString("categoria"));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
