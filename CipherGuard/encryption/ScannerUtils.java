/*

 * ScannerUtils

 * Student Name: Sansita Pattnaik

 * Student Number: 041094310

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor: Daniel Cormier

 *

 */
package encryption;
import java.util.*;

/**
 * Author:Sansita Pattnaik
 * ScannerUtils class provides utility methods for user input using the Scanner class.
 */
public class ScannerUtils {
	
	private static final Scanner input = new Scanner(System.in);
    
	/**
	 * Author:Sansita Pattnaik
     * Displays a menu with the given options and prompts the user to choose an option.
     *
     * @param options The list of options to display in the menu.
     * @return The user's selected menu option as an integer.
     */
	public static int getMenuItem(String... options)  {
        int choice = -1;
        boolean choiceInput = false;

        while (!choiceInput) {
            for (int i = 0; i < options.length; i++) {
                System.out.println("\t" + (i + 1) + " - " + options[i]);
            }
            System.out.print("Please select an option: ");
            String inputStr = input.nextLine();
            try {
                choice = Integer.parseInt(inputStr);
                if (choice >= 1 && choice <= options.length) {
                    choiceInput = true;
                } else {
                    System.out.println("\nPlease select a number in the range");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter an integer");
            }
        }
        return choice; // Returns user's choice
    }
    
	/**
	 * Author:Sansita Pattnaik
     * Prompts the user for a string input with the given prompt and returns the entered string.
     *
     * @param prompt The prompt message to display before accepting the input.
     * @return The string entered by the user.
     */
    public static String getString(String prompt) {
        System.out.print(prompt + ": ");
        return input.nextLine();
    }
    
    /**
     * Author:Sansita Pattnaik
     * Prompts the user for an integer input within a specified range and returns the entered integer.
     *
     * @param prompt The prompt message to display before accepting the input.
     * @param min    The minimum allowed value for the integer.
     * @param max    The maximum allowed value for the integer.
     * @return The integer entered by the user within the specified range.
     */
    public static int getInt(String prompt, int min, int max) {
        int value = min - 1;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt + " ");
            try {
                value = Integer.parseInt(input.nextLine());
                if (! (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE)) {
                	System.out.println("Please select a number in the range");
                }else {
                	validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer");
            }
        }
        return value;
    }
}
