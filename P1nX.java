import java.util.Scanner;

public class P1nX{
    public static void main(String[] args){
        if (args.length != 9){
            System.out.println("ERRO: Numero incorreto de argumentos!");
            System.out.println("Você passou " + args.length + " argumentos, mas 9 eram esperados.");
            System.out.println("\nUso correto: java P1nX <genero> <nome> <sobre> <dia> <mes> <ano> <CPF> <peso> <altura>");
            return;
        }
        try{
            String generoStr = args[0];
            String nome = args[1];
            String sobreNome = args[2];
            String diaStr = args[3];
            String mesStr = args[4];
            String anoStr = args[5];
            String cpfStr = args[6];
            String pesoStr = args[7];
            String alturaStr = args[8];

            if (!generoStr.equalsIgnoreCase("M") && !generoStr.equalsIgnoreCase("F")){
                System.out.println("Erro: Gênero inválido. Use 'M' para Masculino ou 'F' para Feminino.");
                return;
            }
            if (!ValidaData.isDataValida(diaStr, mesStr, anoStr)){
                System.out.println("Erro: Data de nascimento inválida (" + diaStr + "/" + mesStr + "/" + anoStr + ").");
                return;
            }
            if (!ValidaCPF.isCPF(cpfStr)){
                System.out.println("Erro: CPF inválido (" + cpfStr + ").");
                return;
            }

            int dia = Integer.parseInt(diaStr);
            int mes = ValidaData.mesStringParaInt(mesStr);
            int ano = Integer.parseInt(anoStr);
            long cpf = Long.parseLong(cpfStr);
            float peso = Float.parseFloat(pesoStr);
            float altura = Float.parseFloat(alturaStr);

            Pessoa p1;

            if (generoStr.equalsIgnoreCase("M"))    p1 = new Homem(nome, sobreNome, dia, mes, ano, cpf, peso, altura);
            else    p1 = new Mulher(nome, sobreNome, dia, mes, ano, cpf, peso, altura);

            System.out.println(p1.toString());

        } catch (NumberFormatException e){
            System.out.println("ERRO: Um dos argumentos numéricos (dia, mes, ano, cpf, peso, altura) não é um número válido.");
            System.out.println("Detalhe do erro: " + e.getMessage());
            return;
        }
        Scanner teclado = new Scanner(System.in);
        int numAdicionais = 0;

        while (true){
            System.out.print("\nQuantos elementos ADICIONAIS você quer criar no array? ");
            try {
                numAdicionais = teclado.nextInt();
                teclado.nextLine();
                if (numAdicionais < 0)  System.out.println("Erro: O número não pode ser negativo.");
                else    break;
            } catch (Exception e){
                System.out.println("Erro: Isso não é um número válido. Tente novamente.");
                teclado.nextLine();
            }
        }
        Pessoa[] pessoas = new Pessoa[numAdicionais];

        System.out.println("Array 'pessoas' criado com " + numAdicionais + " posições.");

        System.out.println("\nIniciando cadastro de " + numAdicionais + " pessoa(s)...");
        int pessoasCriadas = 0;

        for (int i = 0; i < numAdicionais; i++) {
            
            System.out.println("\n--- Cadastro da Pessoa " + (i + 1) + " ---");

            String generoStr;
            while (true) {
                System.out.print("Digite o Gênero (M/F) ou [ENTER] para parar: ");
                generoStr = teclado.nextLine();

                if (generoStr.isEmpty()) break; // 
                if (generoStr.equalsIgnoreCase("M") || generoStr.equalsIgnoreCase("F")) break;
                System.out.println("Erro: Genero invalido. Tente 'M' ou 'F'.");
            }

            if (generoStr.isEmpty()) {
                System.out.println("Entrada de dados interrompida pelo usuario.");
                break;
            }

            String nome;
            while (true) {
                System.out.print("Digite o Nome: ");
                nome = teclado.nextLine();
                if (nome != null && !nome.trim().isEmpty() && !nome.matches("\\d+"))    break;
                System.out.println("Erro: Nome invalido (nao pode ser vazio ou so números).");
            }

            String sobreNome;
            while (true) {
                System.out.print("Digite o Sobrenome: ");
                sobreNome = teclado.nextLine();
                if (sobreNome != null && !sobreNome.trim().isEmpty() && !sobreNome.matches("\\d+")) break;
                System.out.println("Erro: Sobrenome invalido (nao pode ser vazio ou so numeros).");
            }

            int dia, mes, ano;
            while (true){
                try{
                    System.out.print("Digite o Dia de Nascimento (DD): ");
                    dia = Integer.parseInt(teclado.nextLine());
                    
                    System.out.print("Digite o Mes de Nascimento (MM): ");
                    String mesStr = teclado.nextLine();

                    System.out.print("Digite o Ano de Nascimento (AAAA): ");
                    ano = Integer.parseInt(teclado.nextLine());

                    if (!ValidaData.isMes(mesStr)) {
                         System.out.println("Erro: Mes inválido ('" + mesStr + "'). Tente novamente.");
                         continue;
                    }

                    mes = ValidaData.mesStringParaInt(mesStr);

                    if (ValidaData.isDataValida(dia, mes, ano)) break;  
                    else  System.out.println("Erro: Data invalida. Tente novamente.");

                } catch (NumberFormatException e) {
                    System.out.println("Erro: dia, mes e ano devem ser numeros. Tente novamente.");
                }
            }

            long cpf;
            while (true){
                System.out.print("Digite o CPF (apenas números): ");
                String cpfStr = teclado.nextLine().trim();
                if (ValidaCPF.isCPF(cpfStr)){
                    try{
                        cpf = Long.parseLong(cpfStr.replaceAll("[^0-9]", ""));
                        break;
                    } catch (NumberFormatException e){
                        System.out.println("Erro inesperado na conversao. Tente novamente.");
                    }
                } else  System.out.println("Erro: CPF invalido. Tente novamente.");
            }

            float peso;
            while (true){
                System.out.print("Digite o Peso em kg (ex: 70.5): ");
                try{
                    String pesoStr = teclado.nextLine().trim();
                    peso = Float.parseFloat(pesoStr);
                    if (peso > 3 && peso < 150) break;
                    else    System.out.println("Erro: Peso invalido (deve ser entre 3 e 150 kg). Tente novamente.");    
                } catch (NumberFormatException e){
                    System.out.println("Erro: Entrada invalida. Digite apenas numeros (ex: 70.5).");
                }
            }

            float altura;
            while (true){
                System.out.print("Digite a Altura em metros (ex: 1.75): ");
                try{
                    String alturaStr = teclado.nextLine().trim();
                    altura = Float.parseFloat(alturaStr);
                    if (altura > 0.5 && altura < 2.5)   break; // Altura válida, sai do loop
                    else    System.out.println("Erro: Altura invalida (deve ser entre 0.5 e 2.5 m). Tente novamente.");
                } catch (NumberFormatException e){
                    System.out.println("Erro: Entrada invalida. Digite apenas números (ex: 1.75).");
                }
            }
            
            Pessoa novaPessoa;
            if (generoStr.equalsIgnoreCase("M"))    novaPessoa = new Homem(nome, sobreNome, dia, mes, ano, cpf, peso, altura);
            else    novaPessoa = new Mulher(nome, sobreNome, dia, mes, ano, cpf, peso, altura);
            
            pessoas[i] = novaPessoa;
            pessoasCriadas++;
        }

        System.out.println("\nCadastro finalizado. " + pessoasCriadas + " pessoa(s) adicionada(s) ao array.");
        System.out.println("\n--- EXIBINDO TODOS OS OBJETOS CRIADOS NO ARRAY ---");

        for (Pessoa p : pessoas) {
            if (p != null)  System.out.println(p); 
        }
        int contHomens = 0;
        int contMulheres = 0;

        for (Pessoa p : pessoas) {
            if (p != null) {
                if (p instanceof Homem) contHomens++;
                else if (p instanceof Mulher)   contMulheres++;
            }
        }
        System.out.println("========================================");
        System.out.println("Contagem no array (usando instanceof):");
        System.out.println("Total de Homens: " + contHomens);
        System.out.println("Total de Mulheres: " + contMulheres);
        System.out.println("----------------------------------------");
        System.out.println("Contagem TOTAL de objetos (Pessoa + Homem + Mulher) criados:");
        System.out.println("Total de instâncias (via Pessoa.numPessoas()): " + Pessoa.numPessoas());
        System.out.println("========================================");

        teclado.close();
    }
}
