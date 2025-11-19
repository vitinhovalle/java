import java.util.Scanner;

public class ex13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Comprimento: ");
        double a = input.nextDouble();
        System.out.print("Largura: ");
        double b = input.nextDouble();
        System.out.println("Perimetro: " + (2*a + 2*b));
        System.out.println("Area: " + (a*b));
        input.close();
    }
}
