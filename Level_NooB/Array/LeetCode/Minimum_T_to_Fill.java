package Array.LeetCode;

import java.util.*;

public class Minimum_T_to_Fill {

    // You have a water dispenser that can dispense cold, warm, and hot water. Every
    // second, you can either fill up 2 cups with different types of water, or 1 cup
    // of any type of water.

    // You are given a 0-indexed integer array amount of length 3 where amount[0],
    // amount[1], and amount[2] denote the number of cold, warm, and hot water cups
    // you need to fill respectively. Return the minimum number of seconds needed to
    // fill up all the cups.

    public int fillCups(int[] A) {
        int mx = 0, sum = 0;
        for (int a : A) {
            mx = Math.max(a, mx);
            sum += a;
        }
        return Math.max(mx, (sum + 1) / 2);
    }

    static int fillcupUsingHeap(int arr[]) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int min = 0;

        for (int i : arr) {
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            int a = pq.remove();
            int b = pq.remove();
            if (a == 0 || b == 0) {
                min += a + b;
                return min;
            } else {
                min++;
                a--;
                b--;
                pq.add(a);
                pq.add(b);
            }
        }

        return min;
    }
}
