package com.ada_locate.view;

import com.ada_locate.controller.ClientController;
import com.ada_locate.controller.RentController;
import com.ada_locate.model.Rent;
import com.ada_locate.model.RentItens;
import com.ada_locate.model.response.RentInfo;
import com.ada_locate.view.GeneralOptions.TypeOptions;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.Long.valueOf;

public class RentOptions extends TypeOptions {

    RentController rentController = new RentController();
    ClientController clientController = new ClientController();

    public void options() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        this.limparTela();
        while (option != 0) {
            title("ALUGUEL DE CARROS");
            System.out.println(
                    "1 - Criar ordem de aluguel\n" +
                            "2 - Adicionar itens a uma ordem\n" +
                            "3 - Listar ordens abertas\n" +
                            "4 - Buscar ordem\n" +
                            "5 - Fazer checkout" +
                            "0 - Retornar ao menu anterior\nQual opção deseja? ");
            try {
                option = sc.nextInt();

                switch (option) {
                    case 0:
                        break;
                    case 1:
                        title("ALUGUEL DE CARROS");
                        add();
                        break;
                    case 2:
                        title("ALUGUEL DE CARROS");
                        addItens();
                        break;
                    case 3:
                        title("ALUGUEL DE CARROS");
                        readListOrders();
                        break;

                    case 4:
                        title("ALUGUEL DE CARROS");
                        findByid();
                        break;
                    case 5:
                        title("ALUGUEL DE CARROS");
                        checkoutOrder();
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
            System.out.println("Informe o CPF/CNPJ do cliente: ");
            String identificator = sc.nextLine();

            System.out.println("Informe o numero de diarias: ");
            int dailyRental = sc.nextInt();
            Rent newOrder = new Rent(clientController.getClientByDocument(identificator), dailyRental);

            rentController.addNewOrder(newOrder);

        } catch (InputMismatchException e) {
            System.out.println("Dados inválidos");
            return;
        }
    }

    public void addItens() {
        try {
            this.limparTela();
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o id da ordem: ");
            Long id = sc.nextLong();
            sc.nextLine();
            System.out.println("Informe a placa do veículo: ");
            String plate = sc.nextLine();

            rentController.addRentItemInOrderByRentId(id, plate);

        } catch (IllegalArgumentException e) {
            System.out.println("Dados inválidos");
            return;
        }
    }

    public void readListOrders() {
        //alterar limit posteriormente!
        this.limparTela();
        List<Rent> lista = rentController.getReportOrder(100);
        for (Rent element : lista) {
            System.out.println(
                "Id: " + element.getId() + "\n" +
                "Cliente: " + element.getClient().getName() + "\n" +
                "Diárias: " + element.getDailyRental() + "\n" +
                "Chekin: " + element.getCheckIn() + "\n" +
                "Checkout: " + element.getCheckOut() + "\n" +
                "Itens Locados: "
            );

            int cont = 1;
            for (RentItens iten : element.getRentItens()) {
                System.out.println(
                    cont + " - " +
                    "Carro: " + iten.getVehicle().getModel() + " " +
                    "Tipo: " + iten.getVehicle().getType()
                );
                cont++;
            }

        }
    }

    public void findByid() {
        try {
            this.limparTela();
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o id da ordem: \n");
            Long id = sc.nextLong();
            RentInfo info = rentController.getRentOrderByRentId(id);
            Rent rent = info.getRent();

            System.out.println("Id ordem: " + rent.getId() + "\n" +
                    "Checkin: " + rent.getCheckIn() + "\n" +
                    "Checkout: " + rent.getCheckOut() + "\n" +
                    "Veículos Locados:"
            );
            for (RentItens itens : rent.getRentItens()) {
                System.out.println(
                    "Modelo: " + itens.getVehicle().getModel() + "\t" +
                    "Placa: " + itens.getVehicle().getIdentificator());
            }
        } catch (InputMismatchException e) {
            System.out.println("Dados inválidos");
            return;
        }
    }

    public void checkoutOrder() {
        try {
            this.limparTela();
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o id da ordem cujo checkout será realizado: ");
            Long id = valueOf(sc.nextLine());
            System.out.println("Deseja realizar o checkout dessa ordem (s/n)?");
            String option = sc.nextLine();
            if (option.equalsIgnoreCase("s")) {
                rentController.checkout(id);
            }
        } catch (IllegalArgumentException e) {
            return;
        }

    }
}


