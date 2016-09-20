package com.twu.biblioteca;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Menu menu;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
        menu = new Menu();
    }

    @Test
    public void shouldReturnListOfAvailableBooks() {
        ArrayList<Book> expectedBookList = new ArrayList<Book>() {{
            add(new Book("Metamorfosis",1960 ,"Franz Kafka", false,"1"));
            add(new Book("It",1987 ,"Stephen King", false, "1"));
        }};

        ArrayList<Book> bookList = biblioteca.getListBook(false);

        assertEquals(expectedBookList, bookList);
    }

    @Test

    public void booksAvailableCheckout() {

        biblioteca.Biblioteca();

        ArrayList<Book> bookList = biblioteca.getListBook(false);

        assertEquals(biblioteca.getListBook(false), bookList);
    }

    @Test

    public void booksCheckedOut() {

        biblioteca.Biblioteca();

        ArrayList<Book> bookList = biblioteca.getListBook(true);

        assertEquals(biblioteca.getListBook(true), bookList);
    }

    @Test
    public void findAvailableBook() {
        biblioteca.Biblioteca();
        int position = 0;
        String bookTitle = "It";
        ArrayList<Book> bookList = biblioteca.getListBook(false);
        position = biblioteca.findBooksByTitle(bookTitle, bookList);

        assertEquals(1, position);
    }

    @Test
    public void checkOutBook() {

        String bookTitle = "It";
        biblioteca.Biblioteca();
        boolean isCheckOut = biblioteca.checkoutBook(bookTitle);
        assertEquals(true, isCheckOut);
    }

    @Test
    public void notCheckOutBook() {

        String bookTitle = "hgh";
        biblioteca.Biblioteca();

        boolean isNotCheckOut = biblioteca.checkoutBook(bookTitle);

        assertEquals(false, isNotCheckOut);
    }

    @Test
    public void returnBook() {

        String bookTitle = "Perfume";
        String libraryNumber = "1";
        biblioteca.Biblioteca();

        boolean isReturned = biblioteca.returnBook(bookTitle, libraryNumber);

        assertEquals(true, isReturned);

    }

    @Test
    public void returnInvalidBook() {

        String bookTitle = "Other book";
        String libraryNumber = "2";
        biblioteca.Biblioteca();

        boolean isNotReturned = biblioteca.returnBook(bookTitle, libraryNumber);

        assertEquals(false, isNotReturned);


    }


}