package com.ada_locate.view.RentView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RentOptions extends RentMain{


    public void options() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            this.title();
            System.out.println(
                    "1 - Criar ordem de aluguel\n" +
                            "2 - Adicionar itens a  uma ordem\n" +
                            "3 - Listar ordens abertas" +
                            "4 - Buscar ordem\n" +
                            "5 - Fazer checkout" +
                            "0 - Retornar ao menu anterior");
            try {
                option = sc.nextInt();

                switch (option) {
                    case 0:
                        break;
                    case 1:
                        this.title();
                        break;
                    case 2:
                        this.title();
                        break;
                    case 3:
                        this.title();
                        break;

                    case 4:
                        this.title();
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
}


