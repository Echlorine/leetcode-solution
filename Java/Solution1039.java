class Solution1039 {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int dp[][] = new int[n][n];
        for (int l = 2; l < n; l++) {
            for (int i = 0; i < n - l; i++) {
                if (l == 2) {
                    dp[i][i + l] = values[i] * values[i + 1] * values[i + 2];
                    continue;
                }
                dp[i][i + l] = Integer.MAX_VALUE;
                for (int k = i + 1; k < i + l; k++) {
                    int t1 = 0, t2 = 0;
                    if (k - i >= 2) t1 = dp[i][k];
                    if (i + l - k >= 2) t2 = dp[k][i + l];
                    dp[i][i + l] = Math.min(dp[i][i + l], t1 + t2 + values[i] * values[k] * values[i + l]);
                }
            }
        }
        return dp[0][values.length - 1];
    }
}