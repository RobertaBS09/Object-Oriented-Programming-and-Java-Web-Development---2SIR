package Exercicio01;

public class EmpregadoHorista extends Empregado{
    protected int totaldeHorasTrabalhadas;
    protected double valorHoraTrabalhada;

    public EmpregadoHorista(long matricula, String nome, int totaldeHorasTrabalhadas, double valorHoraTrabalhada) {
        super(matricula, nome);
        this.totaldeHorasTrabalhadas = totaldeHorasTrabalhadas;
        this.valorHoraTrabalhada = valorHoraTrabalhada;
    }

    @Override
    public double calcularSalario() {
        return totaldeHorasTrabalhadas*valorHoraTrabalhada;
    }

    @Override
    public String toString() {
        return "Tipo de empregado: Empregado Horista" +
                "\nTotal de Horas Trabalhadas --> " + totaldeHorasTrabalhadas +
                "\nValor Hora Trabalhada -->R$" + valorHoraTrabalhada;
    }
}
