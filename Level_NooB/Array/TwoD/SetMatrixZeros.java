package Array.TwoD;

import java.util.*;

public class SetMatrixZeros {
    // Q-->https://www.codingninjas.com/codestudio/problems/set-matrix-zeros
    // Problem Statement
    // Given an ‘N’ x ‘M’ integer matrix, if an element is 0, set its entire row and
    // column to 0's, and return the matrix. In particular, your task is to modify
    // it in such a way that if a cell has a value 0 (matrix[i][j] == 0), then all
    // the cells of the ith row and jth column should be changed to 0.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the matrix size N");
        int n = sc.nextInt();
        System.out.println("Enter the matrix");
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    convertArr(arr, i, n);
                } else {
                    continue;
                }
            }
        }
        display(arr);
    }

    static void convertArr(int[][] arr, int i, int l) {
        for (int j = 0; j < l; j++) {
            arr[i][j] = 0;
        }
    }

    static void display(int arr[][]) {
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
