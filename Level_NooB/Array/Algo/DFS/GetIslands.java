package Array.Algo.DFS;

public class GetIslands {
    // ! We are provided with a 2D matrix filled with 1's and 0's.
    // ! Each 1 is taken as Water and 0 is land.
    // ! We need to identify all the possible island that all connected zero's make

    // 1 0 0 0 0 1 1 1 0
    // 0 0 0 0 1 1 1 1 0
    // 1 1 1 0 0 0 1 1 0
    // 1 1 1 1 1 1 1 1 1
    // 0 0 0 0 1 1 1 1 0

    // In the above represntation there are total 5 islands

    // The approach here would be to create a count var to store the number of
    // islands
    // After that whenever we encounter a 0 we increase the count by one
    // then till we have coonected zero's we mark them all as a unqiue number to
    // create a visited check without increasing the count for every connected zero
    // to make that check we call a function that recurssively calls itself marking
    // every zero connected in all 4 directions

    public static void main(String[] args) {
        int arr[][] = { { 1, 0, 0, 0, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 1, 0, 0 },
                { 1, 0, 0, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0 } };

        int ans = GetIsland(arr);
        System.out.println("num islands =" + ans);
        for (int[] row : arr) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int GetIsland(int arr[][]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    count += 1;
                    markConnected(arr, i, j);
                }
            }
        }
        return count;
    }

    public static void markConnected(int arr[][], int i, int j) {
        arr[i][j] = 3;// Unique mark to mark visited lands
        if (i - 1 >= 0 && arr[i - 1][j] != 3 && arr[i - 1][j] != 1) {
            markConnected(arr, i - 1, j);
        }
        if (i + 1 < arr.length && arr[i + 1][j] != 3 && arr[i + 1][j] != 1) {
            markConnected(arr, i + 1, j);
        }
        if (j - 1 >= 0 && arr[i][j - 1] != 3 && arr[i][j - 1] != 1) {
            markConnected(arr, i, j - 1);
        }
        if (j + 1 < arr[0].length && arr[i][j + 1] != 3 && arr[i][j + 1] != 1) {
            markConnected(arr, i, j + 1);
        }
    }
}
