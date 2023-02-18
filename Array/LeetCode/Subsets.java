package Array.LeetCode;

import java.util.*;

public class Subsets {
    // Link -> https://leetcode.com/problems/subsets
    // Q Given an integer array nums of unique elements, return all possible
    // subsets
    // (the power set).
    // The solution set must not contain duplicate subsets. Return the solution in
    // any order.
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> main = new ArrayList<>();// here we create our Main array list that will become our answer
                                                     // later.
        ArrayList<Integer> ans = new ArrayList<>();// here is our ans arraylist that will generate each subsets.
        calcSubs(nums, ans, 0, main);// we call the function to generate the subsets arraylist
        return main;// and finally return it.
    }

    static void calcSubs(int[] nums, ArrayList<Integer> ans, int i, List<List<Integer>> main) {
        if (i == nums.length) {
            main.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[i]);
        calcSubs(nums, ans, i + 1, main);
        ans.remove(ans.size() - 1);
        calcSubs(nums, ans, i + 1, main);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> li = new ArrayList<>();
        li = subsets(nums);
        display(li);
    }

    public static void display(List<List<Integer>> subsets) {
        System.out.print("[");
        for (int i = 0; i < subsets.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < subsets.get(i).size(); j++) {
                System.out.print(subsets.get(i).get(j));
                if (j != subsets.get(i).size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i != subsets.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
