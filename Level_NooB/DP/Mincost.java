package DP;

public class Mincost {
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
}
