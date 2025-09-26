public class Aluno{
    String nome;
    String matricula;

    public void apresenta(){
        System.out.println("Olá! Meu nome é " + nome + " e minha matrícula é " + matricula + ".");
    }
    public static void main(String args[]){
        Aluno aluno1 = new Aluno();
        aluno1.nome = "Vitor";
        aluno1.matricula = "202420403211";
        aluno1.apresenta();
    }
}
