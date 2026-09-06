package Exercicio05;

public class ContaStreaming {
    String usuario;     // Atributo de instância: cada objeto (cada conta) tem seu próprio usuário
    String plano;       // Atributo de instância: cada objeto tem seu próprio plano
    double valorPlano;  // Atributo de instância: cada objeto tem seu próprio valor de plano

    static double taxaValor = 0.10;
    // Atributo da classe (static): existe uma única taxa compartilhada entre TODAS as contas.
    // Começa em 0.10 (10%), mas pode ser alterada pelo sistema chamando alterarTaxa(...).

    public ContaStreaming(String usuario, String plano, double valorPlano) {
        // Construtor: inicializa os atributos do objeto com os valores recebidos do main
        this.usuario = usuario;
        this.plano = plano;
        this.valorPlano = valorPlano;
    }

    public static void alterarTaxa(double reajuste) {
        // Método static porque altera a taxa global (da classe), não de um objeto específico.
        // Aqui você está SOMANDO o reajuste à taxa atual (ex.: 0.10 + 0.05 = 0.15).
        ContaStreaming.taxaValor += reajuste;
    }

    public double alterarValor() {
        // Método de instância (não static) porque depende do valorPlano deste objeto (this.valorPlano).
        // Calcula o acréscimo usando a taxa global (ContaStreaming.taxaValor), que é a mesma para todos.
        double acrescimo = this.valorPlano * ContaStreaming.taxaValor;

        // Atualiza o valor do plano deste objeto
        this.valorPlano = this.valorPlano + acrescimo;

        // Retorna o novo valor do plano deste objeto
        return this.valorPlano;
    }

    public void apresentar() {
        // Exibe os dados armazenados neste objeto
        System.out.println("Usuário " + this.usuario + " | Plano " + this.plano + " | Valor plano: R$" + this.valorPlano);
    }
}