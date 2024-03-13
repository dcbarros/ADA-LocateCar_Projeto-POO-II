package com.ada_locate.view.GeneralOptions;

public class MenuPrincipal {

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
        faixa();
        System.out.println(
                "1 - Veículo\n" +
                "2 - Cliente\n" +
                "3 - Aluguel;\n" +
                "0 - Sair");
    }
}
