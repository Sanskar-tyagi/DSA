package Recursion_1.backtracking;

import java.util.*;

public class KnightsTour {
    // ? 1. You are given a number n, the size of a chess board.
    // ? 2. You are given a row and a column, as a starting point for a knight
    // ? piece.
    // ? 3. You are required to generate the all moves of a knight starting in (row,
    // ? col) such that knight visits
    // ? all cells of the board exactly once.
    // ? 4. Complete the body of printKnightsTour function to calculate and
    // ? print all configurations of the chess board representing the route
    // ? of knight through the chess board. Use sample input and output to get more
    // ? idea.

    // Note -> When moving from (r, c) to the possible 8 options give first
    // precedence to (r - 2, c + 1) and
    // move in clockwise manner to
    // explore other options.

    // input

    // 5
    // 2
    // 0

    // output

    // 25 2 13 8 23
    // 12 7 24 3 14
    // 1 18 15 22 9
    // 6 11 20 17 4
    // 19 16 5 10 21

    // 19 2 13 8 21
    // 12 7 20 3 14
    // 1 18 15 22 9
    // 6 11 24 17 4
    // 25 16 5 10 23

    // 25 2 13 8 19
    // 12 7 18 3 14
    // 1 24 15 20 9
    // 6 11 22 17 4
    // 23 16 5 10 21

    // 19 2 13 8 25
    // 12 7 18 3 14
    // 1 20 15 24 9
    // 6 11 22 17 4
    // 21 16 5 10 23

    // 21 2 17 8 19
    // 12 7 20 3 16
    // 1 22 13 18 9
    // 6 11 24 15 4
    // 23 14 5 10 25

    // etc.....

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int chess[][] = new int[n][n];
        int r = sc.nextInt();
        int c = sc.nextInt();
        printKnightsTour(chess, r, c, 1);

    }
    /*
     * THINK OUT LOUD
     * so lets think by creating an array of answer so far and saving each element
     * that the knight has visited , and marking the same postion in the orignal
     * array as 1 to check if its already visited or not
     * now we need to call the function again by decrementing the moves each time to
     * validate the base case
     * also we will be checking the next move of the knight is valid or is avilable
     * or not
     * we will call the function with each possible moves for the knigth
     * i.e.-> (-2,+1),(+1,+2),(+1,-2),(+2,+1),
     * these are the all possible moves by a knight in a board
     * we will also need if ever these conditions are out of bond
     * the chess is r and c are the orignal values of the first movement
     * we will increment and decrease them with each call of move
     */     

    public static void printKnightsTour(int[][] chess, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] != 0) {
            return;
        }

        if (move == chess.length * chess.length) {
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        } else if (r > chess.length || c > chess[0].length) {
            return;
        }

        chess[r][c] = move;
        printKnightsTour(chess, r - 2, c + 1, move + 1);
        printKnightsTour(chess, r - 1, c + 2, move + 1);
        printKnightsTour(chess, r + 1, c + 2, move + 1);
        printKnightsTour(chess, r + 2, c + 1, move + 1);
        printKnightsTour(chess, r + 2, c - 1, move + 1);
        printKnightsTour(chess, r + 1, c - 2, move + 1);
        printKnightsTour(chess, r - 1, c - 2, move + 1);
        printKnightsTour(chess, r - 2, c - 1, move + 1);
        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}