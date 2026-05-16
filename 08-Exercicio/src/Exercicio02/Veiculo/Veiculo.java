package Exercicio02.Veiculo;

public class Veiculo {
    protected String placa;
    protected String marca;

    public Veiculo(String placa, String marca) {
        this.placa = placa;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "------Veiculo------" +
                "\nPlaca: " + placa +
                "\nMarca: " + marca;

    }
}
