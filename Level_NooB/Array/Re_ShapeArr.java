package Array;

import java.util.*;

public class Re_ShapeArr {
    // ? In MATLAB, there is a handy function called reshape which can reshape an m
    // ? X n matrix into a new one with a different size r x c keeping its original
    // ? data.

    // ? You are given an m x n matrix mat and two integers r and c representing the
    // ? number of rows and the number of columns of the wanted reshaped matrix.

    // ? The reshaped matrix should be filled with all the elements of the original
    // ? matrix in the same row-traversing order as they were.

    // ? If the reshape operation with given parameters is possible and legal,
    // ? output
    // ? the new reshaped matrix; Otherwise, output the original matrix.
    // ? Input: mat = [[1,2],[3,4]], r = 1, c = 4
    // ? Output: [[1,2,3,4]]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println("Please enter the Array to re shape");
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        boolean t = true;
        System.out.println("Please enter the parameters to re shape");
        while (t) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            if (r * c == n * m && r > 0 && c > 0) {
                reshape(arr, r, c);
                t = false;
            } else {
                System.out.println("Please enter Valid  parameters to re shape");
            }
        }

    }

    public static void reshape(int arr[][], int r, int c) {
        int ans[][] = new int[r][c];
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < m * n; i++) {
            ans[i % c][i / c] = arr[i / m][i % m];
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.println(ans[i][j]);
            }
        }
    }
}
