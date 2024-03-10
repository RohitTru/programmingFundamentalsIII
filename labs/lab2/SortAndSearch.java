package labs.lab2;
import java.util.Scanner;

public class SortAndSearch {
    // Array to store the integer data
    private static int[] integerData;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Code to use scanner from java

        int sortingOrder;
        do {
            System.out.println("Enter the order (0 for ascending, 1 for descending):");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter 0 for ascending or 1 for descending:");
                scanner.next();
            }
            sortingOrder = scanner.nextInt();
        } while (sortingOrder != 0 && sortingOrder != 1); // This loop continues prompting the user for input until the input is either 0 or 1, ensuring only valid values are accepted for sorting order.


        // Initialize array to store integer data
        integerData = new int[5]; // creates an array that has enough memory to hold 5 int values

        // Prompt user to enter 5 integer data
        System.out.println("Enter 5 integer data:");
        for (int i = 0; i < 5; i++) {
            integerData[i] = scanner.nextInt();
        }

        // Sort the data according to the user's choice
        if (sortingOrder == 0) {
            quickSortAscending(0, integerData.length - 1);
        } else {
            quickSortDescending(0, integerData.length - 1);
        }

        // Display sorted data
        displaySortedData();

        // Prompt user to enter an item to search for
        System.out.println("Enter an item to search for (or enter -1 to exit):");
        int searchItem = scanner.nextInt();
        while (searchItem != -1) {
            // Perform binary search to find the item
            if (binarySearch(searchItem)) {
                System.out.println("Present");
            } else {
                System.out.println("Absent");
            }
            // Prompt user to enter another item to search for or -1 to exit
            System.out.println("Enter an item to search for (or enter -1 to exit):");
            searchItem = scanner.nextInt();
        }
    }

    // Method to display sorted data
    private static void displaySortedData() {
        System.out.println("Sorted Data:");
        for (int i = 0; i < integerData.length; i++) {
            System.out.print(integerData[i] + " ");
        }
        System.out.println();
    }

    // Quicksort algorithm for ascending order
    private static void quickSortAscending(int low, int high) {
        if (low < high) {
            int partitionIndex = partitionAscending(low, high);

            quickSortAscending(low, partitionIndex - 1);
            quickSortAscending(partitionIndex + 1, high);
        }
    }

    // Quicksort algorithm for descending order
    private static void quickSortDescending(int low, int high) {
        if (low < high) {
            int partitionIndex = partitionDescending(low, high);

            quickSortDescending(low, partitionIndex - 1);
            quickSortDescending(partitionIndex + 1, high);
        }
    }

    // Partition function for quicksort in ascending order
    private static int partitionAscending(int low, int high) {
        // Select the pivot element (here, we choose the last element of the array as the pivot)
        int pivot = integerData[high];

        // Initialize the index of the smaller element
        int i = (low - 1);

        // Traverse through all elements of the array
        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (integerData[j] < pivot) {
                // Increment the index of the smaller element
                i++;

                // Swap the current element with the element at the index of the smaller element
                int temp = integerData[i];
                integerData[i] = integerData[j];
                integerData[j] = temp;
            }
        }

        // After traversing, swap the pivot element with the element at the index of the smaller element + 1
        // This places the pivot element in its correct position in the sorted array
        int temp = integerData[i + 1];
        integerData[i + 1] = integerData[high];
        integerData[high] = temp;

        // Return the index of the pivot element after partitioning
        return i + 1;
    }

    // Partition function for quicksort in descending order
    private static int partitionDescending(int low, int high) {
        int pivot = integerData[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (integerData[j] > pivot) {
                i++;

                // Swap elements
                int temp = integerData[i];
                integerData[i] = integerData[j];
                integerData[j] = temp;
            }
        }

        // Swap pivot element with element at i+1 position
        int temp = integerData[i + 1];
        integerData[i + 1] = integerData[high];
        integerData[high] = temp;

        return i + 1;
    }

    // Binary search algorithm
    private static boolean binarySearch(int searchItem) {
        // Initialize left and right pointers
        int leftIndex = 0;
        int rightIndex = integerData.length - 1;

        // Continue searching while left pointer is less than or equal to right pointer
        while (leftIndex <= rightIndex) {
            // Calculate the middle index
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            // If the searchItem is present at the middle, return true
            if (integerData[middleIndex] == searchItem) {
                return true;
            }

            // If searchItem is greater than the value at the middle index, ignore the left half
            if (integerData[middleIndex] < searchItem) {
                leftIndex = middleIndex + 1;
            }
            // If searchItem is smaller than the value at the middle index, ignore the right half
            else {
                rightIndex = middleIndex - 1;
            }
        }
        // If searchItem is not present in the array, return false
        return false;
    }
}
