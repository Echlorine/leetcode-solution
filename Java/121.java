class Solution121 {
    public int maxProfit(int[] prices) {
        int minprice = 0; // 记录暂存的最小价格
        int res = 0;
        minprice = prices[0];
        for (int i = 1; i < prices.length; i++){
            minprice = prices[i] < minprice ? prices[i] : minprice;
            res = prices[i] - minprice > res ? prices[i] - minprice : res;
        }
        return res;
    }

    public int dpmaxProfit(int[] prices) {
        int[] dp = new int[prices.length]; // dp[i] 表示前 i 天的最大利润
        // 边界条件，第0天
        dp[0] = 0;
        int minprice = prices[0]; // 历史最小值
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minprice) {minprice = prices[i]; dp[i] = dp[i - 1];}
            else dp[i] = Math.max(dp[i - 1], prices[i] - minprice);
        }
        return dp[prices.length - 1];
    }
}