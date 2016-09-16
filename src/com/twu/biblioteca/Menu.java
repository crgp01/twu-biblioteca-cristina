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



    public String menuOptions(int option) {
        String message = "";
        String libraryNUmber ="";

        switch (option) {

            case 1:

                ArrayList<String> listBookdetails = _biblioteca.getListBookDetails();
                for(String detail:listBookdetails)
                {
                    message += detail+"\n";
                }
                message += "\n\n"+Message.MENU_RETURN;
                break;

            case 2:

                System.out.print("Title :\n ");
                String bookTitle = scanner.nextLine();
                _biblioteca.checkoutBook(bookTitle);

                break;




            case 3:

                System.out.print("Title :\n ");
                bookTitle = scanner.nextLine();
                /*System.out.print("Library Number : ");
                libraryNUmber = scanner.nextLine();*/
                _biblioteca.returnBook(bookTitle,"1");


                message += "\n\n"+Message.MENU_RETURN;
                break;


            case 0:

                message += "\n\n"+Message.QUIT;
                System.exit(1);
                break;

            default:
              message = Message.INVALID_OPTION;
                message += "\n\n"+Message.MENU_RETURN;
                break;
        }

        return message;
    }

    public void printMenu(){
        System.out.println(MenuOptions);
    }

    public void init(){
        Scanner in = new Scanner(System.in);
        int option = 0;
        printMenu();

        while (true){
            try {
                option = in.nextInt();
                if(option == 9)
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
