package com.ada_locate.model;

import com.ada_locate.model.enums.VehicleType;
import com.ada_locate.model.interfaces.Indentificator;
import com.ada_locate.utils.LicencePlateUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehicle implements Indentificator{
    @Id
    private String identificator;
    private VehicleType type;
    private String model;
    private Boolean isActive;

    public Vehicle() {
    }

    public Vehicle(String identificator, VehicleType type, String model) {
        setIdentificator(identificator);
        this.type = type;
        this.isActive = true;
        this.model = model;
    }

    public String getIdentificator() {
        return identificator;
    }
    public void setIdentificator(String identificator) {
        if(LicencePlateUtils.isValidLicence(identificator)){
            this.identificator = LicencePlateUtils.convertLicencePlateToId(identificator);
        }else throw new IllegalArgumentException("A placa do veículo é inválida");
    }
    public VehicleType getType() {
        return type;
    }
    public void setType(VehicleType type) {
        this.type = type;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
}
