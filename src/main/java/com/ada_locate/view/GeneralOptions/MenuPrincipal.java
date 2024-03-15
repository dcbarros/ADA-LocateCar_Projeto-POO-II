package com.ada_locate.view.GeneralOptions;

import com.ada_locate.view.ClientOptions;
import com.ada_locate.view.RentOptions;
import com.ada_locate.view.VehicleOptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal extends TypeOptions{

    VehicleOptions vehicleMenu;
    RentOptions rentMenu;
    ClientOptions clientMenu;

    public void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void faixa() {
        System.out.println("==========================\n" +
                "   || ADA LOCATE CAR ||\n" +
                "==========================\n" +
                "Sua locadora de carros!");
    }

    public void inicial() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            faixa();
            System.out.println(
                    "1 - Veículo\n" +
                            "2 - Cliente\n" +
                            "3 - Aluguel;\n" +
                            "0 - Sair");
            try {
                option = sc.nextInt();

                switch (option) {
                    case 0:
                        break;
                    case 1:
                        vehicleMenu.options();
                        break;
                    case 2:
                        clientMenu.options();
                        break;
                    case 3:
                        rentMenu.options();
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
}
