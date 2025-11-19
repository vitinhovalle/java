import java.util.Scanner;

public class ex17 {
    public static void main(String[] args) {
        long a, b;
        int i = 0, remainder = 0;
        int[] soma = new int[20];
        Scanner input = new Scanner(System.in);

        System.out.print("Insira o primeiro numero: ");
        a = input.nextLong();
        System.out.print("Insira o segundo numero: ");
        b = input.nextLong();

        while (a != 0 || b != 0){
            soma[i++] = (int) (a % 10 + b % 10 + remainder) % 2;
            remainder = (int) (a % 10 + b % 10 + remainder) / 2;
            a /= 10;
            b /= 10;
        }
        if (remainder != 0) soma[i++] = remainder;

        while (i > 0){
            System.out.print(soma[--i]);
        }
        System.out.println();
        input.close();
    }
}
