package org.example;

public class book extends item {
    private String ISBNnumber;

    public String getISBNnumber() {
        return ISBNnumber;
    }

    public void setISBNnumber(String ISBNnumber) {
        this.ISBNnumber = ISBNnumber;
    }

    public book(String name, String title, String author, int publictionDate, int length, literaryGenres genre, String ISBNnumber) {
        super(name, title, author, publictionDate, length, genre);
        this.ISBNnumber = ISBNnumber;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", ISBNnumber='" + ISBNnumber + '\''
                ;
    }
}
