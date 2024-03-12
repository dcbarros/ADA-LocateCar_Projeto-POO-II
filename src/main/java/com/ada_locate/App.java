package com.ada_locate;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
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
import com.ada_locate.model.response.RentInfo;
import com.ada_locate.service.ClientService;
import com.ada_locate.service.RentService;
import com.ada_locate.service.VehicleService;


public class App 
{
    public static void main( String[] args ){
        
        RentService t1 = new RentService();
        VehicleService t2 = new VehicleService();
        ClientService t3 = new ClientService();

        // Client clientNP = new Client(new NaturalPerson("333.796.720-50"), "Cleiton", "5555555", null);
        // Client clientLP = new Client(new LegalPerson("47.186.704/0001-64"), "Organizações Tabajara", "5555555", null);

        // t3.add(clientNP);
        // t3.add(clientLP);

        // Vehicle v1 = new Vehicle("MDM-2084",VehicleType.PEQUENO);
        // Vehicle v2 = new Vehicle("NEV-3451",VehicleType.MEDIO);
        // Vehicle v3 = new Vehicle("MUO-2775",VehicleType.SUV);

        // t2.add(v1);
        // t2.add(v2);
        // t2.add(v3);

        // Client c1 = t3.getById("33379672050");
        // Rent rent = new Rent(c1, 4);
        // t1.addNewRentOrder(rent);

        // t1.getAllRentOrdersActive();
        // t1.addRentItemToRentOrderByRentId(1L, "MUO2775");
        //t1.addRentItemToRentOrderByRentId(2L, "MDM-2084");

        // for (RentItens T : t1.getAllRentItensByRentId(2L)) {
        //     System.out.print(T.getRent().getClient().getName());
        //     System.out.print(" " + T.getRent().getClient().getId());
        //     System.out.println(" " + T.getVehicle().getIdentificator() + "\n");
        // }
        
        // RentInfo nf = t1.checkout(3L);

        // System.out.printf("""
        // Nome do Cliente: %s
        // Total de Carros Alugados: %d
        // Pegou as: %d/%d/%d %d:%d
        // Entregou as: %d/%d/%d %d:%d
        // Itens:
        // """,
        // nf.getClient().getName(),
        // nf.getItens().size(),
        // nf.getRent().getCheckIn().getDayOfMonth(),
        // nf.getRent().getCheckIn().getMonthValue(),
        // nf.getRent().getCheckIn().getYear(),
        // nf.getRent().getCheckIn().getHour(),
        // nf.getRent().getCheckIn().getMinute(),
        // nf.getRent().getCheckOut().getDayOfMonth(),
        // nf.getRent().getCheckOut().getMonthValue(),
        // nf.getRent().getCheckOut().getYear(),
        // nf.getRent().getCheckOut().getHour(),
        // nf.getRent().getCheckOut().getMinute()
        // );

        // BigDecimal total = BigDecimal.ZERO;
        // for (int i = 0; i < nf.getItens().size(); i++) {
        //     total = total.add(nf.getValues().get(i));
        //     System.out.printf("""
        //     %d - Veículo: X, Placa: %s\t\tR$ %.2f;
        //     """,
        //     (i+1),
        //     nf.getItens().get(i).getVehicle().getIdentificator(),
        //     nf.getValues().get(i)
        //     );
        // }
        
        // System.out.printf("""
        // -------------------------------------------------------------
        // Total:\tR$ %.2f
        // Desconto: (%.2f %%)
        // Total com desconto:\tR$ %.2f
        // """,
        // total,
        // nf.getDiscount().multiply(new BigDecimal(100)),
        // total.multiply(BigDecimal.ONE.subtract(nf.getDiscount())));

    }

}
