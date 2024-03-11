package com.ada_locate.infra;

import java.util.List;

import com.ada_locate.model.Rent;

import jakarta.persistence.TypedQuery;

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
    public List<Rent> getAllActivesRentOrder(int limit, int offset){
        String stringQuery = "SELECT r FROM Rent r WHERE r.isOpen = 1";
        TypedQuery<Rent> query = entityManager.createQuery(stringQuery, Rent.class);
        query.setFirstResult(offset); 
        query.setMaxResults(limit);    
        return query.getResultList();
    }
}
