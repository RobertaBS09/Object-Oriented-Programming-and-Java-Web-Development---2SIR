package Exercicio01;

public class EmrpregadoComissionado extends Empregado{
    protected double totalVendas, comsissao;

    public EmrpregadoComissionado(long matricula, String nome, double totalVendas, double comsissao) {
        super(matricula, nome);
        this.totalVendas = totalVendas;
        this.comsissao = comsissao;
    }

    @Override
    public double calcularSalario() {
        return (totalVendas*comsissao)/100;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Tipo de empregado: Emrpregado Comissionado" +
                "\n Total de Vendas=" + totalVendas +
                "\n Comsissao=" + comsissao;
    }
}
