package com.twu.biblioteca;

/**
 * Created by crivera on 13/9/16.
 */
public class Book {

    private String title;
    private int year;
    private String author;

    public String getLibraryNumber() {
        return libraryNumber;
    }

    private String libraryNumber;
    private boolean isCheckedOut = false;

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public Book() {
    }

    public Book(String title, int year, String author, boolean isCheckedOut, String libraryNumber) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.isCheckedOut = isCheckedOut;
        this.libraryNumber = libraryNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookDetails() {
        return this.getTitle()+" "+this.getAuthor()+" "+this.getYear();
    }
}
