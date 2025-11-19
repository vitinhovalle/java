import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Raio: ");
        double r = input.nextDouble();
        System.out.println("Perimetro: " + (2.0*r*Math.PI));
        System.out.println("Area: " + (Math.PI*r*r));
        input.close();
    }
}
