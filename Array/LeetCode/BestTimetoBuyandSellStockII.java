package Array.LeetCode;

import java.util.*;

public class BestTimetoBuyandSellStockII {

    public static int maxProfit(int[] nums) {
        int min = nums[0], totalProfit = 0;
        int pos = 1, max = -1;
        while (pos < nums.length) {
            if (nums[pos] < min)
                min = nums[pos];
            while (pos < nums.length && max < nums[pos])
                max = nums[pos++];

            totalProfit += max - min;
            max = -1;
            if (pos < nums.length)
                min = nums[pos];
            pos++;
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
