package com.twu.biblioteca;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    Biblioteca biblioteca = new Biblioteca();


    public String MenuOptions = "Choose an option:\n" +
            "1 - Books List\n" +
            "2 - Checkout Book\n" +
            "3 - Return Book\n" +
            "0 - Quit\n" +
            "";
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        biblioteca.Biblioteca();
    }

    public String menuOptions(String option) {
        String message = "";

        switch (option) {

            case "1":

                ArrayList<String> listBookdetails = biblioteca.getListBookDetails();
                for(String detail:listBookdetails)
                {
                    message += detail+"\n";
                }
                message += "\n\n"+Message.MENU_RETURN;
                break;

            case "2":

                String bookTitle = scanner.nextLine();

                if ( biblioteca.checkoutBook(bookTitle))
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

                bookTitle = scanner.nextLine();
                if(biblioteca.returnBook(bookTitle,"1"))
                {
                    message = Message.SUCCESSFUL_RETURN;
                }
                else{message = Message.UNSUCCESSFUL_RETURN;}

                message += "\n\n"+Message.MENU_RETURN;
                break;


            case "0":

                message += "\n\n"+Message.QUIT;
                break;

            case "9":

                printMenu();
                break;

            default:
              message = Message.INVALID_OPTION;

                break;
        }

        return message;
    }

    private void printMenu(){
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
                    System.out.println(menuOptions(option));
                    if(option.equals("0"))
                    {
                        System.exit(1);
                    }
                }
            }catch (Exception e){
                System.out.println(e);
                init();
            }

        }
    }
}
