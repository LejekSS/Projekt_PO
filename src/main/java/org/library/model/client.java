package org.library.model;

import org.library.utils.IDataStructure;
import org.library.utils.genders;

import java.util.Arrays;
import java.util.Scanner;

public class client extends person implements IDataStructure {
    public void setRented(int[] rented) {
        this.rented = rented;
    }

    private int[] rented;

    public int[] getRented() {
        return rented;
    }

    public client(String name, genders gender, int age, String identityCard) {
        super(name, gender, age, identityCard);
        this.rented = new int[0];
    }

    @Override
    public String toString() {
        return super.toString() +
                ", rented=" + Arrays.toString(rented);
    }

    @Override
    public void ageup() {
        setAge(getAge()+1);
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


