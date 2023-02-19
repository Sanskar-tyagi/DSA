package Recursion_1.LeetCode;

import java.util.*;

public class Permutations_II {

    // ! Q-> https://leetcode.com/problems/permutations-ii/
    // ! Given a collection of numbers, nums, that might contain duplicates, return
    // ! all possible unique permutations in any order.
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter input " + (i + 1) + "th of array");
            arr[i] = sc.nextInt();
        }
        permuteUnique(arr);
        for (List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println(); // print a newline after each sub-list
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return result;
    }

    public static void permute(int[] nums, List<Integer> list, boolean[] used) {

        if (list.size() == nums.length) {
            result.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!used[i]) {
                if (i == 0 || nums[i - 1] != nums[i] || used[i - 1]) {
                    used[i] = true;
                    list.add(nums[i]);
                    permute(nums, list, used);
                    used[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}