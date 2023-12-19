package org.example;

public class book extends item {
    private String ISBNnumber;

    public String getISBNnumber() {
        return ISBNnumber;
    }

    public void setISBNnumber(String ISBNnumber) {
        this.ISBNnumber = ISBNnumber;
    }

    public book(String name, long date, String title, String author, int publictionDate, int length, literaryGenres genre, String ISBNnumber) {
        super(name, date, title, author, publictionDate, length, genre);
        this.ISBNnumber = ISBNnumber;
    }
}
