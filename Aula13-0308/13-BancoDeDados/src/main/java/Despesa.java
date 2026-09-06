import java.time.LocalDate;

public class Despesa {
    private int id;
    private Categoria categoria;
    private double valor;
    private String descricao;
    private LocalDate data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getcategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String toString(){
        return "ID:"+ getId()+
                "Valor: R$"+ getValor()+
                "Data: "+ getData()+
                "ID Categoria: "+ getcategoria().getId();

    }
}
