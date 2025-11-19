package P2n;

public abstract class PessoaIMC extends Pessoa{
    private float peso, altura;

    public PessoaIMC(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura){
        super(nome, sobreNome, dia, mes, ano, numCPF);
        this.setPeso(peso);
        this.setAltura(altura);
    }

    public float getPeso(){    return this.peso;}
    public void setPeso(float peso){
        if (peso > 3 && peso < 150) this.peso = peso;
        else    System.out.println("Peso invalido.");
    }

    public float getAltura(){  return this.altura;}
    public void setAltura(float altura){
        if (altura > 0.3 && altura < 2.5)   this.altura = altura;
        else    System.out.println("Altura invalida.");
    }

    public float calculaIMC(){  return this.peso / (this.altura * this.altura);}
    public abstract String resultIMC();

    public String toString(){   return super.toString() + "Peso: " + this.peso + "kg\n" + "Altura: " + this.altura + "m\n";}
}
