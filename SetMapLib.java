import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Professor: James Mwangi PhD
 * 
 * 
 * Student Name: Sansita Pattnaik
 * Student ID: 041094310
 * Program: Computing Engineering Technology 
 * Course: Data structures 
 * Lab Section: 302
 * lab6
 * 
 */
/**
 * The SetMapLib class contains various methods to perform operations on TreeMap
 * and TreeSet data structures.
 */
public class SetMapLib {
    
    /** TreeMap to store product owners' data*/
    private TreeMap<Integer, String> productOwners = new TreeMap<>();

    /**
     * Displays the menu options for interacting with the TreeMap and TreeSet.
     */
    // Task 1: Display the menu
    public void displayMenu() {
        // Print menu options
        System.out.println("1. Create a TreeMap of data from the text file.");
        System.out.println("2. Display the TreeMap.");
        System.out.println("3. Search for a given key or value in the TreeMap.");
        System.out.println("4. Create and display a keys TreeSet and a values TreeSet from the TreeMap.");
        System.out.println("5. Sort and display values TreeSet in descending order.");
        System.out.println("6. Add new key-value data to the TreeMap.");
        System.out.println("7. Exit");
    }

    /**
     * Reads data from a text file and creates a TreeMap.
     */
    // Task 2: Create a TreeMap from file
    public void createTreeMapFromFile() {
        try {
            Scanner scanner = new Scanner(new File("productowners.txt"));                   // Create a scanner to read from the file
            while (scanner.hasNextLine()) {                                                 // Read data line by line
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                productOwners.put(Integer.parseInt(parts[1].trim()), parts[0].trim());         // Parse the key and value, then add to the TreeMap
            }
            scanner.close();
            System.out.println("\n...TreeMap created...\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * Displays the contents of the TreeMap.
     */
    // Task 3: Display TreeMap
    public void displayTreeMap() {
        // Print the contents of the TreeMap
        System.out.println("\nTreeMap Contents:\n");
        System.out.println(productOwners);
    }


    /**
     * Searches for a given key in the TreeMap.
     * 
     * @param key The key to search for.
     */
    // Task 4: Search for key or value
    public void searchKeyOrValue(int key) {                                // Check if the key exists in the TreeMap
        if (productOwners.containsKey(key)) {
            System.out.println("Key " + key + " was found.");                    // Notify the user if the key is found
        } else {
            System.out.println("Key " + key + " not found.");
        }
    }

    /**
     * Creates and displays TreeSet of keys and values from the TreeMap.
     */
    // Task 5: Create and display keys and values TreeSet
    public void displayTreeSet() {
        TreeSet<Integer> keysSet = new TreeSet<>(productOwners.keySet());             // Create a TreeSet of keys
        TreeSet<String> valuesSet = new TreeSet<>(productOwners.values());            // Create a TreeSet of values
        System.out.println("Keys TreeSet: " + keysSet);                              // Print the TreeSet of keys
        System.out.println("Names TreeSet: " + valuesSet);                            // Print the TreeSet of values
    }

    /**
     * Adds new key-value data to the TreeMap.
     * 
     * @param name The name to be added.
     * @param key  The key associated with the name.
     */
    // Task 6: Add new key-value data
    public void addNewData(String name, int key) {
        productOwners.put(key, name);                                                         // Add the new key-value pair to the TreeMap
        System.out.println("New data added successfully.");                                  // Notify the user that new data is added successfully
    }

    /**
     * Sorts the names TreeSet in descending order.
     */
    // Task 7: Sort names TreeSet in descending order
    public void sortNamesDescending() {
        // Define a comparator to sort strings in descending order of their lengths
        Comparator<String> descendingLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        };

        // Create a TreeSet with the custom comparator for descending order of lengths
        TreeSet<String> descendingNamesSet = new TreeSet<>(descendingLengthComparator);

        // Add all values from the TreeMap to the TreeSet
        descendingNamesSet.addAll(productOwners.values());

        // Print the TreeSet
        System.out.println("Names TreeSet was sorted in descending order: " + descendingNamesSet);
    }
}
