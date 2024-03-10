package com.ada_locate.service;

import java.util.List;

import com.ada_locate.infra.RentDAO;
import com.ada_locate.infra.RentItensDAO;
import com.ada_locate.model.Rent;
import com.ada_locate.model.RentItens;


public class RentService {
    
    private RentItensDAO rentItensDAO;
    private RentDAO rentDAO;
    private VehicleService vehicleService;
    private ClientService clientService;

    public RentService(){
        this.rentItensDAO = new RentItensDAO();
        this.rentDAO = new RentDAO();
        this.vehicleService = new VehicleService();
        this.clientService = new ClientService();
    }

    public List<RentItens> getAllRentItensByRentId(Long rentId) {
        if(rentDAO.findByRentId(rentId) == null) throw new IllegalArgumentException("Id do aluguel não localizado");
        return rentItensDAO.findByRentId(rentId);
    }

    public Boolean addNewRentOrder(List<RentItens> rentItensRequest, Rent rentRequest){
        if((rentItensRequest == null || rentItensRequest.isEmpty()) 
        && rentRequest == null) throw new IllegalArgumentException("Argumentos de itens de aluguel e aluguel devem ser não nulos");

        rentDAO.addAtomicTransaction(rentRequest);
        rentItensDAO.startTransaction();
        for (RentItens rentItens : rentItensRequest) {
            vehicleService.update(rentItens.getVehicle().getIdentificator());
            rentItensDAO.addTransaction(rentItens);
        }
        rentItensDAO.commitTransaction();
        return true;
    }
}
