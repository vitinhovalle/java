import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        int a, b;
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o primeiro numero: ");
        a = input.nextInt();
        System.out.print("Insira o segundo numero: ");
        b = input.nextInt();
        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println(a + " x " + b + " = " + a * b);
        System.out.println(a + " / " + b + " = " + a / b);
        System.out.println(a + " mod " + b + " = " + a % b);
        input.close();
    }
}
