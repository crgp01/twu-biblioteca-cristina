package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {

    @Mock
    private PrintStream printStream;
    @Mock
    private Biblioteca biblioteca;

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp(printStream, biblioteca);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        bibliotecaApp.run();

        verify(printStream).println(Message.WELCOME);
    }

    @Test
    public void shouldPrintAllLibraryBooks() {
        Book tituloPablo = new Book("Titulo", 2013, "Pablo", false, "1234");
        Book tituloAndrea = new Book("Titulo 2", 2013, "Andrea", false, "1234");

        ArrayList<Book> books = new ArrayList<>();
        books.add(tituloPablo);
        books.add(tituloAndrea);

        when(biblioteca.getListBook(anyBoolean())).thenReturn(books);

        bibliotecaApp.run();

        verify(printStream).println(tituloPablo.toString());
        verify(printStream).println(tituloAndrea.toString());
    }


    @Test
    public void printSuccessMessage() {

        assertEquals("Thank you! Enjoy the book", Message.CHECKOUT_BOOK);
    }
}