package P2n;

import java.time.LocalDate;

public class ValidaData{

    private ValidaData(){}

    public static boolean isAno(int ano){
        int anoAtual = LocalDate.now().getYear(), anoMinimo = anoAtual - 120;
        if (ano >= anoMinimo && ano <= anoAtual)    return true;
        else    return false;
    }
    public static boolean isAno(String ano){
        String anoLimpo = ano.trim();
        if (!anoLimpo.matches("^\\d{4}$"))  return false;
        try {
            int anoNum = Integer.parseInt(anoLimpo);
            return isAno(anoNum);
        } catch (NumberFormatException e) { return false;}
    }

    public static boolean isDia(int dia){  return (dia >= 1 && dia <= 31);}
    public static boolean isDia(String dia){
        String diaLimpo = dia.trim();
        if (diaLimpo.matches("^(0?[1-9]|[12][0-9]|3[01])$")){
            try{
                int diaNum = Integer.parseInt(diaLimpo);
                return isDia(diaNum);
            } catch(NumberFormatException e){   return false;}
        }
        return false;
    }

    public static boolean isMes(int mes){  return (mes >= 1 && mes <= 12);}
    public static boolean isMes(String mes){
        String mesLimpo = mes.toLowerCase().trim();
        
        if (mesLimpo.matches("^(0?[1-9]|1[0-2])$")) return true;
        switch (mesLimpo){
            case "janeiro": case "fevereiro": case "marco": case "abril": case "maio": case "junho": 
            case "julho": case "agosto": case "setembro": case "outubro": case "novembro": case "dezembro": return true;
            default: return false;
        }
    }

    public static int mesStringParaInt(String mes){
        String mesLimpo = mes.toLowerCase().trim();
        if (mesLimpo.matches("^(0?[1-9]|1[0-2])$")) return Integer.parseInt(mesLimpo);

        switch (mesLimpo){
            case "janeiro": return 1; case "fevereiro": return 2; case "marco": return 3; case "abril": return 4; 
            case "maio": return 5; case "junho": return 6; case "julho": return 7; case "agosto": return 8;
            case "setembro": return 9; case "outubro": return 10; case "novembro": return 11; case "dezembro": return 12;
            default: return -1;
        }
    }

    public static boolean isDataValida(int dia, int mes, int ano){
        if (!isDia(dia) || !isMes(mes) || !isAno(ano))  return false;
        try {
            LocalDate.of(ano, mes, dia);
            return true;
        } catch (Exception e) { return false;}
    }
    public static boolean isDataValida(String dia, String mes, String ano){
        if (!isAno(ano) || !isMes(mes) || !isDia(dia))  return false;
        try {
            int diaNum = Integer.parseInt(dia.trim());
            int anoNum = Integer.parseInt(ano.trim());
            int mesNum = mesStringParaInt(mes);

            if (mesNum == -1) return false;

            return isDataValida(diaNum, mesNum, anoNum);

        } catch (Exception e) { return false;}
    }

    public static void main(String[] args){
        int anoAtual = LocalDate.now().getYear();

        System.out.println("Ano atual: " + anoAtual);
        System.out.println("Ano minimo valido e: " + (anoAtual - 120));
        System.out.println("2006: " + isAno(2006));
        System.out.println("2026: " + isAno(2026));
        System.out.println("1800: " + isAno(1800));
        System.out.println("1985: " + isAno(1985));
        System.out.println("2025: " + isAno(2025));
    }
}
