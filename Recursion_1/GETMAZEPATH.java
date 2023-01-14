package Recursion_1;

import java.util.*;
//Q:  1. You are given a number n and a number m representing number of rows and columns in a maze.
//    2. You are standing in the top-left corner and have to reach the bottom-right corner.
//Only two moves are allowed'h'(1-step horizontal)and'v'(1-step vertical).
//    3. Complete the body of getMazePath function-without changing signature-to get the list 
//    of all paths that can be used to move from top-left to bottom-right.

// Sample Input
// 3 -n
// 3 -m

// Sample Output

// [hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
public class GETMAZEPATH {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter num of rows");
        int n = scn.nextInt();
        System.out.println("Enter num of col");
        int m = scn.nextInt();
        int sc = 0;
        int sr = 0;
        int dc = n - 1;
        int dr = m - 1;

        ArrayList<String> ans = new ArrayList<>();
        // System.out.println(GETMAZEPATH(new int[n][m], sr, sc, dr, dc, ""));
        GETMAZEPATH(ans, new int[n][m], sr, sc, dr, dc, "");
        System.out.println("Possible paths are: " + ans);
    }

    // The code below is incorrect as we check and call all the paths yet we never
    // store them

    // public static String GETMAZEPATH(int arr[][], int sr, int sc, int dr, int dc,
    // String ansf) {
    // if (sr == dr && sc == dc) {// Valid base case
    // return "";
    // }
    // String h = GETMAZEPATH(arr, sr, sc + 1, dr, dc, ansf + "h");// H movement
    // String v = GETMAZEPATH(arr, sr + 1, sc, dr, dc, ansf + "v");// v movement
    // if (sr > dr || sc > dc) {
    // return null;
    // }
    // String myans = h + v;
    // return myans;
    // }

    public static void GETMAZEPATH(ArrayList<String> ans, int arr[][], int sr, int sc, int dr, int dc, String path) {
        if (sr == dr && sc == dc) { // reached destination
            ans.add(path);
            return;
        }
        if (sr > dr || sc > dc) { // out of grid
            return;
        }
        GETMAZEPATH(ans, arr, sr, sc + 1, dr, dc, path + "h"); // move horizontally
        GETMAZEPATH(ans, arr, sr + 1, sc, dr, dc, path + "v"); // move vertically
    }

}
