package P2n;

public class ValidaCPF{

    private ValidaCPF(){}

    public static boolean isCPF(String cpf){
        if (!cpf.matches("^(\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{3}\\.\\d{3}\\.\\d{3}/\\d{2})$"))    return false;
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        if (cpfLimpo.matches("(\\d)\\1{10}"))   return false;
        try{
            char digito10 = digitoVerificador(cpfLimpo.substring(0, 9));
            char digito11 = digitoVerificador(cpfLimpo.substring(0, 9) + digito10);
            return (digito10 == cpfLimpo.charAt(9) && digito11 == cpfLimpo.charAt(10));
        }   catch(Exception e){ return false;}
    }
    private static char digitoVerificador(String trecho){
        int soma = 0, peso = trecho.length() + 1, digito;
        for (int i = 0; i < trecho.length(); i++){
            soma += Integer.parseInt(trecho.substring(i, i + 1)) * peso;
            peso--;
        }
        digito = 11 - (soma % 11);
        return (digito == 10 || digito == 11) ? '0' : (char) (digito + '0');
    }
    public static String imprimeCPF(String cpf){
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        return cpfLimpo.substring(0, 3) + "." +
               cpfLimpo.substring(3, 6) + "." +
               cpfLimpo.substring(6, 9) + "-" +
               cpfLimpo.substring(9, 11);
    }
    public static long toLong(String cpf){
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        return Long.parseLong(cpfLimpo);
    }
}
