package org.library;
import java.util.*;

public class Main {
    static List<databaseObject> database = new ArrayList<>();
    private static void testdata(){
        database.add(new book("Discover Your Potential", "Emma Smith", 1999, 238, 3, literaryGenres.DLA_MLODZIEZY, "ISBN000001"));
        database.add(new book("Beyond the Horizon", "John Davis", 2001, 138, 2, literaryGenres.SCIENCE_FICTION, "ISBN000002"));
        database.add(new book("The Art of Mindfulness", "Sophia Roberts", 2022, 390, 1, literaryGenres.NAUKOWA, "ISBN000003"));
        database.add(new audiobook("Dom po drugiej stronie jeziora", "Rigly Sager", 2023, 182, literaryGenres.KOMEDIA, 4));
        database.add(new audiobook("Gniew", "Zygmunt Miłoszewski", 2004, 91, literaryGenres.DRAMAT, 8));
        database.add(new employee("Janusz Jezierski", genders.MEZCZYZNA, 55, "A1233", workplaces.ASYSTENT_BIBLIOTEKARZA, 3200));
        database.add(new employee("Mariusz Drobniewski", genders.MEZCZYZNA, 31, "C9421", workplaces.BIBLIOTEKARZ, 4000));
        database.add(new employee("Dariusz Mazurek", genders.MEZCZYZNA, 45, "N11123", workplaces.DYREKTOR, 4500));
        database.add(new client("Anna Byttner", genders.KOBIETA, 25, "A8723"));
        database.add(new client("Adam Maciejewski", genders.MEZCZYZNA, 38, "A9352"));
        database.add(new client("Karolina Jankowska", genders.KOBIETA, 25, "B1211"));
    }
    private static client findClientById(int clientId) {
        for (databaseObject obj : database) {
            if (obj instanceof client && ((client) obj).getId() == clientId) {
                return (client) obj;
            }
        }
        return null;
    }
    private static book findBookById(int bookId) {
        for (databaseObject obj : database) {
            if (obj instanceof book && ((book) obj).getId() == bookId) {
                return (book) obj;
            }
        }
        return null;
    }
    private static audiobook findAudiobookById(int audiobookId) {
        for (databaseObject obj : database) {
            if (obj instanceof audiobook && ((audiobook) obj).getId() == audiobookId) {
                return (audiobook) obj;
            }
        }
        return null;
    }
    private static void rentItem(String name){
        int clientId = getUserInputIntiger("Podaj ID klienta: ");
        int ItemId = getUserInputIntiger("Podaj ID przedmiotu do wypożyczenia: ");

        if(name == "book") {
            client client = findClientById(clientId);
            book book = findBookById(ItemId);

            if (client != null && book != null) {
                book.rent(client, book);
            } else {
                System.out.println("Podano nieprawidłowe ID klienta lub książki.");
            }
        }
        else if(name == "audiobook"){
            client client = findClientById(clientId);
            audiobook audiobook = findAudiobookById(ItemId);

            if (client != null && audiobook != null) {
                audiobook.rent(client, audiobook);
            } else {
                System.out.println("Podano nieprawidłowe ID klienta lub Audiobooka.");
            }
        }
    }
    public static void mainMenu() {
        System.out.println("---------------------------------------");
        System.out.println("158093 | 2 rok 3 semestr | PO - projekt");
        System.out.println("------------------Menu-----------------");
        System.out.println("1. Dodaj nowy obiekt");
        System.out.println("2. Usuń obiekt");
        System.out.println("3. Wyświetl wszystkie obiekty");
        System.out.println("4. Wyświelt podtyp obiektów");
        System.out.println("5. Wyswietl obiekty o podanym ciągu znaków w nazwie");
        System.out.println("6. Funkcja abstrakcyjna | Funkcja implementowana przez interfejs");
        System.out.println("7. Dodaj dane testowe");
        System.out.println("8. Zakończ");
    }
    private static void interfaceMenu(){
        System.out.println("1. Funkcja ageUP() - wykonywana dla pracownika lub klienta");
        System.out.println("2. Funkcja rent() - wykonywana dla klienta z klasy ksiazka");
        System.out.println("3. Funkcja rent() - wykonywana dla klienta z klasy audiobook");
        System.out.println("4. Funkcja return() - implementowana przez klase klient");
        System.out.println("5. Cofnij");
    }
    private static String getUserInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (userInput.trim().isEmpty()) {
            System.out.println(prompt);
            userInput = scanner.nextLine().trim();
            if (userInput.trim().isEmpty()) System.out.println("Wartość nie może być pusta!");
        }
        return userInput;
    }
    private static void returnItem(){
        int clientId = getUserInputIntiger("Podaj ID klienta: ");
        client client = findClientById(clientId);
            if (client != null) {
                int itemID = client.rertun(client);
                if (itemID >= 0){
                    if (findBookById(itemID) != null){
                        book TempBook = findBookById(itemID);
                        TempBook.setQuantity(TempBook.getQuantity()+1);
                    }
                }
            } else {
                System.out.println("Podano nieprawidłowe ID klienta.");
            }
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
    public static void newObjectMenu() {
        System.out.println("---------------------------------------");
        System.out.println("158093 | 2 rok 3 semestr | PO - projekt");
        System.out.println("------------------Menu-----------------");
        System.out.println("1. Nowy użytkownik");
        System.out.println("2. Nowy pracownik");
        System.out.println("3. Nowa książka");
        System.out.println("4. Nowy audiobook");
        System.out.println("5. Cofnij");
    }
    public static void displayObjectByTypeMenu() {
        System.out.println("---------------------------------------");
        System.out.println("158093 | 2 rok 3 semestr | PO - projekt");
        System.out.println("------------------Menu-----------------");
        System.out.println("1. Użytkowik");
        System.out.println("2. Pracownik");
        System.out.println("3. Książka");
        System.out.println("4. Audiobook");
        System.out.println("5. Cofnij");
    }
    public static void waitForAction() {
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
    public static void displayAllElements() {
        if (database.isEmpty()) System.out.println("Nie znalezniono obiektów do wyświetlenia");
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
        } catch (UnsupportedOperationException | NullPointerException ex) {
            System.out.println("Coś poszło nie tak: " + ex);
            removed = false;
        }
        if (removed) System.out.println("Usunieto element od id: " + id);
        else System.out.println("Obiekt o id: " + id + " nie istnieje");
    }
    public static void ageUpPerson(int id) {
        Optional<databaseObject> personOptional = database.stream()
                .filter(obj -> obj.getId() == id)
                .findFirst();

        if (personOptional.isPresent()) {
            databaseObject person = personOptional.get();

            if (person instanceof employee) {
                ((employee) person).ageup();
                System.out.println("Wiek oraz pensjka pracownika z ID " + id + " został zaktualizowany.");
            } else if (person instanceof client) {
                ((client) person).ageup();
                System.out.println("Wiek klienta z ID " + id + " został zaktualizowany.");
            } else {
                System.out.println("Obiekt o podanym ID nie jest pracownikiem ani klientem.");
            }
        } else {
            System.out.println("Nie znaleziono obiektu o podanym ID.");
        }
    }
        public static void main (String[] args)
        {
            boolean isRunning = true;
            while (isRunning) {
                mainMenu();
                switch (getUserInput("Wybierz akcję: ")) {
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
                        interfaceMenu();
                        switch (getUserInput("Wybierz akcję: ")) { //Wybór typu
                            case "1":
                                ageUpPerson(getUserInputIntiger("Podaj id pracownika lub klienta: "));
                                break;
                            case "2":
                                rentItem("book");
                                break;
                            case "3":
                                rentItem("audiobook");
                                break;
                            case "4":
                                returnItem();
                                break;
                            case "5":
                                break;
                            default: //Obsługa błędu
                                System.out.println("Nieprawidlowa opcja");
                                break;
                        }
                        break;
                    case "7": //Zakończ
                        testdata();
                        break;
                    case "8": //Zakończ
                        isRunning = false;
                        break;
                    default: //Obsługa błędu
                        System.out.println("Nieprawidlowa opcja");
                        break;
                }
            }
        }
    }
