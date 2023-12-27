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
    }
    public static void waitForAction(){
        System.out.println("Naciśnij ENTER, aby kontynuować...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void newElement(int type) {
        switch (type) {
            case 1:
                try {
                    database.add(new client(
                            getUserInput("Podaj imię i nazwisko:"),
                            person.setGender(),
                            getUserInputIntiger("Podaj wiek: "),
                            getUserInput("Podaj numer karty: ")));
                    System.out.println("Pomyślnie dodano obiekt do bazy");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Coś poszło nie tak: " + ex);
                }
                break;
            case 2:
                try {
                    database.add(new employee(
                            getUserInput("Podaj imię i nazwisko:"),
                            person.setGender(),
                            getUserInputIntiger("Podaj wiek: "),
                            getUserInput("Podaj numer karty: "),
                            employee.setPosition(),
                            getUserInputIntiger("Podaj wynagrodzenie: ")));
                    System.out.println("Pomyślnie dodano obiekt do bazy");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Coś poszło nie tak: " + ex);
                }
                break;
            case 3:
                try {
                    database.add(new book(
                            getUserInput("Podaj nazwę książki:"),
                            getUserInput("Podaj autora:"),
                            getUserInputIntiger("Podaj rok publikacji: "),
                            getUserInputIntiger("Podaj ilość stron: "),
                            getUserInputIntiger("Podaj ilość egzemplarzy: "),
                            item.setGenre(),
                            getUserInput("Podaj numer ISBN:")));
                    System.out.println("Pomyślnie dodano obiekt do bazy");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Coś poszło nie tak: " + ex);
                }
                break;
            case 4:
                try {
                    database.add(new audiobook(
                            getUserInput("Podaj nazwę audiobooka:"),
                            getUserInput("Podaj autora:"),
                            getUserInputIntiger("Podaj rok publikacji: "),
                            getUserInputIntiger("Podaj długość [Min]: "),
                            item.setGenre(),
                            getUserInputIntiger("Podaj rozmiar pliku [Mb]:")));
                    System.out.println("Pomyślnie dodano obiekt do bazy");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Coś poszło nie tak: " + ex);
                }
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
    public static void rentMenu(){
        System.out.println("---------------------------------------");
        System.out.println("158093 | 2 rok 3 semestr | PO - projekt");
        System.out.println("------------------Menu-----------------");
        System.out.println("1. Wypożycz książkę");
        System.out.println("2. Zwróć książke");
        System.out.println("3. Wypożycz audiobook");
        System.out.println("4. Zwróć audiobook");
        System.out.println("5. Cofnij");
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
        int i;
        for (i = 1; i <= 5; i++) {
            database.add(new book("Book" + i, "Author" + i, 2023, 200, i, literaryGenres.SAMOPOMOC, "ISBN" + i));
        }


        // Add 5 audiobooks
        for (i = 1; i <= 5; i++) {
            database.add(new audiobook("Audiobook" + i, "Author" + i, 2023, 180, literaryGenres.KOMEDIA, 10));
        }

        // Add 5 employees
        for (i = 1; i <= 5; i++) {
            database.add(new employee("Employee" + i, genders.MEZCZYZNA, 30, "ID" + i, workplaces.ASYSTENT_BIBLIOTEKARZA, 50000));
        }

        // Add 5 clients
        for (i = 1; i <= 5; i++) {
            database.add(new client("Client" + i, genders.KOBIETA, 25, "ID" + i));
        }
        boolean isRunning = true;
        while (isRunning){
            mainMenu();
            switch (getUserInput("Wybierz akcję: ")){
                case "1": //Dodawanie nowego obiektu - w trakcie
                    newObjectMenu();
                    switch (getUserInput("Wybierz akcję: ")) {//Wybór typu
                        case "1":
                            System.out.println("Tworzę nowy obiekt typu: użytkownik");
                            newElement(1);
                            break;
                        case "2":
                            System.out.println("Tworzę nowy obiekt typu: pracownik");
                            newElement(2);
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
                            displayObjectsByType(client.class);
                            break;
                        case "2":
                            displayObjectsByType(employee.class);
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
                case "6": //Operacja z interfejstu
                    rentMenu();
                    switch (getUserInput("Wybierz opcje:")){
                        case "1":
                            int clientId = getUserInputIntiger("Podaj ID klienta: ");
                            int bookId = getUserInputIntiger("Podaj ID książki do wypożyczenia: ");

                            if (clientId >= 0 && clientId < database.size() && bookId >= 0 && bookId < database.size()) {
                                if (database.get(clientId) instanceof client && database.get(bookId) instanceof book) {
                                    client client = (client) database.get(clientId);
                                    book book = (book) database.get(bookId);

                                    book.rentItem(client,book.getId());
                                } else {
                                    System.out.println("Podano nieprawidłowe ID klienta lub książki.");
                                }
                            } else {
                                System.out.println("Podano nieprawidłowe ID klienta lub książki.");
                            }
                            break;
                        case "2":
                            int clientId2 = getUserInputIntiger("Podaj ID klienta: ");
                            int bookId2 = getUserInputIntiger("Podaj ID książki do zwrotu: ");

                            if (clientId2 >= 0 && clientId2 < database.size() && bookId2 >= 0 && bookId2 < database.size()) {
                                if (database.get(clientId2) instanceof client && database.get(bookId2) instanceof book) {
                                    client client = (client) database.get(clientId2);
                                    book book = (book) database.get(bookId2);
                                    book.returnItem(client, book);
                                } else {
                                    System.out.println("Podano nieprawidłowe ID klienta lub książki.");
                                }
                            } else {
                                System.out.println("Podano nieprawidłowe ID klienta lub książki.");
                            }
                            break;
                        case "5":
                            break;
                        default: //Obsługa błędu
                        System.out.println("Nieprawidlowa opcja");
                        break;
                    }

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
