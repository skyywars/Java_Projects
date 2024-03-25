class Searching<T extends Comparable<T>> {

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

    public int binarySearch(T[] arr, T key, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
    
            // If the element is present at the middle itself
            if (arr[mid].compareTo(key) == 0)
                return mid;
            else if (arr[mid].compareTo(key) < 0) { // Check if arr[mid] is less than key
                return binarySearch(arr, key, mid + 1, right);
            } else {
                return binarySearch(arr, key, left, mid - 1);
            }
        }
    
        // We reach here when the element is not present in the array
        return -1;
    }
    

    public int linearSearch(T[] arr, T key, int index) {
        if (index >= arr.length)
            return -1;
        if (arr[index].equals(key))
            return index;
        return linearSearch(arr, key, index + 1);
    }
}
