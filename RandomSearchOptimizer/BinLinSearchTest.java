import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


 /**
     * Main method to run the test program.
     * @param args Command-line arguments (not used).
     */
public class lab3BinLinSearchTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryLinearSearch search = new BinaryLinearSearch();
        int[] randomArr = null;
        long startTime, endTime, duration;

        while (true) {
            System.out.println("1. Initialize and populate an array of 32 random integers.");
            System.out.println("2. Perform recursive binary and linear search");
            System.out.println("3. Perform iterative binary and linear search");
            System.out.println("4. Exit.");
            System.out.print("> ");

            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        randomArr = search.generateRandomInts();
                        System.out.println("Array of randomly generated integers: ");
                        //System.out.println("Unsorted array: " + Arrays.toString(randomArr));
                       // Arrays.sort(randomArr);
                        System.out.println("Sorted array: " + Arrays.toString(randomArr));
                        break;

                    case 2:
                        if (randomArr == null) {
                            System.out.println("Please initialize array first.");
                            break;
                        }

                        performSearch(input, search, randomArr, true);
                        break;

                    case 3:
                        if (randomArr == null) {
                            System.out.println("Please initialize array first.");
                            break;
                        }

                        performSearch(input, search, randomArr, false);
                        break;

                    case 4:
                        System.out.println("Exiting..");
                        System.exit(0);

                    default:
                        System.out.println("Invalid option. Please choose an option between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("*****Input Mismatch Exception*****");
                input.next(); // Consume the invalid input
            }
        }
    }

     /**
     * Performs binary or linear search based on the user's choice.
     * @param input Scanner object for user input.
     * @param search BinaryLinearSearch object for performing searches.
     * @param randomArr Array of random integers.
     * @param isRecursive Flag indicating whether to perform recursive search.
     */
    private static void performSearch(Scanner input, BinaryLinearSearch search, int[] randomArr, boolean isRecursive) {
        System.out.println("Please enter an integer value to search: ");
        int key;
        try {
            key = input.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            input.nextLine(); // Clear the buffer
            return;
        }
    
        long startTime, endTime, duration; // Declaration of timing variables
    
        startTime = System.nanoTime(); // Start timing
    
        int result;
        if (isRecursive) {
            result = search.recursiveBinarySearch(randomArr, 0, randomArr.length - 1, key);
        } else {
            result = search.iterativeBinarySearch(randomArr, key);
        }
    
        endTime = System.nanoTime(); // End timing
        duration = (endTime - startTime); // Calculate duration
    
        System.out.println(Arrays.toString(randomArr));
        System.out.println("Time taken in nanoseconds: " + duration);
        System.out.println("Time taken in milliseconds: " + (duration / 1_000_000));
    
        startTime = System.nanoTime(); // Start timing again
    
        if (isRecursive) {
            result = search.recursiveLinearSearch(randomArr, 0, key, 0);
        } else {
            result = search.iterativeLinearSearch(randomArr, key);
        }
    
        endTime = System.nanoTime(); // End timing again
        duration = (endTime - startTime); // Calculate duration again
    
        if (result != -1) {
            System.out.println(key + " was found at index position " + result + ": "
                    + (isRecursive ? "recursive" : "iterative") + " Linear search");
    
        } else {
            System.out.println(key + " was not found: " + (isRecursive ? "recursive" : "iterative") + " Linear Search");
        }
    
        System.out.println("Time taken in nanoseconds: " + duration);
        System.out.println("Time taken in milliseconds: " + (duration / 1_000_000));
    }
}    
