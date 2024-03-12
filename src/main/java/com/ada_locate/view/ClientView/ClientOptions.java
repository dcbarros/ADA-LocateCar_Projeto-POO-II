package com.ada_locate.view.ClientView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientOptions extends ClientMain{

    public void options() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            this.title();
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

