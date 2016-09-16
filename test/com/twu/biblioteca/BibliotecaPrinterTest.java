package com.twu.biblioteca;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by crivera on 13/9/16.
 */
public class BibliotecaPrinterTest {

    public Biblioteca biblioteca = new Biblioteca();


    @Test
    public void printWelcomeMessage() {

        assertEquals(Message.WELCOME, "Welcome!");
    }

    @Test
    public void booklistTest() {

        ArrayList<Book> bookList = biblioteca.getListBook();

        assertEquals(biblioteca.getListBook(),bookList);
    }

@Test

public void bookDetailsTest() {

    Book book = new Book("title",2000,"author",false,"1");

    String bookDetails = book.getBookDetails();

    assertEquals("title author 2000", bookDetails);
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

        String wrongMessage = menu.menuOptions(32);

        assertEquals("Invalid Option!",wrongMessage);
    }

    @Test

    public void exitMessageMenuOptions() {

        Menu menu = new Menu();

        String quitMessage = menu.menuOptions(0);

        assertEquals("Bye Bye!",quitMessage);
    }

    @Test

    public void booksAvaibleCheckout() {

        biblioteca.addBooks();

        ArrayList<Book> bookList = biblioteca.getListBook();

        assertEquals(biblioteca.getListBook(),bookList);
    }

    @Test

    public void booksCheckedOut() {

        biblioteca.addBooks();

        ArrayList<Book> bookList = biblioteca.getListCheckedBook();

        assertEquals(biblioteca.getListCheckedBook(),bookList);
    }

    @Test
    public void printSuccessMessage() {

        assertEquals(Message.CHECKOUT_BOOK, "Thank you! Enjoy the book");
    }
    @Test
    public void findAvailableBook() {
        biblioteca.addBooks();
        int position = 0;
        String bookTitle = "It";
        ArrayList<Book> bookList = biblioteca.getListBook();
        position = biblioteca.findBooksByTitle(bookTitle,bookList);

        assertEquals(1,position);


    }

    @Test
    public void checkOutBook() {

        String bookTitle = "It";
        biblioteca.addBooks();

        String message = biblioteca.checkoutBook(bookTitle);

        assertEquals("Thank you! Enjoy the book", message);


    }

    @Test
    public void notcheckOutBook() {

        String bookTitle = "hgh";
        biblioteca.addBooks();

        String message = biblioteca.checkoutBook(bookTitle);

        assertEquals("That book is not available", message);


    }

    @Test
    public void returnBook() {

        String bookTitle = "Patito lee";
        String libraryNumber = "1";
        biblioteca.addBooks();

        String message = biblioteca.returnBook(bookTitle,libraryNumber);

        assertEquals("Thank you for returning the book", message);


    }

    @Test
    public void returnInvalidBook() {

        String bookTitle = "Patito lee";
        String libraryNumber = "2";
        biblioteca.addBooks();

        String message = biblioteca.returnBook(bookTitle,libraryNumber);

        assertEquals("That is not a valid book to return", message);


    }





}