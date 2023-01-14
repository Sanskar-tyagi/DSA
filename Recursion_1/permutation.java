package Recursion_1;

import java.util.*;

public class permutation {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the array size");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Please input the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printpermutation(arr, n, new int[n]);
    }

    public static void printpermutation(int arr[], int n, int temp[]) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            int t = arr[i]; // Add each element into the list
            list.add(t);
        }
        if (arr.length == 0) {
            System.out.println(temp);
        }
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            temp[i] = num;
            list.remove(i);
            arr = list.stream().mapToInt(j -> j).toArray();
            printpermutation(arr, n, temp);
        }
    }
}
