package Array;

import java.util.Scanner;

public class MaxSumAfterPartitioning {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("n");
        int n = sc.nextInt();
        System.out.println("K");
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        maxSumAfterPartitioning(arr, k);

    }

    // This function trys to partition an array from left to right at K pivot
    // and in the part it tries to find Maximum digit at both ends and returns the
    // sum of the new array
    // Example --> [10 ,2, 15,9,3,10,5] K=3
    // Now at 3rd index --> 9 we try to find the max of both half and swap the
    // numbers
    // new array --> [15,15,15,9,10,10,10]
    // and then return the sum of the array
    public static void maxSumAfterPartitioning(int[] arr, int k) {
        int idx = 0;
        int r = Integer.MIN_VALUE;
        int l = Integer.MIN_VALUE;
        while (idx != k) {
            if (arr[idx] > l) {
                l = arr[idx];
            }
            idx++;
        }
        while (idx != arr.length) {
            if (arr[idx] > r) {
                r = arr[idx];
            }
            idx++;
        }
        System.out.println("ar");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        swapall(arr, 0, l, k);
        swapall(arr, k + 1, r, arr.length);
        int sum = 0;
        System.out.println("rr");
        for (int i : arr) {
            sum += i;
        }
        System.out.println(sum);

    }

    static void swapall(int arr[], int idx, int i, int r) {
        while (idx < r) {
            arr[idx] = i;
            idx++;
        }
    }
}
