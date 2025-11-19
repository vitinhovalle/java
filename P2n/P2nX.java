package P2n;

import java.util.ArrayList;
import java.util.Scanner;

public class P2nX{
    public static void main(String[] args) {
        MinhaListaOrdenavel minhaLista = new MinhaListaOrdenavel();
        
        Homem h1 = new Homem("Vitor", "Valle", 7, 6, 2006, 16368430770L, 58f, 1.68f);
        Homem h2 = new Homem("Renato", "Jose", 27, 12, 1966, 87579251787L, 65f, 1.80f);
        Homem h3 = new Homem("Bruno", "Barreto", 15, 12, 1994, 15761265796L, 95f, 1.78f);
        Homem h4 = new Homem("Gabriel", "Santos", 25, 3, 1994, 12170765735L, 90f, 2.05f);
        Homem h5 = new Homem("Lucas", "Eduardo", 12, 2, 2005, 13791375784L, 75f, 1.73f);

        Mulher m1 = new Mulher("Isabela", "Lima", 29, 10, 2007, 94951774135L, 52f, 1.55f);
        Mulher m2 = new Mulher("Ilma", "Regina", 2, 3, 1972, 1162163798L, 65f, 1.50f);
        Mulher m3 = new Mulher("Amanda", "Cristina", 25, 5, 1995, 14941648765L, 70f, 1.75f);
        Mulher m4 = new Mulher("Taina", "Santos", 22, 11, 1994, 15536569708L, 55f, 1.48f);
        Mulher m5 = new Mulher("Joana", "Sales", 21, 8, 2007, 91581593716L, 70f, 1.65f);

        minhaLista.add(h1); minhaLista.add(h2); minhaLista.add(h3); minhaLista.add(h4); minhaLista.add(h5);
        minhaLista.add(m1); minhaLista.add(m2); minhaLista.add(m3); minhaLista.add(m4); minhaLista.add(m5);

        System.out.println("Lista criada com 10 objetos");

        Scanner teclado = new Scanner(System.in);
        boolean continuar = true;

        while (continuar){
            System.out.println("1. Imprimir Lista de Pessoas");
            System.out.println("2. Sair");
            System.out.print("Digite sua opção: ");

            String opcao = teclado.nextLine();

            switch(opcao){
                case "1":
                    try{
                        System.out.println("\n    Escolha seu modo de ordenacao");
                        System.out.println("1. Alfabetica (A-Z)");
                        System.out.println("2. Alfabetica (Z-A)");
                        System.out.println("3. Menor Peso");
                        System.out.println("4. Maior Peso");
                        System.out.println("5. Menor Altura");
                        System.out.println("6. Maior Altura");
                        System.out.println("7. Menor IMC");
                        System.out.println("8. Maior IMC");
                        System.out.println("9. Genero (H-M)");
                        System.out.println("10. Genero (M-H)");
                        System.out.println("11. Menor Idade");
                        System.out.println("12. Maior Idade");
                        System.out.println("13. Menor Data de Nascimento");
                        System.out.println("14. Maior Data de Nascimento");
                        System.out.println("15. Menor CPF");
                        System.out.println("16. Maior CPF");
                        System.out.println("Digite sua opcao: ");

                        int criterio =  Integer.parseInt(teclado.nextLine());
                        ArrayList<PessoaIMC> listaOrdenada = minhaLista.ordena(criterio);

                        System.out.println("\n--- LISTA ORDENADA ---");
                        for (PessoaIMC p : listaOrdenada) {
                            if (p != null)  System.out.println(p); 
                        }
                    } catch(Exception e){System.out.println("Opcao invalida!!");}
                    break;
            
            case "2":
                continuar = false;
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opcao invalida!! Tente novamente.");
            }
        }
        teclado.close();
        System.out.println("Programa encerrado.");
    }
}
