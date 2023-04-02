package Recursion_1.LeetCode;

import java.util.*;;

public class CombinationSum {
    // Q -> https://leetcode.com/problems/combination-sum/
    class Solution {
        // findCombinations is the helper function
        public void findCombinations(int ind, int arr[], int target, List<List<Integer>> ans, List<Integer> ds) {
            // we will start ind from 0 till it's equal to n
            if (ind == arr.length) {
                // if ind has reached n -> and the target has became 0 after each decrement
                if (target == 0) {
                    ans.add(new ArrayList<>(ds));// add the elements from ds(it's list to store the element) to ans
                }
                return;// backtrack
            }
            if (arr[ind] <= target) {// we will check if arr[i] should be less than or equal to target(because we
                                     // subtract arr[i] from target)
                ds.add(arr[ind]);// add arr[i] in ds list
                // again make a recursive call with PICK
                // ------> (PICK) we will remain on same index
                findCombinations(ind, arr, target - arr[ind], ans, ds);
                // ------>(NOT PICK) we will move to index+1
                // reduce the length of the ds list by 1 beacuse new element add at the last in
                // list
                ds.remove(ds.size() - 1);
            }
            // make a recursive call with (NOT PICK)
            findCombinations(ind + 1, arr, target, ans, ds);
        }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();// it will store the ans
            // call the helper function
            findCombinations(0, candidates, target, ans, new ArrayList<>());
            return ans;
        }
    }
}
