package com.ada_locate.view;

import com.ada_locate.controller.VehicleController;
import com.ada_locate.model.Vehicle;
import com.ada_locate.model.enums.VehicleType;
import com.ada_locate.view.GeneralOptions.TypeOptions;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class VehicleOptions extends TypeOptions {

    VehicleController controller;

    public void options() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            title("VEÍCULO");
            System.out.println(
                    "1 - Cadastrar veículo\n" +
                            "2 - Buscar veículos\n" +
                            "3 - Listar veículos\n" +
                            "0 - Retornar ao menu anterior");
            try {
                option = sc.nextInt();

                switch (option) {
                    case 0:
                        break;
                    case 1:
                        title("VEÍCULO");
                        add();
                        break;
                    case 2:
                        title("VEÍCULO");
                        findByid();
                        break;
                    case 3:
                        title("VEÍCULO");
                        readListVehicle();
                        break;

                    case 4:
                        title("VEÍCULO");
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
            Scanner sc = new Scanner(System.in);

            System.out.println("Informe o modelo do veículo: \n");
            String model = sc.nextLine();

            System.out.println("Informe a placa do veículo: \n");
            String identificator = sc.nextLine();

            System.out.println("Informe o tipo do veículo: \n");
            VehicleType type = VehicleType.valueOf(sc.nextLine().toUpperCase());


            Vehicle newVehicle = new Vehicle(identificator, type, model);
            controller.addVehicle(newVehicle);

        } catch (InputMismatchException e) {
            System.out.println("Dados inválidos");
            return;
        }
    }

    public void findByid() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe a placa do veículo: \n");
            String plate = sc.nextLine();
            Vehicle finded = controller.getVehicleByLicencePlate(plate);

            System.out.println("Dados do Veículo:\n" +
                    "Modelo: " + finded.getModel() + "\n" +
                    "Placa: " + finded.getIdentificator() + "\n" +
                    "Tipo: " + finded.getType() + "."
            );
        } catch (InputMismatchException e) {
            System.out.println("Dados inválidos");
            return;
        }
    }

    public void readListVehicle() {
        try {
            //alterar limit posteriormente!
            List<Vehicle> lista = controller.getAll(100, 0);
            for (Vehicle element : lista) {
                System.out.println("Modelo: " + "\n" +
                        "Placa: " + element.getIdentificator());
            }
        } catch (InputMismatchException e) {
            System.out.println("Dados inválidos");
            return;
        }
    }
}
