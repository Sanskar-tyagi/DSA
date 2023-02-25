package Array.LeetCode;

import java.util.*;;

public class FindDublicate {
    // [1,3,4,2,2]
    // i=0 index= 0; -1
    // i=1 index= 2 -1 3 -4
    // i=2 index= 3 -1 3 -4 2 -2
    // i=3 index= 1 -1 -3 -4 2 -2
    // i=4 index= 1 if condition validates and we return with the val

    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                return Math.abs(nums[i]);
            }
            nums[index] = -nums[index];
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = findDuplicate(nums);
        System.out.println("The duplicate element in the array is: " + result);
    }
}
