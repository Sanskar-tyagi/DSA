package HashMap;

import java.util.*;;

public class topKth {
    char get(String str, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();

        // Count the frequency of each character in the string
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }

        // Create a priority queue to store the frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(freq.values());

        // Remove the top K-1 frequencies from the priority queue
        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == pq.peek()) {
                return entry.getKey();
            }
        }

        return '\0';
    }
}
