package com.ada_locate.service;

import com.ada_locate.infra.DAO;
import com.ada_locate.model.Client;
import com.ada_locate.model.Vehicle;

import java.util.List;

public class VehicleService {

    private DAO<Vehicle> dao;

    public VehicleService(){this.dao = new DAO<>(Vehicle.class);}

    public Boolean add(Vehicle request){
        if(dao.getById(request.getIdentificator()) == null){
            dao.addAtomicTransaction(request);
            return true;
        }
        return false;
    }

    public List<Vehicle> getAll(int limit, int offset){
        return dao.getAll(limit, offset);
    }

    public Vehicle getById(String id){
        if(dao.getById(id) == null){
            throw new IllegalArgumentException("Placa não localizada no sistema.");
        }
        return dao.getById(id);
    }

    public Boolean update(String id){
        if(dao.getById(id) == null){
            throw new IllegalArgumentException("Placa não localizada no sistema.");
        }
        Vehicle vehicle = dao.getById(id);
        vehicle.setIsActive(!vehicle.getIsActive());
        dao.updateAtomicTransaction(vehicle);
        return true;
    }

}
