package com.twu.biblioteca;
import java.util.ArrayList;
public class Biblioteca {

    private ArrayList<Book> books = new ArrayList<Book>();

    public void Biblioteca() {
        books = new ArrayList<Book>() {{
            add(new Book("Metamorfosis",1960 ,"Franz Kafka", false,"1"));
            add(new Book("It",1987 ,"Stephen King", false, "1"));
            add(new Book("Perfume",1960 ,"Varios", true, "1"));
        }};
    }

    public ArrayList<Book> getListBook(boolean condition) {
       ArrayList<Book> bookList = new ArrayList<Book>();

        for (Book book : books) {
            if (book.isCheckedOut() == condition) {
                bookList.add(book);
            }
        }
        return bookList;
    }


    public ArrayList<String> getListBookDetails() {
        ArrayList<String> booksDetails = new ArrayList<>();

        ArrayList<Book> availableBook = getListBook(false);

        for (Book book : availableBook)
        {
            booksDetails.add(book.toString());
        }

        return booksDetails;
    }


    public int findBooksByTitle(String bookTitle, ArrayList<Book> books){
        int i = 0;
        int position = -1;

        for (Book book : books){
            if(book.getTitle().equals(bookTitle)){
                position = i;
                break;
            }
            i++;
        }

        return position;

    }

    public boolean checkoutBook(String bookTitle) {
        ArrayList<Book> availableBooks = getListBook(false);
        int position = findBooksByTitle(bookTitle, availableBooks);

        if (position >= 0) {

            availableBooks.get(position).setCheckedOut(true);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean returnBook(String bookTitle, String libraryNumber) {
        ArrayList<Book> checkOutBooks = getListBook(true);

        int position = findBooksByTitle(bookTitle, checkOutBooks);

        if (position >= 0) {

            if(libraryNumber.equals(checkOutBooks.get(position).getLibraryNumber())) {
                checkOutBooks.get(position).setCheckedOut(false);
                return true;
            }
            else
            {
                return false;
            }
        }
        else {
            return false;
        }
    }



}


