package Array.LeetCode;

import java.util.*;

public class BestTimetoBuyandSellStock {
    // ! Q-->https://leetcode.com/problems/best-time-to-buy-and-sell-stock

    // You are given an array prices where prices[i] is the price of a given stock
    // on the ith day.

    // You want to maximize your profit by choosing a single day to buy one stock
    // and choosing a different day in the future to sell that stock.

    // Return the maximum profit you can achieve from this transaction. If you
    // cannot achieve any profit, return 0.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the input array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int maxProfit = maxProfit(arr);
        System.out.println("Maximum Profit: " + maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max_pro = 0;// [7,1,5,3,6,4]
        for (int i : prices) {
            if (min > prices[i]) {
                min = prices[i];
            }
            max_pro = Math.max(max_pro, prices[i] - min);
        }
        return max_pro;
    }
}
