import util.*;

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
        int userChoice;

        writeContactsToFile();

        contacts = readAllContacts();


        do {
            showMenu();
            System.out.println("Enter an option: ");
            userChoice = input.getInt(1, 5);

            if (userChoice == 1) {
                showAll(contacts);
            } else if (userChoice == 2) {
                addContact(contacts);
            } else if (userChoice == 3) {
                searchContact(contacts);
            } else if (userChoice == 4) {
                deleteContact(contacts);
            }

            System.out.println();

        } while (!(userChoice == 5));
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
            contactsStrings.add("Another name,9154715340");
            contactsStrings.add("Some Else,2543689782");
            contactsStrings.add("Mickey Mouse,2019135865");
            //having append here adds to our file instead of overriding it
//        Files.write(dataFile, contactsStrings, StandardOpenOption.APPEND);
            try {
                Files.write(dataFile, contactsStrings);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static List<Contacts> readAllContacts() {
        String directory = "data";
        String filename = "contacts.txt";
        Path dataFile = Paths.get(directory, filename);
        List<String> contactsStrings = new ArrayList<>();
        List<Contacts> listOfContacts = new ArrayList<>();
        String name, phoneNumber;

        try {
            contactsStrings = Files.readAllLines(dataFile);

//            enhanced for loop to iterate our list of strings
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

        int width = 20;

        System.out.printf("%-" + width + "s| ", "Name");
        System.out.printf("%-" + width + "s|%n ", "Phone number");
        System.out.println("------------------------------------------");

        for (Contacts contact : contacts) {
            System.out.printf("%-" + width + "s| ", contact.getName());
            System.out.printf("(" + contact.getPhoneNumber().substring(0, 3) + ")");
            System.out.printf(contact.getPhoneNumber().substring(3, 6));
            System.out.printf("-" + contact.getPhoneNumber().substring(6));
            System.out.printf("       |\n");
        }
    }

    public static void addContact(List<Contacts> contacts) {
        System.out.println("Enter contact's name.");
        Input input = new Input();
        String nameInput = input.getString();
        String phoneNumberInput = input.getString("Enter contact's phone number.");
        Contacts contactToAdd = new Contacts(nameInput, phoneNumberInput);
        contacts.add(contactToAdd);
        System.out.println("Contact added.");
    }

    public static void deleteContact(List<Contacts> contacts) {
        System.out.println("Enter contact's name to delete");
        Input input = new Input();
        String nameInput = input.getString();
        boolean found = false;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(nameInput)) {
                System.out.println("Contact Removed");
                contacts.remove(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
            found = false;
        }
    }


    public static void searchContact(List<Contacts> contacts) {

        System.out.println("Enter contact's name to search");
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
            System.out.println("Contact not found.");
            found = false;
        }
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








//
//
////method to show menu do while loop. always going to show unless user wants to exit
//
//
////        Input userResponse = new Input();
////        userResponse.getString("Enter an option 1, 2, 3, 4 or 5: ");
//    public static void showMenu() {
//        System.out.println("1. View Contacts");
//        System.out.println("2. Add Contact");
//        System.out.println("3. Search Contact");
//        System.out.println("4. Delete");
//        System.out.println("5. Exit");
//
//
//    }
//
//    Path contactsPath = Paths.get("data", "contacts.txt");
//
//    //psvm then do while loop for all methods
//    //here write main method for public static void showMenu(), then showAll contacts, addContact, searchContact, deleteContact, exit
//
//    public static void writeContactsToFile() throws IOException {
//        String directory = "data";
//        String filename = "contacts.txt";
//        Path dataDirectory = Paths.get(directory);
//        Path dataFile = Paths.get(directory, filename);
//
//        if (Files.notExists(dataDirectory)) {
//            Files.createDirectories(dataDirectory);
//        }
//
//        if (!Files.exists(dataFile)) {
//            Files.createFile(dataFile);
//        }
//
//        ArrayList<String> contacts = new ArrayList<>();
//        contacts.add("Amy, 222-222-2222");
//        contacts.add("Bill, 444-444-4444");
//        contacts.add("Carl, 888-888-8888");
//
//        Files.write(dataFile, contacts);
//    }
//
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
//}
