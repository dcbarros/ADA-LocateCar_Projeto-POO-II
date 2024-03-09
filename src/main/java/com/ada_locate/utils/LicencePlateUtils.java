package com.ada_locate.utils;

public class LicencePlateUtils {
    public static String convertLicencePlateToId(String licence){
        String licenceCopy = licence;
        licence = licence.replaceAll("[^\\p{Alnum}]", "").toUpperCase();

        if(!isValidLicence(licence))
        throw new IllegalArgumentException("A placa do veículo: " + licenceCopy + " fornecido não pode ser um id");

        return licence;
    }
    
    public static Boolean isValidLicence(String licence){
        if(licence.isBlank() || licence == null) 
        throw new IllegalArgumentException("A placa do veículo a ser validada não foi fornecido, tente novamente");

        licence = licence.replaceAll("[^\\p{Alnum}]", "").toUpperCase();
        
        return licence.length() == 7;
    }

}
