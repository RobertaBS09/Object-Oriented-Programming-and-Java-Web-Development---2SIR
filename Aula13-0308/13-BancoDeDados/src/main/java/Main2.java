import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        /*CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoria = new Categoria("Bebida");
        //categoriaDAO.inserir(categoria);


        List<Categoria> lista = new CategoriaDAO().listar();

        //imprime os itens da lista
        for (Categoria c : lista){
            System.out.println(c);
        }

        String pesquisa = categoriaDAO.pesquisar(5);
        System.out.println(pesquisa);*/

        // DESPESA

        DespesaDAO despesaDAO = new DespesaDAO();
        Despesa despesa = new Despesa();
        despesa.setDescricao("Faculdade");
        despesa.setValor(683.67);
        despesa.setData(LocalDate.now());
        //despesa.setCategoria(new Categoria(3));


        //despesaDAO.inserir(despesa);

        List<Despesa> lista = despesaDAO.listar();

        for (Despesa despesa1 :lista){
            System.out.print( despesa1.getDescricao() +" | ");
            System.out.print( despesa1.getValor() +" | ");
            System.out.print( despesa1.getData() +" | ");
        }
    }
}
