import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class contactsapp {

    public static void main(String[] args) {
        System.out.println("*****Welcome to Contacts Manager*****");
        System.out.println("[Main Menu] Press: A Add Contact - S Search Contact - D Delete");
    }

        public static void contactsToFile() throws IOException {
            String directory = "contacts-manager";
            String filename = "contacts.txt";
            Path dataDirectory = Paths.get(directory);
            Path dataFile = Paths.get(directory, filename);

            if (Files.notExists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
            }

            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
            }

        }

    }


