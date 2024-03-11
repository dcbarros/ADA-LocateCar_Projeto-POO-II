package com.ada_locate.utils;

public class DocumentUtils {

    public static String convertDocumentToId(String document){

        String documentCopy = document;
        document = document.replaceAll("[^0-9]", "");

        if(!isValidDocument(document))
        throw new IllegalArgumentException("O documento: " + documentCopy + " fornecido não pode ser um id");
        
        return document;
    }

    public static Boolean isValidDocument(String document){
        if(document == null || document.isBlank()) 
        throw new IllegalArgumentException("O documento a ser validado não foi fornecido, tente novamente");
        
        String documentCopy = document;
        document = document.replaceAll("[^0-9]", "");

        if(document.length() == 11){
            return isValidCPF(document);
        }else if(document.length() == 14){
            return isValidCNPJ(document);
        }else{
            throw new IllegalArgumentException("O documento a ser validado é inválido: " + documentCopy);
        }
    }

    public static String documentType(String document){
        document = convertDocumentToId(document);
        if(document.length() == 11){
            return "cpf";
        }
        return "cnpj";
    }

    private static Boolean isValidCPF(String cpf){
        if(cpf.matches("(\\d)\\1*")) return false;
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            sum += (10 - i) * (cpf.charAt(i) - '0');
        }
        int digit1 = 11 - (sum % 11);
        if (digit1 > 9) digit1 = 0;

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (11 - i) * (cpf.charAt(i) - '0');
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9) digit2 = 0;

        return (cpf.charAt(9) - '0') == digit1 && (cpf.charAt(10) - '0') == digit2;
    }

    private static Boolean isValidCNPJ(String cnpj){
        int sum = 0;
        int[] weights1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 12; i++) {
            sum += (cnpj.charAt(i) - '0') * weights1[i];
        }
        int digit1 = 11 - (sum % 11);
        if (digit1 > 9) digit1 = 0;
        
        sum = 0;
        int[] weights2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 13; i++) {
            sum += (cnpj.charAt(i) - '0') * weights2[i];
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9) digit2 = 0;
        
        return (cnpj.charAt(12) - '0') == digit1 && (cnpj.charAt(13) - '0') == digit2;
    }
}
