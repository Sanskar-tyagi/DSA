package Array.LeetCode;

public class RotateKfromRight {
    // ! Q-> Given an integer array nums, rotate the array to the right by k steps,
    // ! where k is non-negative.

    public static void reverse(int nums[], int i, int j) {
        int li = i;
        int ri = j;

        while (li < ri) {
            int temp = nums[li];
            nums[li] = nums[ri];
            nums[ri] = temp;

            li++;
            ri--;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k < 0) {
            k += nums.length;
        }
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
}
