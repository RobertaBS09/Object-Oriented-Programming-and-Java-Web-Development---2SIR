public class Categoria {
    private int id;
    private String categoria;

    public Categoria(int id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public Categoria(String categoria){
        this.categoria = categoria;
    }

    public Categoria(int id){
        this.id= id;
    }
    public String getcategoria() {
        return categoria;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id: "+ getId()+
                "| Categoria: "+getcategoria();
    }
}
