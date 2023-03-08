package Array.LeetCode;

import java.util.*;

public class DutchColorProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int curr = 0;

        while (curr <= right) {
            if (nums[curr] == 0) {
                swap(nums, left, curr);
                left++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, right, curr);
                right--;
            } else {
                curr++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
