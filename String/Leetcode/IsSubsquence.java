package String.Leetcode;

public class IsSubsquence {
    // ! https://leetcode.com/problems/is-subsequence
    // Given two strings s and t, return true if s is a subsequence of t, or false
    // otherwise.

    // A subsequence of a string is a new string that is formed from the original
    // string by deleting some (can be none) of the characters without disturbing
    // the relative positions of the remaining characters. (i.e., "ace" is a
    // subsequence of "abcde" while "aec" is not).
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0;// we will first create a counter to check for subsquence length
        for (int tIdx = 0; tIdx < t.length(); tIdx++) {
            if (sIdx == s.length()) {// if ever the size of our current counter and the subquence is equal we will
                                     // return true be cause we will only increase the count of the index if only it
                                     // is prenset in the t string sequentially
                return true;
            }
            if (t.charAt(tIdx) == s.charAt(sIdx)) {// if present increase the count to check for the next char in the
                                                   // subsquence.
                sIdx++;
            }
        }
        return sIdx == s.length(); // return the logical boolean value of trururur or false :9
    }

}
    