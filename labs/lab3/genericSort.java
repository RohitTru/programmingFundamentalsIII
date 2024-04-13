import java.util.Scanner;

public class genericSort<T extends Comparable<? super T>> {

    private T[] genericArray;

    // Constructor to set up the class with an array
    genericSort(T[] array) {
        this.genericArray = array;
    }

    // Method to sort the array using the bubble sort algorithm
    public void bubbleSort() {
        for (int i = genericArray.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (genericArray[j].compareTo(genericArray[j + 1]) > 0) {
                    // Swap elements if they are out of order
                    T temp = genericArray[j];
                    genericArray[j] = genericArray[j + 1];
                    genericArray[j + 1] = temp;
                }
            }
        }
    }

    // Method to check if a given string is a palindrome
    public boolean isPalindrome(String str) {
        return isPalindromeRecursive(str, 0, str.length() - 1);
    }

    // Recursive method to check if a string is a palindrome
    private boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            // Base case: if the start index is greater than or equal to the end index, it's a palindrome
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            // If characters at start and end indexes don't match, it's not a palindrome
            return false;
        }
        // Recursively check characters towards the middle of the string
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // Method to display the sorted array and identify palindromes if any
    public void display() {
        System.out.println("The sorted array is:");
        for (int i = 0; i < genericArray.length; i++) {
            System.out.print(genericArray[i] + " ");
            if (genericArray[i] instanceof String && isPalindrome((String) genericArray[i])) {
                // If the element is a string and a palindrome, mark it
                System.out.print("(Palindrome) ");
            }
        }
    }

    // Main method to run the program
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("0 – for integers \n1 – for floats \n2 - for strings");
        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 0) {
            // If the user chooses integers
            Integer[] intArray = new Integer[5];
            System.out.println("Enter 5 integer values:");
            for (int i = 0; i < intArray.length; i++) {
                // Take input from the user and store it in the integer array
                intArray[i] = scanner.nextInt();
            }
            // Create an object of the GenericSort class for integers and perform sorting
            genericSort<Integer> genericSortInteger = new genericSort<>(intArray);
            genericSortInteger.bubbleSort();
            // Display the sorted array
            genericSortInteger.display();
        } else if (choice == 1) {
            // If the user chooses floats
            Float[] floatArray = new Float[5];
            System.out.println("Enter 5 float values:");
            for (int i = 0; i < floatArray.length; i++) {
                // Take input from the user and store it in the float array
                floatArray[i] = scanner.nextFloat();
            }
            // Create an object of the GenericSort class for floats and perform sorting
            genericSort<Float> genericSortFloat = new genericSort<>(floatArray);
            genericSortFloat.bubbleSort();
            // Display the sorted array
            genericSortFloat.display();
        } else {
            // If the user chooses strings
            String[] stringArray = new String[5];
            System.out.println("Enter 5 string values:");
            for (int i = 0; i < stringArray.length; i++) {
                // Take input from the user and store it in the string array
                stringArray[i] = scanner.next();
            }
            // Create an object of the GenericSort class for strings and perform sorting
            genericSort<String> genericSortString = new genericSort<>(stringArray);
            genericSortString.bubbleSort();
            // Display the sorted array
            genericSortString.display();
        }
        scanner.close(); 
    }
}
