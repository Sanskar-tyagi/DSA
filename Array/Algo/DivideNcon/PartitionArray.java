package Array.Algo.DivideNcon;

import java.util.Scanner;

public class PartitionArray {

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
        swapall(arr, 0, l, k - 1);
        swapall(arr, k + 1, r, arr.length);
        System.out.println("rr");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }

    static void swapall(int arr[], int idx, int i, int r) {
        while (idx < r) {
            arr[idx] = i;
            idx++;
        }
    }
}
