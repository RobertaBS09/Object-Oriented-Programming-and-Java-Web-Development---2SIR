package ExercicioAmericanHeartAssocitation;

public class Paciente {
    String nome;
    int idade;


    public int calcularFrequenciaMax(){
        int frequenciaMax=220-idade;

        double limInf = frequenciaMax*0.50;
        return frequenciaMax;
    }

    public double calcularLimiteSuperior(){
        double frequenciaMax = calcularFrequenciaMax();
        double limSup = frequenciaMax*0.85;
        return limSup;
    }

    public double calcularLimiteInferior(){
        double frequenciaMax = calcularFrequenciaMax();
        double limInf = frequenciaMax*0.50;
        return limInf;
    }


}
