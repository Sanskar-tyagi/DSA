package Array.Striver;

public class FindIndexOfFirstOccurance {
    // Given two strings needle and haystack, return the index of the first
    // occurrence of needle in haystack, or -1 if needle is not part of haystack.

    // Input: haystack = "sadbutsad", needle = "sad"
    // Output: 0
    // Explanation: "sad" occurs at index 0 and 6.
    // The first occurrence is at index 0, so we return 0.

    public int strStr(String haystack, String needle) {
        int n = needle.length();
        if (n == 0) {
            return 0;
        }
        int m = haystack.length();
        if (m < n) {
            return -1;
        }
        for (int i = 0; i <= m - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
