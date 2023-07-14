package Interview_Practice;

import java.util.HashMap;

public class SubarraySumK {
    // need to find number of continious subarrray which might be equal to k
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int k = 3;
        getAns(k, arr);
    }

    static void getAns(int k, int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(sum, 1);
        for (int i : arr) {
            sum += i;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }
}
