package DP;

public class CoinCombo {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 6 };
        int tar = 7;
        System.out.println(getCombinationWithDP(arr, tar));
    }

    static int change(int[] coins, int amount, int i) {
        if (i == coins.length) {
            if (amount == 0)
                return 1;
            else
                return 0;
        }
        int pick = 0;
        if (amount >= coins[i]) {
            pick = change(coins, amount - coins[i], i);
        }
        int notPick = change(coins, amount, i + 1);
        return pick + notPick;
    }

    static int getCombinationWithDP(int arr[], int tar) {
        int dp[] = new int[tar + 1];
        dp[0] = 1; // Paying 0 in 1 way by paying NOTHIN ..DUH :0

        for (int i = 1; i < arr.length; i++) {
            for (int CurrPay = arr[i]; CurrPay < tar; CurrPay++) {
                if (CurrPay - arr[i] == 0) {
                    dp[CurrPay] = +1;
                } else {
                    if (CurrPay - arr[i] >= 0)
                        dp[CurrPay] += dp[arr[CurrPay] - tar];
                }
            }
        }
        return dp[tar];
    }
}