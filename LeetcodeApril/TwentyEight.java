package LeetcodeApril;

public class TwentyEight {
    // ! Similar String Groups
    
    class Solution {
        public int numSimilarGroups(String[] str) {
            boolean[] vis = new boolean[str.length];
            int ans = 0;
            for (int i = 0; i < str.length; i++) {
                if (!vis[i]) {
                    groupSearch(str, i, vis);
                    ans++;
                }
            }
            return ans;
        }

        private void groupSearch(String[] str, int i, boolean[] vis) {
            vis[i] = true;
            for (int j = 0; j < str.length; j++) {
                if (!vis[j] && isSimilar(str[i], str[j])) {
                    groupSearch(str, j, vis);
                }
            }
        }

        private boolean isSimilar(String x, String y) {
            if (x.equals(y)) {
                return true;
            }
            int diff = 0;
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) != y.charAt(i)) {
                    diff++;
                }
                if (diff > 2) {
                    return false;
                }
            }
            return true;
        }
    }

}
