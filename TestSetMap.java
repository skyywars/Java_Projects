// TestSetMap.java
import java.util.Scanner;

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
 * The TestSetMap class provides a simple command-line interface to interact with
 * the SetMapLib class functionalities.
 */
public class TestSetMap {

 /**
     * Main method to run the program.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        SetMapLib setMapLib = new SetMapLib();                               // Create an instance of SetMapLib to access its methods
        Scanner scanner = new Scanner(System.in);                            // Create a scanner object to read user input
        int choice;                                                          // Variable to hold the user's choice from the menu


        // Start a loop to continuously display the menu and get user input until the user chooses to exit
        do {                                          
            setMapLib.displayMenu();                                          // Display the menu options
            System.out.print("Enter your choice: ");                        // Prompt the user to enter their choice
            choice = scanner.nextInt();                                        // Read the user's choice
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                // Create TreeMap from file
                    setMapLib.createTreeMapFromFile();
                    break;
                case 2:
                // Display the contents of the TreeMap
                    setMapLib.displayTreeMap();
                    break;
                case 3:
                 // Search for a key in the TreeMap
                    System.out.print("Enter key to search: ");
                    int keyToSearch = scanner.nextInt();
                    setMapLib.searchKeyOrValue(keyToSearch);
                    break;
                case 4:
                // Display TreeSet of keys and values from the TreeMap
                    setMapLib.displayTreeSet();
                    break;
                case 5:
                // Sort names TreeSet in descending order
                    setMapLib.sortNamesDescending();
                    break;
                case 6:
                // Add new key-value data to the TreeMap
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new key: ");
                    int newKey = scanner.nextInt();
                    setMapLib.addNewData(newName, newKey);
                    break;
                case 7:
                 // Exit the program
                    System.out.println("...exiting...");
                    break;
                default:
                 // Inform the user of an invalid choice
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        // Close the scanner
        scanner.close();
    }
}
