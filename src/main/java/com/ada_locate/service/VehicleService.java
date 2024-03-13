package com.ada_locate.service;

import com.ada_locate.infra.DAO;
import com.ada_locate.infra.VehicleDAO;
import com.ada_locate.model.Client;
import com.ada_locate.model.Vehicle;
import com.ada_locate.utils.LicencePlateUtils;

import java.util.List;

public class VehicleService {

    private VehicleDAO dao; 

    public VehicleService(){this.dao = new VehicleDAO();}

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
        id = LicencePlateUtils.convertLicencePlateToId(id);
        if(dao.getById(id) == null){
            throw new IllegalArgumentException("Placa não localizada no sistema.");
        }
        return dao.getById(id);
    }

    public List<Vehicle> getVehiclesByModel(String request){
        if(request == null || request.isEmpty()){throw new IllegalArgumentException("Busca sem argumentos");}
        List<Vehicle> vehicles = dao.seachByNameSubstring(request);
        if(vehicles == null || vehicles.isEmpty()){throw new IllegalArgumentException("Não o modelo não existe no banco de dados.");}
        return vehicles;
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
