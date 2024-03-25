package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import postalCode.PostalCodeEntry;

/**
 * Main class for testing postal code search functionality.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class PostalCodeSearchTest {

    /**
     * Main method which opens and reads a CSV file of Canadian postal codes, stores them in a Map,
     * and tests the Map by retrieving elements using random prefixes.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
                                                                         // Define the filename of the CSV file
        Path file = Paths.get("ottawa_postal_codes.csv");

                                                                         // Initialize a Map to store postal code entries
        Map<String, PostalCodeEntry> postalCodeMap = new HashMap<>();

        // Read the CSV file and populate the Map
        try (BufferedReader input = Files.newBufferedReader(file)) {
            String line;
            while ((line = input.readLine()) != null) {
                                                                          // Split line by comma (CSV format)
                String[] parts = line.split(",");
                                                                         // Created PostalCodeEntry object from the line
                PostalCodeEntry postalCodeEntry = new PostalCodeEntry(parts);
                                                                           // Use prefix as the key and put the entry into the Map
                postalCodeMap.put(postalCodeEntry.getPrefix(), postalCodeEntry);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // Test the Map by retrieving elements using random prefixes
        System.out.println("Testing Map:");
        for (int i = 0; i < 10; i++) {
                                                                       // Generate a random prefix
            String randomPrefix = PostalCodeEntry.getRandomPrefix();
                                                                         // Retrieve the PostalCodeEntry associated with the random prefix from the Map
            PostalCodeEntry entry = postalCodeMap.get(randomPrefix);
                                                                          // Print the retrieval with the result
            System.out.printf("Retrieving: %s - \n%s%n\n", randomPrefix, entry != null ? entry : "        NOT FOUND");
        }
    }
}