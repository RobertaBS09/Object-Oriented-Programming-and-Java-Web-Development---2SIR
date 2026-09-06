package ProjetoProduto;

public class Produto {
    int codigo;
    String nome;
    double valor;

    public Produto(int codigo, String nome, double valor){  //não coloca o tipo (int,double,void) antes de Produto () pois construtor não tem tipo. os dentro do () são Parâmetros
        //atribuir o valor dessas variaveis para a variavel criada dentro da classe, pois esses que vem no parenteses são variáveis locais

        this.codigo=codigo; //o this se referencia ao objeto dentro da classe( os valores que vem do main) se não colocar, os valores dentro do objeto não terão valor (null e 0).
        this.nome=nome ;
        this.valor=valor;

    }

    public void Aumentar(double porcentagem){
        this.valor *= (1+(porcentagem/100));
    }

    public String getDados(){
        return codigo+"\n"+nome+"\n"+valor;


    }




}

