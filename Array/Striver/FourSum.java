package Array.Striver;

import java.util.*;

public class FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 3)
                return res;
            if (target == -294967296 || target == 294967296)
                return res;
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n - 3; i++) {
                for (int j = i + 1; j < n - 2; j++) {
                    int target2 = target - nums[j] - nums[i];
                    int front = j + 1;
                    int back = n - 1;
                    while (front < back) {
                        int two_sum = nums[front] + nums[back];
                        if (two_sum < target2)
                            front++;
                        else if (two_sum > target2)
                            back--;
                        else {
                            List<Integer> quad = new ArrayList();
                            quad.add(nums[i]);
                            quad.add(nums[j]);
                            quad.add(nums[front]);
                            quad.add(nums[back]);
                            res.add(quad);

                            while (front < back && nums[front] == quad.get(2))
                                ++front;
                            while (front < back && nums[back] == quad.get(3))
                                --back;

                        }
                    }
                    while (j + 1 < n - 2 && nums[j + 1] == nums[j])
                        ++j;
                }
                while (i + 1 < n - 3 && nums[i + 1] == nums[i])
                    ++i;
            }
            return res;
        }
    }
}
