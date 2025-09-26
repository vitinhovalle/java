import java.time.LocalDate;
import java.time.Period;

public class Pessoa{

    public enum Genero{ MASCULINO, FEMININO, TRANS}

    private String nome, sobrenome;
    private double altura, peso;
    private Genero genero;
    private LocalDate dataNascimento;
    private static int pessoas = 0;

    public Pessoa(String nome, String sobrenome, double altura, double peso, Genero genero, LocalDate dataNascimento){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        pessoas++;
    }
    public Pessoa(){    this(null, null, 0, 0, null, null);}
    public Pessoa(String nome){    this(nome, null, 0, 0, null, null);}

    public String getNome(){    return this.nome;}
    public void setNome(String novoNome){   this.nome = novoNome;}

    public String getSobrenome(){   return this.sobrenome;}
    public void setSobrenome(String novoSobrenome){ this.sobrenome = novoSobrenome;}

    public double getAltura(){  return this.altura;}
    public void setAltura(double novaAltura){
        if (novaAltura > 0.5 && novaAltura < 2.5)   this.altura = novaAltura;
        else    System.out.println("Altura invalida.");}

    public double getPeso(){    return this.peso;}
    public void setPeso(double novoPeso){
        if (novoPeso > 3 && novoPeso < 150) this.peso = novoPeso;
        else    System.out.println("Peso invalido.");}
    
    public String getGenero(){
        switch(this.genero){
            case MASCULINO: return "Masculino";
            case FEMININO:  return "Feminino";
            case TRANS: return "Trans";
            default: return "Não especificado";
        }
    }
    public void setGenero(Genero novoGenero){   this.genero = novoGenero;}

    private int getIdade(){  return Period.between(this.dataNascimento, LocalDate.now()).getYears();}
    public LocalDate getDataNascimento(){   return this.dataNascimento;}
    public void setDataNascimento(LocalDate novaDataNascimento){    this.dataNascimento = novaDataNascimento;}

    public static int getPessoas(){ return pessoas;}

    public String toString(){   
        return "Nome: "+nome+"\nSobrenome: "+sobrenome+"\nAltura: "+altura+"\nPeso: "+peso+"\nGenero: "+genero+"\nIdade: "+getIdade()+" anos\n";
    }

    public static void main(String args[]){
        Pessoa pai = new Pessoa("Cristiano", "Ronaldo", 1.87, 83, Pessoa.Genero.MASCULINO, LocalDate.of(1985, 2, 5));
        Pessoa mae = new Pessoa("Taylor", "Swift", 1.78, 63, Pessoa.Genero.FEMININO, LocalDate.of(1989, 12, 13));

        System.out.println(pai.toString());
        System.out.println(mae.toString());
        System.out.println("----------------------------");
        System.out.println("Total de pessoas criadas: " + Pessoa.getPessoas());
    }
}
