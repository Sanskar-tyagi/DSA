package Array.LeetCode;

import java.util.*;;

public class Longest_Turbulent_Subarray {
    // ! Q-> https://leetcode.com/problems/longest-turbulent-subarray
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = maxTurbulenceSize(arr);
        System.out.println("The maximum turbulence size is: " + result);
    }

    // APPROACH
    // If the current element is greater than the previous element, "inc" is
    // incremented by 1, and "dec" is reset to 1, as we are looking for alternating
    // increasing and decreasing elements.
    // If the current element is smaller than the previous element, "dec" is
    // incremented by 1, and "inc" is reset to 1.
    // If the current element is equal to the previous element, both "inc" and "dec"
    // are reset to 1, as we cannot consider the previous element in a subarray with
    // alternating increasing and decreasing elements.
    public static int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int res = 1;
        int inc = 1, dec = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else if (arr[i] < arr[i - 1]) {
                dec = inc + 1;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            res = Math.max(res, Math.max(inc, dec));
        }
        return res;
    }
}
