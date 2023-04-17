package LeetcodeApril;

public class SixTeenApril {
    // 1639. Number of Ways to Form a Target String Given a Dictionary

    public int numWays(String[] words, String target) {
        int n = words[0].length(); // given Constraint that at any ith of word length is equal
        int m = target.length();
        int mod = 1000000007;
        // The approach here is to create a storing dp such that at any instance jth of
        // dp we will find the count of the ith charchter of target which will create
        // the number of possiblities further or number of combinations further by
        // checking the count of that charchter after the jth instance
        // to explain it further
        // we will first initilaize our dp[0] as 1 because we need to multiply the jth+1
        // char with j and its count;

        // so lets say we have a target = "aba" and we need to make it from words =
        // ["acca","bbbb","caca"],

        // now the count will be stored as
        // [{1,1,1,0...,0},{1,1,1,0...,0},{0,1,2,0,...,0},{2,1,0,0.....0} ]
        // meaning at the any ith of words string this is the number of count we have
        // for any word
        // so for i=0 we have 1 a in first string 1 b in second 1 c in third
        // for i=3 we have 1 a in first string 1 b in second string and 1 a in third
        // which will increase its freq to 2 a in the ith cell of count
        // this will further help us to calculate the combinations as for lets say
        // at give instance 2 the 2nd char at target is a which has the frequency after 
        int[] dp = new int[m + 1];
        dp[0] = 1;

        int[][] count = new int[n][26]; // Constraint of equal words length
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                dp[j + 1] += (int) ((long) dp[j] * count[i][target.charAt(j) - 'a'] % mod);
                dp[j + 1] %= mod;
            }
        }
        return dp[m];
    }
}
