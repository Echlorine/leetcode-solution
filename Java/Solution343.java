class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1]; // dp[i]表示将正整数i拆分成至少两个正整数的和之后，这些正整数的最大乘积
        // 边界
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j < i; j++) {
                temp = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], temp);
            }
        }
        return dp[n];
    }
}