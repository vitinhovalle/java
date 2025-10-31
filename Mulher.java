public class Mulher extends Pessoa{
    public Mulher(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura){
        super(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
    }

    public String toString(){
        String infosBase = super.toString();
        int idadeNum = this.getIdade();
        String idadeStr;
        if (idadeNum < 0)   idadeStr = "Nao informada.";
        else    idadeStr = idadeNum + " anos";

    return infosBase +
           "Idade: " + idadeStr + "\n" +
           "Genero: Feminino" + "\n" +
           "------------------------------\n";
    }
}
