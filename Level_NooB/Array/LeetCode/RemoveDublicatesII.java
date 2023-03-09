package Array.LeetCode;

public class RemoveDublicatesII {
    public static void main(String[] args) {

    }

    // Approach
    // We first create a Pointer to keep track of current group of Dublicates  
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i : nums) {
            if (k == 0 || k == 1 || i != nums[k - 2]) {// checks if the current element i is different from the two
                                                       // preceding elements in the modified array. This condition
                                                       // ensures that each element appears at most twice in the
                                                       // modified array. If the condition is true, the current element
                                                       // i is added to the modified array by nums[k++] = i;.
                nums[k++] = i;
            }
        }
        return k;
    }

}
