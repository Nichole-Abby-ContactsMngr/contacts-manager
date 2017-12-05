import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class contactsapp {

    public static void main(String[] args) {
        System.out.println("*****Welcome to Contacts Manager*****");
        System.out.println("[Main Menu] Press: A Add Contact - S Search Contact - D Delete");

        Input userResponse = new Input();
        userResponse.getString("Enter a phone number");


        try {
            writeContactsToFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("IO Exception, fix your stuff!");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            System.out.println("Something went wrong!");
        }

        readAllContacts();
    }

    public static void writeContactsToFile() throws IOException {
        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        ArrayList<String> contacts = new ArrayList<>();
//        contacts.add();

        Files.write(dataFile, contacts, StandardOpenOption.APPEND);
    }

    public static void readAllContacts() {
        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        List<String> contacts;

        try {
            contacts = Files.readAllLines(dataFile);
            for(String contact : contacts) {
                System.out.println(contacts);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}