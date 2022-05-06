class Solution256 {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3]; // 表示第i号屋子刷第某个颜色的价格
        // 边界
        dp[0][0] = costs[0][0]; dp[0][1] = costs[0][1]; dp[0][2] = costs[0][2];
        // dp
        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + costs[i][0], dp[i - 1][2] + costs[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + costs[i][1], dp[i - 1][2] + costs[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + costs[i][2], dp[i - 1][1] + costs[i][2]);
        }
        return Math.min(dp[costs.length - 1][0], Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));
    }
}