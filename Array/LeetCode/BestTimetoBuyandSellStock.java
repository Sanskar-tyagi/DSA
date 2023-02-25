package Array.LeetCode;

import java.util.*;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the input array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int maxProfit = maxProfit(arr);
        System.out.println("Maximum Profit: " + maxProfit);
    }

    public static int maxProfit(int[] arr) {

        int minL[] = new int[arr.length];
        int maxR[] = new int[arr.length];

        minL[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (minL[i - 1] > arr[i])
                minL[i] = arr[i];
            else
                minL[i] = minL[i - 1];
        }
        maxR[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxR[i + 1])
                maxR[i] = arr[i];
            else
                maxR[i] = maxR[i + 1];
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int diff = maxR[i] - minL[i];
            if (max < diff)
                max = diff;
        }

        return max;
    }

}
