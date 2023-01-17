package Recursion_1;

import java.util.*;

public class reverseAnArray {
    // ? 1. You are given a number n, representing the size of array a.
    // ? 2. You are given n numbers, representing elements of array a.
    // ? 3. You are required to print the elements of array from end to beginning
    // ? each in a separate line.
    // ?4. For the above purpose complete the body of displayArrReverse function.

    // Example
    // Sample Input

    // 5 -- Input Number of ele
    // 3 --- ele
    // 1
    // 0
    // 7
    // 5

    // Sample Output
    // 5
    // 7
    // 0
    // 1
    // 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of element");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Please enter the" + (i + 1) + "th element");
            arr[i] = sc.nextInt();
        }
        printreverse(arr, n - 1);

    }

    public static void printreverse(int arr[], int n) {
        if (n < 0) {
            return;
        }
        System.out.println(arr[n]);
        printreverse(arr, n - 1);

    }
}