package DP;

public class targetSum {
    static boolean TargetSubSet(int arr[], int tar, int sum, int i) {
        if (sum == tar) {
            return true;
        }
        // Base case: if i is beyond the length of the array, terminate recursion
        if (i == arr.length) {
            return false;
        }

        // Recurse by either including or excluding arr[i]
        return TargetSubSet(arr, tar, sum + arr[i], i + 1) ||
                TargetSubSet(arr, tar, sum, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 5, 6 };
        System.out.println(TargetSubSet(arr, 13, 0, 0));
    }

    static boolean TargetMemo() {

    }
}
