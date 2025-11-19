package P1n;
 
import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String nome, sobreNome;
    private LocalDate dataNasc;
    private long numCPF;
    private float peso, altura;

    private static int totaldePessoas = 0;

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano){
        this.setNome(nome);
        this.setSobreNome(sobreNome);
        this.setDataNasc(ano, mes, dia);
        totaldePessoas++;
    }
    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura){ 
        this(nome, sobreNome, dia, mes, ano);
        this.setNumCPF(numCPF);
        this.setPeso(peso);
        this.setAltura(altura);
    }

    public String getNome(){    return this.nome;}
    public void setNome(String nome){
        if (nome == null || nome.trim().isEmpty()){  
            System.out.println("Nome invalido (vazio ou nulo).");
            return;    
        }
        if (nome.matches("\\d+")){
            System.out.println("Nome invalido ('" + nome + "') - não pode ser apenas numeros");
            return;
        }
        this.nome = nome.trim();
    }

    public String getSobreNome(){  return this.sobreNome;}
    public void setSobreNome(String sobreNome){
        if (sobreNome == null || sobreNome.trim().isEmpty()){  
            System.out.println("Sobrenome invalido (vazio ou nulo).");
            return;    
        }
        if (sobreNome.matches("\\d+")){
            System.out.println("Sobrenome invalido ('" + sobreNome + "') - não pode ser apenas numeros");
            return;
        }
        this.sobreNome = sobreNome.trim();
    }

    public LocalDate getDataNasc(){   return this.dataNasc;}
    public void setDataNasc(int ano, int mes, int dia){
        if (ValidaData.isDataValida(dia, mes, ano)) this.dataNasc = LocalDate.of(ano, mes, dia);
        else{
            System.out.println("Data invalida (" + dia + "/" + mes + "/" + ano + ") Não foi alterada.");
            this.dataNasc = null;
        }
    }

    public long getNumCPF(){    return this.numCPF;}
    public void setNumCPF(long numCPF){
        String cpfStr = String.format("%011d", numCPF);
        if (ValidaCPF.isCPF(cpfStr))    this.numCPF = numCPF;
        else System.out.println("CPF invalido. (" + numCPF + ") rejeitado.");
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

    public String toString(){
        String cpfFormatado = (this.numCPF != 0) ? ValidaCPF.imprimeCPF(String.format("%011d", this.numCPF)) : "CPF nao informado.";
        return "----------------------------------------\n" +
               "Nome: " + (this.nome != null ? this.nome : "N/I") + " " +
               (this.sobreNome != null ? this.sobreNome : "N/I") + "\n" +
               "CPF: " + cpfFormatado + "\n" +
               "Peso: " + this.peso + "kg | Altura: " + this.altura + "m\n";
    }

    public static int numPessoas(){ return totaldePessoas;}

    public int getIdade(){
        if (this.dataNasc == null)  return -1;
        return Period.between(this.dataNasc, LocalDate.now()).getYears();
    }
}
