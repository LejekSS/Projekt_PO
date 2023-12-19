package org.example;
import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void mainMenu(){
        System.out.println("---------------------------------------");
        System.out.println("158093 | 2 rok 3 semestr | PO - projekt");
        System.out.println("------------------Menu-----------------");
        System.out.println("1. Dodaj nowy obiekt");
        System.out.println("2. Usuń obiekt");
        System.out.println("3. Wyświetl wszystkie obiekty");
        System.out.println("4. Wyświelt podtyp obiektów");
        System.out.println("5. Wyswietl obiekty o zadanej nazwie");
        System.out.println("6. Operacja zawarta w interfejsie");
        System.out.println("7. Zakończ");
    }
    public static void subMenu(){
        System.out.println("---------------------------------------");
        System.out.println("158093 | 2 rok 3 semestr | PO - projekt");
        System.out.println("------------------Menu-----------------");
        System.out.println("1. Nowy użytkownik");
        System.out.println("2. Nowy pracownik");
        System.out.println("3. Nowa książka");
        System.out.println("4. Nowy audiobook");
        System.out.println("5. Cofnij");
    }
    public static void main(String[] args) {
        boolean isRunning = true;
        String message;

        while (isRunning){
            mainMenu();
            message = s.nextLine();
            switch (message){
                case "1":
                    subMenu();
                    message = s.nextLine();
                    switch (message) {
                        case "1":
                            break;
                        case "2":
                            break;
                        case "3":
                            break;
                        case "4":
                            break;
                        case "5":
                            break;
                        default:
                            System.out.println("Nieprawidlowa opcja");
                            break;
                    }
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "9":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Nieprawidlowa opcja");
                    break;
            }
        }
    }
}