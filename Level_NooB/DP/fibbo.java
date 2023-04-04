package DP;

import java.util.Scanner;

public class fibbo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(getFibo(x));
        System.out.println(getFiboMemo(x, new int[x + 1]));
        System.out.println(getFiboTabulation(x)); 
        System.out.println(getFiboOptimizedTab(x));
    }

    static int getFibo(int x) { // reccursive call
        if (x == 0 || x == 1) {
            return x;
        }
        int ans = getFibo(x - 1) + getFibo(x - 2);
        return ans;
    }

    static int getFiboMemo(int x, int arr[]) { // reccursive call with memoization
        if (x == 0 || x == 1) {
            arr[x] = x;
            return x;
        }
        if (arr[x] != 0) { // Non zero val Already calc
            return arr[x];
        }
        int ans = getFibo(x - 1) + getFibo(x - 2);

        return arr[x] = ans;
    }

    static int getFiboTabulation(int n) { // Tabulation to save Memory
        int arr[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                arr[i] = i;
            } else {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }

        return arr[n];
    }

    static int getFiboOptimizedTab(int x) { // Optimized tabulation
        if (x == 0 || x == 1) {
            return x;
        }
        int s = 1;
        int f = 0;
        for (int i = 2; i <= x; i++) {
            int third = s + f;
            f = s;
            s = third;
        }
        return s;
    }
}
