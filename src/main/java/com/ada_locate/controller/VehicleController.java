package com.ada_locate.controller;

import java.util.List;

import com.ada_locate.model.Vehicle;
import com.ada_locate.service.VehicleService;

public class VehicleController {
    
    private VehicleService vehicleService;

    public VehicleController() {
        this.vehicleService = new VehicleService();
    }

    public Boolean addVehicle(Vehicle vehicle){
        return this.vehicleService.add(vehicle);
    }

    public Vehicle getVehicleByLicencePlate(String licencePlate){
        return this.vehicleService.getById(licencePlate);
    }

    public List<Vehicle> getAll(int limit, int offset){
        return this.vehicleService.getAll(limit, offset);
    }
 
}
