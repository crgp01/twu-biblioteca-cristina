package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    private static Biblioteca biblioteca;
    private PrintStream printStream;

   

    public void run() {
        printStream.println(Message.WELCOME);
    }

    public static String welcomeMessage(){
        return (Message.WELCOME);
    }

    public void printWelcomeMessage(){
        PrintStream out = System.out;
        out.println(welcomeMessage());
    }

    public static void main(String[] args) {
        
        BibliotecaApp bibliotecaApp = new BibliotecaApp(System.out,biblioteca);
        bibliotecaApp.printWelcomeMessage();
        bibliotecaApp.initMenu();

    }
    public BibliotecaApp(PrintStream printStream, Biblioteca biblioteca) {
        this.printStream = printStream;
    }


    public void initMenu() {
        Menu menu = new Menu();
        menu.init();
    }

}
