import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        int a = 74, b = 36;
        System.out.println(a + b);
        Scanner input = new Scanner(System.in);
        System.out.print("Insira um numero: "); 
        int c = input.nextInt();
        System.out.print("Insira outro numero: ");
        int d = input.nextInt();
        System.out.println(c + " + " + d + " = " + (c + d));
        input.close();
    }
}
