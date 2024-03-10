package com.ada_locate.infra;

import com.ada_locate.model.Rent;

public class RentDAO extends DAO<Rent>{
    
    public RentDAO() {
        super(Rent.class);
    }

    public Rent findByRentId(Long id){
        if(id == null) throw new IllegalArgumentException("Id não fornecido ou Nulo");
        Rent rent = entityManager.find(Rent.class, id);
        if(rent == null) return null;
        return rent;
    }
}
