package com.ada_locate.view;

import com.ada_locate.controller.ClientController;
import com.ada_locate.model.Client;
import com.ada_locate.model.LegalPerson;
import com.ada_locate.model.NaturalPerson;
import com.ada_locate.utils.DocumentUtils;
import com.ada_locate.view.GeneralOptions.TypeOptions;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientOptions extends TypeOptions {

    ClientController controller = new ClientController();

    public void options() {
        this.limparTela();
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            title("CLIENTE");
            System.out.println(
                    "1 - Cadastrar Cliente\n" +
                            "2 - Buscar Cliente\n" +
                            "3 - Alterar dados do Cliente\n" +
                            "4 - Listar Clientes\n" +
                            "0 - Retornar ao menu anterior\nQual opção você deseja? ");
            try {
                option = sc.nextInt();

                switch (option) {
                    case 0:
                        break;
                    case 1:
                        title("CLIENTE");
                        add();
                        break;
                    case 2:
                        title("CLIENTE");
                        findById();
                        break;
                    case 3:
                        title("CLIENTE");
                        update();
                        break;

                    case 4:
                        title("CLIENTE");
                        readListClient(); //lista de Clientes

                        break;
                    default:
                        System.out.println("Opção inválida. Escolha uma das opções do menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Digite um numero inteiro, conforme" +
                        " as opções do Menu.");
                sc.nextLine();
            }
        }
    }

    public void add() {
        try {
            this.limparTela();
            Scanner sc = new Scanner(System.in);


            System.out.println("Informe o nome do cliente: ");
            String name = sc.nextLine();
            
            System.out.println("Informe o CPF ou CNPJ do cliente: ");
            String identificator = sc.nextLine();

            System.out.println("Informe o Cep do cliente: ");
            String cep = sc.nextLine();


            System.out.println("Informe o Complemento do cep: ");
            String complement = sc.nextLine();
            
            Client newClient = new Client();
            if (DocumentUtils.documentType(identificator) == "cpf") {
                newClient = new Client(new NaturalPerson(identificator), name,cep,complement);
            } else if (DocumentUtils.documentType(identificator) == "cnpj") {
                newClient = new Client(new LegalPerson(identificator), name,cep,complement);
            }

            controller.add(newClient);

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Dados inválidos!");
        }
    }

    public void findById() {
        try {
            this.limparTela();
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o CPF/CNPJ do cliente: \n");
            String document = sc.nextLine();
            Client finded = controller.getClientByDocument(document);

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
            this.limparTela();
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o CPF/CNPJ do cliente: \n");
            String identificator = sc.nextLine();

            System.out.println("Informe o novo cep do cliente: \n");
            String cep = sc.nextLine();

            System.out.println("Informe o complemento: \n");
            String complement = sc.nextLine();

            controller.updateClient(identificator, cep, complement);

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Dados inválidos");
        }

    }

    public void readListClient() {
        this.limparTela();
        List<Client> lista = controller.getAll(100, 0);
        for (Client element : lista) {
            System.out.println("Nome: " + element.getName() + "\n" +
                    DocumentUtils.documentType(element.getId()).toUpperCase() + ": " + element.getId());
        }
    }
}




