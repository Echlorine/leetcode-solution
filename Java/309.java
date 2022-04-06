class Solution309 {
    public int maxProfit(int[] prices) {
        // dp
        int[][] dp = new int[prices.length][3];
        // 边界条件，第0天
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        // dp
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}