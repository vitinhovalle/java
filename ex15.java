public class ex15 {
    public static void main(String[] args) {
        int a = 1, b = 2, aux;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        aux = a;
        a = b;
        b = aux;
        System.out.println();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
