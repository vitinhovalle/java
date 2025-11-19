package P2n;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String nome, sobreNome;
    private LocalDate dataNasc;
    private long numCPF;

    private static int totaldePessoas = 0;

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano){
        this.setNome(nome);
        this.setSobreNome(sobreNome);
        this.setDataNasc(dia, mes, ano);
        totaldePessoas++;
    }
    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano, long numCPF){ 
        this(nome, sobreNome, dia, mes, ano);
        this.setNumCPF(numCPF);
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
    public void setDataNasc(int dia, int mes, int ano){
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

    public String toString(){
        String cpfFormatado = (this.numCPF != 0) ? ValidaCPF.imprimeCPF(String.format("%011d", this.numCPF)) : "CPF nao informado.";
        return "----------------------------------------\n" +
               "Nome: " + (this.nome != null ? this.nome : "N/I") + " " +
               (this.sobreNome != null ? this.sobreNome : "N/I") + "\n" +
               "CPF: " + cpfFormatado + "\n";
    }

    public static int numPessoas(){ return totaldePessoas;}

    public int getIdade(){
        if (this.dataNasc == null)  return -1;
        return Period.between(this.dataNasc, LocalDate.now()).getYears();
    }
}
