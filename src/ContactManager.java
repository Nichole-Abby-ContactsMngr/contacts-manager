import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {

    public static void main(String[] args) {
        List<Contacts> contacts = new ArrayList<>();
        Input input = new Input();
        System.out.println("*****Welcome to Contacts Manager*****");
//        System.out.println("1. View Contacts - 2. Add Contact - 3. Search Contact - 4. Delete - 5. Exit");
//        System.out.println("----------------------------------------------------------------------------");

        String userInput;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an option: ");
        userInput = sc.nextLine();
        System.out.println("You entered: --> \"" + userInput + "\" <--");

    }
    //method to show menu do while loop. always going to show unless user wants to exit

    do {
    } while ();

    public static void showMenu() {
        System.out.println("1. View Contacts");
        System.out.println("2. Add Contact");
        System.out.println("3. Search Contact");
        System.out.println("4. Delete");
        System.out.println("5. Exit");

//        Input userResponse = new Input();
//        userResponse.getString("Enter an option 1, 2, 3, 4 or 5: ");
        
    }

    Path contactsPath = Paths.get("data", "contacts.txt");

    //psvm then do while loop for all methods
    //here write main method for public static void showMenu(), then showAll contacts, addContact, searchContact, deleteContact, exit

    public static void writeContactsToFile() throws IOException {
        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (!Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        ArrayList<String> contacts = new ArrayList<>();
        contacts.add("Amy, 222-222-2222");
        contacts.add("Bill, 444-444-4444");
        contacts.add("Carl, 888-888-8888");

        Files.write(dataFile, contacts);
    }

//    public static List<Contacts> readAllContacts() {
//        String directory = "data";
//        String filename = "contacts.txt";
//        Path dataDirectory = Paths.get(directory);
//        Path dataFile = Paths.get(directory, filename);
//        List<Contacts> listOfContacts = new ArrayList<>();
//        String name, phoneNumber;
//
//        try {
//            contactsStrings = Files.readAllLines(dataFile);
//            contacts = Files.readAllLines(dataFile);
//            for (String person : contacts) {
//                System.out.println(contacts);
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
