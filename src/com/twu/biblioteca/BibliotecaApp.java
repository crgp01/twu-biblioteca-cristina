package com.twu.biblioteca;

/**
 * Created by crivera on 15/9/16.
 */
public class BibliotecaApp {

    public static String welcomeMessage(){
        return (Message.WELCOME);
    }

    public void printWelcomeMessage(){
        System.out.println(welcomeMessage());
    }

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage();
        bibliotecaApp.initMenu();

    }

    public void initMenu() {
        Menu menu = new Menu();
        menu.init();
    }


}
