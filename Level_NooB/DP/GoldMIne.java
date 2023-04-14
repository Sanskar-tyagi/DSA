package DP;

public class GoldMine {
    public static void main(String[] args) {
        int[][] array = { { 0, 1, 4, 2, 8, 2 }, { 4, 3, 6, 5, 0, 4 }, { 1, 2, 4, 1, 4, 6 }, { 2, 0, 7, 3, 2, 2 },
                { 3, 1, 5, 9, 2, 4 }, { 2, 7, 0, 8, 5, 1 } };
        int ans = getMaxGold(array);
        System.out.println(ans);
    }

    static int getMaxGold(int arr[][]) {
        int sr = arr.length - 1;
        int sc = arr[0].length - 1;
        int memo[][] = arr;
        for (int i = sr; i >= 0; i--) {
            for (int j = sc; j >= 0; j--) {
                if (j != sc) {
                    int g1 = Integer.MIN_VALUE, g2 = arr[i][j + 1], g3 = Integer.MIN_VALUE;
                    if (i > 0) {
                        g1 = arr[i - 1][j + 1];
                    }
                    if (i < sr) {
                        g3 = arr[i + 1][j + 1];
                    }
                    int gold = Math.max(g2, Math.max(g1, g3));
                    memo[i][j] = gold + arr[i][j];
                }
            }
        }
        int Maxgold = FindMax(memo);
        return Maxgold;
    }

    static int FindMax(int memo[][]) {
        int max = Integer.MIN_VALUE;
        for (int i : memo[0]) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
