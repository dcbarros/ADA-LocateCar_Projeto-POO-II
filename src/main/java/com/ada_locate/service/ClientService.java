package com.ada_locate.service;

import com.ada_locate.infra.DAO;
import com.ada_locate.model.Client;
import com.ada_locate.model.Vehicle;

import java.util.List;

public class ClientService {
    private DAO<Client> dao;

    public ClientService() {
        this.dao = new DAO<>(Client.class);
    }

    public Boolean add(Client request) {
        if (dao.getById(request.getId()) == null
                && request.getName() != null && !request.getName().isBlank()
                && request.getCep() != null && !request.getCep().isBlank()) {
            dao.addAtomicTransaction(request);
            return true;
        }
        return false;
    }

    public List<Client> getAll(int limit, int offset) {return dao.getAll(limit, offset);}

    public Client getById(String id){
        if(dao.getById(id) == null){
            throw new IllegalArgumentException("Identificador não localizado no sistema.");
        }
        return dao.getById(id);
    }

    public Boolean update(String id, String cep, String complement){
        if(dao.getById(id) == null){
            throw new IllegalArgumentException("Identificador não localizado no sistema.");
        }
        Client client = dao.getById(id);
        client.setCep(cep);
        client.setComplement(complement);
        dao.updateAtomicTransaction(client);
        return true;
    }





}
