package com.ada_locate.controller;

import java.util.List;

import com.ada_locate.model.Client;
import com.ada_locate.service.ClientService;

public class ClientController {
    
    ClientService clientService;

    public ClientController() {
        this.clientService = new ClientService();
    }

    public Boolean add(Client request){
        return this.clientService.add(request);
    }

    public List<Client> getAll(int limit, int offset){
        return this.clientService.getAll(limit, offset);
    }

    public Client getClientByDocument(String id){
        return this.clientService.getById(id);
    }

    public Boolean updateClient(String id, String cep, String complement){
        return this.clientService.update(id, cep, complement);
    }
    
}
