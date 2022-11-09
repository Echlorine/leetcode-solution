class Solution132 {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        boolean[][] flag = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = 2000;
            for (int j = 0; j < s.length(); j++) {
                flag[i][j] = true;
            }
        }
        for (int i = s.length() - 1; i >= 0; --i) {
            for (int j = i + 1; j < s.length(); ++j) {
                flag[i][j] = (s.charAt(i) == s.charAt(j)) && flag[i + 1][j - 1];
            }
        }
        // 边界
        dp[0] = 0;
        // dp
        for (int i = 1; i < s.length(); i++) {
            if (flag[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = i; j >= 0; j--) {
                if (j > 0 && flag[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[s.length() - 1];
    }
}