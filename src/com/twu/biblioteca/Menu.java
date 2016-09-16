package com.twu.biblioteca;

import sun.tools.jconsole.Messages;

/**
 * Created by crivera on 14/9/16.
 */
public class Menu {

    Book _book = new Book();

    public static String MenuOptions = "Choose an option:\n" +
            "1 - Books List\n" +
            "2 - Checkout Book\n" +
            "3 - Return Book\n" +
            "4 - Movies List\n" +
            "5 - Login\n" +
            "0 - Quit\n" +
            "";

    public Menu() {

    }

    public String menuOptions(int option) {
        String message = "";

        switch (option) {

            case 1:
                message += Message.QUIT;

                _book.getBookDetails();
                break;
          
            case 2:
                message += Message.QUIT;
                break;
            case 3:
                message += Message.QUIT;
                break;
            case 4:
                message += Message.QUIT;
                break;
            case 5:
                message += Message.QUIT;
                break;

            default:
              message = Message.INVALID_OPTION;
                break;
        }

        return message;
    }
}
