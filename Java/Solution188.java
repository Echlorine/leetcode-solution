class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) return 0;
        int n = Math.min(prices.length, k);
        int[][] buy = new int[prices.length][n + 1]; // n 表示一天结束之后已经进行了n笔交易，并且此时手里有1支股票
        int[][] sell = new int[prices.length][n + 1]; // n 表示一天结束之后已经进行了n笔交易，并且此时手里没有股票
        // 边界条件
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }
        // dp
        for (int i = 1; i < prices.length; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= n; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        int res = 0;
        for (int j = 0; j < sell[prices.length - 1].length; j++)
            if (sell[prices.length - 1][j] > res) res = sell[prices.length - 1][j];
        return res;
    }
}