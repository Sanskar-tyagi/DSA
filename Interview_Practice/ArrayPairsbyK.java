package Interview_Practice;

import java.util.HashMap;

public class ArrayPairsbyK {
    // !Question
    // -->https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
    // very easy question need to find the reminders
    // why??
    // lets say a valid pair be [x,y] where x+y%k==0
    // Assume we want to represnet x and y in terms of k
    // x=k.n1+r (where n1 is any number and r is some reminder)
    // y=k.n2+k-r (where n2 is any number and r is same reminder )
    // adding both we get x+y=k(n1+n2+1)
    // this proves that we need to find any number x which has reminder as r
    // and another number y which has reminder as k-r
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 };
        int k = 5;
        System.out.println(canArrange(arr, k));
    }

    public static boolean canArrange(int[] arr, int k) {
        // first make an hashmap of reminders and their count.
        // then find the numbers required if exists.

        HashMap<Integer, Integer> map = new HashMap<>();
        if (arr.length % 2 != 0)
            return false;
        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            if (rem < 0)
                rem = rem + k;

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        for (Integer i : map.keySet()) {
            if (i == 0) {
                if (map.get(i) % 2 != 0) // cant make a pair of 2
                    return false;
            } else if (i * 2 == k) {
                if (map.get(i) % 2 != 0)
                    return false;
            } else {
                int c1 = map.get(i);
                int c2 = map.getOrDefault(k - i, 0);
                if (c1 != c2)
                    return false;
            }
        }
        return true;
    }
}