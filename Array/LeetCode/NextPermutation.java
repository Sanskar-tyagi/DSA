package Array.LeetCode;

public class NextPermutation {
    // Q-->https://leetcode.com/problems/next-permutation/
    // The code can be broken into 3 steps to find the answer.
    // The pattern that every next permutation follows is that whenever we get an
    // element from the that is in decresing order we swap it with the next greater
    // number in the rest of the array
    // further we reverse the array to get the next smallest permutation

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) { 
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
