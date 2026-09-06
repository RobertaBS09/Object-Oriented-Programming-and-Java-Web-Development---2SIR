package ExercicioProfessores;

public class Professor {
    int numerodDeAulas;
    double valorHoraAula;
    double horasExtras;


    public double caluclarsalrioBase(){
        double salarioBase=(numerodDeAulas*4.5)*valorHoraAula;
        return  salarioBase;
    }
    public double calcularAdicionalHoraAtiv(){
        double salariobase=caluclarsalrioBase();
        double adicional= salariobase*0.05;
        return adicional;

    }
    public double calcularHorasExtras(){
        double valorhorasextras= horasExtras*valorHoraAula;
        return valorhorasextras;
    }
    public double calcularDescansoSemanal(){
        double salariobase=caluclarsalrioBase();
        double adicionalhoraativ=calcularAdicionalHoraAtiv();
        double horasextras=calcularHorasExtras();

        double dsr=(salariobase+adicionalhoraativ+horasextras)/6;

        return dsr;
    }

    public double calcularsalarioBruto(){
        double salariobase=caluclarsalrioBase();
        double adicionalhoraativ=calcularAdicionalHoraAtiv();
        double horasextras=calcularHorasExtras();
        double dsr = calcularDescansoSemanal();

        double salarioBruto = salariobase+adicionalhoraativ+horasextras+dsr;
        return  salarioBruto;
    }




}
