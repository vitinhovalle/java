public class Carro {
    String cor;
    String modelo;

    public void buzinar(){
        System.out.println("Bibi!");
    }
    public static void main(String args[]){
        Carro meuPrimeiroCarro = new Carro();
        meuPrimeiroCarro.cor = "Azul";
        meuPrimeiroCarro.modelo = "Fusca";
        System.out.println(meuPrimeiroCarro.cor);
        System.out.println(meuPrimeiroCarro.modelo);
    }
}
