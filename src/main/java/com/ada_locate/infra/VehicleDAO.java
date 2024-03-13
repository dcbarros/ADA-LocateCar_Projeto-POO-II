package com.ada_locate.infra;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ada_locate.model.Vehicle;

import jakarta.persistence.TypedQuery;

public class VehicleDAO extends DAO<Vehicle> {
    
    public VehicleDAO(){
        super(Vehicle.class);
    }

    public List<Vehicle> seachByNameSubstring(String request){
        String jpql = "SELECT v FROM Vehicle v WHERE v.model LIKE :request";
        TypedQuery<Vehicle> query = entityManager.createQuery(jpql, Vehicle.class);
        query.setParameter("request", "%" + request + "%");
        return query.getResultList();
    }
}
