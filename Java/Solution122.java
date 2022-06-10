class Solution122 {
    public int maxProfit(int[] prices) {
        // dp
        int[][] dp = new int[prices.length][2];
        // 边界条件，第0天
        dp[0][0] = 0; // 0 表示当天结束后，手里没有股票
        dp[0][1] = -prices[0]; // 1 表示当天结束后，手里有1只股票
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

    public int greedymaxProfit(int[] prices) {
        /**
         * 贪心，只要下一天价格比上一天高，那就是利润
         */
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int temp = prices[i + 1] - prices[i];
            if (temp > 0) res += temp;
        }
        return res;
    }
}