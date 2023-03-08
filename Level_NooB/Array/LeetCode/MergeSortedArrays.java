package Array.LeetCode;

import java.util.*;
import java.util.Arrays;

public class MergeSortedArrays {
    // You are given two integer arrays nums1 and nums2, sorted in non-decreasing
    // order, and two integers m and n, representing the number of elements in nums1
    // and nums2 respectively.
    // Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    // The final sorted array should not be returned by the function, but instead be
    // stored inside the array nums1. To accommodate this, nums1 has a length of m +
    // n, where the first m elements denote the elements that should be merged, and
    // the last n elements are set to 0 and should be ignored. nums2 has a length of
    // n.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N");
        int n = sc.nextInt();
        System.out.println("Enter M");
        int m = sc.nextInt();
        int arr[] = new int[n];
        int nums[] = new int[m];
        System.out.println("Enter Arr 1");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter nums");
        for (int j = 0; j < m; j++) {
            nums[j] = sc.nextInt();
        }
        display(arr);
        display(nums);
        Arrays.sort(arr);
        Arrays.sort(nums);
        int ans[] = MergeArr(arr, nums);
        display(ans);
    }

    static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        System.out.println();
    }

    static int[] MergeArr(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int idx = 0;
        int[] ans = new int[nums1.length + nums2.length];
        while (idx < ans.length) {
            int val1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
            int val2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;
            if (val1 < val2) {
                ans[idx] = val1;
                p1++;
            } else {
                ans[idx] = val2;
                p2++;
            }
            idx++;
        }
        return ans;
    }

}
