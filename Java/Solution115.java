class Solution115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 边界
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        // dp
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= i && j <= t.length(); j++) {
                if (s.charAt(i -1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[s.length()][t.length()];
    }
}