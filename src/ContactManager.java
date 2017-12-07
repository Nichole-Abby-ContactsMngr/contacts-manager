import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    public static void main(String[] args) {
        System.out.println("*****Welcome to Contacts Manager*****");
//        System.out.println("1. View Contacts - 2. Add Contact - 3. Search Contact - 4. Delete - 5. Exit");
        System.out.println("----------------------------------------------------------------------------");

        List<Contacts> contacts = new ArrayList<>();
        Input input = new Input();
        int userInput;
        writeContactsToFile();
        contacts = viewAllContacts();

        do {
            showMenu();
            System.out.println("Enter an option: ");
            userInput = input.getInt(1, 5);

            if (userInput == 1) {
                showAll(contacts);
            } else if (userInput == 2) {
                addContact(contacts);
            } else if (userInput == 3) {
                searchContact(contacts);
//            } else if (userInput == 4) {
//                deleteContact(contacts);
            }

            System.out.println();

        } while (!(userInput == 5));
        updateFile(contacts);
        System.out.println("Laterzzz");
    }

    public static void writeContactsToFile() {
        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        List<String> contactsStrings = new ArrayList<>();

        if (Files.notExists(dataDirectory)) {
            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!Files.exists(dataFile)) {
            try {
                Files.createFile(dataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            contactsStrings = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (contactsStrings.size() == 0) {
            contactsStrings.add("Amy B, 123-123-1234");
            contactsStrings.add("Billy C, 234-234-2345");
            contactsStrings.add("Chris D 345-345-3456");
            contactsStrings.add("Diana E, 456-456-4567");
            //having append here adds to our file instead of overriding it
//        Files.write(dataFile, contactsStrings, StandardOpenOption.APPEND);
            try {
                Files.write(dataFile, contactsStrings);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Contacts> viewAllContacts() {
        String directory = "data";
        String filename = "contacts.txt";
        Path dataFile = Paths.get(directory, filename);
        List<String> contactsStrings = new ArrayList<>();
        List<Contacts> listOfContacts = new ArrayList<>();
        String name, phoneNumber;

        try {
            contactsStrings = Files.readAllLines(dataFile);

            for (String person : contactsStrings) {
                name = person.substring(0, person.indexOf(","));
                phoneNumber = person.substring(person.indexOf(",") + 1);
                Contacts contactObject = new Contacts(name, phoneNumber);
                listOfContacts.add(contactObject);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listOfContacts;
    }


    public static void showMenu() {
        System.out.println("1. View Contacts - 2. Add Contact - 3. Search Contact - 4. Delete - 5. Exit");
    }

    public static void showAll(List<Contacts> contacts) {

        System.out.printf("Name");
        System.out.printf("Phone number");

        for (Contacts contact : contacts) {
            System.out.printf(contact.getName());
            System.out.printf(contact.getPhoneNumber().substring(0, 3));
            System.out.printf(contact.getPhoneNumber().substring(3, 6));
            System.out.printf(contact.getPhoneNumber().substring(6));
        }
    }

    public static void searchContact(List<Contacts> contacts) {

        System.out.println("Enter the name to search");
        Input input = new Input();
        String nameInput = input.getString();
        boolean found = false;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(nameInput)) {
                System.out.println(contacts.get(i).getName());
                System.out.println(contacts.get(i).getPhoneNumber());
                found = true;
            }
        }
        if (!found) {
            System.out.println("That contact doesn't exist");
            found = false;
        }
    }

    public static void addContact(List<Contacts> contacts) {
        System.out.println("Enter contact's name");
        Input input = new Input();
        String nameInput = input.getString();
        String phoneNumberInput = input.getString("Enter the contact's phone number");
        Contacts contactToAdd = new Contacts(nameInput, phoneNumberInput);
        contacts.add(contactToAdd);
        System.out.println("Contact added!");
    }


    public static void updateFile(List<Contacts> contacts) {

        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!Files.exists(dataFile)) {
            try {
                Files.createFile(dataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<String> contactsStrings = new ArrayList<>();

        for (int i = 0; i < contacts.size(); i++) {
            String outputString = contacts.get(i).getName() + "," + contacts.get(i).getPhoneNumber();
            contactsStrings.add(outputString);
        }
        try {
            Files.write(dataFile, contactsStrings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}