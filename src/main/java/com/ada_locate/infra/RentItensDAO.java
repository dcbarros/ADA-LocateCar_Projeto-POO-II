package com.ada_locate.infra;

import java.util.List;

import com.ada_locate.model.RentItens;

import jakarta.persistence.TypedQuery;

public class RentItensDAO extends DAO<RentItens>{
    
    public RentItensDAO() {
        super(RentItens.class);
    }    

    public List<RentItens> findByRentId(Long rentId) {
        TypedQuery<RentItens> query = entityManager.createQuery(
                "SELECT ri FROM RentItens ri WHERE ri.rent.id = :rentId", RentItens.class);
        query.setParameter("rentId", rentId);
        return query.getResultList();
    }
}
