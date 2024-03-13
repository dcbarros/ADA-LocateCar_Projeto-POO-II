package com.ada_locate.view.RentView;

import com.ada_locate.model.Client;
import com.ada_locate.model.Rent;
import com.ada_locate.model.RentItens;
import com.ada_locate.utils.DocumentUtils;
import com.ada_locate.view.GeneralOptions.TypeOptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RentOptions implements TypeOptions {


    public void options() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            this.title("ALUGUEL DE CARROS");
            System.out.println(
                    "1 - Criar ordem de aluguel\n" +
                            "2 - Adicionar itens a  uma ordem\n" +
                            "3 - Listar ordens abertas" +
                            "4 - Buscar ordem\n" +
                            "5 - Fazer checkout" +
                            "0 - Retornar ao menu anterior ");
            try {
                option = sc.nextInt();

                switch (option) {
                    case 0:
                        break;
                    case 1:
                        this.title("ALUGUEL DE CARROS");
                        break;
                    case 2:
                        this.title("ALUGUEL DE CARROS");
                        break;
                    case 3:
                        this.title("ALUGUEL DE CARROS");
                        break;

                    case 4:
                        this.title("ALUGUEL DE CARROS");
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

    public Rent add(Rent newOrder){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o CPF/CNPJ do cliente: \n");
            String identificator = sc.nextLine();

            System.out.println("Informe a placa do veículo: \n");
            String placa = sc.nextLine();

            return null;
            // to do controller
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Dados inválidos");
        }
    }

    public void findByid() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o id da ordem: \n");
            Rent finded = null;

            System.out.println("Id ordem: " + finded.getId() +
                    "Checkin: " + finded.getCheckIn() + "\n" +
                    "Checkout: " + finded.getCheckOut() + "\n"
            );
            for(RentItens itens : finded.getRentItens()){
                System.out.println("Veículos Locados: \n" +
                        itens.getVehicle().getModel() + "\n" +
                        "Placa: " + itens.getVehicle().getIdentificator());
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Dados inválidos");
        }
    }
}


