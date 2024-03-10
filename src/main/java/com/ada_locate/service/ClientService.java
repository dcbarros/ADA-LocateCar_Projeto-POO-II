package com.ada_locate.service;

import com.ada_locate.infra.DAO;
import com.ada_locate.model.Client;

public class ClientService {
    private DAO<Client> dao;

    public ClientService(){
        this.dao = new DAO<>(Client.class);
    }
    
    public Boolean add(Client request){
        if(dao.getById(request.getId()) == null
        && request.getName() != null && !request.getName().isBlank()
        && request.getCep() != null && !request.getCep().isBlank()){
            dao.addAtomicTransaction(request);
            return true;
        }
        return false;
    }

}
