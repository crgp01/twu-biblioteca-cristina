package com.twu.biblioteca;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by crivera on 13/9/16.
 */
public class BibliotecaTest {

    public Biblioteca biblioteca = new Biblioteca();
    public BibliotecaApp bibliotecaApp = new BibliotecaApp();

    @Test
    public void printWelcomeMessage() {

        String welcomeMessage = bibliotecaApp.welcomeMessage();
        assertEquals(Message.WELCOME, welcomeMessage);
    }

    @Test
    public void booklistTest() {

        ArrayList<Book> bookList = biblioteca.getListBook(false);

        assertEquals(biblioteca.getListBook(false),bookList);
    }

@Test

public void bookDetailsTest() {

    Book book = new Book("It",1987,"Stephen King",false,"1");

    String bookDetails = book.getBookDetails();

    String whitespaceTitle = String.format("%-20s", "It");
    String whitespaceAuthor = String.format("%-20s", "Stephen King");

    String expected = String.format("%s | %s | %s\n",whitespaceTitle, whitespaceAuthor, 1987);

    assertEquals(expected, bookDetails);
}

    @Test
    public void returnMenuOptions() {

        Menu menu = new Menu();

        String menuOptions = menu.MenuOptions;

        assertTrue(menuOptions,true);
    }

    @Test
    public void wrongMessageMenuOptions() {

        Menu menu = new Menu();

        String wrongMessage = menu.menuOptions("33");

        assertEquals(Message.INVALID_OPTION,wrongMessage);
    }

    @Ignore
    public void exitMessageMenuOptions() {

        Menu menu = new Menu();

        String quitMessage = menu.menuOptions("0");
        System.out.println(quitMessage);

        assertEquals(Message.QUIT,quitMessage);
    }

    @Test

    public void booksAvailableCheckout() {

        biblioteca.addBooks();

        ArrayList<Book> bookList = biblioteca.getListBook(false);

        assertEquals(biblioteca.getListBook(false),bookList);
    }

    @Test

    public void booksCheckedOut() {

        biblioteca.addBooks();

        ArrayList<Book> bookList = biblioteca.getListBook(true);

        assertEquals(biblioteca.getListBook(true),bookList);
    }

    @Test
    public void printSuccessMessage() {

        assertEquals("Thank you! Enjoy the book",Message.CHECKOUT_BOOK);
    }
    @Test
    public void findAvailableBook() {
        biblioteca.addBooks();
        int position = 0;
        String bookTitle = "It";
        ArrayList<Book> bookList = biblioteca.getListBook(false);
        position = biblioteca.findBooksByTitle(bookTitle,bookList);

        assertEquals(1,position);


    }

    @Test
    public void checkOutBook() {

        String bookTitle = "It";
        biblioteca.addBooks();

        boolean isCheckOut = biblioteca.checkoutBook(bookTitle);

        assertEquals(true, isCheckOut);
    }

    @Test
    public void notCheckOutBook() {

        String bookTitle = "hgh";
        biblioteca.addBooks();

        boolean isNotCheckOut = biblioteca.checkoutBook(bookTitle);

        assertEquals(false, isNotCheckOut);
    }

    @Test
    public void returnBook() {

        String bookTitle = "Perfume";
        String libraryNumber = "1";
        biblioteca.addBooks();

        boolean isReturned = biblioteca.returnBook(bookTitle,libraryNumber);

        assertEquals(true, isReturned);

    }

    @Test
    public void returnInvalidBook() {

        String bookTitle = "Other book";
        String libraryNumber = "2";
        biblioteca.addBooks();

        boolean isNotReturned = biblioteca.returnBook(bookTitle,libraryNumber);

        assertEquals(false, isNotReturned);


    }






}