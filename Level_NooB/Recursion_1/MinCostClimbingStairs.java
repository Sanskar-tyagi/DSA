package Recursion_1;

import java.util.Scanner;

public class MinCostClimbingStairs {
    // ! Q--> https://leetcode.com/problems/min-cost-climbing-stairs
    // You are given an integer array cost where cost[i] is the cost of ith step on
    // a staircase. Once you pay the cost, you can either climb one or two steps.

    // You can either start from the step with index 0, or the step with index 1.

    // Return the minimum cost to reach the top of the floor.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = minCostClimbingStairs(arr);
        System.out.println(ans);
    }

    public static int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(cost, 0), helper(cost, 1));
    }

    public static int helper(int[] cost, int index) {
        if (index == cost.length - 1) {
            return cost[index];
        }
        if (index == cost.length) {
            return 0;
        }

        int op1 = helper(cost, index + 1);
        int op2 = helper(cost, index + 2);
        return Math.min(op1, op2) + cost[index];
    }

    // Optimized apporoch
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            for (int i = 2; i < cost.length; i++) {
                cost[i] += Math.min(cost[i - 1], cost[i - 2]);
            }
            return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        }
    }
}
