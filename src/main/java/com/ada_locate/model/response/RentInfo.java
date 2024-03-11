package com.ada_locate.model.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ada_locate.model.Client;
import com.ada_locate.model.LegalPerson;
import com.ada_locate.model.NaturalPerson;
import com.ada_locate.model.Rent;
import com.ada_locate.model.RentItens;
import com.ada_locate.model.enums.VehicleType;
import com.ada_locate.utils.DocumentUtils;

public class RentInfo {

    private Client client;
    private List<RentItens> itens;
    private List<BigDecimal> values;
    private Rent rent;
    
    private BigDecimal discount;

    public RentInfo(Client client, List<RentItens> itens, Rent rent) {
        this.rent = rent;
        this.client = client;
        this.itens = itens;
        setValues(itens, rent.getDailyRental());
        setDiscount(rent.getDailyRental());
    }

    private void setValues(List<RentItens> itens, Integer dailyRental) {
        List<BigDecimal> prices = new ArrayList<>();
        for (RentItens item : itens) {
            BigDecimal price = item.getVehicle().getType().equals(VehicleType.PEQUENO) ? new BigDecimal(100.00) 
                            : item.getVehicle().getType().equals(VehicleType.MEDIO) ? new BigDecimal(150.00)
                            : new BigDecimal(200.00);
            price = price.multiply(new BigDecimal(dailyRental));
            prices.add(price);
        }
        this.values = prices;
    }
    
    private void setDiscount(Integer dailyRental) {
           
        if (DocumentUtils.documentType(client.getId()) == "cpf" && dailyRental >= 5) {
            this.discount = new BigDecimal(0.05);
        } else if (DocumentUtils.documentType(client.getId()) == "cnpj" && dailyRental >= 3) {
            this.discount = new BigDecimal(0.10);
        } else {
            this.discount = BigDecimal.ZERO;
        }
    }

    public BigDecimal getDiscount() {
        return discount;
    }
    
    public Client getClient() {
        return client;
    }
    
    public List<RentItens> getItens() {
        return itens;
    }
    
    public List<BigDecimal> getValues() {
        return values;
    }

    public Rent getRent() {
        return rent;
    }
    
}
