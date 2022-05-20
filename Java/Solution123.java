class Solution123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] lp = new int[len]; // lp[i] 表示前 i 天的最大利润
        int[] rp = new int[len]; // rp[i] 表示从第 i 天到最后一天的最大利润
        // 边界条件，第0天
        lp[0] = 0; rp[prices.length - 1] = 0;
        int minprice = prices[0]; // 历史最小值，计算lp
        int maxprice = prices[len - 1]; // 历史最大值，计算rp
        for (int i = 1; i < len; i++) {
            if (prices[i] < minprice) {minprice = prices[i]; lp[i] = lp[i - 1];}
            else lp[i] = Math.max(lp[i - 1], prices[i] - minprice);
            if (prices[len - 1 - i] > maxprice) {maxprice = prices[len - 1 - i]; rp[len - 1 - i] = rp[len - i];}
            else rp[len - 1 - i] = Math.max(rp[len - i], maxprice - prices[len - 1 - i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (i < len - 1)
                res = Math.max(res, lp[i] + rp[i + 1]);
            else
                res = Math.max(res, lp[i]);
        }
        return res;
    }
}