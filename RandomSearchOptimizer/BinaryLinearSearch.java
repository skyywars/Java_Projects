import java.security.SecureRandom;
import java.util.Arrays;



class BinaryLinearSearch {
    private int[] randomArr;


     /**
     * Generates an array of random integers between 11 and 100 (inclusive),
     * sorts it, and returns the sorted array.
     * @return The array of sorted random integers.
     */
    public int[] generateRandomInts() {
        SecureRandom random = new SecureRandom();
        randomArr = random.ints(32, 11, 101).sorted().toArray();
        return randomArr;
    }

    /**
     * Displays the remaining elements in the array between the specified indices.
     * @param arr The array of integers.
     * @param left The left index.
     * @param right The right index.
     */
    public void remainingElements(int[] arr, int left, int right) {
        Arrays.stream(arr, left, right ).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

     /**
     * Performs an iterative binary search on the sorted array.
     * @param arr The sorted array.
     * @param key The value to search for.
     * @return The index of the key if found, otherwise -1.
     */
    public int iterativeBinarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        int count = 0;
        while (Math.pow(arr.length, 2) > count * count) {
            int mid = (left + right) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key) {
                left = mid + 1;
                count++;
            } else {
                right = mid - 1;
                count++;
            }
        }
        return -1;
    }

     /**
     * Performs a recursive binary search on the sorted array.
     * @param arr The sorted array.
     * @param left The left index of the subarray.
     * @param right The right index of the subarray.
     * @param key The value to search for.
     * @return The index of the key if found, otherwise -1.
     */
    public int recursiveBinarySearch(int[] arr, int left, int right, int key) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                return recursiveBinarySearch(arr, mid + 1, right, key);
            else
                return recursiveBinarySearch(arr, left, mid - 1, key);
        }
        return -1;
    }

    /**
     * Performs an iterative linear search on the array.
     * @param arr The array of integers.
     * @param key The value to search for.
     * @return The index of the key if found, otherwise -1.
     */
    public int iterativeLinearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    
    /**
     * Performs a recursive linear search on the array.
     * @param arr The array of integers.
     * @param index The current index.
     * @param key The value to search for.
     * @param count The current count of iterations.
     * @return The index of the key if found, otherwise -1.
     */
    public int recursiveLinearSearch(int[] arr, int index, int key, int count) {
        if (index >= arr.length || Math.pow(arr.length, 2) <= count * count)
            return -1;
        else if (arr[index] == key) {
            System.out.println(key + " was found at index position " + index + " : recursive linear Search");
            return index;
        } else {
            return recursiveLinearSearch(arr, index + 1, key, count + 1);
        }
    }
}
