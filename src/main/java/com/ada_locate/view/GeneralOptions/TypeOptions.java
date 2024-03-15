package com.ada_locate.view.GeneralOptions;

public abstract class TypeOptions {


    public void title(String typeObject) {
        System.out.println("|| " + typeObject +" || =======\n");
    }

    public void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

