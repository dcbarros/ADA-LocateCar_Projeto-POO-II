package com.ada_locate.model;

import com.ada_locate.model.interfaces.ClientIdentificator;
import com.ada_locate.utils.DocumentUtils;

public class LegalPerson implements ClientIdentificator{

    private String identificator;

    public LegalPerson(String identificator) {
        setIdentificator(identificator);
    }

    @Override
    public String getIdentificator() {
        return this.identificator;
    }

    @Override
    public void setIdentificator(String inputDocument) {
        if(DocumentUtils.isValidDocument(inputDocument)){
            this.identificator = inputDocument;
        }else throw new IllegalArgumentException("O CNPJ é inválido");
    }
    
}
