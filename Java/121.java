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
}