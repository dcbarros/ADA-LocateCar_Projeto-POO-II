package com.ada_locate.model;

import com.ada_locate.model.interfaces.Indentificator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class RentItens{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Vehicle vehicle;
    
    @ManyToOne
    private Rent rent;

    public RentItens() {
    }

    public RentItens(Vehicle vehicle, Rent rent) {
        setVehicle(vehicle);
        setRent(rent);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if(vehicle == null) throw new IllegalArgumentException("Veiculo não repassado");
        this.vehicle = vehicle;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        if(rent == null) throw new IllegalArgumentException("Ficha de Aluguel não repassada");
        this.rent = rent;
    }

}
