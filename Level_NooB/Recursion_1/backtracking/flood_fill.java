package Recursion_1.backtracking;
import java.util.*;

// Q. we are given a matrix of m X n in which the array is filled with
// zeros and ones . The 1's are the boundry and the 0's are the accessible
// paths. We need to explore all the possiblities in the given array to reach
// from the top most left to the bottom most right of the array. The path traced
// should be in the manner T L D R -which is Top Left Down Right ,respectively


// Firstly to approch the code draw down the possiblities and answer
// Then Find out the cases in which the answer should'nt be printed
// in this case there are 3 possiblities in which we will have to return
// from the path. Ex :-
// 1. When the index or the path goes out of bond
// 2. When the index goes to the wall i.e. -> 1's
// 3. When the index is bound in a loop of 0's

// To counter the part of self looping calls BACKTRACKING is implemented
// In this situation to keep the track of the path's covered everytime we
// call the function "We will mark the Traced path as TRUE " in a an alt/Temp
// array to keep track of the visited indexes

public class flood_fill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }

        }
        int idxn = 0;
        int idxm = 0;
        String ansf = "";
        boolean temp[][] = new boolean[n][m];
        findpath(arr, n, m, idxn, idxm, ansf, temp);
    }

    public static void findpath(int arr[][], int n, int m, int idxn, int idxm, String ansf, boolean temp[][]) {

        // valid base case
        if (arr[idxn][idxm] == arr[n][m]) {
            System.out.println(ansf);
            return;
        }
        // invalid base case for all three Cases
        // The first two checks if we ever go for negtive calls as there will be TOP and
        // LEFT movement
        // The second two checks for if we go out of bounded cells
        // The third one will check for the 1's wall
        // and the last one is to check for the self loop (BACKTRACKING)
        if (idxn < 0 || idxm < 0 || idxn > n || idxm > m || arr[idxn][idxm] == 1 || temp[idxn][idxm] == true) {
            return;
        }
        temp[idxn][idxn] = true;
        findpath(arr, n, m, idxn - 1, idxm, ansf + "t", temp);
        findpath(arr, n, m, idxn, idxm - 1, ansf + "l", temp);
        findpath(arr, n, m, idxn + 1, idxm, ansf + "d", temp);
        findpath(arr, n, m, idxn, idxm + 1, ansf + "r", temp);

        // VVVVVVI
        temp[idxn][idxm] = false;// TO OPEN THE NEW POSSIBLITIES OF EXPLORING OTHER PATHS TOO THRU THIS CELL
    }

}