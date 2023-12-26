package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class Main {
    static List<databaseObject> database = new ArrayList<>();
    public static void mainMenu(){
        System.out.println("---------------------------------------");
        System.out.println("158093 | 2 rok 3 semestr | PO - projekt");
        System.out.println("------------------Menu-----------------");
        System.out.println("1. Dodaj nowy obiekt");
        System.out.println("2. Usuń obiekt");
        System.out.println("3. Wyświetl wszystkie obiekty");
        System.out.println("4. Wyświelt podtyp obiektów");
        System.out.println("5. Wyswietl obiekty o podanym ciągu znaków w nazwie");
        System.out.println("6. Operacja zawarta w interfejsie");
        System.out.println("7. Zakończ");
        System.out.print("Wybrana akcja: ");
    }
    private static String getUserInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (userInput.trim().isEmpty() ) {
            System.out.println(prompt);
            userInput = scanner.nextLine().trim();
            if (userInput.trim().isEmpty()) System.out.println("Wartość nie może być pusta!");
        }
        return userInput;
    }
    private static int getUserInputIntiger(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (userInput.trim().isEmpty()) {
            System.out.println(prompt);
            userInput = scanner.nextLine().trim();
            if (userInput.trim().isEmpty()) System.out.println("Wartość nie może być pusta!");
            try {
                Integer.parseInt(userInput);
            } catch (NumberFormatException ex) {
                System.out.println("Nie podano wartosci licznowej");
                userInput = "";
            }
        }
        return Integer.parseInt(userInput);
    }
    public static void newObjectMenu(){
        System.out.println("---------------------------------------");
        System.out.println("158093 | 2 rok 3 semestr | PO - projekt");
        System.out.println("------------------Menu-----------------");
        System.out.println("1. Nowy użytkownik");
        System.out.println("2. Nowy pracownik");
        System.out.println("3. Nowa książka");
        System.out.println("4. Nowy audiobook");
        System.out.println("5. Cofnij");
        System.out.print("Wybrana akcja: ");
    }
    public static void displayObjectByTypeMenu(){
        System.out.println("---------------------------------------");
        System.out.println("158093 | 2 rok 3 semestr | PO - projekt");
        System.out.println("------------------Menu-----------------");
        System.out.println("1. Użytkowik");
        System.out.println("2. Pracownik");
        System.out.println("3. Książka");
        System.out.println("4. Audiobook");
        System.out.println("5. Cofnij");
        System.out.print("Wybrana akcja: ");
    }
    public static void waitForAction(){
        System.out.println("Naciśnij dowolny przycisk, aby kontynuować...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void newElement(int type){
        String name = getUserInput("Podaj nazwę książki:");
        String title = getUserInput("Podaj tytuł książki:");
        String author = getUserInput("Podaj autora książki:");
        int publicationDate = getUserInputIntiger("Podaj rok publikacji: ");
        int length = getUserInputIntiger("Podaj ilość stron: ");
        switch (type){
            case 1:
                break;
            case 2:
                break;
            case 3:
                String ISBN = getUserInput("Podaj numer ISBN: ");
                database.add(new book(name,title,author,publicationDate,length,item.setGenre(),ISBN));
                break;
            case 4:
                float size = getUserInputIntiger("Podaj wielkość pliku");
                database.add(new audiobook(name,title,author,publicationDate,length,item.setGenre(),size));
                break;
            default:
                System.out.println("Coś poszło nie tak");
                break;
        }

    }
    public static void displayAllElements(){
        if (database.isEmpty())System.out.println("Nie znalezniono obiektów do wyświetlenia");
        else {
            try {
                database.forEach(database -> System.out.println(database.toString()));
            } catch (NullPointerException ex) {
                System.out.println("Coś poszło nie tak: " + ex);
            }
        }
        waitForAction();
    }
    public static void displayObjectsByType(Class<?> type) {
        List<databaseObject> temp = database.stream()
                .filter(obj -> type.isAssignableFrom(obj.getClass()))
                .toList();
        if (temp.isEmpty()) System.out.println("Nie znalezniono obiektów do wyświetlenia");
         else {
            try {
                temp.forEach(database -> System.out.println(database.toString()));
            } catch (NullPointerException ex) {
                System.out.println("Coś poszło nie tak: " + ex);
            }
        }
         waitForAction();
    }
    public static void displayObjectsByNameContains(String substring) {
        List<databaseObject> temp = database.stream()
                .filter(obj -> obj.getName().contains(substring))
                .toList();
        if (temp.isEmpty()) System.out.println("Nie znalezniono obiektów do wyświetlenia");
        else {
            try {
                temp.forEach(database -> System.out.println(database.toString()));
            } catch (NullPointerException ex) {
                System.out.println("Coś poszło nie tak: " + ex);
            }
        }
        waitForAction();
    }
    public static void removeObjectById(int id) {
        boolean removed;
        try {
            removed = database.removeIf(obj -> obj.getId() == id);
        }
        catch (UnsupportedOperationException | NullPointerException ex){
            System.out.println("Coś poszło nie tak: " + ex);
            removed = false;
        }
        if(removed) System.out.println("Usunieto element od id: "+ id);
        else System.out.println("Obiekt o id: " + id + " nie istnieje");
    }
    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning){
            mainMenu();
            switch (getUserInput("Wybierz akcję: ")){
                case "1": //Dodawanie nowego obiektu - w trakcie
                    newObjectMenu();
                    switch (getUserInput("Wybierz akcję: ")) {//Wybór typu
                        case "1":
                            break;
                        case "2":
                            break;
                        case "3":
                            System.out.println("Tworzę nowy obiekt typu: ksiazka");
                            newElement(3);
                            break;
                        case "4":
                            System.out.println("Tworzę nowy obiekt typu: audiobook");
                            newElement(4);
                            break;
                        case "5":
                            break;
                        default:
                            System.out.println("Nieprawidlowa opcja");
                            break;
                    }
                    break;
                case "2": //Usuwanie obiektu
                    removeObjectById(getUserInputIntiger("Podaj id obiektu do usunięcia: "));
                    break;
                case "3": //Wyświetlanie wszystkich elementów
                    displayAllElements();
                    break;
                case "4": //Wyświetlanie danego typu elementów
                    displayObjectByTypeMenu();
                    switch (getUserInput("Wybierz akcję: ")) { //Wybór typu
                        case "1":
                            break;
                        case "2":
                            break;
                        case "3":
                            displayObjectsByType(book.class);
                            break;
                        case "4":
                            displayObjectsByType(audiobook.class);
                            break;
                        case "5":
                            break;
                        default:
                            System.out.println("Nieprawidlowa opcja");
                            break;
                    }
                    break;
                case "5": //Wyświetalnie elemenetów z ciągiem znaków w nazwie
                    displayObjectsByNameContains(getUserInput("Podaj ciąg znaków: "));
                    break;
                case "6": //Operacja z interfejstu - w trakcie
                    break;
                case "7": //Zakończ
                    isRunning = false;
                    break;
                default: //Obsługa błędu
                    System.out.println("Nieprawidlowa opcja");
                    break;
            }
        }
    }
}