package com.ada_locate.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.boot.model.naming.IllegalIdentifierException;

import com.ada_locate.infra.RentDAO;
import com.ada_locate.infra.RentItensDAO;
import com.ada_locate.model.Client;
import com.ada_locate.model.Rent;
import com.ada_locate.model.RentItens;
import com.ada_locate.model.Vehicle;
import com.ada_locate.model.response.RentInfo;
import com.ada_locate.utils.LicencePlateUtils;



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

    public List<RentItens> getAllRentItensByRentId(Long idRent) {
        if(rentDAO.findByRentId(idRent) == null) throw new IllegalArgumentException("Id do aluguel não localizado");
        return rentItensDAO.findByRentId(idRent);
    }

    public Rent getRentById(Long idRent){
        if(idRent == null || rentDAO.findByRentId(idRent) == null) 
        throw new IllegalArgumentException("Id nulo ou inexistente");
        return rentDAO.findByRentId(idRent);
    }

    public Boolean addNewRentOrder(Rent rentRequest){

        if(clientService.getById(rentRequest.getClient().getId()) == null) 
        throw new IllegalArgumentException("Cliente não cadastrado");

        if(rentRequest.getDailyRental() <= 0)
        throw new IllegalArgumentException("Número de diárias é inválido");

        rentDAO.addAtomicTransaction(rentRequest);       

        return true;
    }

    public Boolean addRentItemToRentOrderByRentId(Long idRent, String plateLicence){
        if(idRent == null || rentDAO.findByRentId(idRent) == null) 
        throw new IllegalArgumentException("Id nulo ou inexistente");

        plateLicence = LicencePlateUtils.convertLicencePlateToId(plateLicence);

        Rent rent = rentDAO.findByRentId(idRent);
        Vehicle vehicle = vehicleService.getById(plateLicence);
        RentItens rentItem = new RentItens(vehicle, rent);
        
        if(rent == null || !vehicle.getIsActive()) return false;

        vehicleService.update(plateLicence);

        rentItensDAO.addAtomicTransaction(rentItem);

        return true;
    }

    public RentInfo checkout(Long idRent) {
        if (idRent == null || rentDAO.getById(idRent) == null) {
            throw new IllegalArgumentException("Id nulo ou inexistente");
        }
    
        Rent rent = rentDAO.getById(idRent);
    
        if (!rent.getIsOpen()) {
            throw new IllegalArgumentException("Ordem de Aluguel já foi fechada");
        }
    
        LocalDateTime checkOutComparator = LocalDateTime.now();
    
        long comparator = Duration.between(rent.getCheckIn(), checkOutComparator).toHours()/24 < rent.getDailyRental() ? 
                        (long) rent.getDailyRental()
                        : Duration.between(rent.getCheckIn(), checkOutComparator).toHours()/24;
    
        rent.setDailyRental((int) comparator);
        rent.setIsOpen(false);
        rent.setCheckOut(checkOutComparator);
    
        this.chanceActiveVehicleList(getAllRentItensByRentId(idRent));
        this.rentDAO.updateAtomicTransaction(rent);
    
        return new RentInfo(rent.getClient(), this.getAllRentItensByRentId(idRent), rent);
    }

    private void chanceActiveVehicleList(List<RentItens> rentItens){
        for (RentItens item : rentItens) {
            vehicleService.update(item.getVehicle().getIdentificator());
        }
    }

}
