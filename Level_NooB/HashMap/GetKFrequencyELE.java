package HashMap;

import java.util.*;;

public class GetKFrequencyELE {
    // ! https://leetcode.com/problems/top-k-frequent-elements
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> a = new ArrayList<>();
        int arr[] = new int[k];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            a.add(e.getValue());
        }

        Collections.sort(a);

        int j = a.size() - 1;
        for (int i = 0; i < arr.length; i++) {
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (a.get(j) == e.getValue()) {
                    arr[i] = e.getKey();
                    map.remove(e.getKey());
                    j--;
                    break;
                }
            }
        }
        return arr;

    }

    public int[] TopKFrequent(int[] nums, int k) {
        int[] f = new int[20_000 + 1];
        for (int num : nums) {
            f[num + 10_000]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> f[b + 10_000] - f[a + 10_000]);
        for (int i = -10_000; i <= 10_000; i++) {
            if (f[i + 10_000] != 0) {
                pq.offer(i);
            }
        }

        int i = 0;
        int[] result = new int[k];
        while (!pq.isEmpty() && k-- > 0) {
            result[i++] = pq.poll();
        }
        return result;
    }
}
