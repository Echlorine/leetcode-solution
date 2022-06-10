class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int temp = Integer.MAX_VALUE;
        // 边界条件
        dp[0] = 0;
        // dp
        for (int i = 1; i <= amount; i++) {
            temp = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++)
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1)
                    temp = Math.min(temp, dp[i - coins[j]]);
            if (temp == Integer.MAX_VALUE) dp[i] = -1;
            else dp[i] = 1 + temp;
        }
        return dp[amount];
    }
}