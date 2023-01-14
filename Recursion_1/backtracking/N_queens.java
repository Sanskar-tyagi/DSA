package Recursion_1.backtracking;

import java.util.*;

public class N_queens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printQ(n, new int[n][n], "", 0);
        // we create a new empty int array, it will be filled with Zeros' so as to
        // distinguish later we mark the postions of Queen as 1.
    }

    public static void printQ(int n, int arr[][], String ansf, int row) {// Starting with Row zero we ,check every
                                                                         // postion on the row ,in that Col
        if (row == n) {
            System.out.println(ansf + ".");
            return;
        } // valid base case
          // if ever we go out of the row we will just simply return the answer so far
          // meaning it is safe to keep in that row (pos)

        for (int col = 0; col < n; col++) {// in here we go for putting the Queens in the chess we start by placing the
                                           // Queen in the first col of that row. Now in that we :-
                                           // first mark the position as One , and then check is it okay to put 1
                                           // (Queen) there by calling the function/method is safe.
                                           // if it is safe to put the queen there we check for another row ---- This
                                           // part here also tells us how we can optimize our code by skiping ,while
                                           // checking the safety of queen, the row i.e left and right movement because
                                           // in one row we just place one queen and after that we move to another row.
                                           // after we have checked the place we will unmark the place to open up new
                                           // possiblities for the cell in case it isn't safe place for the queen
            arr[row][col] = 1;
            if (isSafe(arr, row, col)) {
                printQ(n, arr, ansf + row + col, row + 1);
            }
            arr[row][col] = 0;
        } // The marking and unmarking process of the recurrsion is called backtracking in
          // which we track back the path by unmarking it and opening to new possiblity
    }

    public static boolean isSafe(int arr[][], int row, int col) {// in this method we simply check the places using the
                                                                 // 2D matrix equations , But also optimize it by
                                                                 // removing the unused or not needed checking , for
                                                                 // example right here we skip the rows checking as
                                                                 // discussed earlier,further more we skip checking the
                                                                 // downwards col, downwards diaognal (both left and
                                                                 // right). The fundamental reason to do so is because
                                                                 // we are putting the queens from the above so there
                                                                 // wont be any downwards
        for (int i = row - 1, j = col; i >= 0; i++) {// Upwards
            if (arr[i][j] == 1) {// for this loop we check if by putting the row just above (Row -1) in the same
                                 // col (j=col) and we do it till all the rows just above the pos where queen is
                                 // placed doenst have any other 1(Queen).
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {// Upper left diagonal
            if (arr[i][j] == 1) {// for this loop we check it going diagonally left by decreasing both the row
                                 // and col by 1(row-1 & col-1) and then we check it till both of them diagonally
                                 // runs less than zero.
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j <= arr[0].length; i--, j++) {// Upper right diagonal
            if (arr[i][j] == 1) {// for this loop we check it going diagonally right by decreasing the row yet
                                 // increasing the col. we check so until we reach the right most corner of the
                                 // chess (0,N) and till then we decrease the i and increase the j simultaneously
                return false;
            }
        }
        return true;
    }
}
