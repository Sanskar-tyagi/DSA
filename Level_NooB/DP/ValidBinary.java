package DP;

import java.util.Scanner;

public class ValidBinary {
    // 1. You are given a number n.
    // 2. You are required to print the number of binary strings of length n with no
    // consecutive 0's.

    // Sample Input
    // 6

    // Sample Output
    // 21

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getValidBinary(n);
    }

    static int getValidBinary(int tar) {
        int dp[][] = new int[1][tar + 1];
        for (int i = 1; i <= tar; i++) {
            if (i == 1) {
                dp[0][i] = dp[1][i] = 1;
            } else { 
                dp[0][i] = dp[1][i - 1];
                dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
            }

        }
        return dp[0][tar] + dp[1][tar];
    }
}
