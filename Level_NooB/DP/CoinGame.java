package DP;

public class CoinGame {
    static boolean isValidCoin(int arr[], int tar, int sum, int i) {
        if (sum == tar) {
            return true;
        }
        // Base case: if i is beyond the length of the array, terminate recursion
        if (i == arr.length) {
            return false;
        }

        // Recurse by either including or excluding arr[i]
        return isValidCoin(arr, tar, sum + arr[i], i + 1) ||
                isValidCoin(arr, tar, sum, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 5, 6 };
        System.out.println(isValidCoin(arr, 13, 0, 0));
    }

    static boolean TargetTabulation(int arr[], int tar) { // using memoization techniqueue
        // Create a memory of coins+1 x Target+1
        boolean dp[][] = new boolean[arr.length + 1][tar + 1];
        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[0].length; c++) {
                if (r == 0) {
                    // Now we firstly fill the array with the known values
                    // True for all em
                    dp[r][c] = true;
                } else if (c == 0) {
                    dp[r][c] = false;
                } else {
                    int coin = arr[c - 1];
                    int Currtar = c;
                    boolean res = dp[r - 1][c];
                    if (Currtar >= coin) {
                        res = dp[r - 1][Currtar - coin] || res;
                    }
                    dp[r][c] = res;
                }
            }
        }
        return dp[arr.length][tar];
    }
}