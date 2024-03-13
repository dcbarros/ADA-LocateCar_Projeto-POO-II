package com.ada_locate.view.VeiculoView;

import com.ada_locate.model.Client;
import com.ada_locate.model.LegalPerson;
import com.ada_locate.model.NaturalPerson;
import com.ada_locate.model.Vehicle;
import com.ada_locate.utils.DocumentUtils;
import com.ada_locate.view.GeneralOptions.TypeOptions;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class VehicleOptions implements TypeOptions {

    public void options() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            this.title("VEÍCULO");
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
                        this.title("VEÍCULO");
                        this.add();
                        break;
                    case 2:
                        this.title("VEÍCULO");
                        this.findByid();
                        break;
                    case 3:
                        this.title("VEÍCULO");
                        this.readListVehicle();
                        break;

                    case 4:
                        this.title("VEÍCULO");
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

    public Vehicle add() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Informe o modelo do veículo: \n");
            String model = sc.nextLine();

            System.out.println("Informe a placa do veículo: \n");
            String identificator = sc.nextLine();

            System.out.println("Informe o tipo do veículo: \n");
            String type = sc.nextLine();


            return null;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Dados inválidos!");
        }
    }

    public void findByid() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe a placa do veículo: \n");
            Vehicle finded = null;

            System.out.println("Dados do Veículo:\n" +
                    "Modelo: " + "\n" +
                    "Placa: " + "\n" +
                    "Tipo: " + "."
            );
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Dados inválidos");
        }
    }

    public void readListVehicle(List<Vehicle> lista) {
        for (Vehicle element : lista) {
            System.out.println("Modelo: " + "\n" +
                    "Placa: " + element.getIdentificator());
        }
    }
}
