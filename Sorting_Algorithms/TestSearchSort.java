import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

class TestSearchSort {
    
    public static void main(String[] args) {
        // Main method
        Scanner scanner = new Scanner(System.in);
        Integer[] randomArr = genRandomInts(1000,120,1000);
        SortingAlgorithms<Integer> sorter = new SortingAlgorithms<>();
        long start, end, duration;
        
        while (true) {
            System.out.println("Select your option in the menu below:");
            System.out.println("1: Initialize and populate an array of 1000 random integers.");
            System.out.println("2: Perform a recursive binary search.");
            System.out.println("3: Perform recursive linear search.");
            System.out.println("4: Sort the array.");
            System.out.println("5: Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Array initialized and populated.");
                    System.out.println(Arrays.toString(randomArr));
                    break;
                case 2:
                    // Perform binary search
                    System.out.print("Enter the element to search: ");
                    int key = scanner.nextInt();
                    start = System.nanoTime();
                    Arrays.sort(randomArr);
                    int index = new Searching<Integer>().binarySearch(randomArr, key, 0, randomArr.length - 1);
                    end = System.nanoTime();
                    duration = end - start;
                    if (index != -1) {
                        System.out.println("Element found at index " + index);
                    } else {
                        System.out.println("Element not found in the array.");
                    }
                    System.out.println("Time taken in nanoseconds: " + duration );
                    System.out.println("Time taken in milliseconds: " + duration / 1000000);
                    break;
                case 3:
                    // Perform linear search
                    System.out.print("Enter the element to search: ");
                    int linearKey = scanner.nextInt();
                    start = System.nanoTime();
                    int linearIndex = new Searching<Integer>().linearSearch(randomArr, linearKey, 0);
                    end = System.nanoTime();
                    duration = end - start;
                    if (linearIndex != -1) {
                        System.out.println("Element found at index " + linearIndex);
                    } else {
                        System.out.println("Element not found in the array.");
                    }
                    System.out.println("Time taken in nanoseconds: " + duration);
                    System.out.println("Time taken in milliseconds: " + duration / 1000000);
                    break;
                case 4:
                    displaySortingMenu(randomArr, scanner, sorter);
                    break;
                case 5:
                    scanner.close();
                    System.out.println("Exiting program...");
                    System.exit(0);
            
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
                }

        }   
    }
    
    private static void displaySortingMenu(Integer[] randomArr, Scanner scanner, SortingAlgorithms<Integer> sorter) {
        long start, end, duration;
        while (true) {
            System.out.println("Select a sort option:");
            System.out.println("B. Bubble Sort");
            System.out.println("I. Insertion Sort");
            System.out.println("S. Selection Sort");
            System.out.println("M. Merge Sort");
            System.out.println("Q. Quick Sort");
            System.out.println("R. Return to main menu");
            System.out.print("Enter your choice: ");
            char sortOption = scanner.next().charAt(0);

            switch (Character.toUpperCase(sortOption)) {
                case 'B':
                    Integer[] bubbleArray = randomArr.clone();
                    start = System.nanoTime();
                    sorter.bubbleSort(bubbleArray);
                    end = System.nanoTime();
                    duration = end - start;
                    System.out.println("Bubble Sort: Simple sorting algorithm   O(n2) Complexity   -");
                    System.out.println("Sorted: " + Arrays.toString(bubbleArray));
                    System.out.println("Time taken in nanoseconds: " + duration);
                    System.out.println("Time taken in miliseconds: " + duration / 1000000);
                    break;
                case 'I':
                    Integer[] insertArray = randomArr.clone();
                    start = System.nanoTime();
                    sorter.insertionSort(insertArray);
                    end = System.nanoTime();
                    duration = end - start;
                    System.out.println("Insertion Sort: Simple sorting algorithm   O(n2) Complexity  -  ");
                    System.out.println("Sorted: " + Arrays.toString(insertArray));
                    System.out.println("Time taken in nanoseconds: " + duration );
                    System.out.println("Time taken in miliseconds: " + duration / 1000000 );
                    break;
                case 'S':
                    Integer[] selectArray = randomArr.clone();
                    start = System.nanoTime();
                    sorter.selectionSort(selectArray);
                    end = System.nanoTime();
                    duration = end - start;
                    System.out.println("Selection Sort:");
                    System.out.println("Sorted: " + Arrays.toString(selectArray));
                    System.out.println("Time taken in nanoseconds: " + duration);
                    System.out.println("Time taken in miliseconds: " + duration / 1000000);
                    break;
                case 'M':
                    Integer[] mergeArray = randomArr.clone();
                    start = System.nanoTime();
                    sorter.mergeSort(mergeArray);
                    end = System.nanoTime();
                    duration = end - start;
                    System.out.println("Merge Sort: Recursive Divide-And-Conquer   O(n log n) Complexity -");
                    System.out.println("Sorted: " + Arrays.toString(mergeArray));
                    System.out.println("Time taken in nanoseconds: " + duration);
                    System.out.println("Time taken in miliseconds: " + duration / 1000000 );
                    break;
                case 'Q':
                    Integer[] quickArray = randomArr.clone();
                    start = System.nanoTime();
                    sorter.quickSort(quickArray);
                    end = System.nanoTime();
                    duration = end - start;
                    System.out.println("Quick Sort:Recursive Divide-And-Conquer   O(n log n) Complexity -");
                    System.out.println("Sorted: " + Arrays.toString(quickArray));
                    System.out.println("Time taken in nanoseconds: " + duration);
                    System.out.println("Time taken in miliseconds: " + duration / 1000000);
                    break;
                case 'R':
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            } 
        }
        
        
    }
    
    private static Integer[] genRandomInts(int size, int min, int max) {
        Integer[] randomArr = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            randomArr[i] = random.nextInt(max - min) + min;
        }
        return randomArr;
    }
}
