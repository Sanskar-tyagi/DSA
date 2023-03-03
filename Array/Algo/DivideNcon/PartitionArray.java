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
        PartArrayFrompivot(arr, k);

    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    
    static void PartArrayFrompivot(int arr[], int k) {
        int i = 0;
        int j = 0;
        while (j != arr.length || i != arr.length) {
            if (arr[i] <= k) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                j++;
            }
        }
    }



}
