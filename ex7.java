import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        int a;
        Scanner input = new Scanner(System.in);
        System.out.print("Insira um numero: ");
        a = input.nextInt();
        for (int i = 0; i < 11; i++) System.out.println(a + " x " + i + " = " + a*i);
        input.close();
    }
}
