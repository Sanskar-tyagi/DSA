
package DP.Leetcode;

import java.util.*;

public class TargetPartition {
    // ! Partition Equal Subset Sum
    // https://leetcode.com/problems/partition-equal-subset-sum/description/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        if (sum / 2 != 0) {
            System.out.println("False");
        }
        System.out.println(Helper(nums, sum / 2, nums.length + 1, (sum / 2) + 1));
    }

    public static boolean Helper(int nums[], int sum, int n, int m) {
        boolean dp[][] = new boolean[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // if(j==0||i==0){ knwn work
                // dp[i][j]=false;
                // }

                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; // Exculding
                } else if (nums[i - 1] == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i][j - nums[i - 1]] || dp[i - 1][j]; // including or excluding
                }
            }
        }
        return dp[n][m];
    }
}