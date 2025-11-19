package P2n;

public class Homem extends PessoaIMC{
    public Homem(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura){
        super(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
    }

    @Override
    public String resultIMC(){
        float imc = calculaIMC();
        if (imc < 20.7)         return "Abaixo do peso ideal";
        else if (imc > 26.4)    return "Acima do peso ideal";
        else                    return "Peso ideal";
    }

    public String toString(){
        String idade;
        if (this.getIdade() < 0)    idade = "Nao informada.";
        else                        idade = this.getIdade() + " anos";
        return super.toString() + idade + "\n" + "Genero: Masculino\n" + 
        "IMC: " + String.format("%.2f", this.calculaIMC()) + " -> " + this.resultIMC() + "\n" + "----------------------";
    }
}
