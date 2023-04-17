package DP;

public class PossibleEncodings {
    public static void main(String[] args) {
        System.out.println(getPossiblity("655196"));
    }

    static int getPossiblity(String s) {
        int dp[] = new int[s.length()];
        if (s.charAt(s.length()) != '0') {
            dp[s.length()] = 1; // ending char can make only one encoding
        } else {
            dp[s.length()] = 0; // ending char cant make any Encoding
        }
        for (int i = s.length() - 1; i > 1; i--) {
            if (i > s.length() - 2) {
                dp[i] = dp[i + 1] + s.charAt(i) == '0' ? 0 : 1;
                dp[i] += dp[i + 1] + s.charAt(i) + s.charAt(i + 1) > 'a' - 26 ? 0 : dp[i + 2];
            } else {
                dp[i] = dp[i + 1] + s.charAt(i) == 0 ? 0 : 1;
            }
        }
        return dp[0];
    }
}
