package Recursion_1.LeetCode;

import java.util.Scanner;

public class WordFind {
    // ! Q--> Given an m x n grid of characters board and a string word, return true
    // ! if word exists in the grid.

    // ! The word can be constructed from letters of sequentially adjacent cells,
    // ! where adjacent cells are horizontally or vertically neighboring. The same
    // ! letter cell may not be used more than once.
    // ! LINK-->https://leetcode.com/problems/word-search/description/
    public static void main(String[] args) {
        // ? Approach.
        // ? First we will subdivide the question into 3 methods.
        // ? first we will traverse through the array and first character of given word
        // ? in given matrix.
        // ?if first character found then we call recursion for remaining task
        // ? Two conditions to stop the current traverse ,If ever we cross the length of
        // ? the target and didnot find it we will simply return , and if ever we found
        // ? the same string we will return true.
        // ? Also we will add and track the words by Marking the visited array
        // ? everytime we cross the word equal to the String
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter R and C");
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("Enter Array");
        char arr[][] = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println("Enter Target");
        String tar = sc.next();
        System.out.println(exist(arr, tar));

    }

    public static boolean exist(char[][] board, String word) {
        // finding first character of given word in given matrix
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // if first character found then we call recursion for remaining task else
                // return false
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, 0, i, j, board.length, board[0].length))
                        return true;
                }
            }
        }
        return false;
    }

    static boolean helper(char[][] board, String word, int index, int i, int j, int rowLen, int colLen) {
        if (index == word.length())
            return true;
        if (i < 0 || j < 0 || i == rowLen || j == colLen || board[i][j] != word.charAt(index))
            return false;
        char temp = board[i][j];
        board[i][j] = '#';// marking the Letter
        boolean ans1 = helper(board, word, index + 1, i, j + 1, rowLen, colLen);
        boolean ans2 = helper(board, word, index + 1, i + 1, j, rowLen, colLen);
        boolean ans3 = helper(board, word, index + 1, i - 1, j, rowLen, colLen);
        boolean ans4 = helper(board, word, index + 1, i, j - 1, rowLen, colLen);
        board[i][j] = temp;
        return ans1 || ans2 || ans3 || ans4;

    }
}
