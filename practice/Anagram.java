package practice;

import java.util.HashMap;

public class Anagram {
    // Write a function to check whether two given strings are anagram of each other
    // or not.
    // An anagram of a string is another string that contains the same characters,
    // only the order of characters can be different.
    // NOTE : Assume english language alphabets in lowercase for now.
    // For example,
    // 1. "abcd" & "dabc" - YES
    // 2. "abccc" & "abc" - NO
    // 3. "xyz" & "abc" - NO
    // 4. "silent" & "listen" - YES
    static boolean isAnan(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!charFreq.containsKey(c)) {
                return false;
            } else {
                charFreq.put(c, charFreq.get(c) - 1);
                if (charFreq.get(c) == 0) {
                    charFreq.remove(c);
                }
            }
        }
        return charFreq.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnan("silent", "listen"));
    }
}
