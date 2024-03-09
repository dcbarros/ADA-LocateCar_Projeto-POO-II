package com.ada_locate;

import com.ada_locate.infra.DAO;
import com.ada_locate.model.Client;
import com.ada_locate.model.NaturalPerson;
import com.ada_locate.model.Rent;
import com.ada_locate.model.RentItens;
import com.ada_locate.model.Vehicle;
import com.ada_locate.model.enums.VehicleType;

public class App 
{
    public static void main( String[] args ){
        // Vehicle v1 = new Vehicle("ABC-5555", VehicleType.PEQUENO);
        // Vehicle v2 = new Vehicle("ABD-5555", VehicleType.MEDIO);
        // Client c1 = new Client(new NaturalPerson("867.884.200-84"), "Jaiminho", null, null);
        // Rent rent = new Rent(c1, 2);
        // RentItens r1 = new RentItens(v1,rent);
        // RentItens r2 = new RentItens(v2,rent);

        DAO<Vehicle> dao = new DAO<>();
        // dao.startTransaction()
        //     .addTransaction(v1)
        //     .addTransaction(v2)
        //     .addTransaction(c1)
        //     .addTransaction(rent)
        //     .addTransaction(r1)
        //     .addTransaction(r2)
        //     .commitTransaction();
        System.out.println(dao.getById("ABC5555").getType());

    }
}
