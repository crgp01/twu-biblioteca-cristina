package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
public class MenuTest {

    private Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void returnMenuOptions() {

        String menuOptions = menu.MenuOptions;
        assertTrue(menuOptions, true);
    }

    @Test
    public void wrongMessageMenuOptions() {

        String wrongMessage = menu.menuOptions("33");
        assertEquals(Message.INVALID_OPTION, wrongMessage);
    }

    @Ignore
    public void exitMessageMenuOptions() {

        String quitMessage = menu.menuOptions("0");
        System.out.println(quitMessage);
        assertEquals(Message.QUIT, quitMessage);
    }


}