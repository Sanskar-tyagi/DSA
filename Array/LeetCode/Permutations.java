package Array.LeetCode;

import java.util.*;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        permutation(nums, ans, pre);
        return ans;
    }

    public static void permutation(int[] nums, List<List<Integer>> ans, List<Integer> pre) {
        if (pre.size() == nums.length) {
            ans.add(new ArrayList<>(pre));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (pre.contains(nums[i])) {// checks if the current element nums[i] has already been added to the current
                                        // permutation
                continue;
            }
            pre.add(nums[i]);// adds current element to the permutation
            permutation(nums, ans, pre);// generates the answer
            pre.remove(pre.size() - 1);// Removes the last element from the pre list. This is used to backtrack after
                                       // generating one permutation by removing the last element that was added to
                                       // pre.
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> li = new ArrayList<>();
        li = permute(nums);
        display(li);
    }

    public static void display(List<List<Integer>> permute) {
        System.out.print("[");
        for (int i = 0; i < permute.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < permute.get(i).size(); j++) {
                System.out.print(permute.get(i).get(j));
                if (j != permute.get(i).size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i != permute.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
