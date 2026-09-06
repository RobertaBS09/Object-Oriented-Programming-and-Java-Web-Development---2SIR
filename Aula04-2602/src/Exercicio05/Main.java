package Exercicio05;

public class Main {
    public static void main(String[] args) {
        ContaStreaming c1= new ContaStreaming("Roberta","Estudante",100);
        ContaStreaming c2= new ContaStreaming("Belinha","PCD",80);
        ContaStreaming c3= new ContaStreaming("Selminha","Normal",150);
        ContaStreaming.alterarTaxa(0.05);
        c1.alterarValor();
        c1.apresentar();
        c2.alterarValor();
        c2.apresentar();
        c3.alterarValor();
        c3.apresentar();
    }
}
