package DP;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int ans = ClimbStairsMemoization(x, new int[x + 1]);
        System.out.println(ans);
        System.out.println(ClimbStairsOPTabulation(x));
        System.out.println();
    }

    public static int getStairPaths(int n, int sum) {
        if (sum == n) {
            return 1;
        }
        if (sum > n) {
            return 0;
        }
        int ansf = 0;
        ansf += getStairPaths(n, sum + 1); // take 1 step
        ansf += getStairPaths(n, sum + 2); // take 2 steps
        ansf += getStairPaths(n, sum + 3); // take 3 steps
        return ansf;
    }

    static int ClimbStairsMemoization(int n, int arr[]) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        int ans = ClimbStairsMemoization(n - 1, arr)
                + ClimbStairsMemoization(n - 2, arr)
                + ClimbStairsMemoization(n - 3, arr);
        arr[n] = ans;
        return ans;
    }

    static int ClimbStairsTabulation(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[2] = 2;
        dp[1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    static int ClimbStairsOPTabulation(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 0, b = 1, c = 2, d = 0;
        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}
