package Recursion_1;

import java.util.Scanner;

public class uniquepathsum {
    // There is a robot on an m x n grid. The robot is initially located at the
    // top-left corner (i.e., grid[0][0]). The robot tries to move to the
    // bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
    // either down or right at any point in time.

    // Given the two integers m and n, return the number of possible unique paths
    // that the robot can take to reach the bottom-right corner.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N");
        int n = sc.nextInt();
        System.out.println("Enter M");
        int m = sc.nextInt();
        int ans = uniquePaths(m, n);
        System.out.println("Number of possible Paths -->" + ans);

    }

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int sum = 0;
        sum += pathgen(m, n, 0, 0, 1);
        return sum;
    }

    static int pathgen(int m, int n, int r, int c, int pathsfar) {
        if (r == m - 1 && c == n - 1) {
            return pathsfar;
        }
        if (r >= m || c >= n) {
            return 0;
        }
        return pathgen(m, n, r + 1, c, pathsfar) + pathgen(m, n, r, c + 1, pathsfar);
    }
}