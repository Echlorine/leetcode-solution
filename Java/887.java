class Solution887 {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n + 1][k + 1];
        // 边界
        for (int j = 1; j <= k; j++) {
            dp[1][j] = 1;
        }
        if (k == 1 || n == 1) return n;
        // dp
        int res = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1] + 1;
            }
            if (dp[i][k] >= n) {
                res = i;
                break;
            }
        }
        return res;
    }
}