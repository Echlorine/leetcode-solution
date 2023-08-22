class Solution1911 {
    public long maxAlternatingSum(int[] nums) {
        long dp[][] = new long[nums.length][2];
        // dp[i][0] 表示子序列个数是偶数的情况，dp[i][1]表示子序列个数是奇数的情况
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
        }
        return dp[nums.length - 1][1];
    }
}