import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro ->");
        int n = sc.nextInt();

        while (true) {
            System.out.print(n+ " ");
            if (n==1){
                break;
            }
            if (!(n % 2 == 0)) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }


        }

    }
}
