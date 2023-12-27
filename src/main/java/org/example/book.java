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
            System.out.println("Książka została wypożyczona");
        } else {
            System.out.println("Książka jest niedostępna");
        }
    }

    @Override
    public void returnItem(client klient, book ksiazka) {
        int bookId = ksiazka.getId();
        int[] rentedBooks = klient.getRented();
        // Sprawdź, czy klient wypożyczył tę książkę
        boolean isBookRented = false;
        for (int i : rentedBooks) {
            if (i == bookId) {
                isBookRented = true;
                break;
            }
        }
        if (isBookRented) {
            // Klient wypożyczył tę książkę, zwróć ją
            ksiazka.setQuantity(ksiazka.getQuantity() + 1);

            // Usuń książkę z listy wypożyczonych u klienta
            int[] updatedRented = Arrays.stream(rentedBooks)
                    .filter(id -> id != bookId)
                    .toArray();
            klient.setRented(updatedRented);

            System.out.println("Książka została pomyślnie zwrócona.");
        } else {
            System.out.println("Klient nie wypożyczył tej książki.");
        }
}
}
