package com.ada_locate.controller;

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

    
}
