package com.ada_locate;

import com.ada_locate.controller.ClientController;
import com.ada_locate.model.Client;
import com.ada_locate.model.NaturalPerson;


public class App 
{
    public static void main( String[] args ){
        
        ClientController clientController = new ClientController();

        Client c1 = new Client(new NaturalPerson("548.890.740-82"), "Cleiton", "11111111", null);

        System.out.println(clientController.add(c1));

    }
}
