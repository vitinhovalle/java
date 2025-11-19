package P2n;

public class Mulher extends PessoaIMC{
    public Mulher(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura){
        super(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
    }

    @Override
    public String resultIMC(){
        float imc = calculaIMC();
        if (imc < 19)         return "Abaixo do peso ideal";
        else if (imc > 25.8)    return "Acima do peso ideal";
        else                    return "Peso ideal";
    }

    public String toString(){
        String idade;
        if (this.getIdade() < 0)    idade = "Nao informada.";
        else                        idade = this.getIdade() + " anos";
        return super.toString() + idade + "\n" + "Genero: Feminino\n" + 
        "IMC: " + String.format("%.2f", this.calculaIMC()) + " -> " + this.resultIMC() + "\n" + "----------------------";
    }
}
