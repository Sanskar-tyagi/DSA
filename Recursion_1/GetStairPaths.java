package Recursion_1;

import java.util.*;

public class GetStairPaths {
    // Q 1. You are given a number n representing number of stairs in a staircase.
    // 2. You are standing at the bottom of staircase. You are allowed to climb 1
    // step, 2 steps or 3 steps in one move.
    // 3. Complete the body of getStairPaths function to get the list of all
    // paths that can be used to climb the staircase up.
    // Use sample input and output to take idea about output.

    // Sample Input

    // 3

    // Sample Output

    // [111, 12, 21, 3]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getStairPaths(n, " ", 0);
    }

    public static void getStairPaths(int n, String ansf, int sum) {
        if (n == sum) {// valid base case
            System.out.println(ansf);
            return;
        }
        if (sum > n) {// invalid base case
            return;
        }

        getStairPaths(n, ansf + "1", sum + 1);// call for 1
        getStairPaths(n, ansf + "2", sum + 2);// call for 2
        getStairPaths(n, ansf + "3 ", sum + 3);// call for 3
    }
}
