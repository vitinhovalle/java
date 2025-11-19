package P2n;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class MinhaListaOrdenavel{

    public static final int NOME_AZ = 1;
    public static final int NOME_ZA = 2;
    public static final int PESO_CRESCENTE = 3;
    public static final int PESO_DECRESCENTE = 4;
    public static final int ALTURA_CRESCENTE = 5;
    public static final int ALTURA_DECRESCENTE = 6;
    public static final int IMC_CRESCENTE = 7;
    public static final int IMC_DECRESCENTE = 8;
    public static final int GENERO_HOMEM = 9;
    public static final int GENERO_MULHER = 10;
    public static final int IDADE_CRESCENTE = 11;
    public static final int IDADE_DECRESCENTE = 12;
    public static final int DATANASC_CRESCENTE = 13;
    public static final int DATANASC_DECRESCENTE = 14;
    public static final int CPF_CRESCENTE = 15;
    public static final int CPF_DECRESCENTE = 16;

    private ArrayList<PessoaIMC> listaDePessoas;

    public MinhaListaOrdenavel(){   this.listaDePessoas = new ArrayList<PessoaIMC>();}

    public void add(PessoaIMC p){   this.listaDePessoas.add(p);}
    public PessoaIMC get(int i){    return this.listaDePessoas.get(i);}

    public Comparator<PessoaIMC> nomeC = new Comparator<PessoaIMC>(){
        public int compare(PessoaIMC p1, PessoaIMC p2){ return p1.getNome().compareTo(p2.getNome());}
    };

    public Comparator<PessoaIMC> pesoC = new Comparator<PessoaIMC>(){
        public int compare(PessoaIMC p1, PessoaIMC p2){
            float peso1 = p1.getPeso();
            float peso2 = p2.getPeso();

            return Float.compare(peso1, peso2);
        }
    };

    public Comparator<PessoaIMC> alturaC = new Comparator<PessoaIMC>(){
        public int compare(PessoaIMC p1, PessoaIMC p2){
            float altura1 = p1.getAltura();
            float altura2 = p2.getAltura();

            return Float.compare(altura1, altura2);
        }
    };

    public Comparator<PessoaIMC> imcC = new Comparator<PessoaIMC>(){
        public int compare(PessoaIMC p1, PessoaIMC p2){
            float imc1 = p1.calculaIMC();
            float imc2 = p2.calculaIMC();

            return Float.compare(imc1, imc2);
        }
    };

    public Comparator<PessoaIMC> generoC = new Comparator<PessoaIMC>(){
        public int compare(PessoaIMC p1, PessoaIMC p2){
            if (p1 == null && p2 == null)   return 0;
            if (p1 == null)                 return 1;
            if (p2 == null)                 return -1;

            if (p1 instanceof Homem){
                if (p2 instanceof Homem)    return 0;
                else                        return -1;
            }

            else{
                if (p2 instanceof Mulher)   return 0;
                else                        return 1;
            }
        }
    };

    public Comparator<PessoaIMC> idadeC = new Comparator<PessoaIMC>(){
        public int compare(PessoaIMC p1, PessoaIMC p2){
            int idade1 = p1.getIdade();
            int idade2 = p2.getIdade();

            return Integer.compare(idade1, idade2);
        }
    };

    public Comparator<PessoaIMC> dataNascC = new Comparator<PessoaIMC>(){
        public int compare(PessoaIMC p1, PessoaIMC p2){ return p1.getDataNasc().compareTo(p2.getDataNasc());}
    };

    public Comparator<PessoaIMC> cpfC = new Comparator<PessoaIMC>(){
        public int compare(PessoaIMC p1, PessoaIMC p2){
            long cpf1 = p1.getNumCPF();
            long cpf2 = p2.getNumCPF();

            return Long.compare(cpf1, cpf2);
        }
    };

    public ArrayList<PessoaIMC> ordena(int criterio){
        switch (criterio){
            case NOME_AZ:
                Collections.sort(this.listaDePessoas, nomeC);
                break;
            case NOME_ZA:
                Collections.sort(this.listaDePessoas, nomeC.reversed());
                break;
            case PESO_CRESCENTE:
                Collections.sort(this.listaDePessoas, pesoC);
                break;
            case PESO_DECRESCENTE:
                Collections.sort(this.listaDePessoas, pesoC.reversed());
                break;
            case ALTURA_CRESCENTE:
                Collections.sort(this.listaDePessoas, alturaC);
                break;
            case ALTURA_DECRESCENTE:
                Collections.sort(this.listaDePessoas, alturaC.reversed());
                break;
            case IMC_CRESCENTE:
                Collections.sort(this.listaDePessoas, imcC);
                break;
            case IMC_DECRESCENTE:
                Collections.sort(this.listaDePessoas, imcC.reversed());
                break;
            case GENERO_HOMEM:
                Collections.sort(this.listaDePessoas, generoC);
                break;
            case GENERO_MULHER:
                Collections.sort(this.listaDePessoas, generoC.reversed());
                break;
            case IDADE_CRESCENTE:
                Collections.sort(this.listaDePessoas, idadeC);
                break;
            case IDADE_DECRESCENTE:
                Collections.sort(this.listaDePessoas, idadeC.reversed());
                break;
            case DATANASC_CRESCENTE:
                Collections.sort(this.listaDePessoas, dataNascC);
                break;
            case DATANASC_DECRESCENTE:
                Collections.sort(this.listaDePessoas, dataNascC.reversed());
                break;
            case CPF_CRESCENTE:
                Collections.sort(this.listaDePessoas, cpfC);
                break;
            case CPF_DECRESCENTE:
                Collections.sort(this.listaDePessoas, cpfC.reversed());
            default:
                System.out.println("Criterio de ordenacao invalido");
        }
        return this.listaDePessoas;
    }
}
