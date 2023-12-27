package org.example;

public class book extends item {
    private String ISBNnumber;

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getISBNnumber() {
        return ISBNnumber;
    }

    public void setISBNnumber(String ISBNnumber) {
        this.ISBNnumber = ISBNnumber;
    }

    public book(String name, String author, int publictionDate, int length, int quantity, literaryGenres genre, String ISBNnumber) {
        super(name, author, publictionDate, length, genre);
        this.ISBNnumber = ISBNnumber;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", ISBNnumber='" + ISBNnumber + '\''
                ;
    }
}
