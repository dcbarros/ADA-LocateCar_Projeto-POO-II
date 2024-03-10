package com.ada_locate;

import java.util.List;

import com.ada_locate.controller.ClientController;
import com.ada_locate.infra.DAO;
import com.ada_locate.model.Client;
import com.ada_locate.model.LegalPerson;
import com.ada_locate.model.NaturalPerson;
import com.ada_locate.model.Rent;
import com.ada_locate.model.RentItens;
import com.ada_locate.model.Vehicle;
import com.ada_locate.model.enums.VehicleType;
import com.ada_locate.service.ClientService;
import com.ada_locate.service.RentService;
import com.ada_locate.service.VehicleService;


public class App 
{
    public static void main( String[] args ){
        
        // DAO<Object> dao = new DAO<>();

        // Client c1 = new Client(new LegalPerson("76.533.760/0001-26"),
        //                          "Jaiminho e CIA", null, null);
        // Vehicle v1 = new Vehicle("ABC5B21", VehicleType.PEQUENO);
        // Rent rent = new Rent(c1, 2);
        // RentItens rentItens = new RentItens(v1, rent);

        // dao.startTransaction()
        //     .addTransaction(c1)
        //     .addTransaction(v1)
        //     .addTransaction(rent)
        //     .addTransaction(rentItens)
        //     .commitTransaction();

        RentService t1 = new RentService();
        VehicleService t2 = new VehicleService();
        ClientService t3 = new ClientService();

        Client c1 = new Client(new NaturalPerson("713.273.260-94"),
                                  "Carmen", null, null);
        t3.add(c1);
        // Vehicle v1 = t2.getById("ABC5B21");
        // Rent rent = new Rent(c1, 5);
        // List<RentItens> rentItem = List.of(new RentItens(v1, rent));

        // t1.addNewRentOrder(rentItem, rent);

    }
}
