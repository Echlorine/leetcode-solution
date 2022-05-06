class Solution265 {
    public int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k]; // 表示第i号屋子刷第某个颜色的价格
        int res = Integer.MAX_VALUE;
        // 边界
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
            res = Math.min(res, dp[0][j]);
        }
        // dp
        for (int i = 1; i < costs.length; i++) {
            if (i == costs.length - 1)
                res = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = 0; m < k; m++) {
                    if (m == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][m] + costs[i][j]);
                    if (i == costs.length - 1)
                        res = Math.min(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}