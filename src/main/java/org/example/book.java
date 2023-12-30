package org.example;

import java.util.Arrays;

public class book extends item implements IDataStructure{
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
                ", ISBNnumber='" + ISBNnumber + '\'' +
                ", quantity=" + quantity;
    }

    @Override
    public void rentItem(client klient, book ksiazka) {
        if (ksiazka.getQuantity() > 0) {
            ksiazka.setQuantity(ksiazka.getQuantity() - 1);
            int[] newRented = Arrays.copyOf(klient.getRented(), klient.getRented().length + 1);
            newRented[newRented.length - 1] = ksiazka.getId();
            klient.setRented(newRented);
        } else {
            System.out.println("Sorry, the book is not available for rent.");
        }
    }

}

