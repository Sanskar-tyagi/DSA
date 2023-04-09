package HashMap;

import java.util.*;;

public class MaxFrequency {
    public static char findMostFrequentChar(String str) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }

        char mostFrequentChar = str.charAt(0);
        int highestFreq = 0;
        for (char c : freq.keySet()) {
            int currFreq = freq.get(c);
            if (currFreq > highestFreq) {
                highestFreq = currFreq;
                mostFrequentChar = c;
            }
        }

        return mostFrequentChar;
    }

}
