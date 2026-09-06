package Exercicio01;

public class Bicicleta {

    String cor;
    int NumMarchas;
    double valor;



    public void RetornarDados(String cor, int NumMarchas, double valor){
        System.out.println("Cor bicicleta --> "+ cor);
        System.out.println("Número de marchas --> "+NumMarchas);
        System.out.println("Valor --> R$ "+ valor);
    }
}
