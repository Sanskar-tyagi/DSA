package DP;

public class MatrixCalls {
    public static void main(String[] args) {
        int[][] arr = { { 0, 1, 4, 2, 8, 2 },
                { 4, 3, 6, 5, 0, 4 },
                { 1, 2, 4, 1, 4, 6 },
                { 2, 0, 7, 3, 2, 2 },
                { 3, 1, 5, 9, 2, 4 },
                { 2, 7, 0, 8, 5, 1 } };
        int ans = getMax(arr, 0, 0, arr.length - 1, arr[0].length - 1, 0);
        System.out.println(ans);

    }

    static int getMax(int arr[][], int sc, int sr, int dc, int dr, int cost) {
        if (sc == dc && sr == dr) {
            return arr[sc][sr];
        }

        if (sc > dc || sr > dr) {
            return Integer.MAX_VALUE;
        }
        int v = getMax(arr, sc, sr + 1, dc, dr, cost);
        int h = getMax(arr, sc + 1, sr, dc, dr, cost);
        return arr[sc][sr] + Math.min(v, h);

    }

    static int getMaxinMemo() {

    }

    static int getCostinTab(int arr[][]) {

    }

}
