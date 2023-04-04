package Array.LeetCode;

public class JumpGame {
    // ! https://leetcode.com/problems/jump-game/description/
    // The approach here is to store a boundry or maximum Index where we can reach
    // to using the jumps we have and the index it is on
    // Example
    // Input: nums = [2,3,1,1,4]
    // Output: true
    // Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    // To explain the approach lets take the above example .
    // as we start with zero we the maximum point at which we can reach is 2 steps
    // that is arr[2];
    // we save it as boundry and then continue the loop.
    // in the next we reach at arr[1] which is 3 jumps.
    // when we add 3 to the index we get boundry or reachable level as 4 which is
    // equal to the index we want to reach so we return true

    // * Better explanation
    // * The approach here is to keep track of the maximum index that we can reach
    // * using the jumps we have from each index. We start with the first index and
    // * the maximum index we can reach is the value at that index. We save this as
    // * the boundary and then continue to loop through the array. For each index,
    // * we add the value at that index to the index itself, and if this sum is
    // * greater than the current boundary, we update the boundary. We keep doing
    // * this until we reach an index where the boundary is greater than or equal to
    // * the last index of the array. If we are able to reach the last index, we
    // * return true, otherwise we return false.

    public boolean canJump(int[] nums) {
        int boundary = 0; // maximum index that we can reach using the jumps we have
        for (int i = 0; i <= boundary; i++) { // loop through the array
            boundary = Math.max(boundary, i + nums[i]); // update the boundary
            if (boundary >= nums.length - 1) // if we can reach the last index, return true
                return true;
        }
        return false; // if we can't reach the last index, return false
    }
}
