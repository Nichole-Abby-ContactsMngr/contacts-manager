import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {



    public static void main(String[] args) {
        System.out.println("*****Welcome to Contacts Manager*****");
        System.out.println("1. View Contacts - 2. Add Contact - 3. Search Contact - 4. Delete - 5. Exit");
        System.out.println("----------------------------------------------------------------------------");

//        Input userResponse = new Input();
//        userResponse.getString("Enter an option 1, 2, 3, 4 or 5: ");

        String userInput;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an option: ");
        userInput = sc.nextLine();
        System.out.println("You entered: --> \"" + userInput + "\" <--");


        Path contactsPath = Paths.get("data", "contacts.txt");

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