package com.ada_locate.controller;

import java.util.List;

import com.ada_locate.model.Client;
import com.ada_locate.model.Rent;
import com.ada_locate.model.response.RentInfo;
import com.ada_locate.service.RentService;

public class RentController {

    private RentService rentService;

    public RentController() {
        this.rentService = new RentService();
    }

    public Boolean addNewOrder(Rent request){
        return this.rentService.addNewRentOrder(request);
    }

    public Boolean addRentItemInOrderByRentId(Long idRent, String plateLicence){
        return this.rentService.addRentItemToRentOrderByRentId(idRent, plateLicence);
    }

    public List<Rent> getReportOrder(int limit){
        return this.rentService.getAllRentOrdersActive(limit);
    }

    public RentInfo getRentOrderByRentId(Long idRent){
        Rent rent = this.rentService.getRentById(idRent);
        return new RentInfo(rent.getClient(), this.rentService.getAllRentItensByRentId(idRent), rent);
    }
    
    public RentInfo checkout(Long idRent){
        return this.rentService.checkout(idRent);
    }
}
