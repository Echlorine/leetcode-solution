class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 边界条件
        dp[0] = 1;
        // dp
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= amount; j++)
                dp[j] += dp[j - coins[i]];
        return dp[amount];
    }
}