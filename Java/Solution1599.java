class Solution1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (4 * boardingCost - runningCost < 0) return -1;
        int remain = 0, sum = 0;
        int profit = 0;
        for (int i = 0; i < customers.length; i++) {
            remain += customers[i];
            int cur = Math.min(remain - sum, 4);
            sum += cur;
            profit += cur * boardingCost - runningCost;
        }
        int times = 0;
        while(remain - sum >= 4) {
            int cur = Math.min(remain - sum, 4);
            sum += cur;
            profit += cur * boardingCost - runningCost;
            times++;
        }
        if ((remain - sum) * boardingCost > runningCost) times++;
        return profit > 0 ? customers.length + times : -1;
    }
}