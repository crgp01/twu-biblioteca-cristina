package com.twu.biblioteca;

import sun.tools.jconsole.Messages;
import java.util.Scanner;

import java.util.ArrayList;

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

    public Menu() {
        _biblioteca.addBooks();
    }

    public String menuOptions(int option) {
        String message = "";

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
                message += "\n\n"+Message.MENU_RETURN;
                break;
            case 3:
                message += Message.QUIT;
                message += "\n\n"+Message.MENU_RETURN;
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
                    //Runtime.getRuntime().exec("cls");
                    printMenu();
                }
                else {
                    System.out.flush();
                    //Runtime.getRuntime().exec("cls");
                    System.out.println(menuOptions(option));
                }
            }catch (Exception e){
                System.out.println(e);
                //System.out.println(Message.INVALID_OPTION);
                init();
            }

        }
    }
}
