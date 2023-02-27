package Array.LeetCode;

import java.util.*;

public class BestTimetoBuyandSellStockII {

    public static int maxProfit(int[] nums) {
        int totalProfit = 0;
        for (int i = 1; i < nums.length ; i++) {

            if (nums[i - 1] > nums[i]) {
                totalProfit += nums[i] - nums[i - 1];
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();
        int[] nums = new int[length];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = maxProfit(nums);
        System.out.println("The maximum profit is: " + result);
        scanner.close();
    }
}
