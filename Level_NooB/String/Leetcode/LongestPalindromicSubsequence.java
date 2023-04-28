package String.Leetcode;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1);
    }

    int helper(String s, int start, int end) {
        if (start > end)
            return 0;

        if (start == end)
            return 1;

        if (s.charAt(start) == s.charAt(end))
            return 2 + helper(s, start + 1, end - 1);

        else
            return Math.max(helper(s, start + 1, end), helper(s, start, end - 1));
    }
}
