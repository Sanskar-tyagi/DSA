package DP;

import java.util.*;;

public class ClimbStairsWithvarJumps {
    // 1. You are given a number n, representing the number of stairs in a
    // staircase.
    // 2. You are on the 0th step and are required to climb to the top.
    // 3. You are given n numbers, where ith element's value represents - till how
    // far from the step you
    // could jump to in a single move.
    // You can of course jump fewer number of steps in the move.
    // 4. You are required to print the number of different paths via which you can
    // climb to the top.

    // Sample Input
    // 10
    //

    // Sample Output
    // 5

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };
        int n = arr.length;
        System.out.println(getPathwithMEMO(0, arr, new int[n + 1]));

    }

    static int getPath(int n, int arr[]) {
        if (n == arr.length) {
            return 1;
        }
        int paths = 0;
        for (int i = 1; i <= arr[n]; i++) {
            if ((i + n) <= arr.length) {
                paths += getPath(n + i, arr);
            } else {
                return 0;
            }
        }
        return paths;
    }

    static int getPathwithMEMO(int n, int arr[], int memo[]) {// Using Memoization
        if (n == arr.length) {
            return memo[n] = 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        int paths = 0;
        for (int i = 1; i <= arr[n]; i++) {
            if ((i + n) <= arr.length) {
                paths += getPathwithMEMO(n + i, arr, memo);
            } else {
                return 0;
            }
        }
        memo[n] = paths;
        return paths;
    }

    static int getPathWithTabulation(int arr[]) {
        int memo[] = new int[arr.length + 1];
        
    }
}
