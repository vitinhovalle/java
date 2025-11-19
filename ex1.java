import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        System.out.println("Hello\nVitor Valle");
        Scanner input = new Scanner(System.in);
        System.out.print("Insira seu primeiro nome: ");
        String pNome = input.next();
        System.out.print("Insira seu sobrenome: ");
        String sNome = input.next();
        System.out.println();
        System.out.println("Hello\n" + pNome + " " + sNome);
        input.close();
    }
}
