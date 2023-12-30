package org.library;

import java.util.Arrays;
import java.util.Scanner;

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


    public void rent(client klient, book ksiazka) {
        if (ksiazka.getQuantity() > 0) {
            ksiazka.setQuantity(ksiazka.getQuantity() - 1);
            int[] newRented = Arrays.copyOf(klient.getRented(), klient.getRented().length + 1);
            newRented[newRented.length - 1] = ksiazka.getId();
            klient.setRented(newRented);
        } else {
            System.out.println("Nie można wypożyczyć książki - nie jest dostępna");
        }
    }

    @Override
    public int rertun(client klient) {
        int[] Rented = Arrays.copyOf(klient.getRented(), klient.getRented().length);
        if (Rented.length > 0) {
            System.out.println("Wypozyczone pozycje: " + Arrays.toString(Rented));
            Scanner scanner = new Scanner(System.in);
            String userInput = "";
            while (userInput.trim().isEmpty()) {
                System.out.println("Podaj ID pozycji do zwrócenia: ");
                userInput = scanner.nextLine().trim();
                if (userInput.trim().isEmpty()) System.out.println("Wartość nie może być pusta!");
                try {
                    Integer.parseInt(userInput);
                } catch (NumberFormatException ex) {
                    System.out.println("Nie podano wartosci licznowej");
                    userInput = "";
                }
            }
            for (int id : Rented) {
                if (id == Integer.parseInt(userInput)) {
                    System.out.println( "Zwrócno " + Integer.parseInt(userInput));
                    int[] newRented = Arrays.copyOf(klient.getRented(), klient.getRented().length-1);
                    for(int i=0, k=0;i<Rented.length;i++){
                        if(Rented[i]!=Integer.parseInt(userInput)){
                            newRented[k]=Rented[i];
                            k++;
                        }
                    }
                    klient.setRented(newRented);
                    return Integer.parseInt(userInput);
                }
            }
            System.out.println( "Wybrano nieprawidłową pozycję do zwrotu");
        }
        else System.out.println( "Użytkownik nie posiada wypozyczonych pozycji");
        return -1;
    }
}

