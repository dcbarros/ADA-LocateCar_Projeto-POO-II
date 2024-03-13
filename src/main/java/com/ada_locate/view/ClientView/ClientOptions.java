package com.ada_locate.view.ClientView;

import com.ada_locate.controller.ClientController;
import com.ada_locate.model.Client;
import com.ada_locate.model.LegalPerson;
import com.ada_locate.model.NaturalPerson;
import com.ada_locate.model.interfaces.ClientIdentificator;
import com.ada_locate.service.ClientService;
import com.ada_locate.utils.DocumentUtils;
import com.ada_locate.view.GeneralOptions.TypeOptions;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientOptions implements TypeOptions {

    ClientController controller;

    public void options() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            this.title("CLIENTE");
            System.out.println(
                    "1 - Cadastrar Cliente\n" +
                            "2 - Buscar Cliente\n" +
                            "3 - Alterar dados do Cliente" +
                            "4 - Listar Clientes\n" +
                            "0 - Retornar ao menu anterior");
            try {
                option = sc.nextInt();

                switch (option) {
                    case 0:
                        break;
                    case 1:
                        this.title("CLIENTE");
                        this.add();
                        break;
                    case 2:
                        this.title("CLIENTE");
                        findByid();
                        break;
                    case 3:
                        this.title("CLIENTE");
                        this.update();
                        break;

                    case 4:
                        this.title("CLIENTE");
                        this.readListClient(); //lista de Clientes

                        break;
                    default:
                        System.out.println("Opção inválida. Escolha uma das opções do menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Digite um numero inteiro, conforme" +
                        " as opções do MenuController.");
                sc.nextLine();
            }
        }
    }

    public Client add() {
        try {
            Scanner sc = new Scanner(System.in);
            Client newClient = new Client();

            System.out.println("Informe o nome do cliente: \n");
            String name = sc.nextLine();
            newClient.setName(name);

            System.out.println("Informe o CPF ou CNPJ do cliente: \n");
            String identificator = sc.nextLine();
            if (DocumentUtils.documentType(identificator) == "cpf") {
                newClient.setIdentificator(new NaturalPerson(identificator));
            } else if (DocumentUtils.documentType(identificator) == "cnpj") {
                newClient.setIdentificator(new LegalPerson(identificator));
            }

            System.out.println("Informe o Cep do cliente: \n");
            String cep = sc.nextLine();
            newClient.setCep(cep);

            System.out.println("Informe o Complemento do cep: \n");
            String complement = sc.nextLine();
            newClient.setComplement(complement);

            return newClient;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Dados inválidos!");
        }
    }

    public void findByid() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o CPF/CNPJ do cliente: \n");
            Client finded = null;

            System.out.println("Dados do Cliente:\n" +
                    "Nome: " + finded.getName() + "\n" +
                    DocumentUtils.documentType(finded.getId()).toUpperCase() + ": " +
                    finded.getId() + "\n" +
                    "Endereço: " + finded.getCep() + ", " + finded.getComplement() + "."
            );
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Dados inválidos");
        }
    }

    public void update() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o CPF/CNPJ do cliente: \n");
            String identificator = sc.nextLine();

            System.out.println("Informe o novo cep do cliente: \n");
            String cep = sc.nextLine();

            System.out.println("Informe o complemento: \n");
            String complement = sc.nextLine();
            // to do controller
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Dados inválidos");
        }

    }

    public void readListClient(List<Client> lista) {
        for (Client element : lista) {
            System.out.println("Nome: " + element.getName() + "\n" +
                    DocumentUtils.documentType(element.getId()).toUpperCase() + ": " + element.getIdentificator());
        }
    }
}




