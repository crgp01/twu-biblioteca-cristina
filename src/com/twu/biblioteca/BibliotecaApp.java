package com.twu.biblioteca;

/**
 * Created by crivera on 15/9/16.
 */
public class BibliotecaApp {

    public static void welcomeMessage(){
        System.out.println(Message.WELCOME);
    }

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.welcomeMessage();
        bibliotecaApp.initMenu();

    }

    public void initMenu() {
        Menu menu = new Menu();
        menu.init();
    }
}
