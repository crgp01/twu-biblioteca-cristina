package com.twu.biblioteca;

import sun.tools.jconsole.Messages;
import java.util.Scanner;

import java.util.ArrayList;
import java.io.Console;

/**
 * Created by crivera on 14/9/16.
 */
public class Menu {

    Biblioteca _biblioteca = new Biblioteca();


    public static String MenuOptions = "Choose an option:\n" +
            "1 - Books List\n" +
            "2 - Checkout Book\n" +
            "3 - Return Book\n" +
            "0 - Quit\n" +
            "";
    Scanner scanner = new Scanner(System.in);
    String bookTitle = "";
    String libraryNumber = "";

    public Menu() {
        _biblioteca.addBooks();
    }

    public String readInputInformation(String message){
        Scanner text = new Scanner(System.in);
        System.out.println(message);
        String itemInformation = text.nextLine();
        return itemInformation;
    }



    public String menuOptions(String option) {
        String message = "";
        String libraryNUmber ="";

        switch (option) {

            case "1":

                ArrayList<String> listBookdetails = _biblioteca.getListBookDetails();
                for(String detail:listBookdetails)
                {
                    message += detail+"\n";
                }
                message += "\n\n"+Message.MENU_RETURN;
                break;

            case "2":

                //System.out.print("Title :\n ");
                String bookTitle = scanner.nextLine();
                _biblioteca.checkoutBook(bookTitle);

                if ( _biblioteca.checkoutBook(bookTitle))
                {
                    message = Message.CHECKOUT_BOOK;
                }
                else
                {
                    message = Message.UNSUCCESSFUL_BOOK_CHECKOUT;
                }


                message += "\n\n"+Message.MENU_RETURN;
                break;

            case "3":

               // System.out.print("Title :\n ");
                bookTitle = scanner.nextLine();
                _biblioteca.returnBook(bookTitle,"1");
                if(_biblioteca.returnBook(bookTitle,"1"))
                {
                    message = Message.SUCCESSFUL_RETURN;
                }
                else{message = Message.UNSUCCESSFUL_RETURN;}

                message += "\n\n"+Message.MENU_RETURN;
                break;


            case "0":

                message += "\n\n"+Message.QUIT;
                System.exit(1);
                break;

            case "9":

                System.out.flush();
                printMenu();

            default:
              message = Message.INVALID_OPTION;

                break;
        }

        return message;
    }

    public void printMenu(){
        System.out.println(MenuOptions);
    }

    public void init(){
        Scanner in = new Scanner(System.in);
        String option = "";
        printMenu();

        while (true){
            try {
                option = in.nextLine();
                if(option.equals("9"))
                {
                    System.out.flush();
                    printMenu();
                }
                else {
                    System.out.flush();
                    System.out.println(menuOptions(option));
                }
            }catch (Exception e){
                System.out.println(e);
                init();
            }

        }
    }
}
