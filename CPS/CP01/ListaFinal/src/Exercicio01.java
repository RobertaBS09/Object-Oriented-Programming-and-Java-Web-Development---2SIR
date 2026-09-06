import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean validacao;
        System.out.println("Digite os genes do pai");
        String dnap = sc.nextLine();
        System.out.println("Digite os genes do filho");
        String dnaf = sc.nextLine();

        dnap = dnap.toUpperCase();
        dnaf = dnaf.toUpperCase();

        validacao = validacao(dnap, dnaf);
        if (!validacao) {
            return;
        } else {
            comparacao(dnap, dnaf);
        }

    }

    public static Boolean validacao(String dnap, String dnaf) {
        if (dnap.length() != dnaf.length()) {
            System.out.println("Sequências INVÁLIDAS. Ambas sequencias devem ter o mesmo comprimento");
            return false;
        }
        for (int i = 0; i < dnaf.length(); i++) {
            char c = dnap.charAt(i);
            if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                System.out.println("Sequências INVÁLIDAS. As sequebncias deve ter somente os caracteres A C G T ");
                return false;
            }
        }
        for (int i = 0; i < dnaf.length(); i++) {
            char c = dnaf.charAt(i);
            if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                System.out.println("Sequências INVÁLIDAS. As sequebncias deve ter somente os caracteres A C G T ");
                return false;
            }
        }
        return true;
    }

    public static void comparacao(String dnap, String dnaf) {
        char[] cDnap = dnap.toCharArray();
        char[] cDnaf = dnaf.toCharArray();
        double diferentes=0;
        double iguais;
        for (int i = 0; i < cDnap.length; i++) {
            if (cDnap[i] != cDnaf[i]) {
                diferentes++;
                System.out.println("Os genes são diferentes na posição "+ (i+1));
            }
        }
        System.out.println("Sequencias diferentes "+diferentes+" genes diferem");
        iguais= dnap.length()-diferentes;
        double semelhanca=((iguais/dnap.length())*100);
        System.out.println("Similaridade: "+semelhanca+"%");
    }


}
